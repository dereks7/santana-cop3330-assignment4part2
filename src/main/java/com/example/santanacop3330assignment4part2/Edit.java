package com.example.santanacop3330assignment4part2;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Derek Santana
 */

import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Edit
{
    public void edit(CreateItem item,TextField description, DatePicker date)
    {
        // set values and texts to date selected and description typed

        date.setValue(item.getDate());
        description.setText(item.getDescription());
    }

    public void update(ObservableList<CreateItem> list, CreateItem item, TextField description, DatePicker date)
    {
        // user hit edit and then changed values and hit add item to list button
        // so this is used to update the list selected for edit

        list.remove(item);
        item.setDate(date.getValue());
        item.setDescription(description.getText());
        list.add(item);
    }

    public void cannotEdit()
    {
        // user tried to edit a completed item
        // display error message

        String title = "ERROR";
        String message =
                """
                        CANNOT EDIT AN ITEM THAT IS ALREADY COMPLETE!
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
