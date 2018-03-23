package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Bands;

public class BandHelper {

	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebBandsWesthoff");

	public void insertBands(Bands toAdd) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();
		
	}

	public List<Bands> showAllBands() {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		// creates the query but does not execute it.
		TypedQuery<Bands> allResults = em.createQuery("Select li from Bands li where li.bandType = 'RegBand'", Bands.class);
		// Selects the info
		List<Bands> allBands = allResults.getResultList();
		// need to close the entity manager
		em.close();

		return allBands;

	}
	public List<Bands> showAllMarchingBands() {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		// creates the query but does not execute it.
		TypedQuery<Bands> allMBResults = em.createQuery("Select li from Bands li where li.bandType = 'Marching'", Bands.class);
		// Selects the info
		List<Bands> allMarchingBands = allMBResults.getResultList();
		// need to close the entity manager
		em.close();

		return allMarchingBands;

	}
	
	//Need to get the name of band where participating_band matches
//select a.name_of_band, b.band_id from band a, participating_bands b where a.band_id = b.band_id;
	//select * from band where band_type = 'partBands';
	
	// https://www.objectdb.com/java/jpa/query/jpql/from
	public List<Bands> showAllPartBands() {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		// creates the query but does not execute it.
		TypedQuery<Bands> allPBResults = em.createQuery("Select li, pb from Bands li, participating_bands pb  where li.bandType = 'partBands' and li band_id of pb.band_id", Bands.class);
		// Selects the info
		List<Bands> allPartBands = allPBResults.getResultList();
		// need to close the entity manager
		em.close();

		return allPartBands;

	}
	
	public void deleteBand(Bands toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		// Creating they query but does not execute
		TypedQuery<Bands> typedQuery = em.createQuery("Select li from Bands li where li.bandId = :selectedId",
				                                    			
				Bands.class);
		typedQuery.setParameter("selectedId", toDelete.getBandId());

		// Gets the 1st one in the table
		typedQuery.setMaxResults(1);

		Bands result = typedQuery.getSingleResult();

		em.remove(result);
		em.getTransaction().commit();
		System.out.println("Record has been deleted");
		em.close();

	}

	public Bands searchForBandById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();

		Bands foundItem = em.find(Bands.class, idToEdit);
		em.close(); // close
		// return the results of the query
		return foundItem;
	}

	
	public Bands searchForBandNameById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();

		Bands foundItem = em.find(Bands.class, idToEdit);
		System.out.println("found Item " + foundItem);
		em.close(); // close
		// return the results of the query
		return foundItem;
	}

	public void updateBand(Bands toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close(); // close
	}

	
	
}
