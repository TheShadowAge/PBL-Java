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
import pbl.model.DAO.GrupoDAO;
import pbl.model.entities.Grupo;
import pbl.model.entities.Selecao;

public class FXMLCadastroSelecaoDialogController {

    @FXML
    private Button BtCancelar;

    @FXML
    private Button BtConfirmar;

    @FXML
    private ChoiceBox<Grupo> CBSelecaoGrupo;

    @FXML
    private ChoiceBox<String> CBSelecaoPosicaoGrupo;

    @FXML
    private TextField TFSelecaoNome;

    @FXML
    private Label labelSelecaoGrupo;

    @FXML
    private Label labelSelecaoNome;

    @FXML
    private Label labelSelecaoPosicaoGrupo;
    
    private List<Grupo> listGrupos;
    private List<String> listPosicaoGrupo;
    
    private ObservableList<Grupo> observableListGrupos;
    private ObservableList<String> observableListPosicoesGrupo;
    
    private final GrupoDAO grupoDAO = DAO.getGrupos();
    
    private Stage dialogStage;
	private boolean buttonConfirmarClicked = false;
    private Selecao selecao = new Selecao(null, 0, 0);
    
    @FXML
    void initialize() {
    	CarregarChoiceBoxGrupo();
    	CarregarChoiceBoxPosicaoGrupo();
    }
    
    public void CarregarChoiceBoxGrupo() {
    	listGrupos = grupoDAO.readAll();
    	
    	observableListGrupos = FXCollections.observableArrayList(listGrupos);
    	CBSelecaoGrupo.setItems(observableListGrupos);
    }
    
    public void CarregarChoiceBoxPosicaoGrupo() {
    	listPosicaoGrupo = Arrays.asList("1","2","3","4");
    	
    	observableListPosicoesGrupo = FXCollections.observableArrayList(listPosicaoGrupo);
    	CBSelecaoPosicaoGrupo.setItems(observableListPosicoesGrupo);
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

	public Selecao getSelecao() {
		return selecao;
	}

	public void setSelecao(Selecao selecao) {
		this.selecao = selecao;
		this.TFSelecaoNome.setText(selecao.getNome());
		this.CBSelecaoGrupo.setValue(selecao.getGrupo());
		this.CBSelecaoPosicaoGrupo.setValue(String.valueOf(selecao.getPosicaoGrupo()));
	}
	
	@FXML
	public void handleBtConfirmar() {
		if (validarEntradaDeDados()) {
			Grupo grupo = CBSelecaoGrupo.getSelectionModel().getSelectedItem();
			String posicaoGrupo = CBSelecaoPosicaoGrupo.getSelectionModel().getSelectedItem();
			selecao.setNome(TFSelecaoNome.getText());
			selecao.setGrupo(grupo.getId());
			selecao.setPosicaoGrupo(Integer.parseInt(posicaoGrupo));

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
		
		if (TFSelecaoNome.getText() == null || TFSelecaoNome.getText().length() == 0) {
			errorMessage += "Nome Inválido!\n";
		}
		if (CBSelecaoGrupo.getValue() == null) {
			errorMessage += "Grupo Inválido!\n";
		}
		if (CBSelecaoPosicaoGrupo.getValue() == null) {
			errorMessage += "Posicao do grupo Inválido!\n";
		}
		if (errorMessage.length() == 0) {
			return true;
		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Erro no cadastro da Selecao");
			alert.setHeaderText("Campos inválidos, por favor, corrija...");
			alert.setContentText(errorMessage);
			alert.show();
			return false;
		}
	}
}

