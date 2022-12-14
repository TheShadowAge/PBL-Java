package pbl.controller.view;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

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
import pbl.controller.entities.ControllerGrupo;
import pbl.controller.entities.ControllerSelecao;
import pbl.model.DAO.DAO;
import pbl.model.DAO.GrupoDAO;
import pbl.model.DAO.SelecaoDAO;
import pbl.model.DAO.JogadorDAO;
import pbl.model.DAO.PartidaDAO;
import pbl.model.DAO.TecnicoDAO;
import pbl.model.entities.Jogador;
import pbl.model.entities.Partida;
import pbl.model.entities.Selecao;

public class FXMLCadastroSelecaoController {

    @FXML
    private Button ButtonAlterarSelecao;

    @FXML
    private Button ButtonInserirSelecao;

    @FXML
    private Button ButtonRemoverSelecao;
    
    @FXML
    private Button ButtonLimparPesquisa;

    @FXML
    private Button ButtonPesquisar;

    @FXML
    private TableView<Selecao> TableViewSelecao;
    
    @FXML
    private TableView<Jogador> TableViewSelecaoJogador;
    
    @FXML
    private TableView<Partida> TableViewSelecaoPartidas;
    
    @FXML
    private TextField TextFieldPesquisa;

    @FXML
    private Label labelSelecaoCodSel;

    @FXML
    private Label labelSelecaoGrupo;

    @FXML
    private Label labelSelecaoID;

    @FXML
    private Label labelSelecaoNome;

    @FXML
    private Label labelSelecaoTecnico;

    @FXML
    private TableColumn<Selecao, String> tableColumnSelecaoID;

    @FXML
    private TableColumn<Selecao, String> tableColumnSelecaoNome;
    
    @FXML
    private TableColumn<Jogador, String> tableColumnSelecaoJogadores;
    
    @FXML
    private TableColumn<Jogador, String> tableColumnSelecaoJogadorID;

    @FXML
    private TableColumn<Jogador, String> tableColumnSelecaoJogadorNome;
    
    @FXML
    private TableColumn<Partida, String> tableColumnSelecaoPartida;
    
    @FXML
    private TableColumn<Partida, String> tableColumnSelecaoPartidaID;

    @FXML
    private TableColumn<Partida, String> tableColumnSelecaoPartidaNome;


    private List<Selecao> listSelecoes;
    private List<Jogador> listJogadores;
    private List<Partida> listPartida;
    private ObservableList<Selecao> observableListSelecoes;
    private ObservableList<Jogador> observableListJogadores;
    private ObservableList<Partida> observableListPartidas;

    private final SelecaoDAO selecaoDAO = DAO.getSelecoes();
    private final TecnicoDAO tecnicoDAO = DAO.getTecnicos();
    private final JogadorDAO jogadorDAO = DAO.getJogadores();
    private final GrupoDAO grupoDAO = DAO.getGrupos();
    private final PartidaDAO partidaDAO = DAO.getPartidas();
    
