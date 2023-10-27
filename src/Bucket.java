public class Bucket {
    City cityInBucket;
    Bucket next;
    public Bucket(City thisCity, Bucket nextBucket) {
        this.cityInBucket = thisCity;
        this.next = nextBucket;
    }
}
