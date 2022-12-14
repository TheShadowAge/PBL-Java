package pbl.controller.view;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import pbl.model.DAO.DAO;
import pbl.model.DAO.JogadorDAO;
import pbl.model.DAO.PartidaDAO;
import pbl.model.DAO.SelecaoDAO;
import pbl.model.entities.JogadorCartoes;
import pbl.model.entities.JogadorGols;
import pbl.model.entities.JogadorGolsCartoes;
import pbl.model.entities.Partida;
import pbl.model.entities.SelecaoGolsCartoes;

public class FXMLCadastroPartidaController {

    @FXML
    private Button ButtonAlterarSelecao;

    @FXML
    private Button ButtonInserirSelecao;

    @FXML
    private Button ButtonLimparPesquisa;

    @FXML
    private Button ButtonPesquisar;

    @FXML
    private Button ButtonRemoverSelecao;

    @FXML
    private TableView<Partida> TableViewPartida;

    @FXML
    private TableView<JogadorGolsCartoes> TableViewSelecaoJogador;

    @FXML
    private TableView<SelecaoGolsCartoes> TableViewSelecaoPartidas;

    @FXML
    private DatePicker DatePickerPesquisa;

    @FXML
    private Label labelLocalPartida;

    @FXML
    private Label labelPartidaData;

    @FXML
    private Label labelPartidaHorário;

    @FXML
    private Label labelPartidaID;

    @FXML
    private Label labelPartidaNome;
    
    @FXML
    private TableColumn<Partida, String> tableColumnPartidaNome;
    
    @FXML
    private TableColumn<Partida, String> tableColumnPartidaData;

    @FXML
    private TableColumn<Partida, String> tableColumnPartidaID;

    @FXML
    private TableColumn<JogadorGolsCartoes, String> tableColumnPartidaJogadorCAmar;

    @FXML
    private TableColumn<JogadorGolsCartoes, String> tableColumnPartidaJogadorCVerm;

    @FXML
    private TableColumn<JogadorGolsCartoes, String> tableColumnPartidaJogadorGol;

    @FXML
    private TableColumn<JogadorGolsCartoes, String> tableColumnPartidaJogadorNome;

    @FXML
    private TableColumn<JogadorGolsCartoes, String> tableColumnPartidaJogadores;

    @FXML
    private TableColumn<SelecaoGolsCartoes, String> tableColumnSelecaoPartida;

    @FXML
    private TableColumn<SelecaoGolsCartoes, String> tableColumnSelecaoPartidaGol;

    @FXML
    private TableColumn<SelecaoGolsCartoes, String> tableColumnSelecaoPartidaNome;

    @FXML
    private TableColumn<SelecaoGolsCartoes, String> tablePartidaSelecaoCAmar;

    @FXML
    private TableColumn<SelecaoGolsCartoes, String> tablePartidaSelecaoCVerm;


    private List<Partida> listPartidas;
    private List<JogadorGolsCartoes> listJogadorGolsCartoes;
    private List<SelecaoGolsCartoes> listSelecoesGolsCartoes;
    private ObservableList<Partida> observableListPartidas;
    private ObservableList<JogadorGolsCartoes> observablelistJogadorGolsCartoes;
    private ObservableList<SelecaoGolsCartoes> observableListSelecoesGolsCartoes;
    
    private final SelecaoDAO selecaoDAO = DAO.getSelecoes();
    private final JogadorDAO jogadorDAO = DAO.getJogadores();
    private final PartidaDAO partidaDAO = DAO.getPartidas();
    
