package com.chk.ubbprotool.ubbprotool.Repository;

import com.chk.ubbprotool.ubbprotool.Helper.Weeks;
import com.chk.ubbprotool.ubbprotool.Model.UniversityClass;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.Date;
import java.util.List;

@Repository
public class WeeksRepository {

    @Autowired
    private SessionFactory sessionFactory;


    public List<Weeks> findAll() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Weeks> cq = cb.createQuery(Weeks.class);
        Root<Weeks> root = cq.from(Weeks.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }


    public int findByDate(Date givenDate) {

        Date dateCopy = givenDate;
        Session session = sessionFactory.getCurrentSession();
        Query hql = session.createQuery("from Weeks u where u.startDate <= :givenDAte and u.endDate >= :dateCopy")
                .setParameter("givenDAte", givenDate)
                .setParameter("dateCopy",dateCopy);
        Weeks foundWeek = null;
        try {
            foundWeek = (Weeks) hql.getSingleResult();
        } catch (NoResultException e) {
            throw new NoResultException("Week does not exist!");
        }
        return foundWeek.getWeekNumber();
    }

    public Date findStartDateOfWeek(Date givenDate) {
        Date dateCopy = givenDate;
        Session session = sessionFactory.getCurrentSession();
        Query hql = session.createQuery("from Weeks u where u.startDate <= :givenDAte and u.endDate >= :dateCopy")
                .setParameter("givenDAte", givenDate)
                .setParameter("dateCopy",dateCopy);
        Weeks foundWeek = null;
        try {
            foundWeek = (Weeks) hql.getSingleResult();
        } catch (NoResultException e) {
            throw new NoResultException("Week does not exist!");
        }
        return foundWeek.getStartDate();
    }

    public Date findEndDateOfWeek(Date givenDate) {
        Date dateCopy = givenDate;
        Session session = sessionFactory.getCurrentSession();
        Query hql = session.createQuery("from Weeks u where u.startDate <= :givenDAte and u.endDate >= :dateCopy")
                .setParameter("givenDAte", givenDate)
                .setParameter("dateCopy",dateCopy);
        Weeks foundWeek = null;
        try {
            foundWeek = (Weeks) hql.getSingleResult();
        } catch (NoResultException e) {
            throw new NoResultException("Week does not exist!");
        }
        return foundWeek.getEndDate();
    }

    public boolean isCurrentDateBetweenGivenDateAndEndOfWeek(Date currentDate, Date givenDate) {
        Date endOfWeek = this.findEndDateOfWeek(givenDate);
        if(currentDate.compareTo(endOfWeek) <= 0 && currentDate.compareTo(givenDate) >= 0)
            return true;
        else
            return false;
    }
}