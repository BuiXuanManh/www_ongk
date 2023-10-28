package fit.se.gk.backend.repositories;

import fit.se.gk.backend.models.Candidate;
import fit.se.gk.backend.models.Experience;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.ws.rs.Path;

import java.util.List;

public class ExperienceRepository {
    private EntityManager em;
    private EntityTransaction tr;

    public ExperienceRepository() {
        em= Connection.getInstance().getEmf().createEntityManager();
        tr= em.getTransaction();
    }
    public boolean insertExpr(Experience experience){
        try {
            tr.begin();
            em.persist(experience);
            tr.commit();
            return true;
        }catch (Exception ex){
            tr.rollback();
        }
        return false;
    }
    public boolean updateExpr(Experience experience){
        try {
            tr.begin();
            em.merge(experience);
            tr.commit();
            return true;
        }catch (Exception ex){
            tr.rollback();
        }
        return false;
    }
    public Experience findById(long id){
        Experience c = em.find(Experience.class, id);
        return c;
    }
    public List<Experience> getAll(){
        List<Experience> l = em.createNamedQuery("Experience.getAll",Experience.class).getResultList();
        return l;
    }
    public List<Experience> findByRoles(int role){
        List<Experience> l = em.createNamedQuery("Experience.findByRole",Experience.class).setParameter(1,role).getResultList();
        return l;
    }
    public List<Experience> findByCanId(Long id){
        List<Experience> l = em.createNamedQuery("Experience.findByCanId", Experience.class).setParameter("id",id).getResultList();
        return l;
    }
}