package com.wcs.citimmo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique=true)
    private String label;
    @OneToMany(cascade={CascadeType.ALL}, mappedBy="profile")
    private List<User> bList = new ArrayList<>();

    public Profile(String label) {
        this.label = label;
    }

}
