package main.model.testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.Assert;
import main.model.DAO.ArbitroDAO;
import main.model.DAO.ArbitroDAOImplementList;
import main.model.entities.Arbitro;
import main.model.entities.Entidade;

class ArbitroTeste {

	@Test
	void testCriar() {
		ArbitroDAO arbitroDAO = new ArbitroDAOImplementList();
		Arbitro arbitro = new Arbitro("Jeferson", "Brasileiro", "Juiz", 52);
		arbitroDAO.create(arbitro);
		Entidade.resetContagem();
		Assert.assertEquals(arbitro, arbitroDAO.read(1));
	}
	
	@Test
	void testAcessarErrado() {
		ArbitroDAO arbitroDAO = new ArbitroDAOImplementList();
		Assert.assertNull(arbitroDAO.read(0));
	}
	
	@Test
	void testUpdate() {
		ArbitroDAO arbitroDAO = new ArbitroDAOImplementList();
		Arbitro arbitro = new Arbitro("Jeferson", "Brasileiro", "Juiz", 52);
		arbitroDAO.create(arbitro);
		Entidade.resetContagem();
		arbitroDAO.update(1, 2, "23");
		Assert.assertEquals(23, arbitroDAO.read(1).getIdade());
	}
	
	@Test
	void testDelete() {
		ArbitroDAO arbitroDAO = new ArbitroDAOImplementList();
		Arbitro arbitro = new Arbitro("Jeferson", "Brasileiro", "Juiz", 52);
		arbitroDAO.create(arbitro);
		Entidade.resetContagem();
		int id = arbitroDAO.read(1).getId();
		arbitroDAO.delete(id);
		Assert.assertNull(arbitroDAO.read(id));
		
	}

}
