public class Parcel {
  String parcelID;
  int daysInDepot;
  int weight;
  int width;
  int length;
  int height;
  Status status;

  public Parcel(String parcelID, int daysInDepot, int weight, int width,
                int length, int height) {
    this.parcelID = parcelID;
    this.daysInDepot = daysInDepot;
    this.weight = weight;
    this.length = length;
    this.height = height;
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

  enum Status { AVAILABLE, COLLECTED }
}
