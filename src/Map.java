import java.io.BufferedReader;
import java.io.FileReader;

public class Map {
    private City[] cities;
    private final int modulo = 541;
    public Map(String file) {
        cities = new City[modulo];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                City first = lookup(row[0]);
                City second = lookup(row[1]);
                Integer distanceInMinutes = Integer.valueOf(row[2]);
                first.addNeighbour(second, distanceInMinutes);
                second.addNeighbour(first, distanceInMinutes);
            }
        } catch (Exception e) {
            System.out.println(" file " + file + " not found or corrupt");
        }
    }
    private Integer hashFunction(String cityName) {
        int index = 0;
        for (int i = 0; i < cityName.length(); i++) {
            index = (index*31 % modulo) + cityName.charAt(i);
        }
        return index % modulo;
    }
    public City lookup(String cityName) {
        Integer index = hashFunction(cityName);
        if (cities[index] == null) {
            cities[index] = new City(cityName);
        } else if ()
        return cities[index]; //used for adding cities and traversing
    }
}
