public class Parcel {
  String parcelID;
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

  public Parcel(String parcelID, int daysInDepot, int weight, int width,
                int length, int height) {
    this.parcelID = parcelID;
    this.daysInDepot = daysInDepot;
    this.weight = weight;
    this.length = length;
    this.height = height;
    int num = Integer.parseInt(parcelID.substring(1, 4));
    if (num <= 500) {
      type = 3;
    } else if (num <= 800) {
      type = 2;
    } else {
      type = 1;
    }
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

  public String getParcelID() { return parcelID; }

  @Override
  public String toString() {
    return parcelID + " " + daysInDepot + " " + weight + " " + width + " " +
        length + " " + height + " " + status;
  }

  public int getType() { return type; }

  public int getWeight() { return weight; }

  public int getDimSum() { return length + width + height; }

  public int getDaysInDepot() { return daysInDepot; }

  enum Status { AVAILABLE, COLLECTED }
}
