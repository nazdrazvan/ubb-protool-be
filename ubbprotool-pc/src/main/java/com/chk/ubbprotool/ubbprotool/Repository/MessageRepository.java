package com.chk.ubbprotool.ubbprotool.Repository;

import com.chk.ubbprotool.ubbprotool.Model.Change;
import com.chk.ubbprotool.ubbprotool.Model.Message;
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
public class MessageRepository {
    @Autowired
    private SessionFactory sessionFactory;


    public List<Message> findAll() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Message> cq = cb.createQuery(Message.class);
        Root<Message> root = cq.from(Message.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }


    public void removeData(int id) {
        Session session = sessionFactory.getCurrentSession();
        Change change = session.byId(Change.class).load(id);session.delete(change);
        session.flush();
        session.clear();
    }


    public void updateData(Change object) {
        Session session = sessionFactory.getCurrentSession();
        session.update(object);
    }


    public void saveData(Change change) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(change);
    }


    public Change findById(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Change.class, theId);
    }
}
