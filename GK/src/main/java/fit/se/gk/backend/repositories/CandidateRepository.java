package fit.se.gk.backend.repositories;

import fit.se.gk.backend.enums.Roles;
import fit.se.gk.backend.models.Candidate;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.ws.rs.Path;

import java.util.List;

public class CandidateRepository {
    private EntityManager em;
    private EntityTransaction tr;

    public CandidateRepository() {
        em= Connection.getInstance().getEmf().createEntityManager();
        tr= em.getTransaction();
    }
    public boolean insertCan(Candidate candidate){
        try {
            tr.begin();
            em.persist(candidate);
            tr.commit();
            return true;
        }catch (Exception ex){
            tr.rollback();
        }
        return false;
    }
    public boolean updateCan(Candidate candidate){
        try {
            tr.begin();
            em.merge(candidate);
            tr.commit();
            return true;
        }catch (Exception ex){
            tr.rollback();
        }
        return false;
    }
    public Candidate findById(long id){
        Candidate c = em.find(Candidate.class, id);
        return c;
    }
    public List<Candidate> getAll(){
        List<Candidate> l = em.createNamedQuery("Candidate.getAll",Candidate.class).getResultList();
        return l;
    }
    public List<Candidate> findByEmail(){
        List<Candidate> l = em.createNamedQuery("Candidate.getByEmail",Candidate.class).getResultList();
        return l;
    }
    public List<Candidate> findByRole(Roles roles){
        List<Candidate> l = em.createNamedQuery("Candidate.getByRole", Candidate.class).setParameter("role", roles).getResultList();
        return l;
    }
}
