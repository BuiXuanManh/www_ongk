package fit.se.gk.backend.services;

import fit.se.gk.backend.models.Experience;
import fit.se.gk.backend.repositories.ExperienceRepository;

import java.util.List;

public class ExperienceService {
    private ExperienceRepository repository;

    public ExperienceService() {
        repository= new ExperienceRepository();
    }
    public boolean insert(Experience experience){
        return repository.insertExpr(experience);
    }
    public List<Experience> findByCanId(Long id){
        return repository.findByCanId(id);
    }

}
