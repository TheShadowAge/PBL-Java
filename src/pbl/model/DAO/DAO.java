package pbl.model.DAO;

/**
 * Classe com métodos estáticos que lida com todos os DAOs do sistema.
 * @author Gabriel Sena
 * @author Ian Gabriel
 *
 */

public class DAO {
	private static SelecaoDAO selecaoDAO;
	private static JogadorDAO jogadorDAO;
	private static TecnicoDAO tecnicoDAO;
	private static ArbitroDAO arbitroDAO;
	private static PartidaDAO partidaDAO;
	private static GrupoDAO grupoDAO;
	
	/**
	 * Método que pode ser acessado de todo o sistema para acessar o DAO de seleções.
	 * @return O Objeto DAO de seleções.
	 */
	
	public static SelecaoDAO getSelecoes() {
		if (selecaoDAO == null) {
			selecaoDAO = new SelecaoDAOImplementList();
		}
		return selecaoDAO;
	}
	
	/**
	 * Método que pode ser acessado de todo o sistema para acessar o DAO de jogadores.
	 * @return O Objeto DAO de jogadores.
	 */
	
	public static JogadorDAO getJogadores() {
		if (jogadorDAO == null) {
			jogadorDAO = new JogadorDAOImplementList();
		}
		return jogadorDAO;
	}
	
	/**
	 * Método que pode ser acessado de todo o sistema para acessar o DAO de técnicos.
	 * @return O Objeto DAO de técnicos.
	 */
	
	public static TecnicoDAO getTecnicos() {
		if (tecnicoDAO == null) {
			tecnicoDAO = new TecnicoDAOImplementList();
		}
		return tecnicoDAO;
	}
	
	/**
	 * Método que pode ser acessado de todo o sistema para acessar o DAO de árbitros.
	 * @return O Objeto DAO de árbitros.
	 */
	
	public static ArbitroDAO getArbitros() {
		if (arbitroDAO == null) {
			arbitroDAO = new ArbitroDAOImplementList();
		}
		return arbitroDAO;
	}
	
	/**
	 * Método que pode ser acessado de todo o sistema para acessar o DAO de partidas.
	 * @return O Objeto DAO de partidas.
	 */
	
	public static PartidaDAO getPartidas() {
		if (partidaDAO == null) {
			partidaDAO = new PartidaDAOImplementList();
		}
		return partidaDAO;
	}
	
	/**
	 * Método que pode ser acessado de todo o sistema para acessa o DAO de grupos.
	 * @return O Objeto DAO de grupos.
	 */
	
	public static GrupoDAO getGrupos() {
		if (grupoDAO == null) {
			grupoDAO = new GrupoDAOImplementList();
		}
		return grupoDAO;
	}
	
}
