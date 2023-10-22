public class Naive {

    public static void main(String[] args) {

        Map map = new Map("trains.csv");

        String from = args[0];
        String to = args[1];

        Integer max = Integer.valueOf(args[2]);

        long t0 = System.nanoTime();
        Integer dist = shortest(map.lookup(from), map.lookup(to), max);
        long time = (System.nanoTime() - t0)/1_000_000;

        System.out.println("shortest: " + dist + " min (" + time + " ms)");
    }
    private static Integer shortest(City from, City to, Integer max) {
        if (max < 0) {
            return null;
        }
        if (from == to) {
            return 0;
        }
        Integer shortestPath = null;
        for (int i = 0; i < from.neighbours.length; i++) {
            if (from.neighbours[i] != null) {
                Connection connection = from.neighbours[i];

            }
        }
        return shortestPath;
    }
}
