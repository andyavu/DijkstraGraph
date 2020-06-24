package cs2400hw3;

import java.util.*;
import java.io.*;

public class CS2400Hw3 
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner userInput = new Scanner(System.in);
        boolean runSystem = true;
        City city;
        Graph graph = new Graph();
        graph.openFile("city.dat", "road.dat");
        System.out.print("Enter 'H' for commands: ");
        while(runSystem == true)
        {
            String input = userInput.nextLine();
            switch(input.toLowerCase())
            {
                case "h":
                    try
                    {
                        System.out.println("  Q  Query the city information by entering the city code."
                                + "\n  I  Insert a road by entering two city codes and distance."
                                + "\n  R  Remove an existing road by entering two city codes."
                                + "\n  H  Display this message."
                                + "\n  E  Exit.");
                        System.out.print("Command? ");
                    }
                    catch(Exception e)
                    {
                        System.out.print("Invalid input. Enter 'H' for commands: ");
                    }
                    break;
                case "q":
                    try
                    {
                        System.out.print("City code: ");
                        input = userInput.nextLine();
                        city = graph.getCity(input);
                        if(city == null)
                        {
                            System.out.println("City with code " + input + " doesn't exist in graph.");
                        }
                        else
                        {
                            System.out.println(city.toString());
                        }
                        System.out.print("Command? ");
                    }
                    catch(Exception e)
                    {
                        System.out.print("Invalid input. Enter 'H' for commands: ");
                    }
                    break;
                case "i":
                    try
                    {
                        System.out.print("City codes and distance: ");
                        input = userInput.nextLine();
                        String string[] = input.split(" ");
                        graph.addRoad(string[0], string[1], Integer.parseInt(string[2]));
                        System.out.print("Command? ");
                    }
                    catch(Exception e)
                    {
                        System.out.print("Invalid input. Enter 'H' for commands: ");
                    }
                    break;
                case "r":
                    try
                    {
                        System.out.print("City codes: ");
                        input = userInput.nextLine();
                        String string[] = input.split(" ");
                        graph.removeRoad(string[0], string[1]);
                        System.out.print("Command?: ");
                    }
                    catch(Exception e)
                    {
                        System.out.print("Invalid input. Enter 'H' for commands: ");
                    }
                    break;
                case "e":
                    try
                    {
                        runSystem = false;
                    }
                    catch(Exception e)
                    {
                        System.out.print("Invalid input. Enter 'H' for commands: ");
                    }
                    break;
                default:
                    System.out.print("Invalid input. Enter 'H' for commands: ");
            }
        }
    }
}