package application;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * 
 */

/**
 * @author MarefkeTyler, Tiernan Meyer
 *
 */
public class main extends Application{

private static Stage window;

public static Stage getStage() {
	return window;
}
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		Setup root = new Setup();
		Scene scene = new Scene(root, 900, 900);
		primaryStage.setTitle("TicTacToe");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
