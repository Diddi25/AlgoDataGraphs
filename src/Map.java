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
        return null; //used after adding cities and traversing
    }
}
