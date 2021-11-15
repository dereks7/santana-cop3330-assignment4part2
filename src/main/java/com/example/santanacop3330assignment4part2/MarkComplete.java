package com.example.santanacop3330assignment4part2;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Derek Santana
 */

import javafx.scene.control.*;
import javafx.collections.ObservableList;

public class MarkComplete
{
    public void markComplete(ObservableList<CreateItem> incompleteList, ListView<CreateItem> incomplete, ObservableList<CreateItem> completedList, ListView<CreateItem> complete)
    {
        // if the user has an item selected that is not complete
        // then remove it from incomplete and add it to complete
        // call setComplete() and add it to complete ListView

        CreateItem item;

        item = incomplete.getSelectionModel().getSelectedItem();

        incompleteList.remove(item);
        completedList.add(item);
        item.setComplete(true);
        complete.setItems(completedList);
    }
}
