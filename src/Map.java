import java.io.BufferedReader;
import java.io.FileReader;

public class Map {
    private Bucket[] cities;
    private final int modulo = 541;
    public Map(String file) {
        cities = new Bucket[modulo];
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
            cities[index] = new Bucket(new City(cityName), null);
        } else if (!cities[index].cityReference.name.equals(cityName)) {
            cities[index].next = new Bucket(new City(cityName), null);
            cities[index] = cities[index].next;
        }
        return cities[index].cityReference; //used for adding cities and traversing
    }
}
