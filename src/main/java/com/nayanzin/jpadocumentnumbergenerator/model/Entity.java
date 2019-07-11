package com.nayanzin.jpadocumentnumbergenerator.model;

import lombok.Data;

import javax.persistence.*;

@Data
@javax.persistence.Entity
@Table(name = "entity")
public class Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entity_id_seq")
    @SequenceGenerator(name = "entity_id_seq", sequenceName = "entity_id_seq", allocationSize = 1)
    private Long id;

    @Transient
    private String prefix;

    @Column(name = "document_number", unique = true)
    private String documentNumber;

    public Entity(String prefix) {
        this.prefix = prefix;
    }
}
