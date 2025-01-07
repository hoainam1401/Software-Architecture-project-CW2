import java.util.ArrayList;

public class ListofParcels {
  static ArrayList<Parcel> list = new ArrayList<>();

  public void addParcel(String parcelID, int daysInDepot, int weight, int width,
      int length, int height) {
    // if ID is valid, adds into parcel list
    if (Parcel.isValidID(parcelID)) {
      list.add(
          new Parcel(parcelID, daysInDepot, weight, width, length, height));
    }
  }

  public void deleteParcel(String parcelID) {
    list.removeIf(
        (parcel) -> {
          return parcel.getParcelID().equals(parcelID);
        });
  }
}
