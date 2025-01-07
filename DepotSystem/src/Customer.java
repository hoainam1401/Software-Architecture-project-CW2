public class Customer {
    String name;
    String parcelID;

    public Customer(String name, String parcelID) {
        this.name = name;
        this.parcelID = parcelID;
    }

    public String getParcelID() {
        return parcelID;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return parcelID + " " + name;
    }
}
