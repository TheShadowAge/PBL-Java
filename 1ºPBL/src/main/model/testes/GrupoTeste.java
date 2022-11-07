package main.model.testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.Assert;
import main.model.DAO.GrupoDAO;
import main.model.DAO.GrupoDAOImplementList;
import main.model.entities.Entidade;
import main.model.entities.Grupo;

class GrupoTeste {

	@Test
	void testCriar() {
		Entidade.resetContagem();
		GrupoDAO grupoDAO = new GrupoDAOImplementList();
		Grupo grupo = new Grupo("A");
		grupoDAO.create(grupo);
		Assert.assertEquals(grupo, grupoDAO.read(1));
	}
	
	@Test
	void testAcessarErrado() {
		GrupoDAO grupoDAO = new GrupoDAOImplementList();
		Assert.assertNull(grupoDAO.read(0));
	}

	@Test
	void testUpdate() {
		Entidade.resetContagem();
		GrupoDAO grupoDAO = new GrupoDAOImplementList();
		Grupo grupo = new Grupo("A");
		grupoDAO.create(grupo);
		grupoDAO.update(1, 1, "B");
		Assert.assertEquals("B", grupoDAO.read(1).getNome());
	}

}
