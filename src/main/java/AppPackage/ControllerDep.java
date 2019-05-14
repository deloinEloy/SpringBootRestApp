package AppPackage;

import DatabasePackage.CalendarEntity;
import DatabasePackage.DepartmentEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class ControllerDep {
    @RequestMapping("/departaments")
    public List<DepartmentEntity> showDepartament(){
        return new DatabaseProvider().GetDepartments();
    }

    @RequestMapping (value = "/days", method = RequestMethod.GET)
    public List<CalendarEntity> getDays(@RequestParam("from") Date from, @RequestParam("to") Date to){
        return  new DatabaseProvider().GetCalendar(from, to);
    }

}
