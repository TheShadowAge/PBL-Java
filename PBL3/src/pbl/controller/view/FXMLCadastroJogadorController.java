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
import pbl.controller.entities.ControllerJogador;
import pbl.controller.entities.ControllerSelecao;
import pbl.model.DAO.DAO;
import pbl.model.DAO.JogadorDAO;
import pbl.model.entities.Jogador;

public class FXMLCadastroJogadorController {

    @FXML
    private Button ButtonAlterarJogador;

    @FXML
    private Button ButtonInserirJogador;

    @FXML
    private Button ButtonRemoverJogador;

    @FXML
    private TableView<Jogador> TableViewJogador;
    
    @FXML
    private Button ButtonLimparPesquisa;

    @FXML
    private Button ButtonPesquisar;
    
    @FXML
    private TextField TextFieldPesquisa;
    
    @FXML
    private Label labelJogadorCartoesAmarelos;

    @FXML
    private Label labelJogadorCartoesVermelhos;

    @FXML
    private Label labelJogadorGols;

    @FXML
    private Label labelJogadorIdade;

    @FXML
    private Label labelJogadorNacionalidade;

    @FXML
    private Label labelJogadorNome;

    @FXML
    private Label labelJogadorPosicao;

    @FXML
    private Label labelJogadorSelecao;

    @FXML
    private Label labelJogadorTitular;

    @FXML
    private TableColumn<Jogador, String> tableColumnJogadorID;

    @FXML
    private TableColumn<Jogador, String> tableColumnJogadorNome;
    
    private List<Jogador> listJogadores;
    private ObservableList<Jogador> observableListJogadores;

    private final JogadorDAO jogadorDAO = DAO.getJogadores();
    
