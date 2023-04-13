package it.prova.gestioneordiniarticolicategorie.service;

import java.util.List;

import it.prova.gestioneordiniarticolicategorie.dao.CategoriaDAO;
import it.prova.gestioneordiniarticolicategorie.model.Categoria;

public interface CategoriaService {

	
	// per injection
	public void setCategoriaDAO (CategoriaDAO categoriaDAO);
	
	
	public List<Categoria> listAll() throws Exception;
	
	public Categoria caricaSingoloElemento (Long id) throws Exception;
	
	public void aggiorna (Categoria categoriaInstance) throws Exception;
	
	public void inserisciNuovo (Categoria categoriaInstance) throws Exception;
	
	public void rimuovi (Long idCategoria) throws Exception;
}
