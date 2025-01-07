public class App {
  public static void main(String[] args) throws Exception {
    Manager man = new Manager();
    man.mapParcelFromFile("Parcels.csv", "Custs.csv");
    man.printParcelMap();
    man.printSortedMap();
    // Parcel parcel1 = new Parcel("X507", 5, 3, 9, 8, 13);
    // Parcel parcel2 = new Parcel("X857", 2, 6, 6, 3, 9);
    // Parcel parcel3 = new Parcel("X198", 9, 4, 8, 0, 1);
  }
}
