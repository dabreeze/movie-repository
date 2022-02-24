package com.groupone.movierepobackend.data.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private UserAccount user;
    private String name;
    private String description;

}
