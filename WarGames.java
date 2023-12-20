package cosc1337;

import java.util.Random;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class WarGames extends Application implements EventHandler<ActionEvent>{

	//fixed parameters
    public static final int BUTTON_SIZE = 150;
    public static final int GAME_SIZE = 600;
    public static final int MAXBUTTONS = 9;
    
    BorderPane mainGUI;                			// the final look of the game --  board in center, controls at bottom
    Scene scene;
    
    Button[] board;    					// internal 2D array for having access to buttons
    GridPane gameBoard;        			// the "GUI" for showing the buttons in grid arrangement
   
    HBox titlePane;						//Box to display Title and signify turn
    Text title;							//Box to display title and notify turn
    
    HBox buttonsPane;        		// Pane for new game and end game buttons
    Button newGame;          		// New game button
    Button quitGame;				// End Game button
  
    Boolean playerTurn;    			// keep track of whose turn it is, last button clicked, etc.
    int	turnCount;					//Game Tracker
    Random random = new Random();
    
    private void setupControls()
    {
    	// create buttons
    	newGame = new Button("New Game");
    	quitGame = new Button("Quit");
    	
    	buttonsPane = new HBox(50);
    	buttonsPane.getChildren().addAll(newGame,quitGame);
    }

    private void setupBoard()
    {
    	board = new Button[MAXBUTTONS];
    	gameBoard = new GridPane();
    	
    	for (int i=0; i < MAXBUTTONS; i++) {
    		board[i] = new Button(".");
    		board[i].setFont(new Font("arial",74));
    		board[i].setPrefSize(BUTTON_SIZE,BUTTON_SIZE);
    		board[i].setOnAction(this);
    	}
    	
    	int index = 0;
    	for (int row = 0; row < 3; row++) {
    		for (int column = 0; column < 3; column++) {
    			gameBoard.add(board[index],  column, row);
    			index++;
    		}
    	}
    	  	
    }
    
	public void handle(ActionEvent event) {
			
				for (int i=0; i < MAXBUTTONS; i++) {
					if (event.getSource() == board[i]) {
						if (playerTurn = true) {
							if (board[i].getText() == ".") {
								board[i].setText("X");
								playerTurn = false;
								turnCount++;
							}
						}
						else if (playerTurn = false) {
							if (board[i].getText() == ".") {
								board[i].setText("O");
								playerTurn = true;
								turnCount++;
						}
					}
				
				}
			}
			
			if(event.getSource() == newGame) {
				firstTurn();
				System.out.println("New Game");
			}
			
			if(event.getSource() == quitGame) {
				
			}
	}
	
	/*public void setState(int state) {
		if (state == 0) {
			this.set(" - ");
			this.value = 0;
		}
		else if (state == 1) {
			this.setText(" X ");
			this.value = 1;
		}
		else if (state == -1) {
			this.setText(" O ");
			this.value = -1;
		}
		else {
			System.out.println("setState() called with illegal state");
		}
	}*/
	
	public void firstTurn() {
		
		if (random.nextInt(2)==0) {
			playerTurn = true;
			title.setText("Player's Turn");
		}
		else {
			playerTurn = false;
			title.setText("Computer's Turn");
		}
	}
    
    private void resetBoard()
    {
    	setupGame();
    }
    
    private boolean isGameOver(int r, int c)
    {
		return false;
    	
    }
    
    private void setupGame()			
    {
    	setupBoard();
    	setupControls();

    	// the final look of the game --  board in center, controls at bottom
        mainGUI = new BorderPane();

        titlePane = new HBox();
        titlePane.setPadding(new Insets(15));
        title = new Text("TIC-TAC-TOE");
        title.setStyle("-fx-font: 48 arial;");
        titlePane.getChildren().addAll(title);
        titlePane.setAlignment(Pos.BOTTOM_CENTER);
        mainGUI.setTop(titlePane);
           
    	gameBoard.setAlignment(Pos.TOP_CENTER);   // contents in board will be centered
    	mainGUI.setCenter(gameBoard);
    	
    	buttonsPane.setAlignment(Pos.CENTER);                  // contents in HBox will always be centered
    	buttonsPane.setPadding(new Insets(19,19,19,19));
    	BorderPane.setAlignment(buttonsPane, Pos.CENTER);     // HBox will be centered in own container
    	mainGUI.setBottom(buttonsPane);
    	scene = new Scene(mainGUI, GAME_SIZE, GAME_SIZE);	//Scene	
    
    }
    
    
    
	//Method to create stage,pane, and scene
	public void start(Stage primaryStage) {	
		setupGame();
		primaryStage.setTitle("Group Project -- War Games");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		System.out.println("Launching application...");
		Application.launch(args);
		
	}


}
