package fit.se.gk.backend.services;

import fit.se.gk.backend.enums.Roles;
import fit.se.gk.backend.models.Candidate;
import fit.se.gk.backend.repositories.CandidateRepository;

import java.time.LocalDate;
import java.util.List;

public class CandidateService {
    private CandidateRepository repository;

    public CandidateService() {
        repository= new CandidateRepository();
    }
    public Candidate findById(long id){
        return repository.findById(id);
    }
    public boolean createCan(Candidate candidate){
        return repository.insertCan(candidate);
    }
    public List<Candidate> getAll(){
        return repository.getAll();
    }
    public Candidate findById(Long id){
        return repository.findById(id);
    }
    public List<Candidate> findByRole(Roles roles){
        return repository.findByRole(roles);
    }
    public List<Candidate> findByEmail(){
        return repository.findByEmail();
    }

}
