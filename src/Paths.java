public class Paths {
    City[] path;
    int sp;
    public Paths() {
        path = new City[54];
        sp = 0;
    }
    private Integer shortest(City from, City to) {
        Integer shortestPath = null;
        for (int i = 0; i < sp; i++) {
            if (path[i] == from) {
                return null;
            }
        }
        path[sp++] = from;
        path[sp--] = null;
        return shortestPath;
    }
}
