package DatabasePackage;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Calendar", schema = "main", catalog = "")
public class CalendarEntity {
    private Short id;
    private Date day;

    @Id
    @Column(name = "ID")
    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Day")
    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalendarEntity that = (CalendarEntity) o;
        return Objects.equals(day, that.day);
    }

    @Override
    public int hashCode() {
        return Objects.hash(day);
    }
}
