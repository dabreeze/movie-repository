package com.groupone.movierepobackend.data.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Setter
@Getter
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;

    @Column(nullable = false)
    private String password;

    @OneToMany
    private List<Playlist> playlists;

    @Column(unique = true, nullable = false)
    private String email;
    @CreationTimestamp
    private LocalDateTime dateCreated;


}
