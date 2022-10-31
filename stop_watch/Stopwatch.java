package stop_watch;

public class Stopwatch {

    private boolean isCounting = false; //preserves the on/off state of the abstract Stopwatch
    private long start;
    private long stop;

    public long start() {
        if (!isCounting) {
            start = System.nanoTime();
            isCounting = true;
            return 0;
        }
        return -1; //error code only returns if you haven't invoked stop() prior
    }

    public float stop() {
        if (isCounting) {
            stop = System.nanoTime();
            isCounting = false;
            return getTime();
        }
        return -1; //error code only returns if you haven't invoked start() prior
    }

    public float getTime() {
        if(isCounting){ //check current time complexity without stopping
            long current = System.nanoTime();
            return (current - start)  / 1000000F;
        }else
            return (stop - start) / 1000000F;
    }
}
