package AppPackage;

import DatabasePackage.CalendarEntity;
import DatabasePackage.DepartmentEntity;
import Models.EmployeeModel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping (value = "/api")
public class ControllerDep {
    @RequestMapping("/departaments")
    public List<DepartmentEntity> showDepartament(){
        return new DatabaseProvider().GetDepartments();
    }

    @RequestMapping (value = "/days", method = RequestMethod.GET)
    public ArrayList<EmployeeModel> getDays(@RequestParam("from") Date from, @RequestParam("to") Date to){
        return new DatabaseProvider().GetCalendar(from, to);
    }

}
