import java.util.ArrayList;

public class ListofParcels {
  ArrayList<Parcel> list = new ArrayList<>();

  public void addParcel(Parcel parcel) { list.add(parcel); }

  public void addParcel(String parcelID, int daysInDepot, int weight, int width,
                        int length, int height) {
    // if ID is valid, adds into parcel list
    if (Parcel.isValidID(parcelID)) {
      list.add(
          new Parcel(parcelID, daysInDepot, weight, width, length, height));
    }
  }

  public Parcel deleteParcel(String parcelID) {
    int count = 0;
    for (Parcel parcel : list) {
      if (parcel.getParcelID().equals(parcelID)) {
        count++;
        list.remove(parcel);
        return parcel;
      }
    }
    if (count == 0) {
      Log.writeToLog("Parcel ID " + parcelID + " not found in parcel list.");
    } else {
      Log.writeToLog("Removed parcel " + parcelID +
                     "from list of parcels successfully.");
    }
    return null;
  }

  public boolean findParcel(String parcelID) {
    for (Parcel parcel : list) {
      if (parcel.getParcelID().equals(parcelID)) {
        return true;
      }
    }
    return false;
  }

  public ArrayList<Parcel> getParcelList() { return list; }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    for (Parcel parcel : list) {
      s.append(parcel.toString()).append("\n");
    }
    return s.toString();
  }
}
