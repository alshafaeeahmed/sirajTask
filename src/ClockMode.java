import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

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
        System.out.println("An alarm activated for 2 minutes");
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                System.out.println("ALARM");
            }
        };
        timer.scheduleAtFixedRate(task, 120000, 120000);

    }

}
