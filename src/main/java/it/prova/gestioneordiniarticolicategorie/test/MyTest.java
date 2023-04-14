package it.prova.gestioneordiniarticolicategorie.test;

import java.time.LocalDate;
import java.util.List;

import javax.management.RuntimeErrorException;

import it.prova.gestioneordiniarticolicategorie.dao.EntityManagerUtil;
import it.prova.gestioneordiniarticolicategorie.model.Articolo;
import it.prova.gestioneordiniarticolicategorie.model.Categoria;
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

			testInserimentoNuovoOrdine(ordineServiceInstance);
			System.out.println("In tabella Ordine ci sono " + ordineServiceInstance.listAll().size() + " elementi");

			testAggiornamentoOrdineEsistente(ordineServiceInstance);
			System.out.println("In tabella Ordine ci sono " + ordineServiceInstance.listAll().size() + " elementi");

			testInserimentoNuovoArticolo(ordineServiceInstance, articoloServiceInstance);
			System.out.println("In tabella Ordine ci sono " + ordineServiceInstance.listAll().size() + " elementi");
			System.out.println("In tabella Articolo ci sono " + articoloServiceInstance.listAll().size() + " elementi");

			testAggiornamentoArticoloEsistente(articoloServiceInstance);
			System.out.println("In tabella Ordine ci sono " + ordineServiceInstance.listAll().size() + " elementi");
			System.out.println("In tabella Articolo ci sono " + articoloServiceInstance.listAll().size() + " elementi");

			testRimozioneArticoloDaOrdine(articoloServiceInstance, ordineServiceInstance);
			System.out.println("In tabella Ordine ci sono " + ordineServiceInstance.listAll().size() + " elementi");
			System.out.println("In tabella Articolo ci sono " + articoloServiceInstance.listAll().size() + " elementi");

			testInserimentoNuovaCategoria(categoriaServiceInstance);
			System.out
					.println("In tabella Categoria ci sono " + categoriaServiceInstance.listAll().size() + " elementi");

			testAggiornamentoCategoriaEsistente(categoriaServiceInstance);
			System.out
					.println("In tabella Categoria ci sono " + categoriaServiceInstance.listAll().size() + " elementi");

			testAssociaArticoloACategoria(articoloServiceInstance, categoriaServiceInstance, ordineServiceInstance);
			System.out.println("In tabella Articolo ci sono " + articoloServiceInstance.listAll().size() + " elementi");
			System.out
					.println("In tabella Categoria ci sono " + categoriaServiceInstance.listAll().size() + " elementi");

			testAssociaCategoriaAdArticolo(articoloServiceInstance, categoriaServiceInstance, ordineServiceInstance);
			System.out.println("In tabella Articolo ci sono " + articoloServiceInstance.listAll().size() + " elementi");
			System.out
					.println("In tabella Categoria ci sono " + categoriaServiceInstance.listAll().size() + " elementi");

			testRimozioneCompletaArticolo(articoloServiceInstance, categoriaServiceInstance, ordineServiceInstance);
			System.out.println("In tabella Articolo ci sono " + articoloServiceInstance.listAll().size() + " elementi");
			System.out
					.println("In tabella Categoria ci sono " + categoriaServiceInstance.listAll().size() + " elementi");
//			

			testRimozioneCompletaCategoria(articoloServiceInstance, categoriaServiceInstance, ordineServiceInstance);
			System.out.println("In tabella Articolo ci sono " + articoloServiceInstance.listAll().size() + " elementi");
			System.out
					.println("In tabella Categoria ci sono " + categoriaServiceInstance.listAll().size() + " elementi");
