package pbl.controller.view;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import pbl.model.DAO.SelecaoDAO;
import pbl.model.entities.Grupo;
import pbl.model.entities.Selecao;
import pbl.model.DAO.DAO;
import pbl.controller.entities.ControllerGrupo;
import pbl.model.DAO.GrupoDAO;
import pbl.model.entities.Arbitro;

public class FXMLListarGrupoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Grupo> TableViewGrupo;

    @FXML
    private TableView<Selecao> TableViewGrupoSelecoes;

    @FXML
    private Label labelGrupoID;

    @FXML
    private Label LabelGrupoQuantidade;

    @FXML
    private Label labelGrupoNome;

    @FXML
    private TableColumn<Grupo, String> tableColumnGrupoID;

    @FXML
    private TableColumn<Grupo, String> tableColumnGrupoNome;

    @FXML
    private TableColumn<Selecao, String> tableColumnGrupoSelecoes;

    @FXML
    private TableColumn<Selecao, String> tableColumnGrupoSelecoesID;

    @FXML
    private TableColumn<Selecao, String> tableColumnGrupoSelecoesNome;
    
    private List<Grupo> listGrupos;
    private List<Selecao> listSelecoes;
    private ObservableList<Grupo> observableListGrupos;
    private ObservableList<Selecao> observableListSelecoes;
    
    private final GrupoDAO grupoDAO = DAO.getGrupos();
    private final SelecaoDAO selecaoDAO = DAO.getSelecoes();    
    @FXML
    void initialize() {
    	carregarTableViewGrupo();
    	TableViewGrupo.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> selecionarItemTableViewGrupo(newValue));
    }
    
    public void carregarTableViewGrupo() {
    	tableColumnGrupoID.setCellValueFactory(new PropertyValueFactory<>("id"));
    	tableColumnGrupoNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	
    	listGrupos = grupoDAO.readAll();
    	
    	observableListGrupos = FXCollections.observableArrayList(listGrupos);
    	TableViewGrupo.setItems(observableListGrupos);
    	TableViewGrupo.refresh();
    }
    
    public void carregarTableViewGrupoSelecoes(Grupo grupo) {
    	tableColumnGrupoSelecoesID.setCellValueFactory(new PropertyValueFactory<>("id"));
    	tableColumnGrupoSelecoesNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	
    	List<Selecao> lista = new LinkedList<Selecao>();
    	
    	for (Selecao selecaoIterator: selecaoDAO.readAll()) {
    		if (selecaoIterator.getGrupo() == grupo.getId()) {
    			lista.add(selecaoIterator);
    		}
    	}
    	
    	observableListSelecoes = FXCollections.observableArrayList(lista);
    	TableViewGrupoSelecoes.setItems(observableListSelecoes);
    	TableViewGrupoSelecoes.refresh();
    }
    
    public void selecionarItemTableViewGrupo(Grupo grupo) {
    	if (grupo != null) {
    		labelGrupoID.setText(Integer.toString(grupo.getId()));
    		labelGrupoNome.setText(grupo.getNome());
    		LabelGrupoQuantidade.setText(Integer.toString(grupo.getQuantidadeSelecoes()));
    		carregarTableViewGrupoSelecoes(grupo);
    	} else {
    		labelGrupoID.setText("");
    		labelGrupoNome.setText("");
    		LabelGrupoQuantidade.setText("");
    	}
    	
    }

}
