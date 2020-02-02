package main.com.team3d.busTravelingSystem.Persistent.Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username",nullable = false,length = 100)
    private String username;

    @Column(name = "password",nullable = false,length = 100)
    private String password;

    @Column(name = "email",nullable = false,length = 200)
    private String email;

    @Column(name = "firstName",nullable = false,length = 100)
    private String firstName;

    @Column(name = "lastName",nullable = false,length = 100)
    private String lastName;
    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = { @JoinColumn(name = "user_id",referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "role_id",referencedColumnName = "id") }
    )
    private List<Role> roles = new ArrayList<>();


    public User(String username, String password, String email, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User() {
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
