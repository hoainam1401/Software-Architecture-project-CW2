import javax.swing.*;

public class App {
  public static void main(String[] args) throws Exception {
    Manager.mapParcelFromFile("Parcels.csv", "Custs.csv");
    // Manager.addCustomer("Hoai Nam Ngo", "X036");
    // Manager.addCustomer("Hoai Nam Ngo", "X151");
    // Manager.addCustomer("Ho Nam Ngo", "X152");
    // Manager.addCustomer("Hoai Namgo", "23");
    // Manager.addCustomer("Hoai N Ngo", "X150");
    // Manager.addCustomer("Hoai Namgo", "X720");
    // Manager.addCustomer("H Nam go", "X153");
    // Manager.addCustomer("Hoi m Ngo", "X150");
    String[] cusArray = Manager.getCusQueue().getQueueofCustomersToArray();
    // System.out.println(Arrays.toString(cusArray));
    JFrame frame = new JFrame();
    frame.setSize(1500, 800);
    frame.setLayout(null);
    frame.setVisible(true);
    JLabel nameLabel = new JLabel("Name:");
    nameLabel.setBounds(50, 500, 100, 25);
    JLabel IDLabel = new JLabel("Parcel ID:");
    IDLabel.setBounds(50, 550, 100, 25);
    JButton enterQueueButton = new JButton("Enter queue");
    enterQueueButton.setBounds(100, 600, 150, 50);
    JTextField nameField = new JTextField();
    nameField.setBounds(125, 500, 200, 25);
    JTextField parcelIDField = new JTextField();
    parcelIDField.setBounds(125, 550, 200, 25);
    JList<String> queueList = new JList<>(cusArray);
    // queueList.setBounds(50, 100, 300, 300);
    frame.add(nameLabel);
    frame.add(IDLabel);
    frame.add(nameField);
    frame.add(parcelIDField);
    frame.add(enterQueueButton);
    // frame.add(queueList);
    // Manager.printParcelMap();
    // Manager.printSortedMap();
    // Manager.printCustomerQueue();
    // Manager.nextCustomer();
    // Manager.nextCustomer();
    // Manager.nextCustomer();
    // Manager.nextCustomer();
    // Manager.nextCustomer();
    // Manager.nextCustomer();
    // Manager.nextCustomer();
    // Manager.nextCustomer();
    // Manager.printCollectedList();
    // Manager.printParcelList();
    // Manager.printCustomerQueue();
    // Manager.printLog();
    // Log.printToFile("out.txt");
    // // Parcel parcel1 = new Parcel("X507", 5, 3, 9, 8, 13);
    // // Parcel parcel2 = new Parcel("X857", 2, 6, 6, 3, 9);
    // // Parcel parcel3 = new Parcel("X198", 9, 4, 8, 0, 1);
  }
}
