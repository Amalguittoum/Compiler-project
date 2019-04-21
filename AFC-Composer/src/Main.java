 import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class Main extends Application {

	public static void main (String[] args) throws Exception {

        //Parser initialization
      /*  ExampleParser parser;
        SymbolTable temp2;
        String temp;

          try {
            parser = new ExampleParser(new java.io.FileInputStream("input.txt"));
          }
          catch(java.io.FileNotFoundException e) {
            System.out.println ("ExampleParser: The file  was not found.");
            return;
          }


        try {
        SimpleNode root =parser.commence();
        // root.dump("    ");
      
          System.out.println ("ExampleParser: The input was readed sucessfully.");
        }
        catch(ParseException e){
          System.out.println ("ExampleParser: There was an error during the parse.");
          System.out.println (e.getMessage());
        }
        catch(TokenMgrError e){
          System.out.println ("ExampleParser: There was an error.");
          System.out.println (e.getMessage());
        }*/
        launch(args);
      }

	@Override
	public void start(Stage stage) throws Exception {
		try {
		Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("AFCOMPOSER");
        stage.show();
		}
		 catch(Exception e) {
		        e.printStackTrace();
		    }
		
		
	}

}
