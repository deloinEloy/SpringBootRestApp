package AppPackage;

import DatabasePackage.CalendarEntity;
import DatabasePackage.DepartmentEntity;

import java.util.Date;
import java.util.List;

public interface IDatabaseProvider {
    List<DepartmentEntity> GetDepartments();
    List<CalendarEntity> GetCalendar(Date from, Date to);
}
