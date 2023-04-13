package it.prova.gestioneordiniarticolicategorie.dao;

import it.prova.gestioneordiniarticolicategorie.model.Ordine;

public interface OrdineDAO extends IBaseDAO<Ordine>{
	
	public Ordine getEagerArticoli (Long idOrdine) throws Exception;
}
