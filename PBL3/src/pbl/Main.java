package pbl;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	
	private static Stage stage;
	private static Scene menuScene;
	
	@Override
	public void start(@SuppressWarnings("exports") Stage primaryStage) throws Exception {
			stage = primaryStage;
		
			primaryStage.setTitle("SysCopa 3.0");
			
			Parent FXMLMenu = FXMLLoader.load(getClass().getResource("/pbl/view/FXMLMain.fxml"));
			menuScene = new Scene(FXMLMenu);
			primaryStage.setScene(menuScene);
			stage.setResizable(false);
			primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}