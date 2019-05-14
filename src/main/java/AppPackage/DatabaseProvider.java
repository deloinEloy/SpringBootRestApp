package AppPackage;

import DatabasePackage.CalendarEntity;
import DatabasePackage.DepartmentEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.Date;
import java.util.List;

public class DatabaseProvider implements IDatabaseProvider {
    public List<DepartmentEntity> GetDepartments(){
        Session session =  HibernateSessionFactory.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<DepartmentEntity> criteria = builder.createQuery(DepartmentEntity.class);
        List<DepartmentEntity> departments = session.createQuery(criteria).getResultList();
        session.close();
        return departments;
    }

    public List<CalendarEntity> GetCalendar(Date from, Date to){
        Session session =  HibernateSessionFactory.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(CalendarEntity.class)
             .add(Restrictions.between("date", from, to));     //add between
        List<CalendarEntity> calendar = criteria.list();
        session.close();

        return calendar;
    }
}