    @FXML
    void initialize() {
    	carregarTableViewPartida();
    	TableViewPartida.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> selecionarItemTableViewPartida(newValue));
    	TableViewSelecaoPartidas.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> selecionarTableViewSelecaoJogador(newValue));
    }

    public void carregarTableViewPartida() {
    	tableColumnPartidaID.setCellValueFactory(new PropertyValueFactory<>("id"));
    	tableColumnPartidaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	tableColumnPartidaData.setCellValueFactory(new PropertyValueFactory<>("data"));
    	
    	listPartidas = partidaDAO.readAll();
    	
    	observableListPartidas = FXCollections.observableArrayList(listPartidas);
    	TableViewPartida.setItems(observableListPartidas);
    	TableViewPartida.refresh();
    }
    
    public void carregarTableViewSelecaoPartida(Partida partida) {
    	tableColumnSelecaoPartidaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	tableColumnSelecaoPartidaGol.setCellValueFactory(new PropertyValueFactory<>("gols"));
    	tablePartidaSelecaoCVerm.setCellValueFactory(new PropertyValueFactory<>("cartVer"));
    	tablePartidaSelecaoCAmar.setCellValueFactory(new PropertyValueFactory<>("cartAma"));
    	
    	
    	List<SelecaoGolsCartoes> selista = new LinkedList<SelecaoGolsCartoes>();
    	
    	selista.add(new SelecaoGolsCartoes(partida.getTime1(), partida.getGolstime1(), partida.getCartAmaTime1(), partida.getCartVerTime1(), selecaoDAO.read(partida.getTime1()).getNome(), partida.getId()));
    	selista.add(new SelecaoGolsCartoes(partida.getTime2(), partida.getGolstime2(), partida.getCartAmaTime2(), partida.getCartVerTime2(), selecaoDAO.read(partida.getTime2()).getNome(), partida.getId()));
    	
    	
    	listSelecoesGolsCartoes = selista;
    	
    	observableListSelecoesGolsCartoes = FXCollections.observableArrayList(listSelecoesGolsCartoes);
    	TableViewSelecaoPartidas.setItems(observableListSelecoesGolsCartoes);
    	TableViewSelecaoPartidas.refresh();
    	
    }
    
    public void carregarTableViewSelecaoJogador(SelecaoGolsCartoes selecao) {
    	tableColumnPartidaJogadorNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	tableColumnPartidaJogadorGol.setCellValueFactory(new PropertyValueFactory<>("gols"));
    	tableColumnPartidaJogadorCVerm.setCellValueFactory(new PropertyValueFactory<>("cartVer"));
    	tableColumnPartidaJogadorCAmar.setCellValueFactory(new PropertyValueFactory<>("cartAma"));


    	List<JogadorGolsCartoes> jolista = new LinkedList<JogadorGolsCartoes>();
    	if (partidaDAO.read(selecao.getPartida()).getTime1() == selecao.getId()) {
    		for (JogadorGols jogadorIterator: partidaDAO.read(selecao.getPartida()).getJogsGols1()) {
    			for (JogadorCartoes jogadorCIterator: partidaDAO.read(selecao.getPartida()).getJogsCarts1()){
    				if (jogadorCIterator.getId() == jogadorIterator.getId()) {
    					jolista.add(new JogadorGolsCartoes(jogadorIterator.getId(), jogadorIterator.getGols(), jogadorCIterator.getCartAma(), jogadorCIterator.getCartVer(), jogadorDAO.read(jogadorIterator.getId()).getNome()));
    				}
    			}
    		}
    	}
    	else {
    		for (JogadorGols jogadorIterator: partidaDAO.read(selecao.getPartida()).getJogsGols2()) {
    			for (JogadorCartoes jogadorCIterator: partidaDAO.read(selecao.getPartida()).getJogsCarts2()){
    				if (jogadorCIterator.getId() == jogadorIterator.getId()) {
    					jolista.add(new JogadorGolsCartoes(jogadorIterator.getId(), jogadorIterator.getGols(), jogadorCIterator.getCartAma(), jogadorCIterator.getCartVer(), jogadorDAO.read(jogadorIterator.getId()).getNome()));
    				}
    			}
    		}
    	}

    	listJogadorGolsCartoes = jolista;

    	observablelistJogadorGolsCartoes = FXCollections.observableArrayList(listJogadorGolsCartoes);
    	TableViewSelecaoJogador.setItems(observablelistJogadorGolsCartoes);
    	TableViewSelecaoJogador.refresh();
    }
    
    public void selecionarItemTableViewPartida(Partida partida) {
    	if (partida != null) {
    		labelPartidaID.setText(Integer.toString(partida.getId()));
    		labelLocalPartida.setText(partida.getLocal());
    		labelPartidaNome.setText(partida.getNome());
    		labelPartidaData.setText(String.valueOf(partida.getData()));
    		labelPartidaHorário.setText(partida.getHorario().format(DateTimeFormatter.ofPattern("HH:mm")));
    		carregarTableViewSelecaoPartida(partida);
    	} else {
    		labelPartidaID.setText("");
    		labelLocalPartida.setText("");
    		labelPartidaNome.setText("");
    		labelPartidaData.setText("");
    		labelPartidaHorário.setText("");
    	}
    }
    
    public void selecionarTableViewSelecaoJogador(SelecaoGolsCartoes selecao) {
    	carregarTableViewSelecaoJogador(selecao);
    }
    
    @FXML
    void handleButtonAlterarSelecao() {

    }

    @FXML
    void handleButtonInserirSelecao() {

    }

    @FXML
    void handleButtonLimpar() {
 	   DatePickerPesquisa.setValue(null);
 	   carregarTableViewPartida();
    }

    @FXML
    void handleButtonPesquisar() throws IOException {
    	List<Partida> listaPesquisa = new LinkedList<Partida>();
    	for (Partida partidaIterator: partidaDAO.readAll()) {
    		if (partidaIterator.getData().equals(DatePickerPesquisa.getValue())){
    			listaPesquisa.add(partidaIterator);
 	 		   }
    	}
 		tableColumnPartidaID.setCellValueFactory(new PropertyValueFactory<>("id"));
 	 	tableColumnPartidaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
 	 	tableColumnPartidaData.setCellValueFactory(new PropertyValueFactory<>("data"));
 	 	listPartidas = listaPesquisa;
 	 	observableListPartidas = FXCollections.observableArrayList(listPartidas);
 	 	TableViewPartida.setItems(observableListPartidas);
 	 	TableViewPartida.refresh();
 	}

    @FXML
    void handleButtonRemoverSelecao() {

    }

}
