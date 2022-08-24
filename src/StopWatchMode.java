import java.util.Timer;
import java.util.TimerTask;

public class StopWatchMode implements WatchMode {
    private static StopWatchMode stopWatchModeInstance = null;
    private static StopWatch stopWatchInstance = null;

    public static WatchMode getInstance() {
        stopWatchInstance = new StopWatch();
        if (stopWatchModeInstance == null)
            stopWatchModeInstance = new StopWatchMode();
        return stopWatchModeInstance;

    }

    @Override
    public WatchMode buttonA() {
        stopWatchInstance.stop(true);
        return PrintBrandMode.getInstance();
    }

    @Override
    public void buttonB() {
        stopWatchInstance.toggle();
    }

    @Override
    public void buttonC() {
        stopWatchInstance.stop(true);
    }

}
