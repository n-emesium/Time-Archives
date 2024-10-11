//add functionality for seconds + minutes;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
public class Timer {
    protected static final Scanner sc = new Scanner(System.in);
    protected String exit = "The timer has finished successfully. ";
    protected int usage = 0;
    protected long time; //in terms of minutes
    protected long total = 0; //in terms of minutes
    //1000 ms = 1 s
    public static void getCurrentTime() {
        System.out.println(LocalDateTime.now());
    }
    public Timer(long time) {
        this.time = time;
    }
    public Timer() {
        System.out.println("Enter how many minutes you want to time in terms of minutes. ");
        time = sc.nextLong();
    }
    public void start() {
        try {
            ArrayList<String> show = new ArrayList<String>();
            for (int i = 0; i < time; i++) {
                show.add(" | ");
            }
            //remember that time is in terms of minutes;
            long end = System.currentTimeMillis() + (time * 60000);
            while (end - System.currentTimeMillis() >= 0) { 
                System.out.println(show);
                long remaining = end - System.currentTimeMillis(); //in terms of miliseconds
                long minutes = remaining / 60000;
                long seconds = (remaining / 1000) % 60;
                System.out.printf("Minutes: %d\tSeconds: %d\n", minutes, seconds);
                Thread.sleep(1000); //sleep thread for 1 second
                show.remove(show.size() - 1);
                System.out.println();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(exit);
        total += time;
        usage++;
    }
    public void setMessage(String exit) {
        this.exit = exit;
    }
    public void setMessage() {
        System.out.println("Enter desired exit message for the timer. ");
        exit = sc.nextLine();
    }
    public void set(long time) {
        this.time = time;
    }
    public void set() {
        System.out.println("Set timer in minutes: ");
        long x = sc.nextLong();
        time = x;
    }
    public long getDuration() {
        return time;
    }
    public long getTotalTime() {
        return total;
    }
    public long getUsage() {
        return usage;
    }
}