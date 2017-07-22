package com.example.vytuatus.customcalendardayview;

import java.util.Date;

/**
 * Created by vytuatus on 7/9/17.
 */

public class EventObjects {

    private int id;
    private String message;
    private Date date;
    private Date end;

    public EventObjects(String message, Date date, Date end) {
        this.message = message;
        this.date = date;
        this.end = end;
    }

    public EventObjects(int id, String message, Date date, Date end) {
        this.id = id;
        this.message = message;
        this.date = date;
        this.end = end;
    }

    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public Date getDate() {
        return date;
    }

    public Date getEnd() {
        return end;
    }
}
