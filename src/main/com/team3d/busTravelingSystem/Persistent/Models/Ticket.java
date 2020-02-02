package main.com.team3d.busTravelingSystem.Persistent.Models;

import javax.persistence.*;
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToOne
    private User user;

    @OneToOne
    private Travel travel;

    @Column(name = "sex",nullable = false)
    private String sex;

    public Ticket(User user, Travel travel, String sex) {
        this.user = user;
        this.travel = travel;
        this.sex = sex;
    }

    public Ticket() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Travel getTravel() {
        return travel;
    }

    public void setTravel(Travel travel) {
        this.travel = travel;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

}
