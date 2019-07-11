package com.nayanzin.jpadocumentnumbergenerator.service;

import com.nayanzin.jpadocumentnumbergenerator.model.PrefixSequenceEntity;
import com.nayanzin.jpadocumentnumbergenerator.model.PrefixSequenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
// @Transactional(isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
@Transactional(rollbackFor = Exception.class)
public class EntitySequenceService {

    private final PrefixSequenceRepository repository;

    @Autowired
    public EntitySequenceService(PrefixSequenceRepository repository) {
        this.repository = repository;
    }

    public long nextValFor(String prefix) {
        if (! repository.existsById(prefix)) {
            repository.save(new PrefixSequenceEntity(prefix, 300_000L));
        }
        return repository.getNexValFor(prefix);
    }
}
