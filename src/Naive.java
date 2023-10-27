public class Naive {

    public static void main(String[] args) {

        Map map = new Map("trains.csv");

        String fromCity = args[0];
        String toCity = args[1];

        Integer max = Integer.valueOf(args[2]);

        long t0 = System.nanoTime();
        Integer distanceInMinutes = shortest(map.lookup(fromCity), map.lookup(toCity), max, map.maxDistance);
        long time = (System.nanoTime() - t0);

        System.out.println("shortest: " + distanceInMinutes + " min (" + time + " ms)");
    }
    private static Integer shortest(City fromCity, City toCity, Integer max, Integer currentDistance) {
        if (max < 0) {
            return null;
        }
        if (fromCity == toCity) {
            return 0;
        }
        Integer shortestPath = currentDistance;
        while (!fromCity.equals(toCity)){
            for (Connection candidate: fromCity.connections) {
                if (candidate.distanceInMinutes < shortestPath) {
                    shortestPath += candidate.distanceInMinutes;
                    if (max < 0) {
                        return null;
                    }
                    max -= shortestPath;
                    shortest(candidate.city, toCity, max, shortestPath);
                }
            }
        }
        return shortestPath;
    }
}
