package com.example.santanacop3330assignment4part2;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Derek Santana
 */

import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

public class Delete
{
    public void deleteItem(ObservableList<CreateItem> incompleteList, ListView<CreateItem> incomplete, ObservableList<CreateItem> completedList, ListView<CreateItem> completed)
    {
        // delete the selected item in either the incomplete or completed list views

        completedList.remove(completed.getSelectionModel().getSelectedItem());
        incompleteList.remove(incomplete.getSelectionModel().getSelectedItem());

        // update the ListView

        completed.refresh();
        incomplete.refresh();

        // reset the selections that were made

        completed.getSelectionModel().clearSelection();
        incomplete.getSelectionModel().clearSelection();
    }
}