//			

			testRimuoviOrdine(ordineServiceInstance, articoloServiceInstance);
			System.out.println("In tabella Ordine ci sono " + ordineServiceInstance.listAll().size() + " elementi");
			System.out.println("In tabella Articolo ci sono " + articoloServiceInstance.listAll().size() + " elementi");

			testListaOrdiniPerCategoria(ordineServiceInstance, articoloServiceInstance, categoriaServiceInstance);
			System.out.println("In tabella Ordine ci sono " + ordineServiceInstance.listAll().size() + " elementi");
			System.out.println("In tabella Articolo ci sono " + articoloServiceInstance.listAll().size() + " elementi");
			System.out
					.println("In tabella Categoria ci sono " + categoriaServiceInstance.listAll().size() + " elementi");

			testListaCategoriaPerOrdine(ordineServiceInstance, articoloServiceInstance, categoriaServiceInstance);
			System.out.println("In tabella Ordine ci sono " + ordineServiceInstance.listAll().size() + " elementi");
			System.out.println("In tabella Articolo ci sono " + articoloServiceInstance.listAll().size() + " elementi");
			System.out
					.println("In tabella Categoria ci sono " + categoriaServiceInstance.listAll().size() + " elementi");

			testSommaPrezziArticoliDiUnaCategoria(ordineServiceInstance, articoloServiceInstance,
					categoriaServiceInstance);
			System.out.println("In tabella Ordine ci sono " + ordineServiceInstance.listAll().size() + " elementi");
			System.out.println("In tabella Articolo ci sono " + articoloServiceInstance.listAll().size() + " elementi");
			System.out
					.println("In tabella Categoria ci sono " + categoriaServiceInstance.listAll().size() + " elementi");

			testOrdinePiuRecentePerCategoria(ordineServiceInstance, articoloServiceInstance, categoriaServiceInstance);
			System.out.println("In tabella Ordine ci sono " + ordineServiceInstance.listAll().size() + " elementi");
			System.out.println("In tabella Articolo ci sono " + articoloServiceInstance.listAll().size() + " elementi");
			System.out
					.println("In tabella Categoria ci sono " + categoriaServiceInstance.listAll().size() + " elementi");

			testListaCodiceCategoriaInUnDeterminatoMese(ordineServiceInstance, articoloServiceInstance,
					categoriaServiceInstance);
			System.out.println("In tabella Ordine ci sono " + ordineServiceInstance.listAll().size() + " elementi");
			System.out.println("In tabella Articolo ci sono " + articoloServiceInstance.listAll().size() + " elementi");
			System.out
					.println("In tabella Categoria ci sono " + categoriaServiceInstance.listAll().size() + " elementi");

			testSommaPrezzoArticoliPerUnDestinatario(ordineServiceInstance, articoloServiceInstance,
					categoriaServiceInstance);
			System.out.println("In tabella Ordine ci sono " + ordineServiceInstance.listAll().size() + " elementi");
			System.out.println("In tabella Articolo ci sono " + articoloServiceInstance.listAll().size() + " elementi");
			System.out
					.println("In tabella Categoria ci sono " + categoriaServiceInstance.listAll().size() + " elementi");

			testListaIndirizziConArticoliContenentiNumeroSeriale(ordineServiceInstance, articoloServiceInstance,
					categoriaServiceInstance);
			System.out.println("In tabella Ordine ci sono " + ordineServiceInstance.listAll().size() + " elementi");
			System.out.println("In tabella Articolo ci sono " + articoloServiceInstance.listAll().size() + " elementi");
			System.out
					.println("In tabella Categoria ci sono " + categoriaServiceInstance.listAll().size() + " elementi");

			testListaArticoliConErroriInOrdine(ordineServiceInstance, articoloServiceInstance,
					categoriaServiceInstance);
			System.out.println("In tabella Ordine ci sono " + ordineServiceInstance.listAll().size() + " elementi");
			System.out.println("In tabella Articolo ci sono " + articoloServiceInstance.listAll().size() + " elementi");
			System.out
					.println("In tabella Categoria ci sono " + categoriaServiceInstance.listAll().size() + " elementi");

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
		System.out.println("------------- testAggiornamentoOrdineEsistente FINE -------------");

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

	private static void testAggiornamentoArticoloEsistente(ArticoloService articoloServiceInstance) throws Exception {
		System.out.println("------------- testAggiornamentoArticoloEsistente INIZIO -------------");

		List<Articolo> listaArticoliPresenti = articoloServiceInstance.listAll();
		if (listaArticoliPresenti.size() < 1) {
			throw new RuntimeException("testAggiornamentoArticoloEsistente FALLITO: non sono presenti voci nel DB.");
		}

		Articolo articoloDaAggiornare = listaArticoliPresenti.get(0);
		System.out.println("Prima dell'aggiornamento: " + articoloDaAggiornare);
		String nuovaDescrizione = "Portatile MacBook";
		articoloDaAggiornare.setDescrizione(nuovaDescrizione);
		articoloServiceInstance.aggiorna(articoloDaAggiornare);

		Articolo articoloReloaded = articoloServiceInstance.caricaSingoloElemento(articoloDaAggiornare.getId());
		if (articoloReloaded.getId() != articoloDaAggiornare.getId()) {
			throw new RuntimeException("testAggiornamentoArticoloEsistente FALLITO: update non avvenuto.");
		}
		System.out.println("Dopo l'aggiornamento: " + articoloReloaded);
		System.out.println("------------- testAggiornamentoArticoloEsistente FINE -------------");

	}

	private static void testRimozioneArticoloDaOrdine(ArticoloService articoloServiceInstance,
			OrdineService ordineServiceInstance) throws Exception {
		System.out.println("------------- testRimozioneArticoloDaOrdine INIZIO -------------");
		List<Ordine> listaOrdiniPresenti = ordineServiceInstance.listAll();
		if (listaOrdiniPresenti.size() < 1) {
			throw new RuntimeException("testRimozioneArticoloDaOrdine FALLITO: non sono presenti voci nel DB.");
		}

		Ordine ordineDaCollegare = listaOrdiniPresenti.get(0);
		Long idOrdineDaCollegare = ordineDaCollegare.getId();
		Articolo nuovoArticolo = new Articolo("Scarpe Nike", "12345678", 329D, LocalDate.now());
		nuovoArticolo.setOrdine(ordineDaCollegare);
		articoloServiceInstance.inserisciNuovo(nuovoArticolo);
		if (nuovoArticolo.getId() == null) {
			throw new RuntimeException("testRimozioneArticoloDaOrdine FALLITO: Articolo non inserito");
		}
		if (!nuovoArticolo.getOrdine().getId().equals(idOrdineDaCollegare)) {
			throw new RuntimeException("testRimozioneArticoloDaOrdine FALLITO: L'ID dell'ordine non corrisponde");
		}
		Long idArticoloDaEliminare = nuovoArticolo.getId();
		articoloServiceInstance.rimuovi(idArticoloDaEliminare);
		Articolo articoloSupposedToBeRemoved = articoloServiceInstance.caricaSingoloElemento(idArticoloDaEliminare);
		if (articoloSupposedToBeRemoved != null) {
			throw new RuntimeException("testRimozioneArticoloDaOrdine FALLITO: articolo non rimosso");
		}
		System.out.println("------------- testRimozioneArticoloDaOrdine FINE -------------");
	}

	private static void testInserimentoNuovaCategoria(CategoriaService categoriaServiceInstance) throws Exception {
		System.out.println("------------- testInserimentoNuovaCategoria INIZIO -------------");

		Categoria categoriaDaInserire = new Categoria("Abbigliamento", "001");
		categoriaServiceInstance.inserisciNuovo(categoriaDaInserire);
		if (categoriaDaInserire.getId() == null) {
			throw new RuntimeException("testInserimentoNuovaCategoria FALLITO: Ordine non inserito.");
		}
		System.out.println("------------- testInserimentoNuovaCategoria FINE -------------");
	}

	private static void testAggiornamentoCategoriaEsistente(CategoriaService categoriaServiceInstance)
			throws Exception {
		System.out.println("------------- testAggiornamentoCategoriaEsistente INIZIO -------------");

		List<Categoria> listaCategoriePresenti = categoriaServiceInstance.listAll();
		if (listaCategoriePresenti.size() < 1) {
			throw new RuntimeException("testAggiornamentoCategoriaEsistente FALLITO: non sono presenti voci nel DB.");
		}

		Categoria categoriaDaAggiornare = listaCategoriePresenti.get(0);
		System.out.println("Prima dell'aggiornamento: " + categoriaDaAggiornare);
		String nuovaDescrizione = "Informatica";
		categoriaDaAggiornare.setDescrizione(nuovaDescrizione);
		categoriaServiceInstance.aggiorna(categoriaDaAggiornare);

		Categoria categoriaReloaded = categoriaServiceInstance.caricaSingoloElemento(categoriaDaAggiornare.getId());
		if (categoriaReloaded.getId() != categoriaDaAggiornare.getId()) {
			throw new RuntimeException("testAggiornamentoCategoriaEsistente FALLITO: update non avvenuto.");
		}
		System.out.println("Dopo l'aggiornamento: " + categoriaReloaded);
		System.out.println("------------- testAggiornamentoCategoriaEsistente FINE -------------");

	}

	private static void testAssociaArticoloACategoria(ArticoloService articoloServiceInstance,
			CategoriaService categoriaServiceInstance, OrdineService ordineServiceInstance) throws Exception {
		System.out.println("------------- testAssociaArticoloECategoria INIZIO -------------");
		Categoria nuovaCategoria = new Categoria("Abbigliamento", "201");
		categoriaServiceInstance.inserisciNuovo(nuovaCategoria);
		if (nuovaCategoria.getId() == null) {
			throw new RuntimeException("testAssociaArticoloECategoria FALLITO: Ordine non inserito.");
		}
		Ordine nuovoOrdine = new Ordine("Luca De Luca", "Via Casilina 52", LocalDate.of(2023, 5, 31),
				LocalDate.of(2023, 8, 30));
		ordineServiceInstance.inserisciNuovo(nuovoOrdine);
		if (nuovoOrdine.getId() == null) {
			throw new RuntimeException("testAssociaArticoloECategoria FALLITO: Ordine non inserito.");
		}
		Articolo nuovoArticolo = new Articolo("Scarpe Nike", "0001", 299D, LocalDate.now());
		nuovoArticolo.setOrdine(nuovoOrdine);
		articoloServiceInstance.inserisciNuovo(nuovoArticolo);
		if (nuovoArticolo.getId() == null) {
			throw new RuntimeException("testAssociaArticoloECategoria FALLITO: Ordine non inserito.");
		}

		categoriaServiceInstance.aggiungiArticolo(nuovaCategoria, nuovoArticolo);
		Categoria categoriaReloaded = categoriaServiceInstance.caricaCategoriaEager(nuovaCategoria.getId());
		if (categoriaReloaded.getArticoli().isEmpty()) {
			throw new RuntimeException("testAssociaArticoloECategoria FALLITO: articolo non associato a categoria");
		}

		System.out.println("------------- testAssociaArticoloECategoria FINE -------------");

	}

	private static void testAssociaCategoriaAdArticolo(ArticoloService articoloServiceInstance,
			CategoriaService categoriaServiceInstance, OrdineService ordineServiceInstance) throws Exception {
		System.out.println("------------- testAssociaCategoriaAdArticolo INIZIO -------------");
		Categoria nuovaCategoria = new Categoria("Abbigliamento", "201");
		categoriaServiceInstance.inserisciNuovo(nuovaCategoria);
		if (nuovaCategoria.getId() == null) {
			throw new RuntimeException("testAssociaCategoriaAdArticolo FALLITO: Ordine non inserito.");
		}
		Ordine nuovoOrdine = new Ordine("Luca De Luca", "Via Casilina 52", LocalDate.of(2023, 5, 31),
				LocalDate.of(2023, 8, 30));
		ordineServiceInstance.inserisciNuovo(nuovoOrdine);
		if (nuovoOrdine.getId() == null) {
			throw new RuntimeException("testAssociaCategoriaAdArticolo FALLITO: Ordine non inserito.");
		}
		Articolo nuovoArticolo = new Articolo("Scarpe Nike", "0001", 299D, LocalDate.now());
		nuovoArticolo.setOrdine(nuovoOrdine);
		articoloServiceInstance.inserisciNuovo(nuovoArticolo);
		if (nuovoArticolo.getId() == null) {
			throw new RuntimeException("testAssociaCategoriaAdArticolo FALLITO: Ordine non inserito.");
		}

		articoloServiceInstance.aggiungiCategoria(nuovoArticolo, nuovaCategoria);
		Articolo articoloReloaded = articoloServiceInstance.caricaArticoloEager(nuovoArticolo.getId());
		if (articoloReloaded.getCategorie().isEmpty()) {
			throw new RuntimeException("testAssociaCategoriaAdArticolo FALLITO: articolo non associato a categoria");
		}

		System.out.println("------------- testAssociaCategoriaAdArticolo FINE -------------");
	}

	private static void testRimozioneCompletaArticolo(ArticoloService articoloServiceInstance,
			CategoriaService categoriaServiceInstance, OrdineService ordineServiceInstance) throws Exception {
		System.out.println("------------- testRimozioneCompletaArticolo INIZIO -------------");
		Categoria nuovaCategoria1 = new Categoria("Abbigliamento", "201");
		Categoria nuovaCategoria2 = new Categoria("Informatica", "202");
		categoriaServiceInstance.inserisciNuovo(nuovaCategoria1);
		categoriaServiceInstance.inserisciNuovo(nuovaCategoria2);
		if (nuovaCategoria1.getId() == null) {
			throw new RuntimeException("testRimozioneCompletaArticolo FALLITO: categoria non inserita.");
		}
		if (nuovaCategoria2.getId() == null) {
			throw new RuntimeException("testRimozioneCompletaArticolo FALLITO: categoria non inserita.");
		}
		Ordine nuovoOrdine = new Ordine("Luca De Luca", "Via Casilina 52", LocalDate.of(2023, 5, 31),
				LocalDate.of(2023, 8, 30));
		ordineServiceInstance.inserisciNuovo(nuovoOrdine);
		if (nuovoOrdine.getId() == null) {
			throw new RuntimeException("testRimozioneCompletaArticolo FALLITO: Ordine non inserito.");
		}
		Articolo nuovoArticolo = new Articolo("Scarpe Nike", "0001", 299D, LocalDate.now());
		nuovoArticolo.setOrdine(nuovoOrdine);
		articoloServiceInstance.inserisciNuovo(nuovoArticolo);
		if (nuovoArticolo.getId() == null) {
			throw new RuntimeException("testRimozioneCompletaArticolo FALLITO: articolo non inserito.");
		}

		articoloServiceInstance.aggiungiCategoria(nuovoArticolo, nuovaCategoria1);
		articoloServiceInstance.aggiungiCategoria(nuovoArticolo, nuovaCategoria2);

		Articolo articoloDaRimuovere = articoloServiceInstance.caricaArticoloEager(nuovoArticolo.getId());
		if (articoloDaRimuovere.getId() == null) {
			throw new RuntimeException("testRimozioneCompletaArticolo FALLITO: Ordine non inserito.");
		}
		if (articoloDaRimuovere.getCategorie().isEmpty()) {
			throw new RuntimeException("testRimozioneCompletaArticolo FALLITO: categoria non associata ad articolo");
		}
		// rimozione completa articolo
		articoloServiceInstance.rimozioneArticoloCompleta(articoloDaRimuovere.getId());

		System.out.println("------------- testRimozioneCompletaArticolo FINE -------------");

	}

	private static void testRimozioneCompletaCategoria(ArticoloService articoloServiceInstance,
			CategoriaService categoriaServiceInstance, OrdineService ordineServiceInstance) throws Exception {
		System.out.println("------------- testRimozioneCompletaCategoria INIZIO -------------");
		Categoria nuovaCategoria = new Categoria("Abbigliamento", "201");
		categoriaServiceInstance.inserisciNuovo(nuovaCategoria);
		if (nuovaCategoria.getId() == null) {
			throw new RuntimeException("testRimozioneCompletaCategoria FALLITO: categoria non inserita.");
		}
		Ordine nuovoOrdine = new Ordine("francesco crispi", "Via appia 2", LocalDate.of(2023, 5, 31),
				LocalDate.of(2023, 8, 30));
		ordineServiceInstance.inserisciNuovo(nuovoOrdine);
		if (nuovoOrdine.getId() == null) {
			throw new RuntimeException("testRimozioneCompletaCategoria FALLITO: Ordine non inserito.");
		}
		Articolo nuovoArticolo1 = new Articolo("Scarpe Nike", "0001", 299D, LocalDate.now());
		Articolo nuovoArticolo2 = new Articolo("Scarpe Nike", "0001", 299D, LocalDate.now());
		nuovoArticolo1.setOrdine(nuovoOrdine);
		articoloServiceInstance.inserisciNuovo(nuovoArticolo1);
		if (nuovoArticolo1.getId() == null) {
			throw new RuntimeException("testRimozioneCompletaCategoria FALLITO: articolo non inserito.");
		}
		nuovoArticolo2.setOrdine(nuovoOrdine);
		articoloServiceInstance.inserisciNuovo(nuovoArticolo2);
		if (nuovoArticolo2.getId() == null) {
			throw new RuntimeException("testRimozioneCompletaCategoria FALLITO: articolo non inserito.");
		}

		categoriaServiceInstance.aggiungiArticolo(nuovaCategoria, nuovoArticolo1);
		categoriaServiceInstance.aggiungiArticolo(nuovaCategoria, nuovoArticolo2);
		Categoria categoriaReloaded = categoriaServiceInstance.caricaCategoriaEager(nuovaCategoria.getId());
		if (categoriaReloaded.getArticoli().isEmpty()) {
			throw new RuntimeException("testRimozioneCompletaCategoria FALLITO: articolo non associato a categoria");
		}

		// rimozione completa categoria
		categoriaServiceInstance.rimozioneCompletaCategoria(categoriaReloaded.getId());

		System.out.println("------------- testRimozioneCompletaCategoria FINE -------------");

	}

	private static void testRimuoviOrdine(OrdineService ordineServiceInstance, ArticoloService articoloServiceInstance)
			throws Exception {
		System.out.println("------------- testRimuoviOrdine INIZIO -------------");

		Ordine ordineDaInserire = new Ordine("Mario Rossi", "Via Mosca 52", LocalDate.of(2023, 04, 21),
				LocalDate.of(2023, 06, 30));
		ordineServiceInstance.inserisciNuovo(ordineDaInserire);
		Long idOrdineDaInserire = ordineDaInserire.getId();
		if (idOrdineDaInserire == null) {
			throw new RuntimeException("testRimuoviOrdine FALLITO: Ordine non inserito.");
		}
		Articolo nuovoArticolo = new Articolo("Scarpe Nike", "12345678", 329D, LocalDate.now());
		nuovoArticolo.setOrdine(ordineDaInserire);
		articoloServiceInstance.inserisciNuovo(nuovoArticolo);
		if (nuovoArticolo.getId() == null) {
			throw new RuntimeException("testRimuoviOrdine FALLITO: Articolo non inserito");
		}
		if (!nuovoArticolo.getOrdine().getId().equals(idOrdineDaInserire)) {
			throw new RuntimeException("testRimuoviOrdine FALLITO: L'ID dell'ordine non corrisponde");
		}

		// test eccezione custom
//		ordineServiceInstance.rimuovi(idOrdineDaInserire);

		Ordine ordineDaEliminare = new Ordine("Mario Rossi", "Via Mosca 52", LocalDate.of(2023, 04, 21),
				LocalDate.of(2023, 06, 30));
		ordineServiceInstance.inserisciNuovo(ordineDaEliminare);
		Long idOrdineDaEliminare = ordineDaEliminare.getId();
		if (idOrdineDaEliminare == null) {
			throw new RuntimeException("testRimuoviOrdine FALLITO: Ordine non inserito.");
		}

		ordineServiceInstance.rimuovi(idOrdineDaEliminare);

		System.out.println("------------- testRimuoviOrdine FINE -------------");

	}

	private static void testListaOrdiniPerCategoria(OrdineService ordineServiceInstance,
			ArticoloService articoloServiceInstance, CategoriaService categoriaServiceInstance) throws Exception {
		System.out.println("------------- testListaOrdiniPerCategoria INIZIO -------------");
		Categoria nuovaCategoria = new Categoria("Abbigliamento", "201");
		categoriaServiceInstance.inserisciNuovo(nuovaCategoria);
		Long idNuovaCategoria = nuovaCategoria.getId();
		if (idNuovaCategoria == null) {
			throw new RuntimeException("testListaOrdiniPerCategoria FALLITO: categoria non inserita.");
		}
		Ordine nuovoOrdine = new Ordine("Luca De Luca", "Via Casilina 52", LocalDate.of(2023, 5, 31),
				LocalDate.of(2023, 8, 30));
		ordineServiceInstance.inserisciNuovo(nuovoOrdine);
		if (nuovoOrdine.getId() == null) {
			throw new RuntimeException("testListaOrdiniPerCategoria FALLITO: Ordine non inserito.");
		}
		Articolo nuovoArticolo = new Articolo("Scarpe Nike", "0001", 299D, LocalDate.now());
		nuovoArticolo.setOrdine(nuovoOrdine);
		articoloServiceInstance.inserisciNuovo(nuovoArticolo);
		if (nuovoArticolo.getId() == null) {
			throw new RuntimeException("testListaOrdiniPerCategoria FALLITO: Ordine non inserito.");
		}

		articoloServiceInstance.aggiungiCategoria(nuovoArticolo, nuovaCategoria);
		Articolo articoloReloaded = articoloServiceInstance.caricaArticoloEager(nuovoArticolo.getId());
		if (articoloReloaded.getCategorie().isEmpty()) {
			throw new RuntimeException("testListaOrdiniPerCategoria FALLITO: articolo non associato a categoria");
		}

		List<Ordine> listaOrdiniPerCategoria = ordineServiceInstance.listaOrdiniPerCategoria(idNuovaCategoria);
		if (listaOrdiniPerCategoria.size() < 1) {
			throw new RuntimeException("testListaOrdiniPerCategoria FALLITO: lista vuota");
		}

		System.out.println(listaOrdiniPerCategoria);
		System.out.println("------------- testListaOrdiniPerCategoria FINE -------------");
	}

	private static void testListaCategoriaPerOrdine(OrdineService ordineServiceInstance,
			ArticoloService articoloServiceInstance, CategoriaService categoriaServiceInstance) throws Exception {
		System.out.println("------------- testListaCategoriaPerOrdine INIZIO -------------");

		Ordine nuovoOrdine = new Ordine("Luca De Luca", "Via Casilina 52", LocalDate.of(2023, 5, 31),
				LocalDate.of(2023, 8, 30));
		ordineServiceInstance.inserisciNuovo(nuovoOrdine);
		Long idNuovoOrdine = nuovoOrdine.getId();
		if (idNuovoOrdine == null) {
			throw new RuntimeException("testListaCategoriaPerOrdine FALLITO: Ordine non inserito.");
		}

		Categoria nuovaCategoria1 = new Categoria("Abbigliamento", "201");
		categoriaServiceInstance.inserisciNuovo(nuovaCategoria1);
		Long idNuovaCategoria = nuovaCategoria1.getId();
		if (idNuovaCategoria == null) {
			throw new RuntimeException("testListaCategoriaPerOrdine FALLITO: categoria non inserita.");
		}
		Categoria nuovaCategoria2 = new Categoria("Musica", "202");
		categoriaServiceInstance.inserisciNuovo(nuovaCategoria2);
		Long idNuovaCategoria2 = nuovaCategoria2.getId();
		if (idNuovaCategoria2 == null) {
			throw new RuntimeException("testListaCategoriaPerOrdine FALLITO: categoria non inserita.");
		}

		Articolo nuovoArticolo1 = new Articolo("Scarpe Nike", "0001", 299D, LocalDate.now());
		nuovoArticolo1.setOrdine(nuovoOrdine);
		articoloServiceInstance.inserisciNuovo(nuovoArticolo1);
		if (nuovoArticolo1.getId() == null) {
			throw new RuntimeException("testListaCategoriaPerOrdine FALLITO: Ordine non inserito.");
		}
		articoloServiceInstance.aggiungiCategoria(nuovoArticolo1, nuovaCategoria1);
		articoloServiceInstance.aggiungiCategoria(nuovoArticolo1, nuovaCategoria2);
		Articolo articoloReloaded = articoloServiceInstance.caricaArticoloEager(nuovoArticolo1.getId());
		if (articoloReloaded.getCategorie().isEmpty()) {
			throw new RuntimeException("testListaCategoriaPerOrdine FALLITO: articolo non associato a categoria");
		}

		Articolo nuovoArticolo2 = new Articolo("iPod", "0002", 180D, LocalDate.now());
		nuovoArticolo2.setOrdine(nuovoOrdine);
		articoloServiceInstance.inserisciNuovo(nuovoArticolo2);
		if (nuovoArticolo2.getId() == null) {
			throw new RuntimeException("testListaCategoriaPerOrdine FALLITO: Ordine non inserito.");
		}
		articoloServiceInstance.aggiungiCategoria(nuovoArticolo2, nuovaCategoria2);
		Articolo articoloReloaded2 = articoloServiceInstance.caricaArticoloEager(nuovoArticolo2.getId());
		if (articoloReloaded2.getCategorie().isEmpty()) {
			throw new RuntimeException("testListaCategoriaPerOrdine FALLITO: articolo non associato a categoria");
		}

		List<Categoria> listaCategoriaPerOrdine = categoriaServiceInstance.listaCategoriaPerOrdine(idNuovoOrdine);
		if (listaCategoriaPerOrdine.size() < 1) {
			throw new RuntimeException("testListaCategoriaPerOrdine FALLITO: lista vuota");
		}

		System.out.println(listaCategoriaPerOrdine);
		System.out.println("------------- testListaCategoriaPerOrdine FINE -------------");
	}

	private static void testSommaPrezziArticoliDiUnaCategoria(OrdineService ordineServiceInstance,
			ArticoloService articoloServiceInstance, CategoriaService categoriaServiceInstance) throws Exception {
		System.out.println("------------- testSommaPrezziArticoliDiUnaCategoria INIZIO -------------");

		Ordine nuovoOrdine = new Ordine("Galileo Galilei", "Via Casilina 52", LocalDate.of(2023, 5, 31),
				LocalDate.of(2023, 8, 30));
		ordineServiceInstance.inserisciNuovo(nuovoOrdine);
		Long idNuovoOrdine = nuovoOrdine.getId();
		if (idNuovoOrdine == null) {
			throw new RuntimeException("testSommaPrezziArticoliDiUnaCategoria FALLITO: Ordine non inserito.");
		}

		Categoria nuovaCategoria = new Categoria("Musica", "202");
		categoriaServiceInstance.inserisciNuovo(nuovaCategoria);
		Long idNuovaCategoria = nuovaCategoria.getId();
		if (idNuovaCategoria == null) {
			throw new RuntimeException("testSommaPrezziArticoliDiUnaCategoria FALLITO: categoria non inserita.");
		}

		Articolo nuovoArticolo1 = new Articolo("apple music", "0001", 300D, LocalDate.now());
		nuovoArticolo1.setOrdine(nuovoOrdine);
		articoloServiceInstance.inserisciNuovo(nuovoArticolo1);
		if (nuovoArticolo1.getId() == null) {
			throw new RuntimeException("testSommaPrezziArticoliDiUnaCategoria FALLITO: Ordine non inserito.");
		}
		articoloServiceInstance.aggiungiCategoria(nuovoArticolo1, nuovaCategoria);
		Articolo articoloReloaded = articoloServiceInstance.caricaArticoloEager(nuovoArticolo1.getId());
		if (articoloReloaded.getCategorie().isEmpty()) {
			throw new RuntimeException(
					"testSommaPrezziArticoliDiUnaCategoria FALLITO: articolo non associato a categoria");
		}

		Articolo nuovoArticolo2 = new Articolo("iPod", "0002", 180D, LocalDate.now());
		nuovoArticolo2.setOrdine(nuovoOrdine);
		articoloServiceInstance.inserisciNuovo(nuovoArticolo2);
		if (nuovoArticolo2.getId() == null) {
			throw new RuntimeException("testSommaPrezziArticoliDiUnaCategoria FALLITO: Ordine non inserito.");
		}
		articoloServiceInstance.aggiungiCategoria(nuovoArticolo2, nuovaCategoria);
		Articolo articoloReloaded2 = articoloServiceInstance.caricaArticoloEager(nuovoArticolo2.getId());
		if (articoloReloaded2.getCategorie().isEmpty()) {
			throw new RuntimeException(
					"testSommaPrezziArticoliDiUnaCategoria FALLITO: articolo non associato a categoria");
		}

		Double sommaPrezzi = articoloServiceInstance.sommaPrezzoArticoliDiUnaCategoria(idNuovaCategoria);

		System.out.println("La somma dei prezzi degli articoli di questa categoria è: " + sommaPrezzi);
		System.out.println("------------- testSommaPrezziArticoliDiUnaCategoria FINE -------------");
	}

	private static void testOrdinePiuRecentePerCategoria(OrdineService ordineServiceInstance,
			ArticoloService articoloServiceInstance, CategoriaService categoriaServiceInstance) throws Exception {
		System.out.println("------------- testOrdinePiuRecentePerCategoria INIZIO -------------");

		Ordine nuovoOrdine1 = new Ordine("francesco bacca", "Via Casilina 52", LocalDate.of(2023, 3, 31),
				LocalDate.of(2023, 8, 30));
		ordineServiceInstance.inserisciNuovo(nuovoOrdine1);
		Long idNuovoOrdine1 = nuovoOrdine1.getId();
		if (idNuovoOrdine1 == null) {
			throw new RuntimeException("testOrdinePiuRecentePerCategoria FALLITO: Ordine non inserito.");
		}
		Ordine nuovoOrdine2 = new Ordine("mario rossi", "viale europa 5", LocalDate.of(2024, 5, 5),
				LocalDate.of(2023, 8, 30));
		ordineServiceInstance.inserisciNuovo(nuovoOrdine2);
		Long idNuovoOrdine2 = nuovoOrdine2.getId();
		if (idNuovoOrdine2 == null) {
			throw new RuntimeException("testOrdinePiuRecentePerCategoria FALLITO: Ordine non inserito.");
		}

		Categoria nuovaCategoria1 = new Categoria("Musica", "202");
		categoriaServiceInstance.inserisciNuovo(nuovaCategoria1);
		Long idNuovaCategoria1 = nuovaCategoria1.getId();
		if (idNuovaCategoria1 == null) {
			throw new RuntimeException("testOrdinePiuRecentePerCategoria FALLITO: categoria non inserita.");
		}

		Categoria nuovaCategoria2 = new Categoria("Videogiochi", "203");
		categoriaServiceInstance.inserisciNuovo(nuovaCategoria2);
		Long idNuovaCategoria2 = nuovaCategoria2.getId();
		if (idNuovaCategoria2 == null) {
			throw new RuntimeException("testOrdinePiuRecentePerCategoria FALLITO: categoria non inserita.");
		}

		Articolo nuovoArticolo1 = new Articolo("apple music", "0001", 300D, LocalDate.now());
		nuovoArticolo1.setOrdine(nuovoOrdine1);
		articoloServiceInstance.inserisciNuovo(nuovoArticolo1);
		if (nuovoArticolo1.getId() == null) {
			throw new RuntimeException("testOrdinePiuRecentePerCategoria FALLITO: Ordine non inserito.");
		}
		articoloServiceInstance.aggiungiCategoria(nuovoArticolo1, nuovaCategoria1);
		Articolo articoloReloaded1 = articoloServiceInstance.caricaArticoloEager(nuovoArticolo1.getId());
		if (articoloReloaded1.getCategorie().isEmpty()) {
			throw new RuntimeException("testOrdinePiuRecentePerCategoria FALLITO: articolo non associato a categoria");
		}

		Articolo nuovoArticolo2 = new Articolo("iPod", "0002", 180D, LocalDate.now());
		nuovoArticolo2.setOrdine(nuovoOrdine2);
		articoloServiceInstance.inserisciNuovo(nuovoArticolo2);
		if (nuovoArticolo2.getId() == null) {
			throw new RuntimeException("testOrdinePiuRecentePerCategoria FALLITO: Ordine non inserito.");
		}
		articoloServiceInstance.aggiungiCategoria(nuovoArticolo2, nuovaCategoria1);
		Articolo articoloReloaded2 = articoloServiceInstance.caricaArticoloEager(nuovoArticolo2.getId());
		if (articoloReloaded2.getCategorie().isEmpty()) {
			throw new RuntimeException("testOrdinePiuRecentePerCategoria FALLITO: articolo non associato a categoria");
		}

		Articolo nuovoArticolo3 = new Articolo("iPod", "0002", 180D, LocalDate.now());
		nuovoArticolo3.setOrdine(nuovoOrdine2);
		articoloServiceInstance.inserisciNuovo(nuovoArticolo3);
		if (nuovoArticolo3.getId() == null) {
			throw new RuntimeException("testOrdinePiuRecentePerCategoria FALLITO: Ordine non inserito.");
		}
		articoloServiceInstance.aggiungiCategoria(nuovoArticolo3, nuovaCategoria2);
		Articolo articoloReloaded3 = articoloServiceInstance.caricaArticoloEager(nuovoArticolo3.getId());
		if (articoloReloaded3.getCategorie().isEmpty()) {
			throw new RuntimeException("testOrdinePiuRecentePerCategoria FALLITO: articolo non associato a categoria");
		}

		Ordine ordinePiuRecente = ordineServiceInstance.ordinePiuRecentePerCategoria(idNuovaCategoria1);

		System.out.println(ordinePiuRecente);

		System.out.println("------------- testOrdinePiuRecentePerCategoria FINE -------------");
	}

	private static void testListaCodiceCategoriaInUnDeterminatoMese(OrdineService ordineServiceInstance,
			ArticoloService articoloServiceInstance, CategoriaService categoriaServiceInstance) throws Exception {
		System.out.println("------------- testListaCodiceCategoriaInUnDeterminatoMese INIZIO -------------");

		Ordine nuovoOrdine1 = new Ordine("francesco bacca", "Via Casilina 52", LocalDate.of(2023, 3, 31),
				LocalDate.of(2023, 8, 30));
		ordineServiceInstance.inserisciNuovo(nuovoOrdine1);
		Long idNuovoOrdine1 = nuovoOrdine1.getId();
		if (idNuovoOrdine1 == null) {
			throw new RuntimeException("testListaCodiceCategoriaInUnDeterminatoMese FALLITO: Ordine non inserito.");
		}
		Ordine nuovoOrdine2 = new Ordine("mario rossi", "viale europa 5", LocalDate.of(2024, 5, 5),
				LocalDate.of(2023, 8, 30));
		ordineServiceInstance.inserisciNuovo(nuovoOrdine2);
		Long idNuovoOrdine2 = nuovoOrdine2.getId();
		if (idNuovoOrdine2 == null) {
			throw new RuntimeException("testListaCodiceCategoriaInUnDeterminatoMese FALLITO: Ordine non inserito.");
		}

		Categoria nuovaCategoria1 = new Categoria("Musica", "202");
		categoriaServiceInstance.inserisciNuovo(nuovaCategoria1);
		Long idNuovaCategoria1 = nuovaCategoria1.getId();
		if (idNuovaCategoria1 == null) {
			throw new RuntimeException("testListaCodiceCategoriaInUnDeterminatoMese FALLITO: categoria non inserita.");
		}

		Categoria nuovaCategoria2 = new Categoria("Videogiochi", "203");
		categoriaServiceInstance.inserisciNuovo(nuovaCategoria2);
		Long idNuovaCategoria2 = nuovaCategoria2.getId();
		if (idNuovaCategoria2 == null) {
			throw new RuntimeException("testListaCodiceCategoriaInUnDeterminatoMese FALLITO: categoria non inserita.");
		}

		Articolo nuovoArticolo1 = new Articolo("apple music", "0001", 300D, LocalDate.now());
		nuovoArticolo1.setOrdine(nuovoOrdine1);
		articoloServiceInstance.inserisciNuovo(nuovoArticolo1);
		if (nuovoArticolo1.getId() == null) {
			throw new RuntimeException("testListaCodiceCategoriaInUnDeterminatoMese FALLITO: Ordine non inserito.");
		}
		articoloServiceInstance.aggiungiCategoria(nuovoArticolo1, nuovaCategoria1);
		Articolo articoloReloaded1 = articoloServiceInstance.caricaArticoloEager(nuovoArticolo1.getId());
		if (articoloReloaded1.getCategorie().isEmpty()) {
			throw new RuntimeException(
					"testListaCodiceCategoriaInUnDeterminatoMese FALLITO: articolo non associato a categoria");
		}

		Articolo nuovoArticolo2 = new Articolo("iPod", "0002", 180D, LocalDate.now());
		nuovoArticolo2.setOrdine(nuovoOrdine2);
		articoloServiceInstance.inserisciNuovo(nuovoArticolo2);
		if (nuovoArticolo2.getId() == null) {
			throw new RuntimeException("testListaCodiceCategoriaInUnDeterminatoMese FALLITO: Ordine non inserito.");
		}
		articoloServiceInstance.aggiungiCategoria(nuovoArticolo2, nuovaCategoria1);
		Articolo articoloReloaded2 = articoloServiceInstance.caricaArticoloEager(nuovoArticolo2.getId());
		if (articoloReloaded2.getCategorie().isEmpty()) {
			throw new RuntimeException(
					"testListaCodiceCategoriaInUnDeterminatoMese FALLITO: articolo non associato a categoria");
		}

		Articolo nuovoArticolo3 = new Articolo("iPod", "0002", 180D, LocalDate.now());
		nuovoArticolo3.setOrdine(nuovoOrdine2);
		articoloServiceInstance.inserisciNuovo(nuovoArticolo3);
		if (nuovoArticolo3.getId() == null) {
			throw new RuntimeException("testListaCodiceCategoriaInUnDeterminatoMese FALLITO: Ordine non inserito.");
		}
		articoloServiceInstance.aggiungiCategoria(nuovoArticolo3, nuovaCategoria2);
		Articolo articoloReloaded3 = articoloServiceInstance.caricaArticoloEager(nuovoArticolo3.getId());
		if (articoloReloaded3.getCategorie().isEmpty()) {
			throw new RuntimeException(
					"testListaCodiceCategoriaInUnDeterminatoMese FALLITO: articolo non associato a categoria");
		}

		int annoDaCercare = 2024;
		int meseDaCercare = 5;
		List<String> listaCodici = categoriaServiceInstance.listaCodiciCategoriaDiUnMese(annoDaCercare, meseDaCercare);
		if (listaCodici.size() < 1) {
			throw new RuntimeException(
					"testListaCodiceCategoriaInUnDeterminatoMese FALLITO: non sono presenti codici in lista.");
		}
		System.out.println(listaCodici);

		System.out.println("------------- testListaCodiceCategoriaInUnDeterminatoMese FINE -------------");
	}

	private static void testSommaPrezzoArticoliPerUnDestinatario(OrdineService ordineServiceInstance,
			ArticoloService articoloServiceInstance, CategoriaService categoriaServiceInstance) throws Exception {
		System.out.println("------------- testSommaPrezzoArticoliPerUnDestinatario INIZIO -------------");

		Ordine nuovoOrdine1 = new Ordine("francesco bacca", "Via Casilina 52", LocalDate.of(2023, 3, 31),
				LocalDate.of(2023, 8, 30));
		ordineServiceInstance.inserisciNuovo(nuovoOrdine1);
		Long idNuovoOrdine1 = nuovoOrdine1.getId();
		if (idNuovoOrdine1 == null) {
			throw new RuntimeException("testSommaPrezzoArticoliPerUnDestinatario FALLITO: Ordine non inserito.");
		}
		Ordine nuovoOrdine2 = new Ordine("Pierpaolo Ceppi", "viale europa 5", LocalDate.of(2024, 5, 5),
				LocalDate.of(2023, 8, 30));
		ordineServiceInstance.inserisciNuovo(nuovoOrdine2);
		Long idNuovoOrdine2 = nuovoOrdine2.getId();
		if (idNuovoOrdine2 == null) {
			throw new RuntimeException("testSommaPrezzoArticoliPerUnDestinatario FALLITO: Ordine non inserito.");
		}

		Categoria nuovaCategoria1 = new Categoria("Musica", "202");
		categoriaServiceInstance.inserisciNuovo(nuovaCategoria1);
		Long idNuovaCategoria1 = nuovaCategoria1.getId();
		if (idNuovaCategoria1 == null) {
			throw new RuntimeException("testSommaPrezzoArticoliPerUnDestinatario FALLITO: categoria non inserita.");
		}

		Categoria nuovaCategoria2 = new Categoria("Videogiochi", "203");
		categoriaServiceInstance.inserisciNuovo(nuovaCategoria2);
		Long idNuovaCategoria2 = nuovaCategoria2.getId();
		if (idNuovaCategoria2 == null) {
			throw new RuntimeException("testSommaPrezzoArticoliPerUnDestinatario FALLITO: categoria non inserita.");
		}

		Articolo nuovoArticolo1 = new Articolo("apple music", "0001", 300D, LocalDate.now());
		nuovoArticolo1.setOrdine(nuovoOrdine1);
		articoloServiceInstance.inserisciNuovo(nuovoArticolo1);
		if (nuovoArticolo1.getId() == null) {
			throw new RuntimeException("testSommaPrezzoArticoliPerUnDestinatario FALLITO: Ordine non inserito.");
		}
		articoloServiceInstance.aggiungiCategoria(nuovoArticolo1, nuovaCategoria1);
		Articolo articoloReloaded1 = articoloServiceInstance.caricaArticoloEager(nuovoArticolo1.getId());
		if (articoloReloaded1.getCategorie().isEmpty()) {
			throw new RuntimeException(
					"testSommaPrezzoArticoliPerUnDestinatario FALLITO: articolo non associato a categoria");
		}

		Articolo nuovoArticolo2 = new Articolo("iPod", "0002", 180D, LocalDate.now());
		nuovoArticolo2.setOrdine(nuovoOrdine2);
		articoloServiceInstance.inserisciNuovo(nuovoArticolo2);
		if (nuovoArticolo2.getId() == null) {
			throw new RuntimeException("testSommaPrezzoArticoliPerUnDestinatario FALLITO: Ordine non inserito.");
		}
		articoloServiceInstance.aggiungiCategoria(nuovoArticolo2, nuovaCategoria1);
		Articolo articoloReloaded2 = articoloServiceInstance.caricaArticoloEager(nuovoArticolo2.getId());
		if (articoloReloaded2.getCategorie().isEmpty()) {
			throw new RuntimeException(
					"testSommaPrezzoArticoliPerUnDestinatario FALLITO: articolo non associato a categoria");
		}

		Articolo nuovoArticolo3 = new Articolo("iPod", "0002", 180D, LocalDate.now());
		nuovoArticolo3.setOrdine(nuovoOrdine2);
		articoloServiceInstance.inserisciNuovo(nuovoArticolo3);
		if (nuovoArticolo3.getId() == null) {
			throw new RuntimeException("testSommaPrezzoArticoliPerUnDestinatario FALLITO: Ordine non inserito.");
		}
		articoloServiceInstance.aggiungiCategoria(nuovoArticolo3, nuovaCategoria2);
		Articolo articoloReloaded3 = articoloServiceInstance.caricaArticoloEager(nuovoArticolo3.getId());
		if (articoloReloaded3.getCategorie().isEmpty()) {
			throw new RuntimeException(
					"testSommaPrezzoArticoliPerUnDestinatario FALLITO: articolo non associato a categoria");
		}

		String nomeDestinatario = "Pierpaolo Ceppi";
		Double sommaPrezziArticoliPerUnDestinatario = articoloServiceInstance
				.sommaPrezzoArticoliDiUnDestinatario(nomeDestinatario);
		System.out.println(
				"La somma dei prezzi degli articoli di questo destinatario è: " + sommaPrezziArticoliPerUnDestinatario);

		System.out.println("------------- testSommaPrezzoArticoliPerUnDestinatario FINE -------------");
	}

	private static void testListaIndirizziConArticoliContenentiNumeroSeriale(OrdineService ordineServiceInstance,
			ArticoloService articoloServiceInstance, CategoriaService categoriaServiceInstance) throws Exception {
		System.out.println("------------- testListaIndirizziConArticoliContenentiNumeroSeriale INIZIO -------------");

		Ordine nuovoOrdine1 = new Ordine("francesco bacca", "Via Casilina 52", LocalDate.of(2023, 3, 31),
				LocalDate.of(2023, 8, 30));
		ordineServiceInstance.inserisciNuovo(nuovoOrdine1);
		Long idNuovoOrdine1 = nuovoOrdine1.getId();
		if (idNuovoOrdine1 == null) {
			throw new RuntimeException(
					"testListaIndirizziConArticoliContenentiNumeroSeriale FALLITO: Ordine non inserito.");
		}
		Ordine nuovoOrdine2 = new Ordine("Pierpaolo Ceppi", "viale europa 5", LocalDate.of(2024, 5, 5),
				LocalDate.of(2023, 8, 30));
		ordineServiceInstance.inserisciNuovo(nuovoOrdine2);
		Long idNuovoOrdine2 = nuovoOrdine2.getId();
		if (idNuovoOrdine2 == null) {
			throw new RuntimeException(
					"testListaIndirizziConArticoliContenentiNumeroSeriale FALLITO: Ordine non inserito.");
		}

		Categoria nuovaCategoria1 = new Categoria("Musica", "202");
		categoriaServiceInstance.inserisciNuovo(nuovaCategoria1);
		Long idNuovaCategoria1 = nuovaCategoria1.getId();
		if (idNuovaCategoria1 == null) {
			throw new RuntimeException(
					"testListaIndirizziConArticoliContenentiNumeroSeriale FALLITO: categoria non inserita.");
		}

		Categoria nuovaCategoria2 = new Categoria("Videogiochi", "203");
		categoriaServiceInstance.inserisciNuovo(nuovaCategoria2);
		Long idNuovaCategoria2 = nuovaCategoria2.getId();
		if (idNuovaCategoria2 == null) {
			throw new RuntimeException(
					"testListaIndirizziConArticoliContenentiNumeroSeriale FALLITO: categoria non inserita.");
		}

		Articolo nuovoArticolo1 = new Articolo("apple music", "100-01", 300D, LocalDate.now());
		nuovoArticolo1.setOrdine(nuovoOrdine1);
		articoloServiceInstance.inserisciNuovo(nuovoArticolo1);
		if (nuovoArticolo1.getId() == null) {
			throw new RuntimeException(
					"testListaIndirizziConArticoliContenentiNumeroSeriale FALLITO: Ordine non inserito.");
		}
		articoloServiceInstance.aggiungiCategoria(nuovoArticolo1, nuovaCategoria1);
		Articolo articoloReloaded1 = articoloServiceInstance.caricaArticoloEager(nuovoArticolo1.getId());
		if (articoloReloaded1.getCategorie().isEmpty()) {
			throw new RuntimeException(
					"testListaIndirizziConArticoliContenentiNumeroSeriale FALLITO: articolo non associato a categoria");
		}

		Articolo nuovoArticolo2 = new Articolo("iPod", "100-999-1001", 180D, LocalDate.now());
		nuovoArticolo2.setOrdine(nuovoOrdine2);
		articoloServiceInstance.inserisciNuovo(nuovoArticolo2);
		if (nuovoArticolo2.getId() == null) {
			throw new RuntimeException(
					"testListaIndirizziConArticoliContenentiNumeroSeriale FALLITO: Ordine non inserito.");
		}
		articoloServiceInstance.aggiungiCategoria(nuovoArticolo2, nuovaCategoria1);
		Articolo articoloReloaded2 = articoloServiceInstance.caricaArticoloEager(nuovoArticolo2.getId());
		if (articoloReloaded2.getCategorie().isEmpty()) {
			throw new RuntimeException(
					"testListaIndirizziConArticoliContenentiNumeroSeriale FALLITO: articolo non associato a categoria");
		}

		Articolo nuovoArticolo3 = new Articolo("iPod", "100-999-1001", 180D, LocalDate.now());
		nuovoArticolo3.setOrdine(nuovoOrdine2);
		articoloServiceInstance.inserisciNuovo(nuovoArticolo3);
		if (nuovoArticolo3.getId() == null) {
			throw new RuntimeException(
					"testListaIndirizziConArticoliContenentiNumeroSeriale FALLITO: Ordine non inserito.");
		}
		articoloServiceInstance.aggiungiCategoria(nuovoArticolo3, nuovaCategoria2);
		Articolo articoloReloaded3 = articoloServiceInstance.caricaArticoloEager(nuovoArticolo3.getId());
		if (articoloReloaded3.getCategorie().isEmpty()) {
			throw new RuntimeException(
					"testListaIndirizziConArticoliContenentiNumeroSeriale FALLITO: articolo non associato a categoria");
		}

		String stringaNumeroSeriale = "999";
		List<String> listaIndirizzi = ordineServiceInstance
				.indirizziConArticoliContenentiNumeroSeriale(stringaNumeroSeriale);
		if (listaIndirizzi.size() < 1) {
			throw new RuntimeException(
					"testListaIndirizziConArticoliContenentiNumeroSeriale FALLITO: non sono presenti indirizzi con articoli con questo numero seriale in lista.");
		}
		System.out.println(listaIndirizzi);

		System.out.println("------------- testListaIndirizziConArticoliContenentiNumeroSeriale FINE -------------");
	}

	private static void testListaArticoliConErroriInOrdine(OrdineService ordineServiceInstance,
			ArticoloService articoloServiceInstance, CategoriaService categoriaServiceInstance) throws Exception {
		System.out.println("------------- testListaArticoliConErroriInOrdine INIZIO -------------");

		Ordine nuovoOrdine1 = new Ordine("francesco bacca", "Via Casilina 52", LocalDate.of(2023, 3, 31),
				LocalDate.of(2023, 8, 30));
		ordineServiceInstance.inserisciNuovo(nuovoOrdine1);
		Long idNuovoOrdine1 = nuovoOrdine1.getId();
		if (idNuovoOrdine1 == null) {
			throw new RuntimeException("testListaArticoliConErroriInOrdine FALLITO: Ordine non inserito.");
		}
		Ordine nuovoOrdine2 = new Ordine("Pierpaolo Ceppi", "viale europa 5", LocalDate.of(2024, 5, 5),
				LocalDate.of(2023, 8, 30));
		ordineServiceInstance.inserisciNuovo(nuovoOrdine2);
		Long idNuovoOrdine2 = nuovoOrdine2.getId();
		if (idNuovoOrdine2 == null) {
			throw new RuntimeException("testListaArticoliConErroriInOrdine FALLITO: Ordine non inserito.");
		}

		Categoria nuovaCategoria1 = new Categoria("Musica", "202");
		categoriaServiceInstance.inserisciNuovo(nuovaCategoria1);
		Long idNuovaCategoria1 = nuovaCategoria1.getId();
		if (idNuovaCategoria1 == null) {
			throw new RuntimeException("testListaArticoliConErroriInOrdine FALLITO: categoria non inserita.");
		}

		Categoria nuovaCategoria2 = new Categoria("Videogiochi", "203");
		categoriaServiceInstance.inserisciNuovo(nuovaCategoria2);
		Long idNuovaCategoria2 = nuovaCategoria2.getId();
		if (idNuovaCategoria2 == null) {
			throw new RuntimeException("testListaArticoliConErroriInOrdine FALLITO: categoria non inserita.");
		}

		Articolo nuovoArticolo1 = new Articolo("apple music", "100-01", 300D, LocalDate.now());
		nuovoArticolo1.setOrdine(nuovoOrdine1);
		articoloServiceInstance.inserisciNuovo(nuovoArticolo1);
		if (nuovoArticolo1.getId() == null) {
			throw new RuntimeException("testListaArticoliConErroriInOrdine FALLITO: Ordine non inserito.");
		}
		articoloServiceInstance.aggiungiCategoria(nuovoArticolo1, nuovaCategoria1);
		Articolo articoloReloaded1 = articoloServiceInstance.caricaArticoloEager(nuovoArticolo1.getId());
		if (articoloReloaded1.getCategorie().isEmpty()) {
			throw new RuntimeException(
					"testListaArticoliConErroriInOrdine FALLITO: articolo non associato a categoria");
		}

		Articolo nuovoArticolo2 = new Articolo("iPod", "100-999-1001", 180D, LocalDate.now());
		nuovoArticolo2.setOrdine(nuovoOrdine2);
		articoloServiceInstance.inserisciNuovo(nuovoArticolo2);
		if (nuovoArticolo2.getId() == null) {
			throw new RuntimeException("testListaArticoliConErroriInOrdine FALLITO: Ordine non inserito.");
		}
		articoloServiceInstance.aggiungiCategoria(nuovoArticolo2, nuovaCategoria1);
		Articolo articoloReloaded2 = articoloServiceInstance.caricaArticoloEager(nuovoArticolo2.getId());
		if (articoloReloaded2.getCategorie().isEmpty()) {
			throw new RuntimeException(
					"testListaArticoliConErroriInOrdine FALLITO: articolo non associato a categoria");
		}

		Articolo nuovoArticolo3 = new Articolo("iPod", "100-999-1001", 180D, LocalDate.now());
		nuovoArticolo3.setOrdine(nuovoOrdine2);
		articoloServiceInstance.inserisciNuovo(nuovoArticolo3);
		if (nuovoArticolo3.getId() == null) {
			throw new RuntimeException("testListaArticoliConErroriInOrdine FALLITO: Ordine non inserito.");
		}
		articoloServiceInstance.aggiungiCategoria(nuovoArticolo3, nuovaCategoria2);
		Articolo articoloReloaded3 = articoloServiceInstance.caricaArticoloEager(nuovoArticolo3.getId());
		if (articoloReloaded3.getCategorie().isEmpty()) {
			throw new RuntimeException(
					"testListaArticoliConErroriInOrdine FALLITO: articolo non associato a categoria");
		}

		List<Articolo> listaArticoliConErrore = articoloServiceInstance.listaArticoliConErroriInOrdine();
		if (listaArticoliConErrore.size() < 1) {
			throw new RuntimeException("testListaArticoliConErroriInOrdine FALLITO: non sono presenti errori.");
		}
		System.out.println(listaArticoliConErrore);

		System.out.println("------------- testListaArticoliConErroriInOrdine FINE -------------");
	}
}