    @FXML
    void initialize() {
        carregarTableViewJogador();
        TableViewJogador.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> selecionarItemTableViewJogador(newValue));
        
    }

    
    public void carregarTableViewJogador() {
    	listJogadores = jogadorDAO.readAll();
    	
    	tableColumnJogadorID.setCellValueFactory(new PropertyValueFactory<>("id"));
    	tableColumnJogadorNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	
    	observableListJogadores = FXCollections.observableArrayList(listJogadores);
    	TableViewJogador.setItems(observableListJogadores);
    	TableViewJogador.refresh();
    }
    
    public void selecionarItemTableViewJogador(Jogador jogador) {
    	if (jogador != null) {
    		labelJogadorNome.setText(jogador.getNome());
    		labelJogadorSelecao.setText(jogador.getSelecao().getNome());
    		labelJogadorNacionalidade.setText(jogador.getNacionalidade());
    		labelJogadorIdade.setText(Integer.toString(jogador.getIdade()));
    		labelJogadorPosicao.setText(jogador.getPosicao());
    		if (jogador.isTitular()) {
    			labelJogadorTitular.setText("Titular");
    		} else {
    			labelJogadorTitular.setText("Reserva");
    		}
    		labelJogadorGols.setText(String.valueOf(jogador.getGolsQuantidade()));
    		labelJogadorCartoesAmarelos.setText(String.valueOf(jogador.getCartaoAmarelo()));
    		labelJogadorCartoesVermelhos.setText(String.valueOf(jogador.getCartaoVermelho()));
    	} else {
    		labelJogadorNome.setText("");
    		labelJogadorSelecao.setText("");
    		labelJogadorNacionalidade.setText("");
    		labelJogadorIdade.setText("");
    		labelJogadorPosicao.setText("");
    		labelJogadorTitular.setText("");
    		labelJogadorGols.setText("");
    		labelJogadorCartoesAmarelos.setText("");
    		labelJogadorCartoesVermelhos.setText("");
    	}
    }
    
    @FXML
    public void handleButtonInserirJogador() throws IOException {
    	Jogador jogador = new Jogador(null, 0, null, 0, null, false);
    	boolean buttonConfirmarClicked = showFXMLCadastrosJogadorDialog(jogador);
    	if (buttonConfirmarClicked) {
    		jogadorDAO.create(jogador);
    		carregarTableViewJogador();
    	}
    }
    
	public void handleButtonAlterarJogador() throws IOException {
		   Jogador jogador = TableViewJogador.getSelectionModel().getSelectedItem();
		   if (jogador != null) {
			   ControllerSelecao.updateSelecao(ControllerJogador.SelecaoJogador(jogador.getId()), 6, String.valueOf(jogador.getId()));
			   boolean buttonConfirmarClicked = showFXMLCadastrosJogadorDialog(jogador);
			   if (buttonConfirmarClicked) {
				   ControllerJogador.updateJogador(jogador.getId(), 1, jogador.getNome());
				   ControllerJogador.updateJogador(jogador.getId(), 2, String.valueOf(jogador.getSelecao()));
				   ControllerSelecao.updateSelecao(ControllerJogador.SelecaoJogador(jogador.getId()), 5, String.valueOf(jogador.getId()));
				   ControllerJogador.updateJogador(jogador.getId(), 3, jogador.getPosicao());
				   ControllerJogador.updateJogador(jogador.getId(), 6, String.valueOf(jogador.getIdade()));
				   ControllerJogador.updateJogador(jogador.getId(), 7, jogador.getNacionalidade());
				   ControllerJogador.updateJogador(jogador.getId(), 8, String.valueOf(jogador.isTitular()));
				   carregarTableViewJogador();
			   }
		   } else {
			   Alert alert = new Alert(Alert.AlertType.ERROR);
			   alert.setHeaderText("Nenhum jogador foi selecionado");
			   alert.setContentText("Por favor, escolha um jogador na tabela");
			   alert.show();
		   }
	   }   
   
   public void handleButtonRemoverJogador() throws IOException {
	   Jogador jogador = TableViewJogador.getSelectionModel().getSelectedItem();
	   if (jogador != null) {
		   Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		   alert.setTitle("Deletar Jogador");
		   alert.setContentText("Tem certeza que deseja excluir o Jogador? \nAperte OK para confirmar");
		   Optional<ButtonType> result = alert.showAndWait();
		   if (result.get() == ButtonType.OK) {
			   ControllerSelecao.updateSelecao(ControllerJogador.SelecaoJogador(jogador.getId()), 5, String.valueOf(jogador.getId()));
			   ControllerJogador.deleteJogador(jogador.getId());
			   carregarTableViewJogador();
			   }
	   } else {
		   Alert alert = new Alert(Alert.AlertType.ERROR);
		   alert.setHeaderText("Nenhum jogador foi selecionado");
		   alert.setContentText("Por favor, escolha um jogador na tabela");
		   alert.show();
	   }
   }
   
   @FXML
   void handleButtonPesquisar() throws IOException {
	   List<Jogador> listaPesquisa = new LinkedList<Jogador>();
	   for (Jogador jogadorIterator: jogadorDAO.readAll()) {
		   if (jogadorIterator.getNome().toLowerCase().contains(TextFieldPesquisa.getText().toLowerCase())) {
			   listaPesquisa.add(jogadorIterator);
		   }
	   }
	   tableColumnJogadorID.setCellValueFactory(new PropertyValueFactory<>("id"));
	   tableColumnJogadorNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
	   listJogadores = listaPesquisa;
	   observableListJogadores = FXCollections.observableArrayList(listJogadores);
	   TableViewJogador.setItems(observableListJogadores);
	   TableViewJogador.refresh();
   }
   
   @FXML
   void handleButtonLimpar() {
	   TextFieldPesquisa.setText("");
	   carregarTableViewJogador();
   }
   
   public boolean showFXMLCadastrosJogadorDialog(Jogador jogador) throws IOException {
	   FXMLLoader loader = new FXMLLoader();
	   loader.setLocation(FXMLCadastroJogadorDialogController.class.getResource("/pbl/view/FXMLCadastroJogadorDialog.fxml"));
	   AnchorPane pagina = (AnchorPane) loader.load();
	   
	   Stage dialogStage = new Stage();
	   dialogStage.setTitle("Cadastro de Jogador");
	   Scene scene = new Scene(pagina);
	   dialogStage.setScene(scene);
	   
	   FXMLCadastroJogadorDialogController controller = loader.getController();
	   controller.setDialogStage(dialogStage);
	   controller.setJogador(jogador);
	   
	   dialogStage.showAndWait();
	   
	   return controller.isButtonConfirmarClicked();
   }
}

