import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ClockMode implements WatchMode {

    private static ClockMode clockModeInstance = null;

    public static WatchMode getInstance() {
        printCurrentTime(false);
        if (clockModeInstance == null)
            clockModeInstance = new ClockMode();
        return clockModeInstance;

    }

    private static void printCurrentTime(boolean asAmPm) {
        String timeFormat = "HH:mm";
        if (asAmPm) {
            timeFormat = "h:mm a";
        }
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern(timeFormat)));
    }

    @Override
    public WatchMode buttonA() {
        return DateMode.getInstance();
    }

    @Override
    public void buttonB() {
        printCurrentTime(true);
    }

    @Override
    public void buttonC() {
        System.out.println("An alarm will be activated after 2 minutes");
        Alarm alarm = new Alarm();
        alarm.beepForAnHour();

    }

}
