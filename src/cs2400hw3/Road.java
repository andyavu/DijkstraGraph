package cs2400hw3;

public class Road 
{
    private City startCity;
    private City destinationCity;
    private int distance;
    
    public Road(City startCity, City destinationCity, int distance)
    {
        this.startCity = startCity;
        this.destinationCity = destinationCity;
        this.distance = distance;
    }
    public void setStartCity(City startCity)
    {
        this.startCity = startCity;
    }
    public City getStartCity()
    {
        return startCity;
    }
    public void setDestinationCity(City destinationCity)
    {
        this.destinationCity = destinationCity;
    }
    public City getDestinationCity()
    {
        return destinationCity;
    }
    public void setDistance(int distance)
    {
        this.distance = distance;
    }
    public int getDistance()
    {
        return distance;
    }
}
