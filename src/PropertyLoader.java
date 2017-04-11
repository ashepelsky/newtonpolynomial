import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by ashepelsky on 4/11/2017.
 */
public class PropertyLoader {

    private static Properties props = new Properties();
    private static InputStream input = null;

    public static double[] loadInitialValues(char value) {
        try {
            input = new FileInputStream("src/resources/initialValues.properties");
            props.load(input);
            String stringValues[] = props.getProperty(String.valueOf(value)).split(",");

            double values[] = new double[stringValues.length];
            for (int i = 0; i < stringValues.length; i++) {
                values[i] = Double.parseDouble(stringValues[i]);
            }

            return values;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
