package com.example.santanacop3330assignment4part2;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Derek Santana
 */

import java.time.LocalDate;

public class CreateItem
{
    private boolean complete;
    private String description;
    private LocalDate date;

    public CreateItem(String description, LocalDate date)
    {
        // applying the value of description date and complete to set values
        // description will be description given
        // date will be date given
        // and complete will be false since it is a new item and is defaulted to incomplete

        this.description = description;
        this.date = date;
        this.complete = false;
    }

    public String getDescription()
    {
        // gets the description from input

        return description;
    }

    public void setDescription (String description)
    {
        // sets the description given to the item we are creating

        this.description = description;
    }

    public LocalDate getDate()
    {
        // gets the date from input

        return date;
    }

    public void setDate(LocalDate date)
    {
        // sets the date given to the item we are creating

        this.date = date;
    }

    public boolean getComplete()
    {
        // gets the input from user and returns false if not marked complete
        // and true if marked complete

        return complete;
    }

    public void setComplete (boolean isComplete)
    {
        // sets the item as complete

        this.complete = isComplete;
    }

    @Override
    public String toString()
    {
        // converts the item into a string to display it in the application

        return date.toString() + ":\t\t"+ description;
    }
}
