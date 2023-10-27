public class Paths {
    private City[] path;
    private int traverseIndex;
    public Paths() {
        path = new City[54];
        traverseIndex = 0;
    }
    private Integer shortest(City fromCity, City toCity) {
        Integer shortestPath = null;
        Integer smallestDistanceCandidate;
        while (!fromCity.equals(toCity)) {
            smallestDistanceCandidate = 850;
            for (Connection candidate: fromCity.connections) {
                if (candidate.distanceInMinutes < smallestDistanceCandidate) {
                    smallestDistanceCandidate = candidate.distanceInMinutes;
                    if (testIfCityIsAlreadyInPathRoute(candidate.city)) {
                        path[traverseIndex++] = candidate.city;
                        shortestPath += candidate.distanceInMinutes;
                    } else {
                        return null;
                    }
                }
            }
        }
        return shortestPath;
    }
    private boolean testIfCityIsAlreadyInPathRoute(City testCity){
        for (City routeCity : path) {
            if (routeCity.equals(testCity)) {
                return false;
            }
        }
        return true;
    }
}
