
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class QueueofCustomers {
  static LinkedList<Customer> queueOfCustomers = new LinkedList<>();

  public void addCustomer(String cusName, String parcelID) {
    queueOfCustomers.add(new Customer(cusName, parcelID));
  }

  public void deleteCustomer(String deleteInput) {
    int sizeBefore = queueOfCustomers.size();
    if (Parcel.isValidID(deleteInput)) {
      queueOfCustomers.removeIf(
          (customer) -> { return customer.getParcelID().equals(deleteInput); });
    } else {
      queueOfCustomers.removeIf(
          (customer) -> { return customer.getName().equals(deleteInput); });
    }
    if (queueOfCustomers.size() == sizeBefore) {
      if (Parcel.isValidID(deleteInput)) {
        Log.writeToLog("Parcel ID " + deleteInput + " not found in queue.");
      } else {
        Log.writeToLog("Customer name or Parcel ID " + deleteInput +
                       " not found in queue.");
      }
    } else {
      if (Parcel.isValidID(deleteInput)) {
        Log.writeToLog("Successfully removed customer with parcel ID " +
                       deleteInput + " from queue.");
      } else {
        Log.writeToLog("Successfully removed all customers with name " +
                       deleteInput + " from queue.");
      }
    }
  }

  public Customer nextCustomer() {
    if (!queueOfCustomers.isEmpty()) {
      return queueOfCustomers.remove();
    } else {
      return null;
    }
  }

  public void setQueue(String[] array) {
    LinkedList<Customer> temp = new LinkedList<>();
    for (String array1 : array) {
      String[] arrayComp = array1.split(" ");
      temp.add(new Customer(arrayComp[1] + " " + arrayComp[2], arrayComp[0]));
    }
    queueOfCustomers = temp;
  }

  public String[] getQueueofCustomersToArray() {
    String[] temp = new String[queueOfCustomers.size()];
    for (int i = 0; i < queueOfCustomers.size(); i++) {
      temp[i] = queueOfCustomers.get(i).toString();
    }
    return temp;
  }

  public String[] getSortedQueueArray() {
    String[] temp = getQueueofCustomersToArray();
    ArrayList<String> surnameList = new ArrayList<>();
    String[] temp3 = new String[temp.length];
    for (String temp1 : temp) {
      surnameList.add(temp1.split(" ")[2]);
    }
    System.out.println(surnameList);
    Collections.sort(surnameList);
    System.out.println(surnameList);
    for (int i = 0; i < temp.length; i++) {
      for (int j = 0; j < temp.length; j++) {
        if (!"".equals(temp[j]) &&
            temp[j].split(" ")[2].equals(surnameList.get(i))) {
          temp3[i] = temp[j];
          temp[j] = "";
          break;
        }
      }
    }
    return temp3;
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
