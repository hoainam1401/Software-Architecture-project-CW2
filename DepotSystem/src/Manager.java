
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Manager {
  static QueueofCustomers cusQueue = new QueueofCustomers();
  static ListofParcels parcelList = new ListofParcels();
  static ListofParcels collectedparcelList = new ListofParcels();
  static Worker worker = new Worker();
  static ParcelMap parcelMap = new ParcelMap();

  public void mapParcelFromFile(String parcelFile, String custFile)
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
    System.out.println(parcelMap.toString());
  }

  public void addParcel(String parcelID, int daysInDepot, int weight, int width,
                        int length, int height) {
    parcelList.addParcel(parcelID, daysInDepot, weight, width, length, height);
  }

  public void deleteParcel(String parcelID) {
    parcelList.deleteParcel(parcelID);
    parcelMap.deleteParcel(parcelID);
  }

  public void printParcelMap() {
    System.out.println("Print parcel map: ");
    System.out.println(parcelMap.toString());
  }

  public void printSortedMap() {
    System.out.println("Print sorted parcel map: ");
    System.out.println(parcelMap.getSortedMap().toString());
  }

  public void nextCustomer() { worker.nextCustomer(); }
}
