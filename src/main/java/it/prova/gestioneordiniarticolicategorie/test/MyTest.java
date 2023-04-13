package it.prova.gestioneordiniarticolicategorie.test;

import it.prova.gestioneordiniarticolicategorie.dao.EntityManagerUtil;
import it.prova.gestioneordiniarticolicategorie.service.ArticoloService;
import it.prova.gestioneordiniarticolicategorie.service.CategoriaService;
import it.prova.gestioneordiniarticolicategorie.service.MyServiceFactory;
import it.prova.gestioneordiniarticolicategorie.service.OrdineService;

public class MyTest {

	public static void main(String[] args) {

		OrdineService ordineServiceInstance = MyServiceFactory.getOrdineServiceInstance();
		ArticoloService articoloServiceInstance = MyServiceFactory.getArticoloServiceInstance();
		CategoriaService categoriaServiceInstance = MyServiceFactory.getCategoriaServiceInstance();

		try {

			System.out.println("In tabella Ordine ci sono " + ordineServiceInstance.listAll().size() + " elementi");
			System.out.println("In tabella Articolo ci sono " + articoloServiceInstance.listAll().size() + " elementi");
			System.out
					.println("In tabella Categoria ci sono " + categoriaServiceInstance.listAll().size() + " elementi");

			System.out.println(
					"**************************** inizio batteria di test ********************************************");
			System.out.println(
					"*************************************************************************************************");

		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			EntityManagerUtil.shutdown();
		}

	}
	
	
	
	
	

}
