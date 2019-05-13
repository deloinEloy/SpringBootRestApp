package DatabasePackage;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Employees", schema = "main", catalog = "")
public class EmployeesEntity {
    private Short id;
    private Object name;
    private Object secondName;
    private Object birthday;
    private Object adress;
    private Object freelance;

    @Id
    @Column(name = "ID")
    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Name")
    public Object getName() {
        return name;
    }

    public void setName(Object name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Second_name")
    public Object getSecondName() {
        return secondName;
    }

    public void setSecondName(Object secondName) {
        this.secondName = secondName;
    }

    @Basic
    @Column(name = "Birthday")
    public Object getBirthday() {
        return birthday;
    }

    public void setBirthday(Object birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "Adress")
    public Object getAdress() {
        return adress;
    }

    public void setAdress(Object adress) {
        this.adress = adress;
    }

    @Basic
    @Column(name = "Freelance")
    public Object getFreelance() {
        return freelance;
    }

    public void setFreelance(Object freelance) {
        this.freelance = freelance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeesEntity that = (EmployeesEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(secondName, that.secondName) &&
                Objects.equals(birthday, that.birthday) &&
                Objects.equals(adress, that.adress) &&
                Objects.equals(freelance, that.freelance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, secondName, birthday, adress, freelance);
    }
}
