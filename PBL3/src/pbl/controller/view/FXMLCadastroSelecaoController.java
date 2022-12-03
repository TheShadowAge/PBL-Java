package pbl.controller.view;

import java.io.IOException;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import pbl.controller.entities.ControllerGrupo;
import pbl.controller.entities.ControllerSelecao;
import pbl.model.DAO.DAO;
import pbl.model.DAO.SelecaoDAO;
import pbl.model.DAO.TecnicoDAO;
import pbl.model.entities.Selecao;

public class FXMLCadastroSelecaoController {

    @FXML
    private Button ButtonAlterarSelecao;

    @FXML
    private Button ButtonInserirSelecao;

    @FXML
    private Button ButtonRemoverSelecao;

    @FXML
    private TableView<Selecao> TableViewSelecao;

    @FXML
    private Label labelSelecaoCodSel;

    @FXML
    private Label labelSelecaoGrupo;

    @FXML
    private Label labelSelecaoID;

    @FXML
    private Label labelSelecaoNome;

    @FXML
    private Label labelSelecaoQuantJogs;

    @FXML
    private Label labelSelecaoTecnico;

    @FXML
    private TableColumn<Selecao, String> tableColumnSelecaoID;

    @FXML
    private TableColumn<Selecao, String> tableColumnSelecaoNome;

    private List<Selecao> listSelecoes;
    private ObservableList<Selecao> observableListSelecoes;
    private int click = 0;

    private final SelecaoDAO selecaoDAO = DAO.getSelecoes();
    private final TecnicoDAO tecnicoDAO = DAO.getTecnicos();
    
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
    
    public void selecionarItemTableViewSelecao(Selecao selecao) {
    	if (selecao != null) {
    		labelSelecaoID.setText(Integer.toString(selecao.getId()));
    		labelSelecaoCodSel.setText(Integer.toString(selecao.getCodSel()));
    		labelSelecaoNome.setText(selecao.getNome());
    		labelSelecaoGrupo.setText(selecao.getGrupo().getNome());
    		labelSelecaoQuantJogs.setText(Integer.toString(selecao.getJogadores().size()));
    		if (selecao.getTecnico() == -1) {
    		labelSelecaoTecnico.setText("Sem tecnico");
    		} else {
    			labelSelecaoTecnico.setText(tecnicoDAO.read(selecao.getTecnico()).getNome());
    		}
    	} else {
    		labelSelecaoID.setText("");
    		labelSelecaoCodSel.setText("");
    		labelSelecaoNome.setText("");
    		labelSelecaoGrupo.setText("");
    		labelSelecaoQuantJogs.setText("");
    		labelSelecaoTecnico.setText("");
    	}
    }
    
    @FXML
    public void handleButtonInserirSelecao() throws IOException {
    	Selecao selecao = new Selecao(null, 0, 0);
    	boolean buttonConfirmarClicked = showFXMLCadastrosSelecaoDialog(selecao);
    	if (buttonConfirmarClicked) {
    		selecaoDAO.create(selecao);
    		ControllerGrupo.updateGrupo(selecao.getGrupo().getId(), 2,String.valueOf(selecao.getId()));
    		carregarTableViewSelecao();
    	}
    }
    
   public void handleButtonAlterarSelecao() throws IOException {
	   Selecao selecao = (Selecao) TableViewSelecao.getSelectionModel().getSelectedItem();
	   if (selecao != null) {
		   boolean buttonConfirmarClicked = showFXMLCadastrosSelecaoDialog(selecao);
		   if (buttonConfirmarClicked) {
			   ControllerSelecao.updateSelecao(selecao.getId(), 1, selecao.getNome());
			   ControllerGrupo.updateGrupo(selecao.getGrupo().getId(), 3 ,Integer.toString(selecao.getId()));
			   ControllerSelecao.updateSelecao(selecao.getId(), 2, String.valueOf(selecao.getGrupo().getId()));
			   ControllerGrupo.updateGrupo(selecao.getGrupo().getId(), 2,Integer.toString(selecao.getId()));
			   carregarTableViewSelecao();
		   }
	   } else {
		   Alert alert = new Alert(Alert.AlertType.ERROR);
		   alert.setContentText("Por favor, escolha uma selecao na tabela");
		   alert.show();
	   }
   }
   
   public void handleButtonRemoverSelecao() throws IOException {
	   Selecao selecao = TableViewSelecao.getSelectionModel().getSelectedItem();
	   if (selecao != null) {
		   if (click == 0) {
			   Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
			   alert.setTitle("Deletar Seleção");
			   alert.setContentText("Tem certeza que deseja excluir a selecao ? \nIsso vai excluir a selecao e todos os jogadores e o ténico dela.\nAperte OK para confirmar");
			   Optional<ButtonType> result = alert.showAndWait();
			   if (result.get() == ButtonType.OK) {
				  ControllerSelecao.deleteSelecao(selecao.getId());
				  carregarTableViewSelecao();
				  }
			   }
	   }else{
		   Alert alertError = new Alert(Alert.AlertType.ERROR);
		   alertError.setContentText("Por favor, escolha uma selecao na tabela");
		   alertError.show();
		}
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

