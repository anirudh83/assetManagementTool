package com.xebia.assetManagement.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.ArrayList;
import java.util.List;

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
    private String mobileNum;
    private String password;

    private List<Asset> assetList = new ArrayList<Asset>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Asset> getAssetList() {
        return assetList;
    }

    public void setAssetList(List<Asset> assetList) {
        this.assetList = assetList;
    }
}
