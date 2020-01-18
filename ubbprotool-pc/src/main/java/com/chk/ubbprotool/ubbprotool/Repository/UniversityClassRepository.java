package com.chk.ubbprotool.ubbprotool.Repository;

import com.chk.ubbprotool.ubbprotool.Model.Student;
import com.chk.ubbprotool.ubbprotool.Model.UniversityClass;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UniversityClassRepository {
    @Autowired
    private SessionFactory sessionFactory;


    public List<UniversityClass> findAll() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<UniversityClass> cq = cb.createQuery(UniversityClass.class);
        Root<UniversityClass> root = cq.from(UniversityClass.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }


    public void removeData(int id) {
        Session session = sessionFactory.getCurrentSession();
        UniversityClass univClass = session.byId(UniversityClass.class).load(id);session.delete(univClass);
        session.flush();
        session.clear();
    }


    public void updateData(UniversityClass object) {
        Session session = sessionFactory.getCurrentSession();
        session.update(object);
    }


    public void saveData(UniversityClass univClass) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(univClass);
    }


    public UniversityClass findById(Long theId) {
        try {
            Session currentSession = sessionFactory.getCurrentSession();
            return currentSession.get(UniversityClass.class, theId);

        }catch (Error e){
            return null;
        }
    }
}
