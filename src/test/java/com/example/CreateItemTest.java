package com.example;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Derek Santana
 */

import com.example.santanacop3330assignment4part2.CreateItem;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class CreateItemTest
{
    @Test
    void getDateTest()
    {
        // make an item with Christmas as the date and then check to see
        // if it matches with the asserted date using getDate()

        CreateItem item = new CreateItem("no description needed", LocalDate.now());
        String date = "2021-12-25";
        item.setDate(LocalDate.of(2021, 12, 25));
        String asrt = item.getDate().toString();

        assertEquals(date, asrt);
    }

    @Test
    void setDateTest()
    {
        // create a new item and give it a date of 12/25/2021 and
        // use setDate() to set it to 2022/1/1 (new years)
        // and assert that the date was set

        CreateItem item = new CreateItem("", LocalDate.of(2021, 12, 25));
        item.setDate(LocalDate.of(2022, 1, 1));
        assertEquals("2022-01-01", item.getDate().toString());
    }

    @Test
    void getDescriptionTest()
    {
        // create a new item with a given description and
        // use setDescription to set it to new one.
        // then use getDescription() to get the new and assert that it is true

        CreateItem item = new CreateItem("Is it Christmas?", LocalDate.now());
        String description = "No it is not";
        item.setDescription(description);
        String asrt = item.getDescription();

        assertEquals(description, asrt);
    }

    @Test
    void setDescriptionTest()
    {
        // create a new item and give it a description and
        // use setDescription() to set it to something else
        // and assert that the description was set to that something else

        CreateItem item = new CreateItem("Go find out if it is Christmas yet", LocalDate.now());
        String description = "I found out it is not Christmas yet ;(";
        item.setDescription(description);

        assertEquals(description, item.getDescription());
    }

    @Test
    void isCompletedTest()
    {
        // make a new item and give it random values
        // use setComplete() to mark the item as complete
        // assert that isComplete() is true and item is marked completed

        CreateItem item = new CreateItem("Hola mi amor", LocalDate.now());
        item.setComplete(true);
        boolean asrt;
        asrt = item.getComplete();

        assertTrue(asrt);
    }

    @Test
    void setCompletedTest()
    {
        // make a new item and give it random values
        // use setComplete() to set the item as completed
        // then use isComplete() to mark it complete
        // assert that the item was marked complete

        CreateItem item = new CreateItem("", LocalDate.now());
        item.setComplete(true);
        boolean asrt = item.getComplete();

        assertTrue(asrt);
    }
}
