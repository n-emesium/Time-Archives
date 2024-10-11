import java.util.ArrayList;
public class MicroTimer extends Timer {
    private long seconds; 
    public MicroTimer(long minutes, long seconds) {
        super(minutes); 
        this.seconds = seconds;
    }
    public MicroTimer() {
        super(); 
        System.out.println("Enter seconds: ");
        this.seconds = sc.nextLong();
        time += seconds / 60; 
    }
    public void start() {
        try {
            ArrayList<String> show = new ArrayList<String>();
            for (int i = 0; i < time + (seconds / 60); i++) {
                show.add(" | ");
            }
            long end = System.currentTimeMillis() + ((time * 60000) + (seconds * 1000));
            while (end - System.currentTimeMillis() >= 0) {
                System.out.println(show);
                long remaining = end - System.currentTimeMillis(); 
                long minutes = remaining / 60000;
                long secs = (remaining / 1000) % 60;
                System.out.printf("Minutes: %d\tSeconds: %d\n", minutes, secs);
                Thread.sleep(1000); 
                show.remove(show.size() - 1);
                System.out.println();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(exit);
        total += time + (seconds / 60);
        usage++;
    }
    public void setSeconds(long seconds) {
        this.seconds = seconds;
        time += seconds / 60;
    }
    public long getSeconds() {
        return seconds;
    }
}
