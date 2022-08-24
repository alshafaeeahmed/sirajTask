import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateMode implements WatchMode {

    private static DateMode datModeInstance = null;

    public static WatchMode getInstance() {
        printCurrentDate(false);
        if (datModeInstance == null)
            datModeInstance = new DateMode();
        return datModeInstance;

    }

    private static void printCurrentDate(boolean yearOnly) {
        LocalDateTime currentTime = LocalDateTime.now();
        String dateFormat = "dd/MM";
        if (yearOnly) {
            dateFormat = "yyyy";
        }
        System.out.println(currentTime.format(DateTimeFormatter.ofPattern(dateFormat)));
    }

    @Override
    public WatchMode buttonA() {
        return StopWatchMode.getInstance();
    }

    @Override
    public void buttonB() {
        printCurrentDate(true);
    }

    @Override
    public void buttonC() {
        System.out.println(new SimpleDateFormat("EEEE").format(new Date(0)));
    }


}
