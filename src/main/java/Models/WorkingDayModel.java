package Models;

import java.util.Date;

public class WorkingDayModel {
    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public MarkModel getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    private Short id;
    private Date day;
    private MarkModel mark;
}
