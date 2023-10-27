import java.io.BufferedReader;
import java.io.FileReader;

public class Map {
    private Bucket[] map;
    private final int modulo = 541;
    public Map(String file) {
        map = new Bucket[modulo];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                City fromCity = lookup(row[0]);
                City toCity = lookup(row[1]);
                Integer distanceInMinutes = Integer.valueOf(row[2]);
                fromCity.addNeighbour(toCity, distanceInMinutes);
                toCity.addNeighbour(fromCity, distanceInMinutes);
            }
        } catch (Exception e) {
            System.out.println(" file " + file + " not found or corrupt");
        }
    }
    public City lookup(String cityName) {
        Integer cityIndex = hashFunction(cityName);
        if (map[cityIndex] == null) {
            map[cityIndex] = new Bucket(new City(cityName), null);
        } else if (!map[cityIndex].cityInBucket.name.equals(cityName)) {
            map[cityIndex].next = new Bucket(new City(cityName), null);
            map[cityIndex] = map[cityIndex].next;
        }
        return map[cityIndex].cityInBucket; //used for adding map and traversing
    }
    private Integer hashFunction(String cityName) {
        return cityName.hashCode();
    }
}
