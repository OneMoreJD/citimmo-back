package com.wcs.citimmo.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String label;
    @OneToMany(cascade={CascadeType.ALL}, mappedBy="profile")
    private List<User> bList = new ArrayList<User>();

    public Profile() {
    }

    public Profile(String label) {
        this.label = label;
    }

    public Profile(int id, String label) {
        this.id = id;
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
