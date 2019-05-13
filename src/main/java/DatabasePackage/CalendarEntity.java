package DatabasePackage;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "Calendar", schema = "main", catalog = "")
public class CalendarEntity {
    private Object day;

    @Basic
    @Column(name = "Day")
    public Object getDay() {
        return day;
    }

    public void setDay(Object day) {
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
