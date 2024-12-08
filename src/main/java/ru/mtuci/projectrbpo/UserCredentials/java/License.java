package ru.mtuci.projectrbpo.UserCredentials.java;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class License {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String licenseKey;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private ru.mtuci.projectrbpo.repository.User user;
}
