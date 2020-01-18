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


    public void removeData(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Message message = session.byId(Message.class).load(id);session.delete(message);
        session.flush();
        session.clear();
    }


    public void updateData(Message object) {
        Session session = sessionFactory.getCurrentSession();
        session.update(object);
    }


    public void saveData(Message message) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(message);
    }


    public Message findById(Long theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Message.class, theId);
    }
}
