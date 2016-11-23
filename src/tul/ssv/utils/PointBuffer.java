package tul.ssv.utils;


public class PointBuffer<T> {

    final int length;
    final T[] points;

    private int pointer;
    private boolean overflow = false;

    public PointBuffer(int length) {
        this.length = length;
        this.pointer = 0;
        this.points = (T[]) new Object[this.length];
    }

    public void add(T point) {
        points[pointer] = point;
        if (pointer + 1 == length)
            overflow = true;
        pointer = (pointer + 1) % length;
        
    }

    public int getSize() {
        return overflow ? length : pointer;
    }

    public int getPointer() {
        return overflow ? pointer : 0;
    }

    public T get(int i) {
        return points[i % length];
    }

}
