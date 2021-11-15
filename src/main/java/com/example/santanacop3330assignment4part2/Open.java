package com.example.santanacop3330assignment4part2;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Derek Santana
 */

import javafx.stage.FileChooser;
import java.io.*;
import java.util.ArrayList;

public class Open
{
    public String openList()
    {
        // loads the file chooser pop up

        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(".txt", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        fileChooser.setTitle("Open To-Do List");
        File file = fileChooser.showOpenDialog(null);

        // return the file path of the .txt selected

        return file.getAbsolutePath();
    }

    public static ArrayList<String> getIncomplete(String path) throws IOException
    {
        // gets the incomplete items in the file

        ArrayList<String> incomplete = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(path));

        // exclude the "Incomplete" text in the file from your incomplete list

        String exclude = br.readLine();

        // create a string variable to act as a reader for the lines of the .txt list file

        String reader = br.readLine();

        // loop through and read until you reach "Complete" so you only get your incomplete items

        while (!reader.equals("Complete"))
        {
            incomplete.add(reader);
            reader = br.readLine();
        }

        // return your incomplete list

        return incomplete;
    }

    public static ArrayList<String> getComplete(String path) throws IOException
    {
        // gets the complete items from file

        ArrayList<String> complete = new ArrayList<>();
        ArrayList<String> exclude = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(path));

        // create a string variable to act as a reader for the lines of the .txt list file

        String reader = br.readLine();

        // exclude all the incomplete items from the .txt file
        // we only want completed

        while(!reader.equals("Complete"))
        {
            exclude.add(reader);
            reader = br.readLine();
        }

        // exclude the "Complete" text in the file from your incomplete list

        exclude.add(reader);

        // then add all of your completed items to the completed list

        reader = br.readLine();

        while (reader != null)
        {
            complete.add(reader);
            reader = br.readLine();
        }
        br.close();

        // return you complete list

        return complete;
    }
}
