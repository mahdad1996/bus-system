package main.com.team3d.busTravelingSystem.Persistent.Models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Travel {
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
    private Date hour;
    @Column(name = "travelId",nullable = false)
    private Long travelId;

}
