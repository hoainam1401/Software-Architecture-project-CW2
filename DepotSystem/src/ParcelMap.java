
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class ParcelMap {
  // maps the parcel id with customer name
  static HashMap<String, String> map = new HashMap<>();
  static ArrayList<String> sortedSurnameList = new ArrayList<>();
  static HashMap<String, String> sortedMap = new LinkedHashMap<>();

  public void deleteParcel(String parcelID) {
    map.forEach((currParcelID, cusName) -> {
      if (currParcelID.equals(parcelID)) {
        map.remove(currParcelID);
      }
    });
  }

  public void sortMap() {
    ArrayList<String> tempSurnameList = new ArrayList<>();
    map.forEach(
        (parcelID, cusName) -> { tempSurnameList.add(cusName.split(" ")[1]); });
    Collections.sort(tempSurnameList);
    // remove duplicates
    for (String surname : tempSurnameList) {
      if (!sortedSurnameList.contains(surname)) {
        sortedSurnameList.add(surname);
      }
    }

    for (String surname : sortedSurnameList) {
      map.forEach((parcelID, cusName) -> {
        if (cusName.split(" ")[1].equals(surname)) {
          sortedMap.put(parcelID, cusName);
        }
      });
    }
  }

  public void addMapping(String parcelID, String cusName) {
    // only maps parcel id with customer name if parcel id is valid
    if (ListofParcels.isValidID(parcelID)) {
      map.put(parcelID, cusName);
    }
  }

  public HashMap<String, String> getSortedMap() {
    sortMap();
    return sortedMap;
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
