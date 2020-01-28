package main.com.team3d.busTravelingSystem.Persistent.Models;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Ticket {
    private Long id;
    private String Buyer;
    private String sex;
    private String fromPlace;
    private String toPlace;
    private Date date;
    private Date hour;
    private Long tId;

}
