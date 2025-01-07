
import java.util.HashMap;

public class ParcelMap {
  // maps the parcel id with customer name
  static HashMap<String, String> map = new HashMap<>();
  // static ArrayList<String> sortedNameList = new
  // ArrayList<>(parcelMap.values());

  public void deleteParcel(String parcelID) {
    map.forEach((currParcelID, cusName) -> {
      if (currParcelID.equals(parcelID)) {
        map.remove(currParcelID);
      }
    });
  }

  public void sortMap() {
    // Collections.sort(sortedNameList);
    // for (String name : sortedNameList)
    // System.out.println("Parcel = " + parcelMap.
    // + ", Value = " + map.get(x));
  }

  public void addMapping(String parcelID, String cusName) {
    // only maps parcel id with customer name if parcel id is valid
    if (ListofParcels.isValidID(parcelID)) {
      map.put(parcelID, cusName);
    }
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    map.forEach((parcelID, cusName) -> {
      s.append(parcelID);
      s.append(" ");
      s.append(cusName);
      s.append("\n");
    });
    return s.toString();
  }
}
