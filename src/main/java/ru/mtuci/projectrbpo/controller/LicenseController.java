package ru.mtuci.projectrbpo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mtuci.projectrbpo.repository.LicenseRepository;

import java.util.List;

@RestController
@RequestMapping("/licenses")
public class LicenseController {
    private final LicenseRepository licenseRepository;

    public LicenseController(LicenseRepository licenseRepository) {
        this.licenseRepository = licenseRepository;
    }

    @GetMapping
    public List<ru.mtuci.projectrbpo.repository.License> getAllLicenses() {
        return licenseRepository.findAll();
    }

    @PostMapping
    public License createLicense(@RequestBody License license) {

        return license;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLicense(@PathVariable Long id) {
        licenseRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
