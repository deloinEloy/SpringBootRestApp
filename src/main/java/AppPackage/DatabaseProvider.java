package AppPackage;

import DatabasePackage.CalendarEntity;
import DatabasePackage.DepartmentEntity;
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

    public List<CalendarEntity> GetCalendar(Date from, Date to, int departmentId){
        Session session =  HibernateSessionFactory.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<CalendarEntity> criteria = builder.createQuery(CalendarEntity.class);
        //criteria.add(Restrictions.between("date", from, to);//add between
        //criteria.add(Restrictions.eq("departament",departmentId);//add check on id
        List<CalendarEntity> calendar = criteria.stream().filter(c -> c.getWorker().getDepartmentId() == departmentId && (c.getDate() >= from && c.getDate() <= to));
        List<CalendarEntity> calendar = session.createQuery(criteria).getResultList();
        session.close();

        return
    }
}
