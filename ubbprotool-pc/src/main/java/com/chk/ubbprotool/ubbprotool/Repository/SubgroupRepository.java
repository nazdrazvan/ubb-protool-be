package com.chk.ubbprotool.ubbprotool.Repository;

import com.chk.ubbprotool.ubbprotool.Model.Student;
import com.chk.ubbprotool.ubbprotool.Model.Subgroup;
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
public class SubgroupRepository {
    @Autowired
    private SessionFactory sessionFactory;


    public List<Subgroup> findAll() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Subgroup> cq = cb.createQuery(Subgroup.class);
        Root<Subgroup> root = cq.from(Subgroup.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }


    public void removeData(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Subgroup subgroup = session.byId(Subgroup.class).load(id);
        session.delete(subgroup);
        session.flush();
        session.clear();
    }


    public void updateData(Subgroup object) {
        Session session = sessionFactory.getCurrentSession();
        session.update(object);
    }


    public void saveData(Subgroup subgroup) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(subgroup);
    }


    public Subgroup findById(Long theId) {

        try {
            Session currentSession = sessionFactory.getCurrentSession();
            return currentSession.get(Subgroup.class, theId);
        }catch (Error e){
            return null;
        }

    }

    public Subgroup findByGroupAndSubgroup(Integer groupNumber, Integer subgroupNumber) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query hql = currentSession.createQuery("from Subgroup s where s.groupNumber = :groupNumber and s.subgroupNumber = :subgroupNumber")
                .setParameter("groupNumber", groupNumber)
                .setParameter("subgroupNumber", subgroupNumber);
        Subgroup foundGroup = null;
        try {
            foundGroup = (Subgroup) hql.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
        return foundGroup;
    }
}
