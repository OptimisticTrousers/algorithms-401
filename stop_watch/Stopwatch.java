package stop_watch;

public class Stopwatch {
    
    private long start;
    private long stop;

    public long start() {
        start = System.currentTimeMillis();
        return start;
    }

    public long stop() {
        stop = System.currentTimeMillis();
        return stop;
    }

    public long getTime() {
        return stop - start;
    }
}
