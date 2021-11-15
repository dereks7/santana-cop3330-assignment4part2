package com.example.santanacop3330assignment4part2;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Derek Santana
 */

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Display
{
    // display all the items

    public void displayAll(ListView<CreateItem> incomplete, ListView<CreateItem> complete)
    {
        // create a new window for this

        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("All");
        window.setMinWidth(250);

        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> window.close());

        Text text = new Text();
        text.setText("Top = Incompleted --- Bottom = Completed");

        VBox layout = new VBox(10);
        layout.getChildren().addAll(text,incomplete,complete,closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }

    // display completed items

    public void displayComplete(ListView<CreateItem> complete)
    {
        // create a new window for this

        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Completed");
        window.setMinWidth(250);

        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> window.close());

        Text text = new Text();
        text.setText("Completed Items");

        VBox layout = new VBox(10);
        layout.getChildren().addAll(text,complete,closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }

    // display incomplete items

    public void displayIncomplete(ListView<CreateItem> incomplete)
    {
        // create a new window for this

        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Incomplete");
        window.setMinWidth(250);

        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> window.close());

        Text text = new Text();
        text.setText("Incomplete Items");

        VBox layout = new VBox(10);
        layout.getChildren().addAll(text,incomplete,closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
}