    @FXML
    void initialize() {
        carregarTableViewSelecao();
        TableViewSelecao.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> selecionarItemTableViewSelecao(newValue));
        
    }

    
    public void carregarTableViewSelecao() {
    	tableColumnSelecaoID.setCellValueFactory(new PropertyValueFactory<>("id"));
    	tableColumnSelecaoNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	
    	listSelecoes = selecaoDAO.readAll();
    	
    	observableListSelecoes = FXCollections.observableArrayList(listSelecoes);
    	TableViewSelecao.setItems(observableListSelecoes);
    	TableViewSelecao.refresh();
    }
    
    public void carregarTableViewSelecaoJogador(Selecao selecao) {
    	tableColumnSelecaoJogadorID.setCellValueFactory(new PropertyValueFactory<>("id"));
    	tableColumnSelecaoJogadorNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	
    	List<Jogador> lista = new LinkedList<Jogador>();
    	for (Jogador jogadorIterator: jogadorDAO.readAll()) {
			if (jogadorIterator.getSelecao().getId() == selecao.getId()) {
				lista.add(jogadorIterator);
			}
    	}
    	
    	listJogadores = lista;
    	
    	observableListJogadores = FXCollections.observableArrayList(listJogadores);
    	TableViewSelecaoJogador.setItems(observableListJogadores);
    	TableViewSelecaoJogador.refresh();
    }
    
    public void carregarTableViewSelecaoPartida(Selecao selecao) {
    	tableColumnSelecaoPartidaID.setCellValueFactory(new PropertyValueFactory<>("id"));
    	tableColumnSelecaoPartidaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	
    	List<Partida> lista = new LinkedList<Partida>();
    	for (Partida partidaIterator: partidaDAO.readAll()) {
			if (partidaIterator.getTime1() == selecao.getId() || partidaIterator.getTime2() == selecao.getId()){
				lista.add(partidaIterator);
			}
    	}
    	
    	listPartida = lista;
    	
    	observableListPartidas = FXCollections.observableArrayList(listPartida);
    	TableViewSelecaoPartidas.setItems(observableListPartidas);
    	TableViewSelecaoPartidas.refresh();
    }
    
    
    public void selecionarItemTableViewSelecao(Selecao selecao) {
    	if (selecao != null) {
    		labelSelecaoID.setText(Integer.toString(selecao.getId()));
    		labelSelecaoCodSel.setText(Integer.toString(selecao.getCodSel()));
    		labelSelecaoNome.setText(selecao.getNome());
    		labelSelecaoGrupo.setText(grupoDAO.read(selecao.getGrupo()).getNome());
    		if (selecao.getTecnico() == -1) {
    		labelSelecaoTecnico.setText("Sem tecnico");
    		} else {
    			labelSelecaoTecnico.setText(tecnicoDAO.read(selecao.getTecnico()).getNome());
    		}
    		carregarTableViewSelecaoJogador(selecao);
    		carregarTableViewSelecaoPartida(selecao);
    	} else {
    		labelSelecaoID.setText("");
    		labelSelecaoCodSel.setText("");
    		labelSelecaoNome.setText("");
    		labelSelecaoGrupo.setText("");
    		labelSelecaoTecnico.setText("");
    	}
    }
    
    @FXML
    public void handleButtonInserirSelecao() throws IOException {
    	Selecao selecao = new Selecao(null, 0, 0);
    	boolean buttonConfirmarClicked = showFXMLCadastrosSelecaoDialog(selecao);
    	if (buttonConfirmarClicked) {
    		selecaoDAO.create(selecao);
    		ControllerGrupo.updateGrupo(selecao.getGrupo(), 2,String.valueOf(selecao.getId()));
    		carregarTableViewSelecao();
    	}
    }
   
    @FXML
    public void handleButtonAlterarSelecao() throws IOException {
 	   Selecao selecao = (Selecao) TableViewSelecao.getSelectionModel().getSelectedItem();
 	   if (selecao != null) {
 		   ControllerGrupo.updateGrupo(selecao.getGrupo(), 3 ,Integer.toString(selecao.getId()));
 		   int aux = selecao.getGrupo();
 		   boolean buttonConfirmarClicked = showFXMLCadastrosSelecaoDialog(selecao);
 		   if (buttonConfirmarClicked) {
 			   ControllerSelecao.updateSelecao(selecao.getId(), 1, selecao.getNome());
 			   ControllerSelecao.updateSelecao(selecao.getId(), 2, String.valueOf(selecao.getGrupo()));
 			   ControllerGrupo.updateGrupo(selecao.getGrupo(), 2,Integer.toString(selecao.getId()));
 			   grupoDAO.read(aux).setQuantidadeSelecoes(1);;
 			   carregarTableViewSelecao();
 		   }
 	   } else {
 		   Alert alert = new Alert(Alert.AlertType.ERROR);
 		   alert.setHeaderText("Nenhuma selecao foi selecionada");
 		   alert.setContentText("Por favor, escolha uma selecao na tabela");
 		   alert.show();
 	   }
    }
   
   @FXML
   public void handleButtonRemoverSelecao() throws IOException {
	   Selecao selecao = TableViewSelecao.getSelectionModel().getSelectedItem();
	   if (selecao != null) {
			   Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
			   alert.setTitle("Deletar Seleção");
			   alert.setContentText("Tem certeza que deseja excluir a selecao ? \nIsso vai excluir a selecao e todos os jogadores e o ténico dela.\nAperte OK para confirmar");
			   Optional<ButtonType> result = alert.showAndWait();
			   if (result.get() == ButtonType.OK) {
				  ControllerSelecao.deleteSelecao(selecao.getId());
				  carregarTableViewSelecao();
				  }
	   }else{
		   Alert alertError = new Alert(Alert.AlertType.ERROR);
		   alertError.setHeaderText("Nenhuma selecao foi selecionada");
		   alertError.setContentText("Por favor, escolha uma selecao na tabela");
		   alertError.show();
		}
   }	   
   
   @FXML
   void handleButtonPesquisar() throws IOException {
	   List<Selecao> listaPesquisa = new LinkedList<Selecao>();
	   for (Selecao selecaoIterator: selecaoDAO.readAll()) {
		   if (selecaoIterator.getNome().toLowerCase().contains(TextFieldPesquisa.getText().toLowerCase())) {
			   listaPesquisa.add(selecaoIterator);
		   }
	   }
	   tableColumnSelecaoID.setCellValueFactory(new PropertyValueFactory<>("id"));
	   tableColumnSelecaoNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
	   listSelecoes = listaPesquisa;
	   observableListSelecoes = FXCollections.observableArrayList(listSelecoes);
	   TableViewSelecao.setItems(observableListSelecoes);
	   TableViewSelecao.refresh();
   }
   
   @FXML
   void handleButtonLimpar() {
	   TextFieldPesquisa.setText("");
	   carregarTableViewSelecao();
   }
   
   public boolean showFXMLCadastrosSelecaoDialog(Selecao selecao) throws IOException {
	   FXMLLoader loader = new FXMLLoader();
	   loader.setLocation(FXMLCadastroSelecaoDialogController.class.getResource("/pbl/view/FXMLCadastroSelecaoDialog.fxml"));
	   AnchorPane pagina = (AnchorPane) loader.load();
	   
	   Stage dialogStage = new Stage();
	   dialogStage.setTitle("Cadastro de Selecao");
	   Scene scene = new Scene(pagina);
	   dialogStage.setScene(scene);
	   
	   FXMLCadastroSelecaoDialogController controller = loader.getController();
	   controller.setDialogStage(dialogStage);
	   controller.setSelecao(selecao);
	   
	   dialogStage.showAndWait();
	   
	   return controller.isButtonConfirmarClicked();
   }
}

