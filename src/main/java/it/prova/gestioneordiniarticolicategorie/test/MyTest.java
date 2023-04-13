package it.prova.gestioneordiniarticolicategorie.test;

import java.time.LocalDate;
import java.util.List;

import javax.management.RuntimeErrorException;

import it.prova.gestioneordiniarticolicategorie.dao.EntityManagerUtil;
import it.prova.gestioneordiniarticolicategorie.model.Articolo;
import it.prova.gestioneordiniarticolicategorie.model.Ordine;
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

//			testInserimentoNuovoOrdine(ordineServiceInstance);
//			System.out.println("In tabella Ordine ci sono " + ordineServiceInstance.listAll().size() + " elementi");

//			testAggiornamentoOrdineEsistente(ordineServiceInstance);
//			System.out.println("In tabella Ordine ci sono " + ordineServiceInstance.listAll().size() + " elementi");

//			testInserimentoNuovoArticolo(ordineServiceInstance, articoloServiceInstance);
//			System.out.println("In tabella Ordine ci sono " + ordineServiceInstance.listAll().size() + " elementi");
//			System.out.println("In tabella Articolo ci sono " + articoloServiceInstance.listAll().size() + " elementi");
			
			testAggiornamentoArticoloEsistente(articoloServiceInstance);
			System.out.println("In tabella Ordine ci sono " + ordineServiceInstance.listAll().size() + " elementi");
			System.out.println("In tabella Articolo ci sono " + articoloServiceInstance.listAll().size() + " elementi");
			
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			EntityManagerUtil.shutdown();
		}

	}

	// metodi static per test

	private static void testInserimentoNuovoOrdine(OrdineService ordineServiceInstance) throws Exception {
		System.out.println("------------- testInserimentoNuovoOrdine INIZIO -------------");

		Ordine ordineDaInserire = new Ordine("Mario Rossi", "Via Mosca 52", LocalDate.of(2023, 04, 21),
				LocalDate.of(2023, 06, 30));
		ordineServiceInstance.inserisciNuovo(ordineDaInserire);
		if (ordineDaInserire.getId() == null) {
			throw new RuntimeException("testInserimentoNuovoOrdine FALLITO: Ordine non inserito.");
		}
		System.out.println("------------- testInserimentoNuovoOrdine FINE -------------");
	}

	private static void testAggiornamentoOrdineEsistente(OrdineService ordineServiceInstance) throws Exception {
		System.out.println("------------- testAggiornamentoOrdineEsistente INIZIO -------------");

		List<Ordine> listaOrdiniPresenti = ordineServiceInstance.listAll();
		if (listaOrdiniPresenti.size() < 1) {
			throw new RuntimeException("testAggiornamentoOrdineEsistente FALLITO: non sono presenti voci nel DB.");
		}

		Ordine ordineDaAggiornare = listaOrdiniPresenti.get(0);
		System.out.println("Prima dell'aggiornamento: " + ordineDaAggiornare);
		String nuovoDestinatario = "Simone Riillo";
		ordineDaAggiornare.setNomeDestinatario(nuovoDestinatario);
		ordineServiceInstance.aggiorna(ordineDaAggiornare);

		Ordine ordineReloaded = ordineServiceInstance.caricaSingoloElemento(ordineDaAggiornare.getId());
		if (ordineReloaded.getId() != ordineDaAggiornare.getId()) {
			throw new RuntimeException("testAggiornamentoOrdineEsistente FALLITO: update non avvenuto.");
		}
		System.out.println("Dopo l'aggiornamento: " + ordineReloaded);
		System.out.println("------------- testInserimentoNuovoOrdine FINE -------------");

	}

	private static void testInserimentoNuovoArticolo(OrdineService ordineServiceInstance,
			ArticoloService articoloServiceInstance) throws Exception {
		System.out.println("------------- testInserimentoNuovoArticolo INIZIO -------------");

		Ordine ordineDaCollegare = new Ordine("Filippo Belli", "Via Prenestina 52", LocalDate.of(2023, 05, 19),
				LocalDate.of(2023, 07, 30));
		ordineServiceInstance.inserisciNuovo(ordineDaCollegare);
		Long idOrdineDaCollegare = ordineDaCollegare.getId();
		if (idOrdineDaCollegare == null) {
			throw new RuntimeException("testInserimentoNuovoArticolo FALLITO: Ordine non inserito.");
		}
		Articolo nuovoArticolo = new Articolo("Scarpe Nike", "12345678", 329D, LocalDate.now());
		nuovoArticolo.setOrdine(ordineDaCollegare);
		articoloServiceInstance.inserisciNuovo(nuovoArticolo);
		if (nuovoArticolo.getId() == null) {
			throw new RuntimeException("testInserimentoNuovoArticolo FALLITO: Articolo non inserito");
		}
		if (!nuovoArticolo.getOrdine().getId().equals(idOrdineDaCollegare)) {
			throw new RuntimeException("testInserimentoNuovoArticolo FALLITO: L'ID dell'ordine non corrisponde");
		}
		System.out.println("------------- testInserimentoNuovoArticolo FINE -------------");

	}

	private static void testAggiornamentoArticoloEsistente (ArticoloService articoloServiceInstance) throws Exception {
		System.out.println("------------- testAggiornamentoArticoloEsistente INIZIO -------------");

		List<Articolo> listaArticoliPresenti = articoloServiceInstance.listAll();
		if (listaArticoliPresenti.size() < 1) {
			throw new RuntimeException("testAggiornamentoOrdineEsistente FALLITO: non sono presenti voci nel DB.");
		}

		Articolo articoloDaAggiornare = listaArticoliPresenti.get(0);
		System.out.println("Prima dell'aggiornamento: " + articoloDaAggiornare);
		String nuovaDescrizione = "Portatile MacBook";
		articoloDaAggiornare.setDescrizione(nuovaDescrizione);
		articoloServiceInstance.aggiorna(articoloDaAggiornare);

		Articolo articoloReloaded = articoloServiceInstance.caricaSingoloElemento(articoloDaAggiornare.getId());
		if (articoloReloaded.getId() != articoloDaAggiornare.getId()) {
			throw new RuntimeException("testAggiornamentoOrdineEsistente FALLITO: update non avvenuto.");
		}
		System.out.println("Dopo l'aggiornamento: " + articoloReloaded);
		System.out.println("------------- testAggiornamentoArticoloEsistente FINE -------------");

		
	}
}
