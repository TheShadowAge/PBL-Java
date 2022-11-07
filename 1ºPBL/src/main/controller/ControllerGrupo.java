package main.controller;

import main.model.DAO.DAO;
import main.model.DAO.GrupoDAO;

public class ControllerGrupo {
	public static void updateGrupo(int idGrupo, int opcao, String atributo) {
		GrupoDAO grupoDAO = DAO.getGrupos();
		grupoDAO.update(idGrupo, opcao, atributo);
	}
}
