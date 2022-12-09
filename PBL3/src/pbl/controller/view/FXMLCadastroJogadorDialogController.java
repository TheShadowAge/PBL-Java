package pbl.controller.view;

import java.util.Arrays;
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
import pbl.model.entities.Jogador;
import pbl.model.entities.Selecao;

public class FXMLCadastroJogadorDialogController {

    @FXML
    private Button BtCancelar;

    @FXML
    private Button BtConfirmar;

    @FXML
    private ChoiceBox<Selecao> CBJogadorSelecao;

    @FXML
    private ChoiceBox<String> CBJogadorTitular;

    @FXML
    private ChoiceBox<String> CBJogadorPosicao;
    
    @FXML
    private TextField TFJogadorIdade;

    @FXML
    private TextField TFJogadorNacionalidade;

    @FXML
    private TextField TFJogadorNome;

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
    
    private List<Selecao> listSelecoes;
    
    private ObservableList<Selecao> observableListSelecoes;
    private ObservableList<String> observableListTitular;
    private ObservableList<String> observableListPosicoes;
    
    private final SelecaoDAO selecaoDAO = DAO.getSelecoes();
    
    private Stage dialogStage;
	private boolean buttonConfirmarClicked = false;
    private Jogador jogador = new Jogador(null, 0, null, 0, null, false);
    
    @FXML
    void initialize() {
    	CarregarChoiceBoxSelecao();
    	CarregarChoiceBoxTitular();
    	CarregarChoiceBoxPosicao();
    }
    
    public void CarregarChoiceBoxSelecao() {
    	List<Selecao> lista = new LinkedList<Selecao>();
    	for (Selecao selecaoIterator: selecaoDAO.readAll()) {
			if (selecaoIterator.getJogadores().size() < 26) {
				lista.add(selecaoIterator);
			}
    	}
    	
    	listSelecoes = lista;
    	if (listSelecoes.size() == 0) {
    		Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setHeaderText("Não existe seleção criada ou todas seleções estão cheias");
			alert.setContentText("Remova algum jogador de umas das seleções existentes ou crie uma nova seleção");
			alert.show();
    	}
    	observableListSelecoes = FXCollections.observableArrayList(listSelecoes);
    	CBJogadorSelecao.setItems(observableListSelecoes);
    }
    
    public void CarregarChoiceBoxTitular() {
    	List<String> listTitular = Arrays.asList("Titular", "Reserva");
    	
    	observableListTitular = FXCollections.observableArrayList(listTitular);
    	CBJogadorTitular.setItems(observableListTitular);
    }
    
    public void CarregarChoiceBoxPosicao() {
    	List<String> posicoesJogadores = Arrays.asList("Goleiro","Lateral direito","Zagueiro central","Quarto zagueiro","Meia defensivo/Volante","Lateral esquerdo","Meia atacante/Ponta direita","Meia defensivo/Segundo volante","Centroavante/Atacante","Meia armador","Meia atacante/Ponta esquerda");

    	observableListPosicoes = FXCollections.observableArrayList(posicoesJogadores);
    	CBJogadorPosicao.setItems(observableListPosicoes);
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

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
		this.TFJogadorNome.setText(jogador.getNome());
		this.TFJogadorNacionalidade.setText(jogador.getNacionalidade());
		TFJogadorIdade.setText(String.valueOf(jogador.getIdade()));
		if (TFJogadorIdade.getText().equals("0")){
			TFJogadorIdade.setText("");
		}
		this.CBJogadorPosicao.setValue(jogador.getPosicao());
		this.CBJogadorSelecao.setValue(jogador.getSelecao());
		if (jogador.isTitular()) {
			this.CBJogadorTitular.setValue("Titular");
		} else {
			this.CBJogadorTitular.setValue("Reserva");
		}
	}
	
	@FXML
	public void handleBtConfirmar() {
		
		if (validarEntradaDeDados()) {
			Selecao selecao = CBJogadorSelecao.getSelectionModel().getSelectedItem();
			Boolean titular = false;
			String posicao = CBJogadorPosicao.getSelectionModel().getSelectedItem();
			if (CBJogadorTitular.getSelectionModel().getSelectedItem().equals("Titular")) {
				titular = true;
			} else {
				titular = false;
			}
		
			jogador.setNome(TFJogadorNome.getText());
			jogador.setSelecao(selecao.getId());
			jogador.setNacionalidade(TFJogadorNacionalidade.getText());
			jogador.setIdade(Integer.parseInt(TFJogadorIdade.getText()));
			jogador.setPosicao(posicao);
			jogador.setTitular(titular);
		
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
		
		if (TFJogadorNome.getText() == null || TFJogadorNome.getText().length() == 0) {
			errorMessage += "Nome Inválido!\n";
		}
		if (TFJogadorIdade.getText() == null || TFJogadorIdade.getText().length() == 0) {
			errorMessage += "Idade Inválida!\n";
		}
		if (TFJogadorNacionalidade.getText() == null || TFJogadorNacionalidade.getText().length() == 0) {
			errorMessage += "Nacionalidade Inválida!\n";
		}
		if (CBJogadorPosicao.getValue() == null) {
			errorMessage += "Posicao Inválida!\n";
		}
		if (CBJogadorSelecao.getValue() == null) {
			errorMessage += "Selecao Inválida!\n";
		}
		if (CBJogadorTitular.getValue() == null) {
			errorMessage += "Titular Inválida!\n";
		}
		
		if (errorMessage.length() == 0) {
			return true;
		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Erro no cadastro do Jogador");
			alert.setHeaderText("Campos inválidos, por favor, corrija...");
			alert.setContentText(errorMessage);
			alert.show();
			return false;
		}
	}
}

