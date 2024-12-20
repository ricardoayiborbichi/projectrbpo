package ru.mtuci.projectrbpo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mtuci.projectrbpo.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
