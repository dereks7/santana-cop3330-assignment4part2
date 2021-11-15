package com.example.santanacop3330assignment4part2;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Derek Santana
 */

import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddItem
{
    public void addItem(CreateItem item, TextField description, DatePicker date, ObservableList<CreateItem> incomplete,ListView<CreateItem> incompleteList)
    {
        // if there is no item, then we are creating a new one else we are updating / editing the item if
        // it has values in it ( not null )

        if (item == null)
        {
            // if the description is <= 256 and >= 1 then
            // add the item into the observable list and list view
            // else display an error message

            if(description.getText().length() <= 256 && description.getText().length() >= 1)
            {
                incomplete.add(new CreateItem(description.getText(), date.getValue()));
                incompleteList.setItems(incomplete);
            }
            else
            {
                String title = "ERROR";
                String message =
                        """
                                CANNOT ADD AN ITEM THAT IS GREATER THAN 256 IN LENGTH!
                                                      """;
                Stage window = new Stage();

                window.initModality(Modality.APPLICATION_MODAL);
                window.setTitle(title);
                window.setMinWidth(500);

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

        else
        {
            // call update() from the Edit class and overwrite data to new given data

            Edit edit = new Edit();
            edit.update(incomplete,item,description,date);
            incompleteList.setItems(incomplete);
        }
    }
}
