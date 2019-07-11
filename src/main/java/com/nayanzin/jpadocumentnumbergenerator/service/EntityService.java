package com.nayanzin.jpadocumentnumbergenerator.service;

import com.nayanzin.jpadocumentnumbergenerator.model.Entity;
import com.nayanzin.jpadocumentnumbergenerator.model.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class EntityService {

    private final EntitySequenceService entitySequenceService;
    private final EntityRepository repository;

    @Autowired
    public EntityService(EntitySequenceService entitySequenceService, EntityRepository repository) {
        this.entitySequenceService = entitySequenceService;
        this.repository = repository;
    }

    public void save(Entity entity) {
        long number = entitySequenceService.nextValFor(entity.getPrefix());
        entity.setDocumentNumber(String.format("%s %6d", entity.getPrefix(), number));
        repository.save(entity);
    }

}
