package it.prova.gestioneordiniarticolicategorie.dao;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestioneordiniarticolicategorie.model.Categoria;

public class CategoriaDAOImpl implements CategoriaDAO{

	
	private EntityManager entityManager;
	
	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	@Override
	public List<Categoria> list() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categoria get(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Categoria o) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(Categoria o) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Categoria o) throws Exception {
		// TODO Auto-generated method stub
		
	}



}
