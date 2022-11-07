package main.model.testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.Assert;

import main.model.DAO.DAO;
import main.model.DAO.JogadorDAO;
import main.model.DAO.JogadorDAOImplementList;
import main.model.DAO.SelecaoDAO;
import main.model.DAO.SelecaoDAOImplementList;
import main.model.entities.Entidade;
import main.model.entities.Jogador;
import main.model.entities.Selecao;

class JogadorTeste {

	@Test
	void testCriar() {
		Entidade.resetContagem();
		JogadorDAO jogadorDAO = new JogadorDAOImplementList();
		SelecaoDAO selecaoDAO = DAO.getSelecoes();
		Selecao selecao = new Selecao("Brasil", "A", 3);
		selecaoDAO.create(selecao);
		Jogador jogador = new Jogador("Josefo Santana", 1, "Brasileiro", 27, "Lateral-direito", true);
		jogadorDAO.create(jogador);
		selecaoDAO.delete(1);
		Assert.assertEquals(jogador, jogadorDAO.read(2));
	}
	
	@Test
	void testAcessarErrado() {
		JogadorDAO jogadorDAO = new JogadorDAOImplementList();
		Assert.assertNull(jogadorDAO.read(0));
	}

	@Test
	void testUpdate() {
		Entidade.resetContagem();
		SelecaoDAO selecaoDAO = DAO.getSelecoes();
		Selecao selecao = new Selecao("Brasil", "A", 3);
		selecaoDAO.create(selecao);
		JogadorDAO jogadorDAO = new JogadorDAOImplementList();
		Jogador jogador = new Jogador("Josefo Santana", 1, "Brasileiro", 27, "Lateral-direito", true);
		jogadorDAO.create(jogador);
		jogadorDAO.update(2, 1, "Jonas");
		selecaoDAO.delete(1);
		Assert.assertEquals("Jonas", jogadorDAO.read(2).getNome());
	}
	
	@Test
	void testDelete() {
		Entidade.resetContagem();
		SelecaoDAO selecaoDAO = DAO.getSelecoes();
		Selecao selecao = new Selecao("Brasil", "A", 3);
		selecaoDAO.create(selecao);
		JogadorDAO jogadorDAO = new JogadorDAOImplementList();
		Jogador jogador = new Jogador("Josefo Santana", 1, "Brasileiro", 27, "Lateral-direito", true);
		jogadorDAO.create(jogador);
		int id = jogadorDAO.read(2).getId();
		jogadorDAO.delete(id);
		selecaoDAO.delete(1);
		Assert.assertNull(jogadorDAO.read(id));
	}
}
