import java.io.FileNotFoundException;
import javax.swing.*;

public class App {
  public static void main(String[] args) throws Exception {
    Manager.mapParcelFromFile("Parcels.csv");
    Manager.readCustomerFromFile("Custs.csv");
    Parcel currParcel = null;
    if (Manager.worker.getCurrCustomer() != null) {
      currParcel = Manager.getParcelMap().getMap().get(
          (Manager.worker.getCurrCustomer().getParcelID()));
    }
    String[] cusArray = Manager.getCusQueue().getQueueofCustomersToArray();
    String[] parcelArray = Manager.getParcelMap().getParcelMapToArray();
    String[] collectedArray = Manager.getCollectedMap().getParcelMapToArray();
    JFrame frame = new JFrame();
    frame.setSize(1500, 1000);
    frame.setLayout(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    JLabel nameLabel = new JLabel("Name:");
    nameLabel.setBounds(50, 500, 100, 25);
    JLabel IDLabel = new JLabel("Parcel ID:");
    IDLabel.setBounds(50, 550, 100, 25);
    JButton enterQueueButton = new JButton("Enter queue");
    enterQueueButton.setBounds(50, 600, 125, 50);
    JButton deleteQueueButton = new JButton("Delete from queue");
    deleteQueueButton.setBounds(200, 600, 150, 50);
    JTextField nameField = new JTextField();
    nameField.setBounds(125, 500, 200, 25);
    JTextField parcelIDField = new JTextField();
    parcelIDField.setBounds(125, 550, 200, 25);
    JLabel queueLabel = new JLabel("Customer queue:");
    queueLabel.setBounds(50, 75, 100, 25);
    JList<String> queueList = new JList<>(cusArray);
    queueList.setBounds(50, 100, 300, 300);
    JList<String> parcelList = new JList<>(parcelArray);
    parcelList.setBounds(800, 100, 300, 300);
    JLabel parcelLabel = new JLabel("Available parcel list:");
    parcelLabel.setBounds(800, 75, 200, 25);
    JList<String> collectedList = new JList<>(collectedArray);
    collectedList.setBounds(800, 500, 300, 300);
    JLabel collectedLabel = new JLabel("Collected parcel list:");
    collectedLabel.setBounds(800, 475, 200, 25);
    JButton nextButton = new JButton("Next customer");
    nextButton.setBounds(450, 450, 125, 50);
    JButton payButton = new JButton("Pay fee");
    payButton.setEnabled(false);
    payButton.setBounds(625, 450, 125, 50);
    JLabel currParcelLabel = new JLabel("Current parcel:");
    currParcelLabel.setBounds(450, 75, 100, 25);
    JTextArea currParcelText = new JTextArea("");
    currParcelText.setBounds(450, 100, 300, 300);
    currParcelText.setEditable(false);
    currParcelText.setText(Manager.worker.parcelToField(currParcel));
    JButton printLogButton = new JButton("Log to File");
    printLogButton.setBounds(500, 600, 150, 50);

    JLabel currCusLabel =
        new JLabel("Current customer: " + Manager.worker.getCurrCusName());
    currCusLabel.setBounds(500, 50, 500, 25);
    JButton sortButton = new JButton("Sort");
    sortButton.setBounds(200, 75, 100, 20);
    JLabel label1 = new JLabel("ID");
    JLabel label2 = new JLabel("Weight");
    JLabel label3 = new JLabel("Width");
    JLabel label4 = new JLabel("Length");
    JLabel label5 = new JLabel("Height");
    JTextField text1 = new JTextField();
    JTextField text2 = new JTextField();
    JTextField text3 = new JTextField();
    JTextField text4 = new JTextField();
    JTextField text5 = new JTextField();
    label1.setBounds(50, 700, 50, 25);
    label2.setBounds(200, 700, 50, 25);
    label3.setBounds(350, 700, 50, 25);
    label4.setBounds(500, 700, 50, 25);
    label5.setBounds(650, 700, 50, 25);
    text1.setBounds(100, 700, 80, 25);
    text2.setBounds(250, 700, 80, 25);
    text3.setBounds(400, 700, 80, 25);
    text4.setBounds(550, 700, 80, 25);
    text5.setBounds(700, 700, 80, 25);
    JButton addParcelButton = new JButton("Add parcel");
    addParcelButton.setBounds(400, 750, 100, 50);
    frame.add(nameLabel);
    frame.add(IDLabel);
    frame.add(nameField);
    frame.add(parcelIDField);
    frame.add(deleteQueueButton);
    frame.add(enterQueueButton);
    frame.add(queueList);
    frame.add(parcelList);
    frame.add(collectedList);
    frame.add(currCusLabel);
    frame.add(queueLabel);
    frame.add(parcelLabel);
    frame.add(collectedLabel);
    frame.add(payButton);
    frame.add(currParcelLabel);
    frame.add(currParcelText);
    frame.add(nextButton);
    frame.add(printLogButton);
    frame.add(sortButton);
    frame.add(label1);
    frame.add(label2);
    frame.add(label3);
    frame.add(label4);
    frame.add(label5);
    frame.add(text1);
    frame.add(text2);
    frame.add(text3);
    frame.add(text4);
    frame.add(text5);
    frame.add(addParcelButton);
    JScrollPane queueScrollPane = new JScrollPane(queueList);
    queueScrollPane.setBounds(50, 100, 300, 300);
    JScrollPane parcelScrollPane = new JScrollPane(parcelList);
    parcelScrollPane.setBounds(800, 100, 300, 300);
    JScrollPane collectedScrollPane = new JScrollPane(collectedList);
    collectedScrollPane.setBounds(800, 500, 300, 300);
    frame.add(queueScrollPane);
    frame.add(parcelScrollPane);
    frame.add(collectedScrollPane);

    nextButton.addActionListener((actionEvent) -> {
      Manager.nextCustomer();
      final String[] tempArray =
          Manager.getCusQueue().getQueueofCustomersToArray();
      queueList.setListData(tempArray);
      final Parcel tempParcel = Manager.getParcelMap().getMap().get(
          (Manager.worker.getCurrCustomer().getParcelID()));
      currCusLabel.setText("Current customer: " +
                           Manager.worker.getCurrCusName());
      currParcelText.setText(Manager.worker.parcelToField(tempParcel));
      if (!"".equals(currParcelText.getText())) {
        nextButton.setEnabled(false);
        payButton.setEnabled(true);
      }
    });

    payButton.addActionListener((actionEvent) -> {
      Manager.worker.paid();
      String[] tempParcelArray = Manager.getParcelMap().getParcelMapToArray();
      String[] tempCollectedArray =
          Manager.getCollectedMap().getParcelMapToArray();
      String[] tempCusArray =
          Manager.getCusQueue().getQueueofCustomersToArray();
      parcelList.setListData(tempParcelArray);
      collectedList.setListData(tempCollectedArray);
      currCusLabel.setText("Current customer: ");
      currParcelText.setText("");
      payButton.setEnabled(false);
      if (tempCusArray.length > 0) {
        nextButton.setEnabled(true);
      }
    });

    printLogButton.addActionListener((actionEvent) -> {
      try {
        Log.printToFile("out.txt");
      } catch (FileNotFoundException ex) {
      }
    });

    enterQueueButton.addActionListener((actionEvent) -> {
      Manager.addCustomer(nameField.getText(), parcelIDField.getText());
      nameField.setText("");
      parcelIDField.setText("");
      String[] tempCusArray =
          Manager.getCusQueue().getQueueofCustomersToArray();
      if (tempCusArray.length > 0) {
        nextButton.setEnabled(true);
      }
      queueList.setListData(tempCusArray);
    });

    deleteQueueButton.addActionListener((actionEvent) -> {
      Manager.removeCustomer(nameField.getText());
      Manager.removeCustomer(parcelIDField.getText());
      nameField.setText("");
      parcelIDField.setText("");
      String[] tempCusArray =
          Manager.getCusQueue().getQueueofCustomersToArray();
      if (tempCusArray.length == 0) {
        nextButton.setEnabled(false);
      }
      queueList.setListData(tempCusArray);
    });

    sortButton.addActionListener((actionEvent) -> {
      String[] tempQueueArray = Manager.cusQueue.getSortedQueueArray();
      queueList.setListData(tempQueueArray);
      Manager.cusQueue.setQueue(tempQueueArray);
      Log.writeToLog("Customer queue sorted.");
    });

    addParcelButton.addActionListener((actionEvent) -> {
      Manager.addParcel(text1.getText(), 0, Integer.parseInt(text2.getText()),
                        Integer.parseInt(text3.getText()),
                        Integer.parseInt(text4.getText()),
                        Integer.parseInt(text5.getText()));
      text1.setText("");
      text2.setText("");
      text3.setText("");
      text4.setText("");
      text5.setText("");
      String[] tempParcelArray = Manager.getParcelMap().getParcelMapToArray();
      parcelList.setListData(tempParcelArray);
    });
  }
}
