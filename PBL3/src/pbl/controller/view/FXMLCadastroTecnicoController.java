package pbl.controller.view;

import java.io.IOException;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import pbl.model.DAO.DAO;
import pbl.controller.entities.ControllerSelecao;
import pbl.controller.entities.ControllerTecnico;
import pbl.model.DAO.TecnicoDAO;
import pbl.model.entities.Tecnico;

public class FXMLCadastroTecnicoController {

	@FXML
    private Button ButtonAlterarTecnico;

    @FXML
    private Button ButtonInserirTecnico;

    @FXML
    private Button ButtonRemoverTecnico;

    @FXML
    private TableView<Tecnico> TableViewTecnico;

    @FXML
    private Label labelTecnicoId;

    @FXML
    private Label labelTecnicoIdade;

    @FXML
    private Label labelTecnicoNacionalidade;

    @FXML
    private Label labelTecnicoNome;

    @FXML
    private Label labelTecnicoSelecao;

    @FXML
    private Label labelTecnicoTime;

    @FXML
    private TableColumn<Tecnico, Integer> tableColumnTecnicoId;

    @FXML
    private TableColumn<Tecnico, String> tableColumnTecnicoNome;

    
    private List<Tecnico> listTecnicos;
    private ObservableList<Tecnico> observableListTecnicos;

    private final TecnicoDAO tecnicoDAO = DAO.getTecnicos();
    
    @FXML
    void initialize() {
        carregarTableViewTecnico();
        TableViewTecnico.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> selecionarItemTableViewTecnico(newValue));
        
    }

    
    public void carregarTableViewTecnico() {
    	tableColumnTecnicoId.setCellValueFactory(new PropertyValueFactory<>("id"));
    	tableColumnTecnicoNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	
    	listTecnicos = tecnicoDAO.readAll();
    	
    	observableListTecnicos = FXCollections.observableArrayList(listTecnicos);
    	TableViewTecnico.setItems(observableListTecnicos);
    	TableViewTecnico.refresh();
    }
    
    public void selecionarItemTableViewTecnico(Tecnico tecnico) {
    	if (tecnico != null) {
    		labelTecnicoId.setText(Integer.toString(tecnico.getId()));
    		labelTecnicoNome.setText(tecnico.getNome());
    		labelTecnicoNacionalidade.setText(tecnico.getNacionalidade());
    		labelTecnicoIdade.setText(Integer.toString(tecnico.getIdade()));
    		labelTecnicoSelecao.setText(tecnico.getSelecao().getNome());
    		labelTecnicoTime.setText(tecnico.getTimeAnterior());
    	} else {
    		labelTecnicoId.setText("");
    		labelTecnicoNome.setText("");
    		labelTecnicoNacionalidade.setText("");
    		labelTecnicoIdade.setText("");
    		labelTecnicoSelecao.setText("");
    		labelTecnicoTime.setText("");
    		
    	}
    }
    
    @FXML
    public void handleButtonInserirTecnico() throws IOException {
    	Tecnico tecnico = new Tecnico(null, 0, null, null, 0);
    	boolean buttonConfirmarClicked = showFXMLCadastrosTecnicoDialog(tecnico);
    	if (buttonConfirmarClicked) {
    		tecnicoDAO.create(tecnico);
    		carregarTableViewTecnico();
    	}
    }
    
   public void handleButtonAlterarTecnico() throws IOException {
	   Tecnico tecnico = TableViewTecnico.getSelectionModel().getSelectedItem();
	   if (tecnico != null) {
		   boolean buttonConfirmarClicked = showFXMLCadastrosTecnicoDialog(tecnico);
		   if (buttonConfirmarClicked) {
			   ControllerTecnico.updateTecnico(tecnico.getId(), 1, tecnico.getNome());
			   ControllerSelecao.updateSelecao(tecnico.getSelecao().getId(), 4, String.valueOf(-1));
			   ControllerTecnico.updateTecnico(tecnico.getId(), 2, String.valueOf(tecnico.getSelecao().getId()));
			   ControllerSelecao.updateSelecao(tecnico.getSelecao().getId(), 4, String.valueOf(tecnico.getId()));
			   ControllerTecnico.updateTecnico(tecnico.getId(), 3, String.valueOf(tecnico.getIdade()));
			   ControllerTecnico.updateTecnico(tecnico.getId(), 4, tecnico.getNacionalidade());
			   ControllerTecnico.updateTecnico(tecnico.getId(), 5, tecnico.getTimeAnterior());
			   carregarTableViewTecnico();
		   }
	   } else {
		   Alert alert = new Alert(Alert.AlertType.ERROR);
		   alert.setHeaderText("Nenhum Tecnico foi selecionado");
		   alert.setContentText("Por favor, escolha um tecnico na tabela");
		   alert.show();
	   }
   }
   
   public void handleButtonRemoverTecnico() throws IOException {
	   Tecnico tecnico = TableViewTecnico.getSelectionModel().getSelectedItem();
	   if (tecnico != null) {
		   ControllerTecnico.deleteTecnico(tecnico.getId());
		   carregarTableViewTecnico();
	   } else {
		   Alert alert = new Alert(Alert.AlertType.ERROR);
		   alert.setHeaderText("Nenhum Tecnico foi selecionado");
		   alert.setContentText("Por favor, escolha um tecnico na tabela");
		   alert.show();
	   }
   }
   
   public boolean showFXMLCadastrosTecnicoDialog(Tecnico tecnico) throws IOException {
	   FXMLLoader loader = new FXMLLoader();
	   loader.setLocation(FXMLCadastroTecnicoDialogController.class.getResource("/pbl/view/FXMLCadastroTecnicoDialog.fxml"));
	   AnchorPane pagina = (AnchorPane) loader.load();
	   
	   Stage dialogStage = new Stage();
	   dialogStage.setTitle("Cadastro de Tecnico");
	   Scene scene = new Scene(pagina);
	   dialogStage.setScene(scene);
	   
	   FXMLCadastroTecnicoDialogController controller = loader.getController();
	   controller.setDialogStage(dialogStage);
	   controller.setTecnico(tecnico);
	   
	   dialogStage.showAndWait();
	   
	   return controller.isButtonConfirmarClicked();
   }
}

