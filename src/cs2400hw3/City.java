package cs2400hw3;

import java.util.*;

public class City 
{
    private int ID, population, elevation;
    private String code, name;
    ArrayList<Road> roads;
    
    public City(int ID, String code, String name)
    {
        this.ID = ID;
        this.code = code;
        this.name = name;
        roads = new ArrayList<Road>();
    }
    public void setID(int ID)
    {
        this.ID = ID;
    }
    public int getID()
    {
        return ID;
    }
    public void setPopulation(int population)
    {
        this.population = population;
    }
    public int getPopulation()
    {
        return population;
    }
    public void setElevation(int elevation)
    {
        this.elevation = elevation;
    }
    public int getElevation()
    {
        return elevation;
    }
    public void setCode(String code)
    {
        this.code = code;
    }
    public String getCode()
    {
        return code;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return name;
    }
    public void addRoad(Road road)
    {
        roads.add(road);
    }
    public void removeRoad(Road road)
    {
        roads.remove(road);
    }
    public String toString()
    {
        return ID + " " + code + " " + name + " " + population + " " + elevation;
    }
}
