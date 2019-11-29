
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.*;
import java.util.Random;


public class GuessGame extends Application {

	private Text numberFieldLabel;
	private TextField numberField;
	private Button submitButton;
	private Text resultText;
	
	boolean isCorrect = false;
	Random randomNum = new Random();
	int result = randomNum.nextInt(100) + 1;

	public void start(Stage primaryStage) {
		GridPane gridPane = new GridPane();
		gridPane.setStyle("-fx-background-color: Pink");
		gridPane.setVgap(20);
		gridPane.setHgap(20);
		gridPane.setAlignment(Pos.CENTER);

		numberFieldLabel = new Text("Enter a number between 1 and 100 (Both Inclusive) :");
		numberFieldLabel.setFont(Font.font("Helvetica",16));
		numberFieldLabel.setTextAlignment(TextAlignment.CENTER);
		numberField = new TextField();
		numberField.setMaxWidth(75);
		TilePane numberPane = new TilePane(numberFieldLabel, numberField);
		gridPane.add(numberPane, 0, 0);

		submitButton = new Button("Submit");
		submitButton.setOnAction(this::handleCalculateButton);
		submitButton.setFont(Font.font("Helvetica",20));
		TilePane buttonPane = new TilePane(submitButton);
		gridPane.add(buttonPane, 0, 1);;
		

		resultText = new Text("");
		gridPane.add(resultText, 0, 2);

		Scene scene = new Scene(gridPane, 380, 400);
		primaryStage.setTitle("Guess game");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	private void handleCalculateButton(ActionEvent event) {
		
		System.out.println("Result is " + result);
		do {
			int userNumber = Integer.parseInt(numberField.getText());
			if (userNumber > result) {
				resultText.setFill(Color.RED);
				resultText.setText("Make lesser guess");
				numberField.clear();
			} else if (userNumber < result) {
				resultText.setFill(Color.RED);
				resultText.setText("Make greater guess");
				numberField.clear();
			} else if (userNumber == result) {
				isCorrect = true;
				resultText.setText("Guess is correct");
				resultText.setFill(Color.BLUE);
				numberField.clear();
				result = randomNum.nextInt(100) + 1;
			} 
		}	while (isCorrect == false);	
	}

	public static void main(String[] args) {
		launch(args);

	}

}
