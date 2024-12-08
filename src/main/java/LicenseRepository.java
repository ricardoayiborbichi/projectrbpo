package ru.mtuci.projectrbpo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mtuci.projectrbpo.repository.License;

public interface LicenseRepository extends JpaRepository<License, Long> {
}
