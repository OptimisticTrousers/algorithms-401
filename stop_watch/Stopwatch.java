package stop_watch;

public class Stopwatch {

    private boolean isCounting = false;
    private long start;
    private long stop;

    public long start() {
        if (!isCounting) {
            start = System.currentTimeMillis();
            isCounting = true;
            return start;
        }
        return -1;
    }

    public long stop() {
        if (isCounting) {
            stop = System.currentTimeMillis();
            isCounting = false;
            return stop;
        }
        return -1;
    }

    public long getTime() {
        if(isCounting){
            long current = System.currentTimeMillis();
            return current - start;
        }else
            return stop - start;
    }
}
