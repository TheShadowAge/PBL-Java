package pbl.controller.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import pbl.model.StartingEntitiesCreator;

public class FXMLMainController {

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private MenuItem menuCadastroArbitro;

    @FXML
    private MenuItem menuCadastroGrupo;

    @FXML
    private MenuItem menuCadastroJogador;

    @FXML
    private MenuItem menuCadastroPartida;

    @FXML
    private MenuItem menuCadastroSelecao;

    @FXML
    private MenuItem menuCadastroTecnico;

    @FXML
    private Menu menuInserir;

    @FXML
    private Menu menuListar;

    @FXML
    private MenuItem menuListarArbitro;

    @FXML
    private MenuItem menuListarJogador;

    @FXML
    private MenuItem menuListarPartida;

    @FXML
    private MenuItem menuListarSelecao;

    @FXML
    private MenuItem menuListarTecnico;

    @FXML
    private Menu menuPesquisar;

    @FXML
    private Menu menuPesquisarCategoria;

    @FXML
    private MenuItem menuPesquisarCategoriaArbitro;

    @FXML
    private MenuItem menuPesquisarCategoriaJogador;

    @FXML
    private MenuItem menuPesquisarCategoriaPartida;

    @FXML
    private MenuItem menuPesquisarCategoriaSelecao;

    @FXML
    private MenuItem menuPesquisarCategoriaTecnico;

    @FXML
    private MenuItem menuPesquisarPartidaPorData;

    @FXML
    private MenuItem menuPesquisarSelecao;
    
    @FXML
    void initialize() {
    	StartingEntitiesCreator.entitiesCreator();
    }
    
    @FXML
    public void handleMenuItemCadastroArbitro() throws IOException {
    	AnchorPane cena = (AnchorPane) FXMLLoader.load(getClass().getResource("/pbl/view/FXMLCadastroArbitro.fxml"));
    	anchorPane.getChildren().setAll(cena);
    }
    
    @FXML
    public void handleMenuItemCadastroJogador() throws IOException {
    	AnchorPane cena = (AnchorPane) FXMLLoader.load(getClass().getResource("/pbl/view/FXMLCadastroJogador.fxml"));
    	anchorPane.getChildren().setAll(cena);
    }
    
    @FXML
    public void handleMenuItemCadastroSelecao() throws IOException {
    	AnchorPane cena = (AnchorPane) FXMLLoader.load(getClass().getResource("/pbl/view/FXMLCadastroSelecao.fxml"));
    	anchorPane.getChildren().setAll(cena);
    }
    
    @FXML
    public void handleMenuItemCadastroTecnico() throws IOException {
    	AnchorPane cena = (AnchorPane) FXMLLoader.load(getClass().getResource("/pbl/view/FXMLCadastroTecnico.fxml"));
    	anchorPane.getChildren().setAll(cena);
    }
    
    @FXML
    public void handleMenuItemListarGrupo() throws IOException {
    	AnchorPane cena = (AnchorPane) FXMLLoader.load(getClass().getResource("/pbl/view/FXMLListarGrupo.fxml"));
    	anchorPane.getChildren().setAll(cena);
    }
    
    @FXML
    public void handleMenuItemCadastrarPartida() throws IOException {
    	AnchorPane cena = (AnchorPane) FXMLLoader.load(getClass().getResource("/pbl/view/FXMLCadastroPartida.fxml"));
    	anchorPane.getChildren().setAll(cena);
    }

}
