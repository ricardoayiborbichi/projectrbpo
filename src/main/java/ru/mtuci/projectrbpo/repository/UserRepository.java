package ru.mtuci.projectrbpo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mtuci.projectrbpo.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByLogin(String login);
    boolean existsByLogin(String login);
    boolean existsByEmail(String email);
}