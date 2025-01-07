
import java.util.ArrayList;
import java.util.HashMap;

public class ParcelMap {
  static HashMap<Parcel, String> parcelMap = new HashMap<>();
  static ArrayList<String> sortedNameList = new ArrayList<>(parcelMap.values());

  public static void addParcel(String parcelID, String cusName, int daysInDepot,
                               int weight, int width, int length, int height) {
    Parcel newParcel = new Parcel(parcelID, cusName, daysInDepot, weight, width,
                                  length, height);
    parcelMap.put(newParcel, newParcel.getCusName());
  }

  public static void deleteParcel(String parcelID) {
    parcelMap.forEach((parcel, object) -> {
      if (parcel.getParcelID().equals(parcelID)) {
        parcelMap.remove(parcel);
      }
    });
  }

  public static void sortMap() {
    // Collections.sort(sortedNameList);
    // for (String name : sortedNameList)
    // System.out.println("Parcel = " + parcelMap.
    // + ", Value = " + map.get(x));
  }
}
