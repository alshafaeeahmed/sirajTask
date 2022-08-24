import static java.util.concurrent.TimeUnit.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

class Alarm {
private final ScheduledExecutorService scheduler = 
   Executors.newScheduledThreadPool(1);

public void beepForAnHour() {
    final Runnable beeper = new Runnable() {
            public void run() { System.out.println("beep"); }
        };
    final ScheduledFuture<?> beeperHandle = 
        scheduler.scheduleAtFixedRate(beeper, 2, 2, MINUTES);
    scheduler.schedule(new Runnable() {
            public void run() { beeperHandle.cancel(true); }
        }, 60 * 60, SECONDS);
   }
}