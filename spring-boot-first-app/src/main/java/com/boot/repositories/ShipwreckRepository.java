package com.boot.repositories;

import com.boot.models.Shipwreck;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface of the CRUD for the shipwrecks. The concrete class is automatically provided by Spring Data JPA.
 */
public interface ShipwreckRepository extends JpaRepository<Shipwreck, Long> {
}
