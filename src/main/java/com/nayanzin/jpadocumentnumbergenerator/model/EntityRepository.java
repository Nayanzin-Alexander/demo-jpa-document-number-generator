package com.nayanzin.jpadocumentnumbergenerator.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EntityRepository extends JpaRepository<Entity, String> {
}
