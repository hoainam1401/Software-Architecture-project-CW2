public class App {
  public static void main(String[] args) throws Exception {
    Manager man = new Manager();
    man.mapParcelFromFile("Parcels.csv", "Custs.csv");
    man.printParcelMap();
    man.printSortedMap();
    man.addCustomer("Hoai Nam Ngo", "X150");
    man.addCustomer("Hoai Nam Ngo", "X151");
    man.addCustomer("Ho Nam Ngo", "X152");
    man.addCustomer("Hoai Namgo", "23");
    man.addCustomer("Hoai N Ngo", "X150");
    man.addCustomer("Hoai Namgo", "X9677");
    man.addCustomer("H Nam go", "X153");
    man.addCustomer("Hoi m Ngo", "X150");
    man.printCustomerQueue();
    man.removeCustomer("Hoai Nam Ngo");
    man.printCustomerQueue();
    man.removeCustomer("X155");
    man.printCustomerQueue();
    man.removeCustomer("X150");
    man.printCustomerQueue();
    man.removeCustomer("Hoai Namgo");
    man.printCustomerQueue();
    man.printLog();
    Log.printToFile("out.txt");
    // Parcel parcel1 = new Parcel("X507", 5, 3, 9, 8, 13);
    // Parcel parcel2 = new Parcel("X857", 2, 6, 6, 3, 9);
    // Parcel parcel3 = new Parcel("X198", 9, 4, 8, 0, 1);
  }
}
