package ru.mtuci.projectrbpo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository<User> extends JpaRepository<User, Long> {
}
