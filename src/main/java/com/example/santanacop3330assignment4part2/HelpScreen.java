package com.example.santanacop3330assignment4part2;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class HelpScreen
{
    public static void help(String title)
    {
        // user selected the Help menu item and selected directions

        String message =
                """
                        ------------------------------------------------------------------------
                        --- Hello! Welcome to Derek Santana's To-Do List Application ---
                        ------------------------------------------------------------------------
                        --------------------------------------
                        HOW TO ADD AN ITEM TO A LIST
                        --------------------------------------
                        1: To get started, type in the description of your list
                        2: Next, you want to choose a date from the Date Picker
                        3: Next, you want to click the "Add Item To List" button to add it to the list
                                                
                        \t\t\tNOW YOU HAVE ADDED AN ITEM TO YOUR LIST!
                                                
                        --------------------------------------
                        HOW TO EDIT AN ITEM IN A LIST
                        --------------------------------------
                        1: Click display on the menu bar at the top
                        2: Select Display All ( or whichever you want )
                        3: Click the item you want to edit and close the window
                        4: Click the "Edit" button
                        5: Type in a new description or new date depending what you want to edit
                        6: Click the "Add Item" button to update it
                                                
                        \t\t\tNOW YOU HAVE EDITED AN ITEM IN YOUR LIST!
                                                
                        --------------------------------------
                        HOW TO DELETE AN ITEM IN A LIST
                        --------------------------------------
                        1: Click display on the menu bar at the top
                        2: Select Display All ( or whichever you want )
                        3: Click the item you want to delete and close the window
                        4: Click the "Delete" button
                                     
                        \t\t\tNOW YOU HAVE DELETED AN ITEM IN YOUR LIST!
                                                
                        --------------------------------------
                        HOW TO MARK AN ITEM AS COMPLETE OR INCOMPLETE IN A LIST
                        --------------------------------------
                        1: Click display on the menu bar at the top
                        2: Select Display All ( or whichever you want )
                        3: Click the item you want to mark complete (incomplete is top) or incomplete (complete is bottom)
                         and close the window
                        4: Click the "Mark Complete" or "Mark Incomplete" button
                                     
                        \t\t\tNOW YOU HAVE MARKED AN ITEM AS COMPLETE IN YOUR LIST!
                                                
                        --------------------------------------
                        HOW TO SAVE YOUR LIST
                        --------------------------------------
                        1: Click "File" tab in the menu and select "Save List"
                        2: File Explorer will open and give your list a name and hit save
                                                
                        \t\t\tNOW YOU HAVE A LIST SAVED ON YOUR COMPUTER!         
                                                
                        --------------------------------------
                        HOW TO OPEN YOUR LIST
                        --------------------------------------
                        1: Click "File" tab in the menu and select "Open List"
                        2: Find the .txt file you wish to open that is a previously saved list and double click it
                                                
                        \t\t\t\t\tNOW YOUR LIST IS OPENED!
                                                
                        """;
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);

        Label label = new Label();
        label.setText(message);
        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label,closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
}
