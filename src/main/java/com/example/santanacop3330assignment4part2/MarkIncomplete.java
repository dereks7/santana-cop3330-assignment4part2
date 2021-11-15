package com.example.santanacop3330assignment4part2;

import javafx.collections.ObservableList;
import javafx.scene.control.ListView;


public class MarkIncomplete
{
    public void markIncomplete(ObservableList<CreateItem> incompleteList, ListView<CreateItem> incomplete, ObservableList<CreateItem> completedList, ListView<CreateItem> complete)
    {
        // if the user has an item selected that is complete
        // then remove it from complete and add it to incomplete
        // call setIncomplete() and add it to incomplete ListView

        CreateItem item;

        item = complete.getSelectionModel().getSelectedItem();

        completedList.remove(item);
        incompleteList.add(item);
        item.setIncomplete(true);
        incomplete.setItems(incompleteList);
    }
}
