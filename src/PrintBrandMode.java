import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PrintBrandMode implements WatchMode {
    private static PrintBrandMode printBrandModeInstance = null;
    private static final String watchBrand = "The One s2!";
    private static final String fileName = "output.txt";

    public static PrintBrandMode getInstance() {
        System.out.println(watchBrand);
        if (printBrandModeInstance == null)
            printBrandModeInstance = new PrintBrandMode();
        return printBrandModeInstance;

    }

    @Override
    public WatchMode buttonA() {
        return ClockMode.getInstance();
    }

    @Override
    public void buttonB() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        writer.write(watchBrand);
        writer.close();
    }

    @Override
    public void buttonC() {
        return;
    }


}
