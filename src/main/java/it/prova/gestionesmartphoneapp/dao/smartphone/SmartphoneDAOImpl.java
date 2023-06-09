package it.prova.gestionesmartphoneapp.dao.smartphone;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestionesmartphoneapp.model.Smartphone;

public class SmartphoneDAOImpl implements SmartphoneDAO {

	private EntityManager entityManager;

	@Override
	public List<Smartphone> list() throws Exception {
		return entityManager.createQuery("from Smartphone", Smartphone.class).getResultList();
	}

	@Override
	public Smartphone get(Long id) throws Exception {
		return entityManager.find(Smartphone.class, id);

	}

	@Override
	public void update(Smartphone input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		input = entityManager.merge(input);

	}

	@Override
	public void insert(Smartphone input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.persist(input);
	}

	@Override
	public void delete(Smartphone input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(input));
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void deleteAppJoin(Long idBranoInput, Long idAppInput) throws Exception {
		entityManager.createNativeQuery("delete from smartphone_app c where c.smartphone_id = ?1 and c.app_id = ?2 ")
				.setParameter(1, idBranoInput).setParameter(2, idAppInput).executeUpdate();
	}

	@Override
	public void deleteSmartphoneAndUnlinkApp(Long idSmartphoneInput) throws Exception {
		entityManager.createNativeQuery("delete from smartphone_app c where c.smartphone_id = ?1")
				.setParameter(1, idSmartphoneInput).executeUpdate();
		entityManager.createNativeQuery("delete from smartphone c where c.id = ?1").setParameter(1, idSmartphoneInput)
				.executeUpdate();
	}

}
