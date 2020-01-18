package com.chk.ubbprotool.ubbprotool.Repository;

import com.chk.ubbprotool.ubbprotool.Model.Course;
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
public class CourseRepository {
    @Autowired
    private SessionFactory sessionFactory;


    public List<Course> findAll() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);
        Root<Course> root = cq.from(Course.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }


    public void removeData(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Course course = session.byId(Course.class).load(id);session.delete(course);
        session.flush();
        session.clear();
    }


    public void updateData(Course object) {
        Session session = sessionFactory.getCurrentSession();
        session.update(object);
    }


    public void saveData(Course course) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(course);
    }


    public Course findById(Long theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Course.class, theId);
    }
}
