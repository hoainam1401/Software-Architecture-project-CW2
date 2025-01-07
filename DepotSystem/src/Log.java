public class Log {
  static StringBuffer log = new StringBuffer();

  public static void writeToLog(String event) {
    log.append(event);
  }

  public static String getLog() {
    return log.toString();
  }
}
