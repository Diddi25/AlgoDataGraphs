import java.util.ArrayList;

public class City {
    String name;
    ArrayList<Connection> connections;
    public City(String name) {
        this.name = name;
    }
    public void addConnection(City next, Integer distance) {
        this.connections.add(new Connection(next, distance));
    }
}
