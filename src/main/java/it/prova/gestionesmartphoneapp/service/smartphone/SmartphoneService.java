package it.prova.gestionesmartphoneapp.service.smartphone;


import it.prova.gestionesmartphoneapp.dao.smartphone.SmartphoneDAO;
import it.prova.gestionesmartphoneapp.model.Smartphone;

public interface SmartphoneService {

	 void inserisciNuovo(Smartphone smartphoneInstance) throws Exception;
	
	public void setSmartphoneDAO(SmartphoneDAO smartphoneDAO);
}
