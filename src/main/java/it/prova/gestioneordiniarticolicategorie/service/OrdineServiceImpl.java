package it.prova.gestioneordiniarticolicategorie.service;

import java.util.List;

import it.prova.gestioneordiniarticolicategorie.dao.OrdineDAO;
import it.prova.gestioneordiniarticolicategorie.model.Ordine;

public class OrdineServiceImpl implements OrdineService {

	private OrdineDAO ordineDAO;
	
	@Override
	public void setOrdineDAO(OrdineDAO ordineDAO) {
		this.ordineDAO = ordineDAO;
	}

	@Override
	public List<Ordine> listAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ordine caricaSingoloElemento(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void aggiorna(Ordine ordineInstance) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inserisciNuovo(Ordine ordineInstance) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rimuovi(Long idOrdine) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
