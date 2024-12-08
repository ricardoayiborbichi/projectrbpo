package ru.mtuci.projectrbpo.service;


import org.springframework.stereotype.Service;
import ru.mtuci.projectrbpo.model.Licence;
import ru.mtuci.projectrbpo.repository.LicenceRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LicenceService {
    private final LicenceRepository licenceRepository;

    public LicenceService(LicenceRepository licenceRepository) {
        this.licenceRepository = licenceRepository;
    }

    public List<Licence> getAllLicences() {
        return licenceRepository.findAll();
    }

    public Optional<Licence> getLicenceById(Long id) {
        return licenceRepository.findById(id);
    }

    public Licence saveLicence(Licence licence) {
        return licenceRepository.save(licence);
    }

    public void deleteLicence(Long id) {
        licenceRepository.deleteById(id);
    }

    // Additional business logic methods (if needed) can be added here
}
