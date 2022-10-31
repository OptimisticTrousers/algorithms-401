package stop_watch;

public class Stopwatch {

    private boolean isCounting = false;
    private float start;
    private float stop;

    public float start() {
        if (!isCounting) {
            start = System.currentTimeMillis();
            isCounting = true;
            return start;
        }
        return -1;
    }

    public float stop() {
        if (isCounting) {
            stop = System.currentTimeMillis();
            isCounting = false;
            return stop;
        }
        return -1;
    }

    public float getTime() {
        if(isCounting){
            float current = System.currentTimeMillis();
            return current - start;
        }else
            return stop - start;
    }
}
