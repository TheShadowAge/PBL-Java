package main.model.testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.Assert;
import main.model.DAO.DAO;
import main.model.DAO.SelecaoDAO;
import main.model.DAO.TecnicoDAO;
import main.model.DAO.TecnicoDAOImplementList;
import main.model.entities.Entidade;
import main.model.entities.Selecao;
import main.model.entities.Tecnico;

/**
 * Teste que testa o DAO de Técnico.
 * @author Gabriel Sena
 * @author Ian Gabriel
 */

class TecnicoTeste {

	@Test
	void testCriar() {
		Entidade.resetContagem();
		SelecaoDAO selecaoDAO = DAO.getSelecoes();
		Selecao selecao = new Selecao("Brasil", "A", 3);
		selecaoDAO.create(selecao);
		TecnicoDAO tecnicoDAO = new TecnicoDAOImplementList();
		Tecnico tecnico = new Tecnico("Brasileiro", 1, "Santos", "Josefido Marcos", 39);
		tecnicoDAO.create(tecnico);
		selecaoDAO.delete(1);
		Entidade.resetContagem();
		Assert.assertEquals(tecnico, tecnicoDAO.read(2));
	}
	
	@Test
	void testAcessarErrado() {
		TecnicoDAO tecnicoDAO = new TecnicoDAOImplementList();
		Assert.assertNull(tecnicoDAO.read(0));
	}

	@Test
	void testUpdate() {
		Entidade.resetContagem();
		SelecaoDAO selecaoDAO = DAO.getSelecoes();
		Selecao selecao = new Selecao("Brasil", "A", 3);
		selecaoDAO.create(selecao);
		TecnicoDAO tecnicoDAO = new TecnicoDAOImplementList();
		Tecnico tecnico = new Tecnico("Brasileiro", 1, "Santos", "Josefido Marcos", 39);
		tecnicoDAO.create(tecnico);
		tecnicoDAO.update(2, 3, "52");
		selecaoDAO.delete(1);
		Entidade.resetContagem();
		Assert.assertEquals(52, tecnicoDAO.read(2).getIdade());
	}

	@Test
	void testDelete() {
		Entidade.resetContagem();
		SelecaoDAO selecaoDAO = DAO.getSelecoes();
		Selecao selecao = new Selecao("Brasil", "A", 3);
		selecaoDAO.create(selecao);
		TecnicoDAO tecnicoDAO = new TecnicoDAOImplementList();
		Tecnico tecnico = new Tecnico("Brasileiro", 1, "Santos", "Josefido Marcos", 39);
		tecnicoDAO.create(tecnico);
		int id = tecnicoDAO.read(2).getId();
		tecnicoDAO.delete(id);
		Entidade.resetContagem();
		Assert.assertNull(tecnicoDAO.read(id));
	}
}
