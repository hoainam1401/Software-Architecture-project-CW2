
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Log {
  final static StringBuffer log = new StringBuffer();

  public static void writeToLog(String event) {
    log.append(event).append("\n");
  }

  public static StringBuffer getLog() { return log; }

  public static void printToFile(String outputFile)
      throws FileNotFoundException {
    try (PrintWriter writer = new PrintWriter(outputFile)) {
      writer.println(log.toString());
    }
  }
}
