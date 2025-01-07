
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

    public String[] getQueueofCustomersToArray() {
        String[] temp = new String[queueOfCustomers.size()];
        for (int i = 0; i < queueOfCustomers.size(); i++) {
            temp[i] = queueOfCustomers.get(i).toString();
        }
        return temp;
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
