
import java.util.ArrayList;
import java.util.HashMap;

public class ParcelMap {
  // maps the parcel id with customer name
  // static HashMap<String, String> map = new HashMap<>();
  // static ArrayList<String> sortedSurnameList = new ArrayList<>();
  // static HashMap<String, String> sortedMap = new LinkedHashMap<>();

  HashMap<String, Parcel> map = new HashMap<>();

  public void addParcel(String parcelID, Parcel parcel) {
    // only maps parcel id with parcel if parcel id is valid
    if (Parcel.isValidID(parcelID)) {
      map.put(parcelID, parcel);
    }
  }

  public Parcel deleteParcel(String parcelID) { return map.remove(parcelID); }

  // public void sortMap() {
  // ArrayList<String> tempSurnameList = new ArrayList<>();
  // map.forEach((parcelID, cusName) -> {
  // tempSurnameList.add(cusName.split(" ")[1]);
  // });
  // Collections.sort(tempSurnameList);
  // // remove duplicates
  // for (String surname : tempSurnameList) {
  // if (!sortedSurnameList.contains(surname)) {
  // sortedSurnameList.add(surname);
  // }
  // }

  // for (String surname : sortedSurnameList) {
  // map.forEach((parcelID, cusName) -> {
  // if (cusName.split(" ")[1].equals(surname)) {
  // sortedMap.put(parcelID, cusName);
  // }
  // });
  // }
  // }

  public boolean findParcel(String parcelID) {
    for (String id : map.keySet()) {
      if (id.equals(parcelID)) {
        return true;
      }
    }
    return false;
  }

  public HashMap<String, Parcel> getMap() { return map; }

  public String[] getParcelMapToArray() {
    String[] temp = new String[map.size()];
    ArrayList<String> temp1 = new ArrayList<>();
    map.forEach((id, parcel) -> { temp1.add(id + " " + parcel.toString()); });
    for (int i = 0; i < temp1.size(); i++) {
      temp[i] = temp1.get(i);
    }
    return temp;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    map.forEach((parcelID, parcel) -> {
      s.append(parcelID);
      s.append(" ");
      s.append(parcel.toString());
      s.append("\n");
    });
    return s.toString();
  }

  // public String getSortedToString() {
  // sortMap();
  // StringBuilder s = new StringBuilder();
  // sortedMap.forEach((parcelID, cusName) -> {
  // s.append(parcelID);
  // s.append(" ");
  // s.append(cusName);
  // s.append("\n");
  // });
  // return s.toString();
  // }
}
