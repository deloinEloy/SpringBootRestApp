package DatabasePackage;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Employees", schema = "main", catalog = "")
public class EmployeesEntity {
    private Short id;
    private String  name;
    private String  secondName;
    private Date birthday;
    private String  adress;
    private Boolean freelance;

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
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Second_name")
    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Basic
    @Column(name = "Birthday")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "Adress")
    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Basic
    @Column(name = "Freelance")
    public Boolean getFreelance() {
        return freelance;
    }

    public void setFreelance(Boolean freelance) {
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
