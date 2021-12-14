package jalopy2.jalopy2;

import de.hunsicker.jalopy.Jalopy;
import de.hunsicker.jalopy.storage.Convention;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.apache.log4j.Logger;
import org.codehaus.plexus.util.FileUtils;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {

  private static final Logger LOGGER = Logger.getLogger(AppTest.class.getName());

  /**
   * Create the test case
   *
   * @param testName name of the test case
   */
  public AppTest(String testName) {
    super(testName);
  }

  /** Returns a method-ordered test suite.
   *
   * @return a method-ordered test suite
   */
  public static Test suite() {
    final TestSuite suite = new TestSuite();
    suite.addTest(new AppTest("testApp"));
    return suite;
  }

  public void testApp() {
    LOGGER.info("testApp");
    final Jalopy jalopy = new Jalopy();

    //  18:44:13,608 main [BootstrapMethodsTest] Jalopy SettingsDirectory: /home/reed/.jalopy.15
    //  18:44:13,609 main [BootstrapMethodsTest] Jalopy ProjectSettingsDirectory: /home/reed/.jalopy.15/default
    LOGGER.info("Jalopy SettingsDirectory: " + Convention.getSettingsDirectory());
    LOGGER.info("Jalopy ProjectSettingsDirectory: " + Convention.getProjectSettingsDirectory());
    final String emittedSourceCodePath = "data/generated/GeneratedTestImpl.java";
    final String formattedSourceCodePath = "src/main/java/org/texai/bl/generated/GeneratedTestImpl.java";
    final File formattedSourceCodeFile = new File(formattedSourceCodePath);
    final StringBuffer stringBuffer = new StringBuffer();
    try {
      jalopy.setInput(new File(emittedSourceCodePath));
      jalopy.setOutput(formattedSourceCodeFile);
      //jalopy.setOutput(stringBuffer);
    } catch (final FileNotFoundException ex) {
      fail(ex.getMessage());
    }
    jalopy.format();
    //LOGGER.info("Jalopy stringBuffer...\n" + stringBuffer.toString());

    try {
      final String formattedSourceCode = FileUtils.fileRead(formattedSourceCodeFile);
      final String[] formattedSouceCodeLines = formattedSourceCode.split("\n");
      final StringBuilder stringBuilder2 = new StringBuilder();
      int lineNumber = 0;
      for (final String formattedSourceCodeLine : formattedSouceCodeLines) {
        stringBuilder2
                .append(++lineNumber)
                .append('\t')
                .append(formattedSourceCodeLine)
                .append("\n");
      }
      LOGGER.info("formattedSourceCode...\n" + stringBuilder2.toString());
    } catch (IOException ex) {
      fail(ex.getMessage());
    }
  }
}
