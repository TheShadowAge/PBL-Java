package pbl.controller.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;

public class FXMLMainController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private AnchorPane anchorPane;

	@FXML
	private Menu menuInserir;

	@FXML
	private MenuItem menuInserirArbitro;

	@FXML
	private MenuItem menuInserirJogador;
	
	@FXML
	private MenuItem menuInserirPartida;

	@FXML
	private MenuItem menuInserirSelecao;

	@FXML
	private MenuItem menuInserirTecnico;

	@FXML
	private Menu menuPesquisar;

	@FXML
	private MenuItem menuPesquisarCategoria;

	@FXML
	private MenuItem menuPesquisarPartidaPorData;

	@FXML
	private MenuItem menuPesquisarSelecao;

    @FXML
    void initialize() {

    }
    
    @FXML
    void handleMenuItemInserirArbitro() throws IOException {
    	AnchorPane cena = (AnchorPane) FXMLLoader.load(getClass().getResource("/pbl/view/FXMLCadastroArbitro.fxml"));
    	anchorPane.getChildren().setAll(cena);
    }
    
    @FXML
    public void handleMenuItemInserirJogador() throws IOException {
    	AnchorPane cena = (AnchorPane) FXMLLoader.load(getClass().getResource("/pbl/view/FXMLCadastroJogador.fxml"));
    	anchorPane.getChildren().setAll(cena);
    }
    
    @FXML
    public void handleMenuItemInserirSelecao() throws IOException {
    	AnchorPane cena = (AnchorPane) FXMLLoader.load(getClass().getResource("/pbl/view/FXMLCadastroSelecao.fxml"));
    	anchorPane.getChildren().setAll(cena);
    }

}
