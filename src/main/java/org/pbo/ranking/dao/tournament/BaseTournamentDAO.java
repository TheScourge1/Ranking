package org.pbo.ranking.dao.tournament;

import org.pbo.ranking.dao.RankingDAOException;
import org.pbo.ranking.model.tournament.BaseTournamentEntity;
import org.slf4j.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.validation.ConstraintViolationException;

@Stateless
public class BaseTournamentDAO<T extends BaseTournamentEntity> {

    @PersistenceContext(unitName="Ranking")
    private EntityManager em;

    @Inject
    Logger log;

    public T find(T entity) {
        if(entity == null || entity.getId() == null) return null;

        T result = (T)em.find(entity.getClass(), entity.getId());
        return result;
    }

    public void persist(T entity) throws RankingDAOException {
        try{
                em.persist(entity);
        }catch(ConstraintViolationException ex)
        {
            ex.getConstraintViolations().forEach( e -> log.error(e.getMessage() +  ":" + e.getLeafBean() + "=" + e.getInvalidValue()));
            throw new RankingDAOException("Error saving: "+entity,ex);
        }
        catch(PersistenceException ex)
        {
            throw new RankingDAOException("Error saving: "+entity,ex);
        }
    }


    public T update(T entity) throws RankingDAOException {
        try{
            return em.merge(entity);
        }catch(ConstraintViolationException ex)
        {
            ex.getConstraintViolations().forEach( e -> log.error(e.getMessage() +  ":" + e.getLeafBean() + "=" + e.getInvalidValue()));
            throw new RankingDAOException("Error updating: "+entity,ex);
        }
        catch(PersistenceException ex)
        {
            throw new RankingDAOException("Error updating: "+entity,ex);
        }
    }

    public void delete(T entity) throws RankingDAOException{
        try{
            em.remove(entity);
        }catch(ConstraintViolationException ex)
        {
            ex.getConstraintViolations().forEach( e -> log.error(e.getMessage() +  ":" + e.getLeafBean() + "=" + e.getInvalidValue()));
            throw new RankingDAOException("Error deleting: "+entity,ex);
        }
        catch(PersistenceException ex)
        {
            throw new RankingDAOException("Error deleting: "+entity,ex);
        }

    }

}
