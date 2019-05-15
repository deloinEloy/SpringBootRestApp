package AppPackage;

import DatabasePackage.CalendarEntity;
import DatabasePackage.DepartmentEntity;
import Models.*;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DatabaseProvider implements IDatabaseProvider {
    public List<DepartmentEntity> GetDepartments(){
        Session session =  HibernateSessionFactory.getSessionFactory().openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<DepartmentEntity> cq = cb.createQuery(DepartmentEntity.class);
        Root<DepartmentEntity> rootEntry = cq.from(DepartmentEntity.class);
        CriteriaQuery<DepartmentEntity> all = cq.select(rootEntry);

        TypedQuery<DepartmentEntity> allQuery = session.createQuery(all);
        return allQuery.getResultList();
        /*
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<DepartmentEntity> criteria = builder.createQuery(DepartmentEntity.class);
        List<DepartmentEntity> departments = session.createQuery(criteria).getResultList();
        session.close();
        return departments;*/
    }

    public ArrayList<EmployeeModel> GetCalendar(Date from, Date to){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String fromStr = df.format(from);
        String toStr = df.format(to);
        Session session =  HibernateSessionFactory.getSessionFactory().openSession();
        SQLQuery query = session.createSQLQuery("SELECT\n" +
                "       Employees.*,\n" +
                "       C.Id as Calendar_Id,\n" +
                "       C.Day,\n" +
                "       M.Id as Mark_Id,\n" +
                "       M.Name as Mark_Name,\n" +
                "       D.Id as Dep_Id,\n" +
                "       D.Name as Dep_Name,\n" +
                "       P.Id as Position_Id,\n" +
                "       P.Name as Position_Name\n" +
                "FROM Employees\n" +
                "    LEFT JOIN Calendar C on Employees.ID = C.ID_employee AND DATETIME(C.Day/1000, 'unixepoch') >= "+fromStr+"\n" +
                "                                                             AND DATETIME(C.Day/1000, 'unixepoch') <= "+toStr+"\n" +
                "                                                                 \n" +
                "    LEFT JOIN Mark M on C.ID_mark = M.ID\n" +
                "    LEFT JOIN Department D on Employees.ID_department = D.ID\n" +
                "    LEFT JOIN Position P on Employees.ID_position = P.ID\n" +
                "ORDER BY Employees.ID;");
        List<Object[]> rows = query.list();
        session.close();

        ArrayList<EmployeeModel> employees = new ArrayList<EmployeeModel>();
        EmployeeModel lastModel = null;
        for(Object[] row : rows){
            EmployeeModel employeeModel=null;
            if(lastModel != null){
                if(lastModel.getId() == Short.parseShort(row[0].toString()))
                    employeeModel = lastModel;
            }
            if(employeeModel == null) {
                employeeModel = new EmployeeModel();
                employeeModel.setId(Short.parseShort(row[0].toString()));
                employeeModel.setName(row[1].toString());
                employeeModel.setSecondName(row[2].toString());
                employeeModel.setBirthday((row[3].toString()));//
                employeeModel.setAdress(row[4].toString());
                employeeModel.setFreelance(Boolean.valueOf(row[5].toString()));
                //заполняем employeeModel, включая position и department

                PositionModel positionModel = new PositionModel();
                positionModel.setId(Short.parseShort(row[0].toString()));
                positionModel.setName((row[1].toString()));

                DepartmentModel departmentModel = new DepartmentModel();
                departmentModel.setId(Short.parseShort(row[0].toString()));
                departmentModel.setName((row[1]).toString());

            }

            if(employeeModel.getWorkingDays() == null){
                employeeModel.setWorkingDays(new ArrayList<>());
            }

            WorkingDayModel workingDayModel = new WorkingDayModel();
            workingDayModel.setId(Short.parseShort(row[0].toString()));
            workingDayModel.setDay(row[1].toString());//
            workingDayModel.setMark(row[2].toString());//
            //заполняем день, включая метку
            MarkModel markModel = new MarkModel();
            markModel.setId(Short.parseShort(row[0].toString()));
            markModel.setName(row[1].toString());


            employeeModel.getWorkingDays().add(workingDayModel);
            employees.add(employeeModel);
        }

        return employees;
    }
}
