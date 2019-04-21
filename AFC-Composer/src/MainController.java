

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class MainController {

    @FXML
    private Button myButton;
  
    final FileChooser fileChooser = new FileChooser();
    @FXML
    private Label myLabel;

    @FXML
    private TextField link;
    @FXML
    private TextArea result;


    @SuppressWarnings("static-access")
	@FXML
    private void on_button(ActionEvent event) throws IOException {

    	FileChooser fileChooser = new FileChooser();
     
     
    	 
    	fileChooser.getExtensionFilters().addAll(
     
    	        new ExtensionFilter("ihm Files", "*.ihm"));
    	 
    	 
     
    	//List<File> selectedFiles = fileChooser.showOpenMultipleDialog(savedStage);
    	 
    	File selectedFile = fileChooser.showOpenDialog(null);
    	 
    	if (selectedFile != null) {
    	 
    	    link.setText("File selected: " + selectedFile.getName());
    	 
    	}
    	 
    	else {
    
    	    link.setText("File selection cancelled.");
     
    	}
    	 ExampleParser parser;
         

           try {
             parser = new ExampleParser(new java.io.FileInputStream(selectedFile.getPath()));
           }
           catch(java.io.FileNotFoundException e) {
        	 result.setText("Erreur : The file  was not found.");
              
             return;
           }


         try {
         SimpleNode root =parser.commence();
        
		
		 root.dump("    ");
		 FileWriter fstream = new FileWriter("out1.gui");
	      BufferedWriter out = new BufferedWriter(fstream);
	      out.write("L'arbre syntaxique:");
	      out.newLine();
		 for (int i=0;i<root.ls.size();i++) 
			 {
			 
		      out.write(root.ls.get(i));
		      out.newLine();
			 }
       
        out.close();
         
         result.setText("Parse : The input was readed sucessfully.");
         
         }
     
        
       catch(TokenMgrError e){
             
             
          	 result.setText("lexer : There was an error "+e.getMessage());
             }
         catch(ParseException e){
         	 result.setText("Parse : There was an error during the parse. " +e.getMessage()); 
           
         }
         catch( ComposantNotFoundException e)
         {
        	 result.setText("SEMANTIC : Le composant dans la partie ACTION n'est pas déclarer dans la section COMPOSANT !"); 
         }
         catch(ActionNotDeclaredException e)
         {
        	 result.setText("SEMANTIC : Le composant utilise une action que n'a pas été déclarer dans la section EVENMENT !"); 
         }
        

    }
    @FXML
    private void on_clickb(ActionEvent event) {
    	File gui=new File("out.gui");
    	try {
			Desktop.getDesktop().open(gui);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    @FXML
    private void on_click1(ActionEvent event) {
    	File gui=new File("out1.gui");
    	try {
			Desktop.getDesktop().open(gui);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    @FXML
    private void on_click2(ActionEvent event) {
    	File gui=new File("out2.aef");
    	try {
			Desktop.getDesktop().open(gui);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
