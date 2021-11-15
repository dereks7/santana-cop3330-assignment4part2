package com.example.santanacop3330assignment4part2;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Derek Santana
 */

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.collections.ObservableList;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MarkComplete
{
    public void markComplete(ObservableList<CreateItem> incompleteList, ListView<CreateItem> incomplete, ObservableList<CreateItem> completedList, ListView<CreateItem> complete)
    {
        CreateItem item = null;

        // if the user has an item selected that is not complete
        // then remove it from incomplete and add it to complete
        // call setComplete() and add it to complete ListView

        if (incomplete.getSelectionModel().getSelectedItem() != null)
        {
            item = incomplete.getSelectionModel().getSelectedItem();

            incompleteList.remove(item);
            completedList.add(item);
            item.setComplete(true);
            complete.setItems(completedList);
        }

        else
        {
            String title = "ERROR";
            String message =
                    """
                            CANNOT MARK AN ALREADY COMPLETE ITEM AS COMPLETE!
                            \t\tIT IS ALREADY COMPLETED YOU DUMMY!
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
}
