package com.example;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Derek Santana
 */

import com.example.santanacop3330assignment4part2.CreateItem;
import com.example.santanacop3330assignment4part2.Delete;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class ControllerTest
{

    @Test
    void addItemTest()
    {
        // create an observable list and add an item w/ class CreateItem
        // check to see if the description is less than 256 and above 1

        ObservableList<CreateItem> list = FXCollections.observableArrayList();
        list.add(new CreateItem("This is the description", LocalDate.now()));
        boolean asrt = true;

        if (list.get(0).getDescription().length() > 256 || list.get(0).getDescription().length() < 1)
        {
            asrt = false;
        }
        else
        {
            asrt = true;
        }

        assertTrue(asrt);
    }

    @Test
    void deleteTest()
    {
        // make a list and add a description and date
        // remove the index from the list and if it is empty
        // the test passed
        // else false

        ObservableList<CreateItem> list = FXCollections.observableArrayList();
        list.add(new CreateItem("This is the description", LocalDate.now()));
        boolean asrt = true;
        list.remove(0);
        Delete del = new Delete();

        if(list.isEmpty())
        {
            asrt = true;
        }
        else
        {
            asrt = false;
        }

        assertTrue(asrt);
    }

    @Test
    void markCompleteTest()
    {
        // make two lists incomplete and complete
        // and make boolean arbitrary value

        ObservableList<CreateItem> incomplete = FXCollections.observableArrayList();
        ObservableList<CreateItem> complete = FXCollections.observableArrayList();
        boolean asrt = false;

        // fill up incomplete with 3 items

        incomplete.add(new CreateItem("Description 1", LocalDate.now()));
        incomplete.add(new CreateItem("Description 2", LocalDate.now()));
        incomplete.add(new CreateItem("Description 3", LocalDate.now()));

        // add them to the complete list

        for (int i=0; i<incomplete.size(); i++)
        {
            complete.add(incomplete.get(i));
        }

        // if the size of complete is the same as how many items we added to complete
        // then we passed the test

        if(complete.size() == 3)
        {
            asrt = true;
        }
        else
        {
            asrt = false;
        }

        assertTrue(asrt);
    }

    @Test
    void clearTest()
    {
        // make two lists incomplete and complete
        // and make boolean arbitrary variable

        ObservableList<CreateItem> incomplete = FXCollections.observableArrayList();
        ObservableList<CreateItem> complete = FXCollections.observableArrayList();
        boolean asrt = false;

        // add items to incomplete and complete lists

        incomplete.add(new CreateItem("Incomplete Description 1", LocalDate.now()));
        incomplete.add(new CreateItem("Incomplete Description 2", LocalDate.now()));
        incomplete.add(new CreateItem("Incomplete Description 3", LocalDate.now()));

        complete.add(new CreateItem("Complete Description 1", LocalDate.now()));
        complete.add(new CreateItem("Complete Description 2", LocalDate.now()));
        complete.add(new CreateItem("Complete Description 3", LocalDate.now()));

        // clear the lists

        incomplete.clear();
        complete.clear();

        // if lists are empty then they were cleared and test passed
        // else failed and assert false

        if(incomplete.isEmpty() && complete.isEmpty())
        {
            asrt = true;
        }
        else
        {
            asrt = false;
        }

        assertTrue(asrt);
    }

    @Test
    void editTest()
    {
        // make an incomplete list and an arbitrary boolean variable
        // and fill up the list with some items

        ObservableList<CreateItem> incomplete = FXCollections.observableArrayList();
        boolean asrt = false;

        incomplete.add(new CreateItem("Incomplete Description 1", LocalDate.now()));
        incomplete.add(new CreateItem("Incomplete Description 2", LocalDate.now()));
        incomplete.add(new CreateItem("Incomplete Description 3", LocalDate.now()));

        // make a new description and date that you want to edit your item to

        String newDescription = "Edited Description";
        LocalDate newDate = LocalDate.of(2021, 12, 25);

        // remove the index you want to edit and add in the edited values to that index

        incomplete.remove(0);
        incomplete.add(0,new CreateItem(newDescription, newDate));

        // if the index 0 has the edited values then asrt is ture
        // else asrt is false

        if(Objects.equals(incomplete.get(0).getDescription(), "Edited Description")
                && Objects.equals(incomplete.get(0).getDate(), LocalDate.of(2021, 12, 25)))
        {
            asrt = true;
        }
        else
        {
            asrt = false;
        }

        assertTrue(asrt);
    }
}