public class App {
  public static void main(String[] args) throws Exception {
    Manager man = new Manager();
    man.mapParcelFromFile("Parcels.csv", "Custs.csv");
  }
}
