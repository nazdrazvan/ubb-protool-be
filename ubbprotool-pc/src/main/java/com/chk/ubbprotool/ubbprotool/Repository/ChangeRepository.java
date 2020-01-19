package com.chk.ubbprotool.ubbprotool.Repository;

import com.chk.ubbprotool.ubbprotool.Model.Change;
import com.chk.ubbprotool.ubbprotool.Model.Student;
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
public class ChangeRepository {
    @Autowired
    private SessionFactory sessionFactory;


    public List<Change> findAll() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Change> cq = cb.createQuery(Change.class);
        Root<Change> root = cq.from(Change.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }


    public void removeData(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Change change = session.byId(Change.class).load(id);session.delete(change);
        session.flush();
        session.clear();
    }


    public void updateData(Change object) {
        Session session = sessionFactory.getCurrentSession();
        session.update(object);
    }


    public Long saveData(Change change) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(change);
        return change.getChangeId();
    }


    public Change findById(Long theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Change.class, theId);
    }
}
