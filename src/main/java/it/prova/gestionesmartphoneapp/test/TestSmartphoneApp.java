package it.prova.gestionesmartphoneapp.test;


import it.prova.gestionesmartphoneapp.dao.EntityManagerUtil;
import it.prova.gestionesmartphoneapp.model.Smartphone;
import it.prova.gestionesmartphoneapp.service.app.AppService;
import it.prova.gestionesmartphoneapp.service.MyServiceFactory;
import it.prova.gestionesmartphoneapp.service.smartphone.SmartphoneService;

public class TestSmartphoneApp {

	public static void main(String[] args) {
		SmartphoneService smartphoneServiceInstance = MyServiceFactory.getSmartphoneServiceInstance();
		AppService appServiceInstance = MyServiceFactory.getAppServiceInstance();

//		try {
//
//			testInserimentoNuovoSmartphone(smartphoneServiceInstance);
//
//		} catch (Throwable e) {
//			e.printStackTrace();
//		} finally {
//			EntityManagerUtil.shutdown();
//		}

	}


	private static void testInserimentoNuovoSmartphone(SmartphoneService smartphoneServiceInstance) throws Exception {
		System.out.println(".......testInserimentoNuovoSmartphone inizio.............");

		Smartphone smartphoneInstance = new Smartphone("iPhone", "13", 800, "16.0.3");
		smartphoneServiceInstance.inserisciNuovo(smartphoneInstance);
			if (smartphoneInstance.getId() == null)
				throw new RuntimeException("testInserimentoNuovoSmartphone fallito ");

		System.out.println(".......testInserimentoNuovoSmartphone fine: PASSED.............");
	}

}