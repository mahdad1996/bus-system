package main.com.team3d.busTravelingSystem.Persistent.Models;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.Date;

@Entity
public class Travel implements Comparator<Travel>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "source",nullable = false)
    private String source;
    @Column(name = "destination",nullable = false)
    private String destination;
    @Column(name = "date",nullable = false)
    private Date date;

    @Column(name = "hour",nullable = false)
    private String hour;

    @Transient
    private String persianDate;

    public Travel() {
    }

    public Travel(String source, String destination, Date date, String hour) {
        this.source = source;
        this.destination = destination;
        this.date = date;
        this.hour = hour;
    }

   

    public String getPersianDate() {
        return persianDate;
    }

    public void setPersianDate(String persianDate) {
        this.persianDate = persianDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }


    @Override
    public int compare(Travel o1, Travel o2) {
        return o1.getHour().compareTo(o2.hour);
    }
}
