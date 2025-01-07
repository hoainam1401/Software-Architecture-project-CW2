public class App {
  public static void main(String[] args) throws Exception {
    Manager.mapParcelFromFile("Parcels.csv", "Custs.csv");
    Manager.printParcelMap();
    Manager.printSortedMap();
    Manager.addCustomer("Hoai Nam Ngo", "X036");
    Manager.addCustomer("Hoai Nam Ngo", "X151");
    Manager.addCustomer("Ho Nam Ngo", "X152");
    Manager.addCustomer("Hoai Namgo", "23");
    Manager.addCustomer("Hoai N Ngo", "X150");
    Manager.addCustomer("Hoai Namgo", "X720");
    Manager.addCustomer("H Nam go", "X153");
    Manager.addCustomer("Hoi m Ngo", "X150");
    Manager.printCustomerQueue();
    Manager.nextCustomer();
    Manager.nextCustomer();
    Manager.nextCustomer();
    Manager.nextCustomer();
    Manager.nextCustomer();
    Manager.nextCustomer();
    Manager.nextCustomer();
    Manager.nextCustomer();
    Manager.printCollectedList();
    Manager.printParcelList();
    Manager.printCustomerQueue();
    Manager.printLog();
    Log.printToFile("out.txt");
    // Parcel parcel1 = new Parcel("X507", 5, 3, 9, 8, 13);
    // Parcel parcel2 = new Parcel("X857", 2, 6, 6, 3, 9);
    // Parcel parcel3 = new Parcel("X198", 9, 4, 8, 0, 1);
  }
}
