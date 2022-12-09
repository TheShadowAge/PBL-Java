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
import pbl.controller.entities.ControllerArbitro;
import pbl.model.DAO.ArbitroDAO;
import pbl.model.entities.Arbitro;

public class FXMLCadastroArbitroController {

	@FXML
    private Button ButtonAlterarArbitro;

    @FXML
    private Button ButtonInserirArbitro;

    @FXML
    private Button ButtonRemoverArbitro;

    @FXML
    private TableView<Arbitro> TableViewArbitro;

    @FXML
    private Label labelArbitroIdade;

    @FXML
    private Label labelArbitroNacionalidade;

    @FXML
    private Label labelArbitroNome;

    @FXML
    private Label labelArbitroTipo;

    @FXML
    private Label labelArbitroId;
    
    @FXML
    private TableColumn<Arbitro, String> tableColumnArbitroID;

    @FXML
    private TableColumn<Arbitro, String> tableColumnArbitroNome;
    
    private List<Arbitro> listArbitros;
    private ObservableList<Arbitro> observableListArbitros;

    private final ArbitroDAO arbitroDAO = DAO.getArbitros();
    
    @FXML
    void initialize() {
        carregarTableViewArbitro();
        TableViewArbitro.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> selecionarItemTableViewArbitro(newValue));
        
    }

    
    public void carregarTableViewArbitro() {
    	tableColumnArbitroID.setCellValueFactory(new PropertyValueFactory<>("id"));
    	tableColumnArbitroNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	
    	listArbitros = arbitroDAO.readAll();
    	
    	observableListArbitros = FXCollections.observableArrayList(listArbitros);
    	TableViewArbitro.setItems(observableListArbitros);
    	TableViewArbitro.refresh();
    }
    
    public void selecionarItemTableViewArbitro(Arbitro arbitro) {
    	if (arbitro != null) {
    		labelArbitroId.setText(Integer.toString(arbitro.getId()));
    		labelArbitroNome.setText(arbitro.getNome());
    		labelArbitroNacionalidade.setText(arbitro.getNacionalidade());
    		labelArbitroIdade.setText(Integer.toString(arbitro.getIdade()));
    		labelArbitroTipo.setText(arbitro.getTipo());
    	} else {
    		labelArbitroId.setText("");
    		labelArbitroNome.setText("");
    		labelArbitroNacionalidade.setText("");
    		labelArbitroIdade.setText("");
    		labelArbitroTipo.setText("");
    	}
    }
    
    @FXML
    public void handleButtonInserirArbitro() throws IOException {
    	Arbitro arbitro = new Arbitro(null, null, null, 0);
    	boolean buttonConfirmarClicked = showFXMLCadastrosArbitroDialog(arbitro);
    	if (buttonConfirmarClicked) {
    		arbitroDAO.create(arbitro);
    		carregarTableViewArbitro();
    	}
    }
    
   public void handleButtonAlterarArbitro() throws IOException {
	   Arbitro arbitro = TableViewArbitro.getSelectionModel().getSelectedItem();
	   if (arbitro != null) {
		   boolean buttonConfirmarClicked = showFXMLCadastrosArbitroDialog(arbitro);
		   if (buttonConfirmarClicked) {
			   ControllerArbitro.updateArbitro(arbitro.getId(), 1, arbitro.getNome());
			   ControllerArbitro.updateArbitro(arbitro.getId(), 2, String.valueOf(arbitro.getId()));
			   ControllerArbitro.updateArbitro(arbitro.getId(), 3, arbitro.getNacionalidade());
			   ControllerArbitro.updateArbitro(arbitro.getId(), 4, arbitro.getTipo());
			   carregarTableViewArbitro();
		   }
	   } else {
		   Alert alert = new Alert(Alert.AlertType.ERROR);
		   alert.setHeaderText("Nenhum arbitro foi selecionado");
		   alert.setContentText("Por favor, escolha um arbitro na tabela");
		   alert.show();
	   }
   }
   
   public void handleButtonRemoverArbitro() throws IOException {
	   Arbitro arbitro = TableViewArbitro.getSelectionModel().getSelectedItem();
	   if (arbitro != null) {
		   ControllerArbitro.deleteArbitro(arbitro.getId());
		   carregarTableViewArbitro();
	   } else {
		   Alert alert = new Alert(Alert.AlertType.ERROR);
		   alert.setHeaderText("Nenhum arbitro foi selecionado");
		   alert.setContentText("Por favor, escolha um arbitro na tabela");
		   alert.show();
	   }
   }
   
   public boolean showFXMLCadastrosArbitroDialog(Arbitro arbitro) throws IOException {
	   FXMLLoader loader = new FXMLLoader();
	   loader.setLocation(FXMLCadastroArbitroDialogController.class.getResource("/pbl/view/FXMLCadastroArbitroDialog.fxml"));
	   AnchorPane pagina = (AnchorPane) loader.load();
	   
	   Stage dialogStage = new Stage();
	   dialogStage.setTitle("Cadastro de Arbitro");
	   Scene scene = new Scene(pagina);
	   dialogStage.setScene(scene);
	   
	   FXMLCadastroArbitroDialogController controller = loader.getController();
	   controller.setDialogStage(dialogStage);
	   controller.setArbitro(arbitro);
	   
	   dialogStage.showAndWait();
	   
	   return controller.isButtonConfirmarClicked();
   }
}

