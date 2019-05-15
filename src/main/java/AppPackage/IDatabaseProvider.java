package AppPackage;

import DatabasePackage.CalendarEntity;
import DatabasePackage.DepartmentEntity;
import Models.EmployeeModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface IDatabaseProvider {
    List<DepartmentEntity> GetDepartments();
    ArrayList<EmployeeModel> GetCalendar(Date from, Date to);
}
