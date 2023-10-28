package fit.se.gk.frontend.model;

import fit.se.gk.backend.models.Experience;
import fit.se.gk.backend.services.ExperienceService;

public class ExperienceModel {
    private ExperienceService service;

    public ExperienceModel() {
        service= new ExperienceService();
    }
    public void insert(Experience experience){
        service.insert(experience);
    }
}
