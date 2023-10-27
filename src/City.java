import java.util.ArrayList;

public class City {
    String name;
    ArrayList<Connection> neighbours;
    int i = 0;
    public City(String name) {
        this.name = name;
    }
    public void addNeighbour(City next, Integer distance) {
        this.neighbours.add(new Connection(next, distance));
    }
}
