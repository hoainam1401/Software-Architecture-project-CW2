public class Customer {
  String name;
  String surname;
  String parcelID;

  public Customer(String name, String parcelID) {
    this.name = name;
    this.parcelID = parcelID;
    String[] nameComp = name.split(" ");
    this.surname = nameComp[nameComp.length];
  }

  public String getSurname() { return surname; }
}
