
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Manager {
  static QueueofCustomers cusQueue = new QueueofCustomers();
  static ListofParcels parcelList = new ListofParcels();
  static ListofParcels collectedparcelList = new ListofParcels();
  static Worker worker = new Worker();
  static ParcelMap parcelMap = new ParcelMap();

  public static void mapParcelFromFile(String parcelFile, String custFile)
      throws FileNotFoundException {
    Scanner sc = new Scanner(new File(parcelFile));
    while (sc.hasNextLine()) {
      String line = sc.nextLine();
      String[] lineComp = line.split(",");
      // read all the parcels from file
      parcelList.addParcel(
          lineComp[0], Integer.parseInt(lineComp[1]),
          Integer.parseInt(lineComp[2]), Integer.parseInt(lineComp[3]),
          Integer.parseInt(lineComp[4]), Integer.parseInt(lineComp[5]));
    }
    sc.close();
    sc = new Scanner(new File(custFile));
    while (sc.hasNextLine()) {
      String line = sc.nextLine();
      String[] lineComp = line.split(",");
      // maps parcel id with customers name
      parcelMap.addMapping(lineComp[1], lineComp[0]);
    }
    sc.close();
  }

  public static void addParcel(String parcelID, int daysInDepot, int weight,
                               int width, int length, int height) {
    parcelList.addParcel(parcelID, daysInDepot, weight, width, length, height);
  }

  public static void addCustomer(String cusName, String parcelID) {
    if (Parcel.isValidID(parcelID)) {
      cusQueue.addCustomer(cusName, parcelID);
      parcelMap.addMapping(parcelID, cusName);
      Log.writeToLog("Customer " + cusName + " added to queue successfully.");
    } else {
      Log.writeToLog("Invalid parcel ID. Failed to add customer " + cusName +
                     " to queue.");
    }
  }

  public static void deleteParcel(String parcelID) {
    parcelList.deleteParcel(parcelID);
    parcelMap.deleteParcel(parcelID);
  }

  // this can remove one entry with am available valid code
  // or all entries of an available customer name
  public static void removeCustomer(String deleteInput) {
    cusQueue.deleteCustomer(deleteInput);
  }

  public static void nextCustomer() { worker.process(); }

  public static QueueofCustomers getCusQueue() { return cusQueue; }

  public static ListofParcels getParcelList() { return parcelList; }

  public static ParcelMap getParcelMap() { return parcelMap; }

  public static void printParcelMap() {
    System.out.println("Print parcel map: ");
    System.out.println(parcelMap.toString());
  }

  public static void printSortedMap() {
    System.out.println("Print sorted parcel map: ");
    System.out.println(parcelMap.getSortedToString());
  }

  public static void printCustomerQueue() {
    System.out.println("Customer queue: ");
    System.out.println(cusQueue.toString());
  }

  public static void printParcelList() {
    System.out.println("Parcel list: ");
    System.out.println(parcelList.toString());
  }

  public static void printCollectedList() {
    System.out.println("Collected parcel list: ");
    System.out.println(collectedparcelList.toString());
  }

  public static void printLog() {
    System.out.println("Log history:");
    System.out.println(Log.getLog().toString());
  }
}
