public class LittleImprovement {
    private City[] path;
    private int traverseIndex;
    private Integer dynamicMaxValue;
    private final Integer longestPathInMap;
    public LittleImprovement(Map objectToAccessMaxDistance) {
        this.path = new City[54];
        this.traverseIndex = 0;
        this.longestPathInMap = objectToAccessMaxDistance.maxDistance;
        this.dynamicMaxValue = null;
    }
    private Integer shortest(City fromCity, City toCity) {
        Integer shortestPath = 0;
        Integer smallestDistanceCandidate;
        while (!fromCity.equals(toCity)) {
            smallestDistanceCandidate = longestPathInMap;
            for (Connection candidate: fromCity.connections) {
                if (candidate.city.equals(toCity)) {
                    dynamicMaxValue = candidate.distanceInMinutes + shortestPath;
                }
                if (candidate.distanceInMinutes < smallestDistanceCandidate && shortestPath < dynamicMaxValue) {
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
