package DatabasePackage;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Position", schema = "main", catalog = "")
public class PositionEntity {
    private Short id;
    private String  name;

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
    public String  getName() {
        return name;
    }

    public void setName(String  name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositionEntity that = (PositionEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
