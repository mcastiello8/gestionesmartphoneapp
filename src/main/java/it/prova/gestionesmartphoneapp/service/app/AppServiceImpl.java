package it.prova.gestionesmartphoneapp.service.app;

import it.prova.gestionesmartphoneapp.dao.app.AppDAO;

public class AppServiceImpl implements AppService {
	
	private AppDAO appDAO;

	@Override
	public void setAppDAO(AppDAO appDAO) {
		this.appDAO = appDAO;
	}
}
