package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Competition;

public class CompetitionHelper {

	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebBandsWesthoff");

	public void insertCompetition(Competition toAdd) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();

	}

	public List<Competition> showAllCompetitions() {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		// creates the query but does not execute it.
		TypedQuery<Competition> allResults = em.createQuery("select li from Competition li "  , Competition.class);
		// Selects the info
		List<Competition> allCompetitions = allResults.getResultList();
		// need to close the entity manager
		em.close();
		return allCompetitions;
	}

//	public Competition searchForCompeitionById(Integer tempId) {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	public void deleteCompetition(Competition toDelete) {
//		// TODO Auto-generated method stub
//		EntityManager em = emfactory.createEntityManager();
//		em.getTransaction().begin();
//		// Creating they query but does not execute
//		TypedQuery<Competition> typedQuery = em.createQuery("Select li from Competition li where li.bandId = :selectedId",
//
//				Competition.class);
//		typedQuery.setParameter("selectedId", toDelete.getBandId());
//
//		// Gets the 1st one in the table
//		typedQuery.setMaxResults(1);
//
//		Competition result = typedQuery.getSingleResult();
//
//		em.remove(result);
//		em.getTransaction().commit();
//		System.out.println("Record has been deleted");
//		em.close();
//
//	}
//
//	public Competition searchForCompetitionById(int idToEdit) {
//		// TODO Auto-generated method stub
//		EntityManager em = emfactory.createEntityManager();
//		em.getTransaction().begin();
//
//		Competition foundItem = em.find(Competition.class, idToEdit);
//		em.close(); // close
//		// return the results of the query
//		return foundItem;
//	}
//
//	public void updateCompetition(Competition toEdit) {
//		EntityManager em = emfactory.createEntityManager();
//		em.getTransaction().begin();
//		em.merge(toEdit);
//		em.getTransaction().commit();
//		em.close(); // close
//		// TODO Auto-generated method stub
//
//	}

}
