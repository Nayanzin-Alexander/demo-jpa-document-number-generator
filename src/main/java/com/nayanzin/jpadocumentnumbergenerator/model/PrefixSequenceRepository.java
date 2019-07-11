package com.nayanzin.jpadocumentnumbergenerator.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PrefixSequenceRepository extends CrudRepository<PrefixSequenceEntity, String> {

    @Query(value = "" +
            " UPDATE prefix_sequence_entity" +
            " SET curr_val = 1 + curr_val" +
            " where prefix = :prefix" +
            " returning curr_val", nativeQuery = true)
    long getNexValFor(@Param("prefix") String prefix);
}
