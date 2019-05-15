package Models;

import java.util.Date;
import java.util.List;

public class EmployeeModel {
    private Short id;
    private String  name;
    private String  secondName;
    private Date birthday;
    private String  adress;
    private Boolean freelance;
    private DepartmentModel department;
    private PositionModel position;

    public DepartmentModel getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentModel department) {
        this.department = department;
    }

    public PositionModel getPosition() {
        return position;
    }

    public void setPosition(PositionModel position) {
        this.position = position;
    }

    public List<WorkingDayModel> getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(List<WorkingDayModel> workingDays) {
        this.workingDays = workingDays;
    }

    private List<WorkingDayModel> workingDays;

    public Short getId() {
        return id;
    }
    public void setId(Short id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSecondName() {
        return secondName;
    }
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    public String getAdress() {
        return adress;
    }
    public void setAdress(String adress) {
        this.adress = adress;
    }
    public Boolean getFreelance() {
        return freelance;
    }
    public void setFreelance(Boolean freelance) {
        this.freelance = freelance;
    }
}
