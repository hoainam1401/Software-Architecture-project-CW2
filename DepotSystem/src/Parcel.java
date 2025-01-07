public class Parcel {
  int daysInDepot;
  int weight;
  int width;
  int length;
  int height;

  // X000 - X500: Type 3 packet
  // X501 - X800: Type 2 packet
  // x801 - X999: Type 1 packet
  int type;

  Status status;

  public Parcel(int daysInDepot, int weight, int width, int length, int height,
                int type) {
    this.daysInDepot = daysInDepot;
    this.weight = weight;
    this.width = width;
    this.length = length;
    this.height = height;
    this.type = type;
    this.status = Status.AVAILABLE;
  }

  public int calculateFee() { return 0; }

  public void changeStatus() {
    if (status == Status.AVAILABLE) {
      status = Status.COLLECTED;
    } else {
      status = Status.AVAILABLE;
    }
  }

  @Override
  public String toString() {
    return daysInDepot + " " + weight + " " + width + " " + length + " " +
        height + " " + status;
  }

  public int getType() { return type; }

  public int getWeight() { return weight; }

  public int getDimSum() { return length + width + height; }

  public int getDaysInDepot() { return daysInDepot; }

  // valid format is: X followed by 3 digits
  public static boolean isValidID(String parcelID) {
    String numbers = "0123456789";
    return (parcelID.length() == 4 && "X".equals(parcelID.charAt(0) + "") &&
            numbers.contains(parcelID.charAt(1) + "") &&
            numbers.contains(parcelID.charAt(2) + "") &&
            numbers.contains(parcelID.charAt(3) + ""));
  }

  enum Status { AVAILABLE, COLLECTED }
}
