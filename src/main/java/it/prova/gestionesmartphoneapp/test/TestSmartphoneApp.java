package it.prova.gestionesmartphoneapp.test;

import it.prova.gestionesmartphoneapp.dao.EntityManagerUtil;
import it.prova.gestionesmartphoneapp.model.App;
import it.prova.gestionesmartphoneapp.model.Smartphone;
import it.prova.gestionesmartphoneapp.service.app.AppService;
import it.prova.gestionesmartphoneapp.service.MyServiceFactory;
import it.prova.gestionesmartphoneapp.service.smartphone.SmartphoneService;

public class TestSmartphoneApp {

	public static void main(String[] args) {
		SmartphoneService smartphoneServiceInstance = MyServiceFactory.getSmartphoneServiceInstance();
		AppService appServiceInstance = MyServiceFactory.getAppServiceInstance();

		try {
			
//			testInserimentoNuovoSmartphone(smartphoneServiceInstance);
//			testInserimentoNuovaApp(appServiceInstance);
//			testAggiornaVersioneOS(smartphoneServiceInstance);
//			testAggiornaVersioneApp(appServiceInstance);
//			testInstallaAppEsistenti(smartphoneServiceInstance, appServiceInstance);
//			smartphoneServiceInstance.disinstallaApp(1L, 1L);
//			smartphoneServiceInstance.rimuoviMaPrimaDisinstallaApp(2L);
			
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			EntityManagerUtil.shutdown();
		}

	}
	

	private static void testInserimentoNuovoSmartphone(SmartphoneService smartphoneServiceInstance) throws Exception {
		System.out.println(".......testInserimentoNuovoSmartphone inizio.............");

		Smartphone smartphoneInstance = new Smartphone("Samsung", "Galaxy S30", 1000, 12);
		smartphoneServiceInstance.inserisciNuovo(smartphoneInstance);
		if (smartphoneInstance.getId() == null)
			throw new RuntimeException("testInserimentoNuovoSmartphone fallito ");

		System.out.println(".......testInserimentoNuovoSmartphone fine: PASSED.............");
	}
	
	private static void testAggiornaVersioneOS(SmartphoneService smartphoneServiceInstance) throws Exception {
		System.out.println(".......testAggiornaVersioneOS inizio.............");
		
		Smartphone smartphoneInstance = smartphoneServiceInstance.listAll().get(0);
		Integer version = 18;
		smartphoneServiceInstance.aggiornamentoVersioneOsSmartphone(smartphoneInstance,version);
		if (smartphoneInstance.getId() == null)
			throw new RuntimeException("testAggiornaVersioneOS fallito ");

		System.out.println(".......testAggiornaVersioneOS fine: PASSED.............");
	}
	
	
	private static void testInstallaAppEsistenti(SmartphoneService smartphoneServiceInstance, AppService appServiceInstance)
			throws Exception {
		System.out.println(".......testInstallaAppEsistenti inizio.............");

		if (smartphoneServiceInstance.listAll().isEmpty())
			throw new RuntimeException("testInstallaApp fallito: non ci sono smartphone da caricare. ");
		Smartphone smartphoneInstance = smartphoneServiceInstance.listAll().get(1);

		if (appServiceInstance.listAll().isEmpty())
			throw new RuntimeException("testInstallaApp fallito: non ci sono app da caricare. ");
		App appInstance = appServiceInstance.listAll().get(1);

		smartphoneServiceInstance.installaApp(smartphoneInstance, appInstance);


		System.out.println(".......testInstallaAppEsistenti fine: PASSED.............");
	}
	
	
	
	private static void testInserimentoNuovaApp(AppService appServiceInstance) throws Exception {
		System.out.println(".......testInserimentoNuovaApp inizio.............");

		App appInstance = new App("BeReal", 3);
		appServiceInstance.inserisciNuovo(appInstance);

		System.out.println(".......testInserimentoNuovaApp fine: PASSED.............");
	}
	
	

	private static void testAggiornaVersioneApp(AppService appServiceInstance) throws Exception {
		System.out.println(".......testAggiornaVersioneApp inizio.............");
		
		App appInstance = appServiceInstance.listAll().get(0);
		Integer version = 7;
		appServiceInstance.aggiornamentoVersioneEDataUpdate(appInstance,version);

		System.out.println(".......testAggiornaVersioneApp fine: PASSED.............");
	}
	
	
}