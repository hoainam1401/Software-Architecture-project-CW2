
import java.util.LinkedList;
import java.util.Queue;

public class QueueofCustomers {
  static Queue<Customer> queueOfCustomers = new LinkedList<>();

  public void addCustomer(String cusName, String parcelID) {
    queueOfCustomers.add(new Customer(cusName, parcelID));
  }

  public void deleteCustomer(String deleteInput) {
    int sizeBefore = queueOfCustomers.size();
    if (Parcel.isValidID(deleteInput)) {
      queueOfCustomers.removeIf(
          (customer) -> {
            return customer.getParcelID().equals(deleteInput);
          });
    } else {
      queueOfCustomers.removeIf(
          (customer) -> {
            return customer.getName().equals(deleteInput);
          });
    }
    if (queueOfCustomers.size() == sizeBefore) {
      if (Parcel.isValidID(deleteInput)) {
        Log.writeToLog("Parcel ID " + deleteInput + " not found.");
      } else {
        Log.writeToLog("Customer name or Parcel ID " + deleteInput +
            " not found.");
      }
    } else {
      if (Parcel.isValidID(deleteInput)) {
        Log.writeToLog("Successfully removed customer with parcel ID " +
            deleteInput + ".");
      } else {
        Log.writeToLog("Successfully removed all customers with name " +
            deleteInput + ".");
      }
    }
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    int count = 1;
    for (Customer customer : queueOfCustomers) {
      s.append(count)
          .append(" ")
          .append(customer.getName())
          .append(" ")
          .append(customer.getParcelID())
          .append("\n");
      count++;
    }
    return s.toString();
  }
}
