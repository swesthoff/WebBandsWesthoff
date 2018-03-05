package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.PepBand;

public class PepBandHelper {

	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebBandsWesthoff");

	public void insertPepBand(PepBand toAdd) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();

	}

	public List<PepBand> showAllPepBands() {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		// creates the query but does not execute it.
		TypedQuery<PepBand> allResults = em.createQuery("Select list_item from PepBand list_item", PepBand.class);
		// Selects the info
		List<PepBand> allPepBands = allResults.getResultList();
		// need to close the entity manager
		em.close();
		return allPepBands;
	}

	public void deletePepBand(PepBand toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		// Creating they query but does not execute
		TypedQuery<PepBand> typedQuery = em.createQuery("Select li from PepBand li where li.bandId = :selectedId",

				PepBand.class);
		typedQuery.setParameter("selectedId", toDelete.getBandId());

		// Gets the 1st one in the table
		typedQuery.setMaxResults(1);

		PepBand result = typedQuery.getSingleResult();

		em.remove(result);
		em.getTransaction().commit();
		System.out.println("Record has been deleted");
		em.close();

	}

	public PepBand searchForPepBandById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();

		PepBand foundItem = em.find(PepBand.class, idToEdit);
		em.close(); // close
		// return the results of the query
		return foundItem;
	}

	public void updatePepBand(PepBand toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close(); // close
		// TODO Auto-generated method stub

	}

}
