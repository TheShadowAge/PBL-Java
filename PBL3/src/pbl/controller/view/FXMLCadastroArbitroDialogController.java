package pbl.controller.view;

import java.util.Arrays;
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
import pbl.model.entities.Arbitro;
import pbl.model.entities.Arbitro;
import pbl.model.entities.Selecao;

public class FXMLCadastroArbitroDialogController {

	 @FXML
	 private Button BtCancelar;

	 @FXML
	 private Button BtConfirmar;

	 @FXML
	 private ChoiceBox<String> CBArbitroTipo;

	 @FXML
	 private TextField TFArbitroIdade;

	 @FXML
	 private TextField TFArbitroNacionalidade;

	 @FXML
	 private TextField TFArbitroNome;

    @FXML
    private Label labelArbitroIdade;

    @FXML
    private Label labelArbitroNacionalidade;

    @FXML
    private Label labelArbitroNome;

    @FXML
    private Label labelArbitroPosicao;

    
    private List<String> listTipo;
    
    private ObservableList<String> observableListTipo;
    
    private Stage dialogStage;
	private boolean buttonConfirmarClicked = false;
    private Arbitro arbitro = new Arbitro(null, null, null, 0);
    
    @FXML
    void initialize() {
    	CarregarChoiceBoxTipo();
    	
    }
    
    public void CarregarChoiceBoxTipo() {
    	listTipo = Arrays.asList("Arbitro", "Arbitro de video", "Arbitro auxiliar");
    	
    	observableListTipo = FXCollections.observableArrayList(listTipo);
    	CBArbitroTipo.setItems(observableListTipo);
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

	public Arbitro getArbitro() {
		return arbitro;
	}

	public void setArbitro(Arbitro arbitro) {
		this.arbitro = arbitro;
		this.TFArbitroNome.setText(arbitro.getNome());
		this.TFArbitroNacionalidade.setText(arbitro.getNacionalidade());
		TFArbitroIdade.setText(String.valueOf(arbitro.getIdade()));
		if (TFArbitroIdade.getText().equals("0")){
			TFArbitroIdade.setText("");
		}
		this.CBArbitroTipo.setValue(arbitro.getTipo());
	}
	
	@FXML
	public void handleBtConfirmar() {
		
		if (validarEntradaDeDados()) {
			Selecao selecao = CBArbitroSelecao.getSelectionModel().getSelectedItem();
			Boolean titular = false;
			String posicao = CBArbitroPosicao.getSelectionModel().getSelectedItem();
			if (CBArbitroTitular.getSelectionModel().getSelectedItem().equals("Titular")) {
				titular = true;
			} else {
				titular = false;
			}
		
			arbitro.setNome(TFArbitroNome.getText());
			arbitro.setSelecao(selecao.getId());
			arbitro.setNacionalidade(TFArbitroNacionalidade.getText());
			arbitro.setIdade(Integer.parseInt(TFArbitroIdade.getText()));
			arbitro.setPosicao(posicao);
			arbitro.setTitular(titular);
		
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
		
		if (TFArbitroNome.getText() == null || TFArbitroNome.getText().length() == 0) {
			errorMessage += "Nome Inválido!\n";
		}
		if (TFArbitroIdade.getText() == null || TFArbitroIdade.getText().length() == 0) {
			errorMessage += "Idade Inválida!\n";
		}
		if (TFArbitroNacionalidade.getText() == null || TFArbitroNacionalidade.getText().length() == 0) {
			errorMessage += "Nacionalidade Inválida!\n";
		}
		if (CBArbitroPosicao.getValue() == null) {
			errorMessage += "Posicao Inválida!\n";
		}
		if (CBArbitroSelecao.getValue() == null) {
			errorMessage += "Selecao Inválida!\n";
		}
		if (CBArbitroTitular.getValue() == null) {
			errorMessage += "Titular Inválida!\n";
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

