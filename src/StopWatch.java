import java.util.Timer;
import java.util.TimerTask;

public class StopWatch {

    private static int secondsPassed;
    private static Timer timer;
    private static TimerTask task;
    private static boolean isRunning;

    public StopWatch() {
        secondsPassed = 0;
        isRunning = false;
        printTime();
    }

    public void start() {
        isRunning = true;
        timer = new Timer();
        task = new TimerTask() {
            public void run() {
                secondsPassed++;
                printTime();
            }
        };
        timer.scheduleAtFixedRate(task, 0, 1000);
    }

    public void stop(boolean reset) {
        if (reset) {
            secondsPassed = 0;
        }
        isRunning = false;
        if (timer != null ){
            timer.cancel();
            timer.purge();
        }
        if (task != null ) {
            task.cancel();
        }
        printTime();
    }

    public void toggle() {
        if (isRunning){
            stop(false);
        }else {
            start();
        }
    }

    public void printTime() {
        int hr = secondsPassed / 3600;
        int rem = secondsPassed % 3600;
        int mn = rem / 60;
        int sec = rem % 60;
        String hrStr = (hr < 10 ? "0" : "") + hr;
        String mnStr = (mn < 10 ? "0" : "") + mn;
        String secStr = (sec < 10 ? "0" : "") + sec;
        System.out.println("StopWatch - > " + hrStr + ':' + mnStr + ':' + secStr);
    }
}
