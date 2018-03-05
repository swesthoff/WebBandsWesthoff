package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


import model.MarchingBand;

public class MarchingBandHelper {

	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebBandsWesthoff");

	public void insertMarchingBand(MarchingBand toAdd) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();

	}

	public List<MarchingBand> showAllMarchingBands() {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		// creates the query but does not execute it.
		TypedQuery<MarchingBand> allResults = em.createQuery("Select list_item from MarchingBand list_item",
				MarchingBand.class);
		// Selects the info
		List<MarchingBand> allMarchingBands = allResults.getResultList();
		// need to close the entity manager
		em.close();
		return allMarchingBands;
	}

	public void deleteMarchingBand(MarchingBand toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		// Creating they query but does not execute
		TypedQuery<MarchingBand> typedQuery = em.createQuery(
				"Select li from MarchingBand li where li.bandId = :selectedId",

				MarchingBand.class);
		typedQuery.setParameter("selectedId", toDelete.getBandId());

		// Gets the 1st one in the table
		typedQuery.setMaxResults(1);

		MarchingBand result = typedQuery.getSingleResult();

		em.remove(result);
		em.getTransaction().commit();
		System.out.println("Record has been deleted");
		em.close();

	}

	public MarchingBand searchForMarchingBandById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();

		MarchingBand foundItem = em.find(MarchingBand.class, idToEdit);
		em.close(); // close
		// return the results of the query
		return foundItem;
	}

	public void updateMarchingBand(MarchingBand toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close(); // close
		// TODO Auto-generated method stub
		
	}

}
