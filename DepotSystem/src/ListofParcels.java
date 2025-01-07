import java.util.ArrayList;

public class ListofParcels {
  static ArrayList<Parcel> list = new ArrayList<>();

  public void addParcel(String parcelID, int daysInDepot, int weight, int width,
                        int length, int height) {
    list.add(new Parcel(parcelID, daysInDepot, weight, width, length, height));
  }

  public void deleteParcel(String parcelID) {
    list.removeIf(
        (parcel) -> { return parcel.getParcelID().equals(parcelID); });
  }
}
