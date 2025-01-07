public class Worker {
  Customer currentCus = null;

  public static void nextCustomer() {
  }

  // fee calculation:
  //// if weight <= 4 and l + w + h <= 15: 5
  //// if weight <= 7 and l + w + h <= 25: 8
  //// else: 12
  // then for each day that exceeds 7 days in depot: +1

  // Type 3: Customer pay 100% of the fee
  // Type 2: Customer pay 60% of the fee
  // Type 1: Premium packet: Customer don't have to pay the fee

  public static int calculateFee(Parcel parcel) {
    if (parcel.getType() == 1) {
      return 0;
    } else {
      double fee;
      if (parcel.getWeight() <= 4 && parcel.getDimSum() <= 15) {
        fee = 5;
      } else if (parcel.getWeight() <= 7 && parcel.getDimSum() <= 25) {
        fee = 8;
      } else {
        fee = 12;
      }
      if (parcel.getDaysInDepot() > 7) {
        fee += parcel.getDaysInDepot() - 7;
      }
      if (parcel.getType() == 2) {
        fee = 0.6 * fee;
      }
      // rounds to int
      return (int) fee;
    }
  }
}
