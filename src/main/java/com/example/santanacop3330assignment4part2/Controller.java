package com.example.santanacop3330assignment4part2;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Derek Santana
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.event.Event;

public class Controller
{
    @FXML
    private ListView<CreateItem> incompleteList;
    @FXML
    private ListView<CreateItem> completedList;
    @FXML
    private DatePicker date;
    @FXML
    private TextField description;

    public ObservableList<CreateItem> completed = FXCollections.observableArrayList();
    public ObservableList<CreateItem> incomplete = FXCollections.observableArrayList();
    public CreateItem item;

    @FXML
    public void helpScreen(Event event) // done
    {
        // helps the user navigate the program

        HelpScreen.help("Directions");
    }

    @FXML
    public void initialize() // done
    {
        // initialize variable date & description to give them a placeholder value

        date.setValue(LocalDate.now());
        description.setText("");
    }

    @FXML
    public void save(Event event) throws IOException // done
    {
        // save the file to a given path and name

        Save save = new Save();
        String path;
        path = save.saveFile();
        Save.write(path, incomplete, completed);
    }

    @FXML
    public void open(Event event) throws IOException // done
    {
        // call openList() from class Open to get the path of the file

        Open open = new Open();
        String path;
        path = open.openList();

        // clear the incomplete and complete lists so that we can open a new list

        incomplete.clear();
        completed.clear();

        // store the data opened from the path we got from openList()
        // into an ArrayList

        ArrayList<String> incomp = Open.getIncomplete(path);
        ArrayList<String> comp = Open.getComplete(path);

        // loop through the ArrayList to get the items and add it to the
        // recently cleared incomplete and complete lists
        // and then set it to the appropriate ListView

        for (int i=0; i<incomp.size(); i++)
        {
            LocalDate theDate = dateFromFile(incomp, i);
            String desc = descriptionFromFile(incomp, i);
            incomplete.add(new CreateItem(desc, theDate));
        }
        for (int i = 0; i < comp.size(); i++)
        {
            LocalDate theDate = dateFromFile(comp, i);
            String desc = descriptionFromFile(comp, i);
            completed.add(new CreateItem(desc, theDate));
        }

        incompleteList.setItems(incomplete);
        completedList.setItems(completed);
    }

    public LocalDate dateFromFile(ArrayList<String> item, int index) // done
    {
        // split the string at the instance of " : "
        // when split, it gives us date and description separate from eachother
        // we then return that date that we extracted

        String[] str = item.get(index).split(":");
        return LocalDate.parse(str[0].trim());
    }

    public String descriptionFromFile(ArrayList<String> item, int index) // done
    {
        // split the string at the instance of " : "
        // when split, it gives us date and description separate from eachother
        // we then return that description that we extracted

        String[] str = item.get(index).split(":");
        return str[1].trim();
    }

    @FXML
    public void displayAll(Event event) // done
    {
        // display all items by calling displayAll()

        Display display = new Display();
        ListView<CreateItem> incomp = incompleteList;
        ListView<CreateItem> comp = completedList;
        display.displayAll(incomp,comp);
    }

    @FXML
    public void displayComplete(Event event) // done
    {
        // display all complete items by calling displayComplete()

        Display display = new Display();
        display.displayComplete(completedList);
    }

    @FXML
    public void displayIncomplete(Event event) // done
    {
        // display all incomplete items by calling displayIncomplete()

        Display display = new Display();
        ListView<CreateItem> incomp = incompleteList;
        display.displayIncomplete(incomp);
    }

    @FXML
    public void addItem(Event event) // done
    {
        // adds an item to the list by calling addItem() from class AddItem

        AddItem itm = new AddItem();
        itm.addItem(item,description, date, incomplete,incompleteList);

        // reset values of description and date to enter a new one

        description.setText("");
        date.setValue(LocalDate.now());
    }

    @FXML
    public void markComplete(Event event) // done
    {
        // mark an item complete by calling markComplete() from class MarkComplete

        MarkComplete complete = new MarkComplete();
        complete.markComplete(incomplete, incompleteList, completed, completedList);
    }

    @FXML
    public void markIncomplete(Event event) // done
    {
        // mark an item incomplete by calling markIncomplete() from class MarkIncomplete

        MarkIncomplete incomp = new MarkIncomplete();
        incomp.markIncomplete(incomplete, incompleteList, completed, completedList);
    }

    @FXML
    public void delete(Event event) // done
    {
        // delete an item by calling deleteItem() from class Delete

        Delete delete = new Delete();
        delete.deleteItem(incomplete, incompleteList, completed, completedList);
    }

    @FXML
    public void clear(Event event) // done
    {
        // clear a list by calling clearList() from class Clear

        Clear clear = new Clear();
        clear.clearList(incomplete, incompleteList, completed, completedList);
    }

    @FXML
    public void edit(Event event) // done
    {
        // edit an item by calling edit() from class Edit

        Edit e = new Edit();

        // check if item selected is in incomplete or complete list view

        if (incompleteList.getSelectionModel().getSelectedItem() != null)
        {
            item = incompleteList.getSelectionModel().getSelectedItem();
            e.edit(item,description,date);
        }

        // user cannot edit an item that is already completed

        else if (completedList.getSelectionModel().getSelectedItem() != null)
        {
            e.cannotEdit();
        }
    }
}