package main.model.testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.Assert;
import main.model.DAO.DAO;
import main.model.DAO.SelecaoDAO;
import main.model.DAO.SelecaoDAOImplementList;
import main.model.entities.Entidade;
import main.model.entities.Selecao;

class SelecaoTeste {

	@Test
	void testCriar() {
		Entidade.resetContagem();
		SelecaoDAO selecaoDAO = new SelecaoDAOImplementList();
		Selecao selecao = new Selecao("Brasil", "A", 3);
		selecaoDAO.create(selecao);
		Assert.assertEquals(selecao, selecaoDAO.read(1));
	}
	
	@Test
	void testAcessarErrado() {
		SelecaoDAO selecaoDAO = new SelecaoDAOImplementList();
		Assert.assertNull(selecaoDAO.read(0));
	}
	
	@Test
	void testUpdate() {
		Entidade.resetContagem();
		SelecaoDAO selecaoDAO = new SelecaoDAOImplementList();
		Selecao selecao = new Selecao("Brasil", "A", 3);
		selecaoDAO.create(selecao);
		selecaoDAO.update(1, 1, "Argentina");
		Assert.assertEquals("Argentina", selecaoDAO.read(1).getNome());
	}
	
	@Test
	void testDelete() {
		Entidade.resetContagem();
		SelecaoDAO selecaoDAO = new SelecaoDAOImplementList();
		Selecao selecao = new Selecao("Brasil", "A", 3);
		selecaoDAO.create(selecao);
		int id = selecaoDAO.read(1).getId();
		selecaoDAO.delete(id);
		Assert.assertNull(selecaoDAO.read(id));
	}
}
