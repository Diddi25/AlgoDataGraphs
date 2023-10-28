public class Paths {
    private City[] path;
    private int traverseIndex;
    private final Integer longestPathInMap;
    public Paths(Map objectToAccessMaxDistance) {
        this.path = new City[54];
        this.traverseIndex = 0;
        this.longestPathInMap = objectToAccessMaxDistance.maxDistance;
    }
    private Integer shortest(City fromCity, City toCity) {
        Integer shortestPath = null;
        Integer smallestDistanceCandidate;
        while (!fromCity.equals(toCity)) {
            smallestDistanceCandidate = longestPathInMap;
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
