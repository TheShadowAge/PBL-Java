module PBL3 {

	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	requires javafx.base;
		
	opens pbl.controller.entities to javafx.graphics, javafx.fxml, javafx.base;
	opens pbl.controller.view to javafx.graphics, javafx.fxml, javafx.base;
	opens pbl.model.DAO to javafx.graphics, javafx.fxml, javafx.base;
	opens pbl.model.entities to javafx.graphics, javafx.fxml, javafx.base;
	exports pbl;
		
}