package com.chk.ubbprotool.ubbprotool.Repository;

import com.chk.ubbprotool.ubbprotool.Model.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class TeacherRepository {
    @Autowired
    private SessionFactory sessionFactory;


    public List<Teacher> findAll() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Teacher> cq = cb.createQuery(Teacher.class);
        Root<Teacher> root = cq.from(Teacher.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    public void removeData(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Teacher Teacher = session.byId(Teacher.class).load(id);
        session.delete(Teacher);
        session.flush();
        session.clear();
    }


    public void updateData(Teacher object) {
        Session session = sessionFactory.getCurrentSession();
        session.update(object);
    }

    public void saveData(Teacher teacher) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(teacher);
    }

    public Teacher findById(Long theId) {
        try {
            Session currentSession = sessionFactory.getCurrentSession();
            return currentSession.get(Teacher.class, theId);
        } catch (Error e) {
            return null;
        }
    }

    public Teacher findByEmailAndPassword(String email, String password) {
        Session session = sessionFactory.getCurrentSession();
        Query hql = session.createQuery("from Teacher t where t.email = :email and t.password = :password")
                .setParameter("email", email)
                .setParameter("password", password);
        Teacher foundTeach = null;
        try {
            foundTeach = (Teacher) hql.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
        return foundTeach;
    }

    public int activateTeacher(Teacher teach) {
        Session session = sessionFactory.getCurrentSession();
        Query hql = session.createQuery("update Teacher t set t.teacherAvailability = :thesisAvailability," +
                " t.teacherFirstName = :firstName, t.teacherLastName = :lastName, t.password = :password" +
                ", t.teacherEnabled = :enable, t.teacherFaculty = :faculty, t.teacherUniversity = :university" +
                ", t.teacherWebSite = :website, t.teacherDepartment = :department where t.email = :email")
                .setParameter("email", teach.getEmail())
                .setParameter("thesisAvailability", teach.isTeacherAvailability())
                .setParameter("firstName", teach.getTeacherFirstName())
                .setParameter("lastName", teach.getTeacherLastName())
                .setParameter("password", teach.getPassword())
                .setParameter("enable", teach.isTeacherEnabled())
                .setParameter("faculty", teach.getTeacherFaculty())
                .setParameter("university", teach.getTeacherUniversity())
                .setParameter("website", teach.getTeacherWebSite())
                .setParameter("department", teach.getTeacherDepartment());
        int result = 0;
        try {
            result = hql.executeUpdate();
        } catch (NoResultException e) {
            return result;
        }
        return result;
    }
}
