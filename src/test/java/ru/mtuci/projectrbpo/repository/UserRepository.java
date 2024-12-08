package ru.mtuci.projectrbpo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mtuci.projectrbpo.repository.User;

public interface UserRepository<User> extends JpaRepository<User, Long> {
}
