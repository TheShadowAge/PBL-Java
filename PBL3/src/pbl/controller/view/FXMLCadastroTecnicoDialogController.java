package pbl.controller.view;

import java.util.LinkedList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pbl.model.DAO.DAO;
import pbl.model.DAO.SelecaoDAO;
import pbl.model.entities.Tecnico;
import pbl.model.entities.Selecao;

public class FXMLCadastroTecnicoDialogController {

	@FXML
    private Button BtCancelar;

    @FXML
    private Button BtConfirmar;

    @FXML
    private ChoiceBox<Selecao> CBTecnicoSelecao;

    @FXML
    private TextField TFTecnicoIdade;

    @FXML
    private TextField TFTecnicoNacionalidade;

    @FXML
    private TextField TFTecnicoNome;

    @FXML
    private TextField TFTecnicoTime;

    @FXML
    private Label labelTecnicoIdade;

    @FXML
    private Label labelTecnicoNacionalidade;

    @FXML
    private Label labelTecnicoNome;

    @FXML
    private Label labelTecnicoPosicao;

    @FXML
    private Label labelTecnicoSelecao;

    
    private List<Selecao> listSelecao;
    
    private ObservableList<Selecao> observableListSelecao;
    private final SelecaoDAO selecaoDAO = DAO.getSelecoes();
    
    
    private Stage dialogStage;
	private boolean buttonConfirmarClicked = false;
    private Tecnico tecnico = new Tecnico(null, 0, null, null, 0);
    
    @FXML
    void initialize() {
    	CarregarChoiceBoxSelecao();
    	
    }
    
    public void CarregarChoiceBoxSelecao() {
    	List<Selecao> lista = new LinkedList<Selecao>();
    	for (Selecao selecaoIterator: selecaoDAO.readAll()) {
			if (selecaoIterator.getTecnico() == -1) {
				lista.add(selecaoIterator);
			}
    	}
    	
    	listSelecao = lista;
    	if (listSelecao.size() == 0) {
    		Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Erro no cadastro do Tecnico");
			alert.setHeaderText("Não existe seleção criada ou todas seleções estão cheias");
			alert.setContentText("Remova algum tecnico de umas das seleções existentes ou crie uma nova seleção");
			alert.show();
    	}
    	
    	observableListSelecao = FXCollections.observableArrayList(listSelecao);
    	CBTecnicoSelecao.setItems(observableListSelecao);
    }
    
    public Stage getDialogStage() {
		return dialogStage;
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public boolean isButtonConfirmarClicked() {
		return buttonConfirmarClicked;
	}

	public void setButtonConfirmarClicked(boolean buttonConfirmarClicked) {
		this.buttonConfirmarClicked = buttonConfirmarClicked;
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
		this.TFTecnicoNome.setText(tecnico.getNome());
		this.TFTecnicoNacionalidade.setText(tecnico.getNacionalidade());
		this.TFTecnicoIdade.setText(String.valueOf(tecnico.getIdade()));
		if (TFTecnicoIdade.getText().equals("0")){
			TFTecnicoIdade.setText("");
		}
		this.CBTecnicoSelecao.setValue(tecnico.getSelecao());
		this.TFTecnicoTime.setText(tecnico.getTimeAnterior());
	}
	
	@FXML
	public void handleBtConfirmar() {
		
		if (validarEntradaDeDados()) {
			Selecao selecao = CBTecnicoSelecao.getSelectionModel().getSelectedItem();
			tecnico.setNome(TFTecnicoNome.getText());
			tecnico.setNacionalidade(TFTecnicoNacionalidade.getText());
			tecnico.setIdade(Integer.parseInt(TFTecnicoIdade.getText()));
			tecnico.setSelecao(selecao.getId());
			tecnico.setTimeAnterior(TFTecnicoTime.getText());
			buttonConfirmarClicked = true;
			dialogStage.close();
		}
	}
	
	@FXML
	public void handleBtCancelar() {
		dialogStage.close();
	}
	
	public boolean validarEntradaDeDados() {
		String errorMessage = "";
		
		if (TFTecnicoNome.getText() == null || TFTecnicoNome.getText().length() == 0) {
			errorMessage += "Nome Inválido!\n";
		}
		if (TFTecnicoIdade.getText() == null || TFTecnicoIdade.getText().length() == 0) {
			errorMessage += "Idade Inválida!\n";
		}
		if (TFTecnicoNacionalidade.getText() == null || TFTecnicoNacionalidade.getText().length() == 0) {
			errorMessage += "Nacionalidade Inválida!\n";
		}
		if (CBTecnicoSelecao.getValue() == null) {
			errorMessage += "Selecao Inválida!\n";
		}
		if (TFTecnicoTime.getText() == null || TFTecnicoTime.getText().length() == 0) {
			errorMessage += "Time Inválido!\n";
		}

		if (errorMessage.length() == 0) {
			return true;
		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Erro no cadastro");
			alert.setHeaderText("Campos inválidos, por favor, corrija...");
			alert.setContentText(errorMessage);
			alert.show();
			return false;
		}
	}
}

