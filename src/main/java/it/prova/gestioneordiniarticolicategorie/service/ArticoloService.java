package it.prova.gestioneordiniarticolicategorie.service;

import java.util.List;

import it.prova.gestioneordiniarticolicategorie.dao.ArticoloDAO;
import it.prova.gestioneordiniarticolicategorie.model.Articolo;

public interface ArticoloService {

	//per injection
	public void setArticoloDAO (ArticoloDAO articoloDAO);
	
	
	public List<Articolo> listAll() throws Exception;
	
	public Articolo caricaSingoloElemento(Long id) throws Exception;
	
	public void aggiorna (Articolo articoloInstance) throws Exception;
	
	public void inserisciNuovo (Articolo articoloInstance) throws Exception;
	
	public void rimuovi (Long idArticolo) throws Exception;
}
