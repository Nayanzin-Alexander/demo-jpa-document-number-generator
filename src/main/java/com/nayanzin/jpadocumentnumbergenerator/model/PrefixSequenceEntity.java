package com.nayanzin.jpadocumentnumbergenerator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "prefix_sequence_entity")
public class PrefixSequenceEntity {

    @Id
    @Column(name = "prefix", unique = true)
    private String prefix;

    @Column(name = "curr_val")
    private Long currentVal;
}
