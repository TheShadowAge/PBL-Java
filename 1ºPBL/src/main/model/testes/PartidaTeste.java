package main.model.testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.Assert;
import main.model.DAO.PartidaDAO;
import main.model.DAO.PartidaDAOImplementList;
import main.model.entities.Entidade;
import main.model.entities.Partida;

class PartidaTeste {

	@Test
	void testCriar() {
		Entidade.resetContagem();
		PartidaDAO partidaDAO = new PartidaDAOImplementList();
		Partida partida = new Partida("Brasil vs Alemanha", null, null, null, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null);
		partidaDAO.create(partida);
		Assert.assertEquals(partida, partidaDAO.read(1));
	}
	
	@Test
	void testAcessarErrado() {
		PartidaDAO partidaDAO = new PartidaDAOImplementList();
		Assert.assertNull(partidaDAO.read(0));
	}
	
	@Test
	void testUpdate() {
		Entidade.resetContagem();
		PartidaDAO partidaDAO = new PartidaDAOImplementList();
		Partida partida = new Partida("Brasil vs Alemanha", null, null, null, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null);
		partidaDAO.create(partida);
		partidaDAO.update(1, 6, "27");
		Assert.assertEquals(27, partidaDAO.read(1).getCartAmaTime1());
	}
	
	@Test
	void testDelete() {
		Entidade.resetContagem();
		PartidaDAO partidaDAO = new PartidaDAOImplementList();
		Partida partida = new Partida("Brasil vs Alemanha", null, null, null, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null);
		partidaDAO.create(partida);
		int id = partidaDAO.read(1).getId();
		partidaDAO.delete(id);
		Assert.assertNull(partidaDAO.read(id));
	}
	
}
