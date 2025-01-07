import java.util.ArrayList;

public class ListofParcels {
  static ArrayList<Parcel> list = new ArrayList<>();

  public void addParcel(String parcelID, int daysInDepot, int weight, int width,
                        int length, int height) {
    // if ID is valid, adds into parcel list
    if (isValidID(parcelID)) {
      list.add(
          new Parcel(parcelID, daysInDepot, weight, width, length, height));
    }
  }

  public void deleteParcel(String parcelID) {
    list.removeIf(
        (parcel) -> { return parcel.getParcelID().equals(parcelID); });
  }

  // valid format is: X followed by 3 digits
  public static boolean isValidID(String parcelID) {
    String numbers = "0123456789";
    return ("X".equals(parcelID.charAt(0) + "") &&
            numbers.contains(parcelID.charAt(1) + "") &&
            numbers.contains(parcelID.charAt(2) + "") &&
            numbers.contains(parcelID.charAt(3) + ""));
  }
}
