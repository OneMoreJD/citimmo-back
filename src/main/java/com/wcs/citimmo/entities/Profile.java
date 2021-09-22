package com.wcs.citimmo.entities;

import com.wcs.citimmo.enums.ProfileEnum;

import javax.persistence.*;

@Entity
@Table(name = "profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private ProfileEnum profileName;

    @OneToOne(mappedBy = "user")
    private User user;

    public Profile(ProfileEnum profileName) {
        this.profileName = profileName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProfileEnum getProfileName() {
        return profileName;
    }

    public void setProfileName(ProfileEnum profileName) {
        this.profileName = profileName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
