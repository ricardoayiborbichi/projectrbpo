package ru.mtuci.projectrbpo.UserCredentials.java;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ru.mtuci.projectrbpo.repository.License> licenses;
}
