public class Bucket {
    City cityReference;
    Bucket next;
    public Bucket(City thisCity, Bucket nextReference) {
        this.cityReference = thisCity;
        this.next = nextReference;
    }
}
