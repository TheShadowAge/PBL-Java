package main.model;

public class DAO {
	private static SelecaoDAO selecaoDAO;
	private static JogadorDAO jogadorDAO;
	private static TecnicoDAO tecnicoDAO;
	private static ArbitroDAO arbitroDAO;
	
	public static SelecaoDAO getSelecoes() {
		if (selecaoDAO == null) {
			selecaoDAO = new SelecaoDAOImplementList();
		}
		return selecaoDAO;
	}
	
	public static JogadorDAO getJogadores() {
		if (jogadorDAO == null) {
			jogadorDAO = new JogadorDAOImplementList();
		}
		return jogadorDAO;
	}
	
	public static TecnicoDAO getTecnicos() {
		if (tecnicoDAO == null) {
			tecnicoDAO = new TecnicoDAOImplementList();
		}
		return tecnicoDAO;
	}
	
	
	
	public static ArbitroDAO getArbitros() {
		if (arbitroDAO == null) {
			arbitroDAO = new ArbitroDAOImplementList();
		}
		return arbitroDAO;
	}

}
