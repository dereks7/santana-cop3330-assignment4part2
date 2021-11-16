package com.example.santanacop3330assignment4part2;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Derek Santana
 */

import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

public class Clear
{
    public void clearList(ObservableList<CreateItem> incomplete, ListView<CreateItem> incompleteList, ObservableList<CreateItem> complete, ListView<CreateItem> completeList)
    {
        // clear the lists and then refresh them

        incomplete.clear();
        complete.clear();
        incompleteList.refresh();
        completeList.refresh();
    }
}
