// Name: Eric Clifford and Ray Thibodeaux
// Class: CSC 145-2
// Problem: Midterm Project
// File Name: TextStatistics.java

import java.text.DecimalFormat;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


public class TextStatistics extends Application {
    
    String input;
    TextArea inputText;
    DecimalFormat fmt = new DecimalFormat("0.##");
    
    //-------------------------------------------------------
    // Results that will change when text is submitted
    //-------------------------------------------------------
    Text wordCount;
    Text avgLength;
    Text charCount;
    
    public void start(Stage primaryStage) {
        
        //------------------------------------------------------------------
        // Text area for user input, with set dimensions and word wrapping
        //------------------------------------------------------------------
        Text inputHeader = new Text("Type Something!");
        inputHeader.setFont(new Font(30));
        inputHeader.setUnderline(true);
        
        inputText = new TextArea();
        inputText.setWrapText(true);
        inputText.setPrefHeight(450);
        inputText.setPrefWidth(350);
        
        //---------------------------------------------------
        // Button for submitting text from input field
        //---------------------------------------------------
        Button btn = new Button();
        btn.setText("Submit");
        btn.setOnAction(this::processButtonPress);
        
        //-----------------------------------------
        // Header label for results section
        //-----------------------------------------
        Text resultLabel = new Text("Results:");
        resultLabel.setFont(new Font(30));
        resultLabel.setUnderline(true);
        
        Text charCountHead = new Text("Character count:");
        
        //-------------------------------------------------------
        // Results that will change when text is submitted
        //-------------------------------------------------------
        wordCount = new Text("Word Count: --");
        wordCount.setTextAlignment(TextAlignment.CENTER);
        avgLength = new Text("Average Length: --");
        avgLength.setTextAlignment(TextAlignment.CENTER);
        charCount = new Text("");
        
        //-----------------------------------------------------
        // VBox layout for the text area and submit button
        //-----------------------------------------------------
        VBox inputBox = new VBox();
        inputBox.setSpacing(10);
        inputBox.setPadding(new Insets(10));
        inputBox.setAlignment(Pos.TOP_CENTER);
        inputBox.getChildren().addAll(inputHeader, inputText, btn);

        //--------------------------------------------
        // VBox layout for the results area
        //--------------------------------------------
        VBox resultBox = new VBox();
        resultBox.setSpacing(10);
        resultBox.setPadding(new Insets(10));
        resultBox.setAlignment(Pos.TOP_CENTER);
        resultBox.getChildren().addAll(resultLabel, wordCount, avgLength, 
                charCountHead, charCount);
        
        //--------------------------------------------
        // HBox layout for the two VBox objects
        //--------------------------------------------
        HBox root = new HBox();
        root.setSpacing(5);
        root.getChildren().addAll(inputBox, resultBox);
        root.setStyle("-fx-background-color: #faebd7");
        
        Scene scene = new Scene(root, 600, 650);
        
        primaryStage.setTitle("Text Statistics!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    //-------------------------------------------------------------------------
    // Handles a button press by creating new UserInput object from TextArea
    // input. Uses the methods of UserInput to set the Word Count and
    // Average Length. Changes these on the GUI display.
    //-------------------------------------------------------------------------
    public void processButtonPress(ActionEvent event)
    {   
        
        UserInput input = new UserInput(inputText.getText());
        wordCount.setText("Word Count: " + input.getTotalWords());
        avgLength.setText("Average Length: " + fmt.format(input.getAverage()));
        charCount.setText(input.characterCount());
    }
    

    
    public static void main(String[] args) {
        launch(args);
    }
    
}