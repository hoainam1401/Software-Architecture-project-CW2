
import java.util.Queue;

public class QueueofCustomers {
  static Queue<Customer> queueOfCustomers;

  public static void addCustomer(String cusName, String parcelID) {
    queueOfCustomers.add(new Customer(cusName, parcelID));
  }

  public static void deleteCustomer() {
    queueOfCustomers.remove();
  }
}
