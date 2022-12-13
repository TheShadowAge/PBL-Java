package pbl.controller.view;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import pbl.model.DAO.DAO;
import pbl.model.DAO.GrupoDAO;
import pbl.model.DAO.JogadorDAO;
import pbl.model.DAO.PartidaDAO;
import pbl.model.DAO.SelecaoDAO;
import pbl.model.DAO.TecnicoDAO;
import pbl.model.entities.Jogador;
import pbl.model.entities.JogadorCartoes;
import pbl.model.entities.JogadorGols;
import pbl.model.entities.JogadorGolsCartoes;
import pbl.model.entities.Partida;
import pbl.model.entities.Selecao;
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
    private TextField TextFieldPesquisa;

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
    private TableColumn<JogadorGolsCartoes, String> tableColumnSelecaoID;

    @FXML
    private TableColumn<SelecaoGolsCartoes, String> tableColumnSelecaoNome;

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

    private List<Selecao> listSelecoes;
    private List<Partida> listPartidas;
    private List<JogadorGols> listJogadorGols;
    private List<JogadorCartoes> listJogadorCartoes;
    private List<JogadorGolsCartoes> listJogadorGolsCartoes;
    private List<SelecaoGolsCartoes> listSelecoesGolsCartoes;
    private ObservableList<Selecao> observableListSelecoes;
    private ObservableList<Jogador> observableListJogadores;
    private ObservableList<Partida> observableListPartidas;
    private ObservableList<JogadorGolsCartoes> observablelistJogadorGolsCartoes;
    private ObservableList<SelecaoGolsCartoes> observableListSelecoesGolsCartoes;
    
    private final SelecaoDAO selecaoDAO = DAO.getSelecoes();
    private final TecnicoDAO tecnicoDAO = DAO.getTecnicos();
    private final JogadorDAO jogadorDAO = DAO.getJogadores();
    private final GrupoDAO grupoDAO = DAO.getGrupos();
    private final PartidaDAO partidaDAO = DAO.getPartidas();
    
    @FXML
    void initialize() {
    	carregarTableViewSelecao();
    	TableViewPartida.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> selecionarItemTableViewSelecao(newValue));
    	TableViewSelecaoPartidas.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> selecionarTableViewSelecaoJogador(newValue));
    }

    public void carregarTableViewSelecao() {
    	tableColumnSelecaoID.setCellValueFactory(new PropertyValueFactory<>("id"));
    	tableColumnSelecaoNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	
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
    
    public void selecionarItemTableViewSelecao(Partida partida) {
    	if (partida != null) {
    		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    		labelPartidaID.setText(Integer.toString(partida.getId()));
    		labelLocalPartida.setText(partida.getLocal());
    		labelPartidaNome.setText(partida.getNome());
    		labelPartidaData.setText(formatter.format(partida.getData()));
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
    void handleButtonAlterarSelecao(ActionEvent event) {

    }

    @FXML
    void handleButtonInserirSelecao(ActionEvent event) {

    }

    @FXML
    void handleButtonLimpar(ActionEvent event) {

    }

    @FXML
    void handleButtonPesquisar(ActionEvent event) {

    }

    @FXML
    void handleButtonRemoverSelecao(ActionEvent event) {

    }

}
