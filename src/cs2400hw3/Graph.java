package cs2400hw3;

import java.util.*;
import java.io.*;

public class Graph
{
    private ArrayList<City> cities;
    HashMap<String, Road> roads;
    HashMap<String, City> cityMap;
    
    public Graph()
    {
        cities = new ArrayList<City>();
        roads = new HashMap<String, Road>();
        cityMap = new HashMap<String, City>();
    }
    public void addRoad(int ID1, int ID2, int distance)
    {
        addRoad(cities.get(ID1 - 1), cities.get(ID2 - 1), distance);
    }
    public void addRoad(String start, String destination, int distance)
    {
        Road road;
        City city1 = cityMap.get(start), city2=cityMap.get(destination);
        if(city1 == null && city2 == null)
        {
            System.out.println(start + " and " + destination + " doesn't exist.");
            return;
        }
        if(city1 == null)
        {
            System.out.println(start + " doesn't exist.");
            return;
        }
        if(city2 == null)
        {
            System.out.println(destination + " doesn't exist.");
            return;
        }
        if((road = roads.get(start + destination)) != null)
        {
            System.out.println("There is already a road with distance " + road.getDistance() + " between " + city1.getName() + " and " + city2.getName() + ".");
            return;
        }
        addRoad(city1, city2, distance);
        System.out.println("You have inserted a road from " + city1.getName() + " to " + city2.getName() + " with a distance of " + distance + ".");
    }
    public void addRoad(City city1, City city2, int distance)
    {
        Road road = new Road(city1, city2, distance);
        city1.addRoad(road);
        roads.put(city1.getCode() + city2.getCode(),road);
    }
    public void removeRoad(String start, String destination)
    {
        Road road;
        City city1 = cityMap.get(start), city2 = cityMap.get(destination);
        if(city1 == null & city2 == null)
        {
            System.out.println(start + " and " + destination + " doesn't exist.");
            return;
        }
        if(city1 == null)
        {
            System.out.println(start + " doesn't exist.");
            return;
        }
        if(city2 == null)
        {
            System.out.println(destination + " doesn't exist.");
            return;
        }
        if((road = roads.get(start + destination)) == null)
        {
            System.out.println("The road from " + city1.getName() + " to " + city2.getName() + " doesn't exist.");
            return;
        }
        city1.removeRoad(road);
        roads.remove(start + destination);
        System.out.println("You have removed the road from " + city1.getName() + " to " + city2.getName() + " with a distance of " + road.getDistance() + ".");
    }
    public City getCity(String code)
    {
        return cityMap.get(code);
    }
    public void openFile(String citiesFile,String roadsFile) throws FileNotFoundException 
    {
        File file = new File(citiesFile);
        Scanner scanner = new Scanner(file);
        City city;
        String name, string;
        while(scanner.hasNext())
        {
            city = new City(scanner.nextInt(), scanner.next(), scanner.next());
            name = city.getName();
            while(true)
            {
                string = scanner.next();
                try
                {
                    city.setPopulation(Integer.parseInt(string));
                    break;
                }
                catch(Exception e)
                {
                    name += " " + string;
                }
            }
            city.setName(name);
            city.setElevation(scanner.nextInt());
            cityMap.put(city.getCode(), city);
            cities.add(city);
        }
        scanner.close();
        file = new File(roadsFile);
        scanner = new Scanner(file);
        while(scanner.hasNext())
        {
            addRoad(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        }
        scanner.close();
    }
}