
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Manager {
    static QueueofCustomers cusQueue = new QueueofCustomers();
    static Worker worker = new Worker();
    static ParcelMap parcelMap = new ParcelMap();
    static ParcelMap collectedParcelMap = new ParcelMap();

    public static void mapParcelFromFile(String parcelFile)
            throws FileNotFoundException {
        try (Scanner sc = new Scanner(new File(parcelFile))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] lineComp = line.split(",");
                String parcelID = lineComp[0];
                // read all the parcels from file
                if (Parcel.isValidID(parcelID)) {
                    int num = Integer.parseInt(parcelID.substring(1, 4));
                    int type;
                    if (num <= 500) {
                        type = 3;
                    } else if (num <= 800) {
                        type = 2;
                    } else {
                        type = 1;
                    }
                    Parcel newParcel = new Parcel(
                            Integer.parseInt(lineComp[1]), Integer.parseInt(lineComp[2]),
                            Integer.parseInt(lineComp[3]), Integer.parseInt(lineComp[4]),
                            Integer.parseInt(lineComp[5]), type);
                    System.out.println(newParcel.toString());
                    parcelMap.addParcel(parcelID, newParcel);
                }
            }
        }
    }

    public static void readCustomerFromFile(String customerFile)
            throws FileNotFoundException {
        try (Scanner sc = new Scanner(new File(customerFile))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] lineComp = line.split(",");
                addCustomer(lineComp[0], lineComp[1]);
            }
        }
    }

    public static void addParcel(String parcelID, int daysInDepot, int weight,
            int width, int length, int height) {
        int num = Integer.parseInt(parcelID.substring(1, 4));
        int type;
        if (num <= 500) {
            type = 3;
        } else if (num <= 800) {
            type = 2;
        } else {
            type = 1;
        }
        Parcel newParcel = new Parcel(daysInDepot, weight, width, length, height, type);
        parcelMap.addParcel(parcelID, newParcel);
    }

    public static void addCustomer(String cusName, String parcelID) {
        if (Parcel.isValidID(parcelID)) {
            cusQueue.addCustomer(cusName, parcelID);
            Log.writeToLog("Customer " + cusName + " added to queue successfully.");
        } else {
            Log.writeToLog("Invalid parcel ID. Failed to add customer " + cusName +
                    " to queue.");
        }
    }

    public static void deleteParcel(String parcelID) {
        parcelMap.deleteParcel(parcelID);
    }

    // this can remove one entry with am available valid code
    // or all entries of an available customer name
    public static void removeCustomer(String deleteInput) {
        cusQueue.deleteCustomer(deleteInput);
    }

    public static void nextCustomer() {
        worker.process();
    }

    public static QueueofCustomers getCusQueue() {
        return cusQueue;
    }

    public static ParcelMap getParcelMap() {
        return parcelMap;
    }

    public static ParcelMap getCollectedMap() {
        return collectedParcelMap;
    }

    public static void printParcelMap() {
        System.out.println("Print parcel map: ");
        System.out.println(parcelMap.toString());
    }

    public static void printCustomerQueue() {
        System.out.println("Customer queue: ");
        System.out.println(cusQueue.toString());
    }

    public static void printCollectedList() {
        System.out.println("Collected parcel list: ");
        System.out.println(collectedParcelMap.toString());
    }

    public static void printLog() {
        System.out.println("Log history:");
        System.out.println(Log.getLog().toString());
    }
}
