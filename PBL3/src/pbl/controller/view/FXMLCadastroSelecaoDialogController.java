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
    private TextField TFSelecaoNome;

    @FXML
    private Label labelSelecaoGrupo;

    @FXML
    private Label labelSelecaoNome;

    @FXML
    private Label labelSelecaoPosicaoGrupo;
    
    private List<Grupo> listGrupos;
    
    private ObservableList<Grupo> observableListGrupos;
    
    private final GrupoDAO grupoDAO = DAO.getGrupos();
    
    private Stage dialogStage;
	private boolean buttonConfirmarClicked = false;
    private Selecao selecao = new Selecao(null, 0, 0);
    
    @FXML
    void initialize() {
    	CarregarChoiceBoxGrupo();
    }
    
    public void CarregarChoiceBoxGrupo() {
    	List<Grupo> lista = new LinkedList<Grupo>();
    	CBSelecaoGrupo.setItems(observableListGrupos);
    	for (Grupo grupoIterator: grupoDAO.readAll()) {
			if (grupoIterator.getQuantidadeSelecoes() < 4) {
				lista.add(grupoIterator);
			}
    	}
    	listGrupos = lista;
    	if (listGrupos.size() == 0) {
    		Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Erro no cadastro da Selecao");
			alert.setHeaderText("Todos grupos estão cheios");
			alert.setContentText("Remova alguma selecao de um dos grupos existentes");
			alert.show();
    	} else {
    		observableListGrupos = FXCollections.observableArrayList(listGrupos);
        	CBSelecaoGrupo.setItems(observableListGrupos);
    	}
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
		this.CBSelecaoGrupo.setValue(grupoDAO.read(selecao.getGrupo()));
	}
	
	@FXML
	public void handleBtConfirmar() {
		if (validarEntradaDeDados()) {
			Grupo grupo = CBSelecaoGrupo.getSelectionModel().getSelectedItem();
			selecao.setNome(TFSelecaoNome.getText());
			selecao.setGrupo(grupo.getId());

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

