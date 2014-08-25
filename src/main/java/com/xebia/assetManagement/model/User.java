package com.xebia.assetManagement.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by anirudh on 22/08/14.
 */
@Entity
@Table(name = "user",
        uniqueConstraints=
        @UniqueConstraint(columnNames = {"id", "emailAddress"}))
public class User {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String employeeId;
    private String mobileNum;
    private String password;
    private boolean isAdmin;
    private List<Asset> assets = new ArrayList<Asset>(0);

    public User() {

    }

    public User(Long id, String firstName, String lastName, String email, String mobileNum, String password, List<Asset> assets) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobileNum = mobileNum;
        this.password = password;
        this.assets = assets;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Column(name = "emailAddress")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "mobileNumber")
    public String getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "assignedTo", cascade = CascadeType.ALL)
    public List<Asset> getAssets() {
        return assets;
    }

    public void setAssets(List<Asset> assets) {
        this.assets = assets;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Column(name="isAdmin")
    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Column(name="employeeId")
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
}
