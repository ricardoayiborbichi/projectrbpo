package ru.mtuci.projectrbpo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mtuci.projectrbpo.model.Licence;

public interface LicenceRepository extends JpaRepository<Licence,Long> {
}

