package com.example.santanacop3330assignment4part2;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Derek Santana
 */

import javafx.collections.ObservableList;
import javafx.stage.FileChooser;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Save
{
    public String saveFile()
    {
        // use a file chooser to save the .txt file of the list

        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(".txt", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        fileChooser.setTitle("Save To-Do List");
        File file = fileChooser.showSaveDialog(null);

        // return path of file saved

        return file.getAbsolutePath();
    }

    public static void write(String path, ObservableList<CreateItem> incompleteList, ObservableList<CreateItem> completedList) throws IOException
    {
        // write all the necessary text of the list into .txt file using a buffered writer

        BufferedWriter bw = new BufferedWriter(new FileWriter(path));

        bw.write("Incomplete\n");

        for (CreateItem incompleteItem: incompleteList)
        {
            bw.write(String.format("%s:\t%s\n", incompleteItem.getDate(), incompleteItem.getDescription()));
        }

        bw.write("Complete\n");

        for (CreateItem completedItem: completedList)
        {
            bw.write(String.format("%s:\t%s\n", completedItem.getDate(), completedItem.getDescription()));
        }

        bw.close();
    }
}
