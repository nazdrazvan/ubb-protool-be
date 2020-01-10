package com.chk.ubbprotool.ubbprotool.Repository;

import com.chk.ubbprotool.ubbprotool.Model.Course;
import com.chk.ubbprotool.ubbprotool.Model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class StudentRepository  {

    @Autowired
    private SessionFactory sessionFactory;


    public List<Student> findAll() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Student> cq = cb.createQuery(Student.class);
        Root<Student> root = cq.from(Student.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }


    public void removeData(int id) {
        Session session = sessionFactory.getCurrentSession();
        Student Student = session.byId(Student.class).load(id);session.delete(Student);
        session.flush();
        session.clear();
    }


    public void updateData(Student object) {

    }


    public void saveData(Student theStudent) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(theStudent);
    }


    public Student findById(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Student.class, theId);
    }

}
