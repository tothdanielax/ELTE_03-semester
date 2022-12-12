package Shape;

public class Point {
    /**
     * x coordinate
     */
    private double x;
    /**
     * y coordinate
     */
    private double y;

    /**
     * @param x is the x coordinate
     * @param y is the y coordinate
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return x coordinate
     */
    public double getX() {
        return x;
    }

    /**
     * @return y coordinate
     */
    public double getY() {
        return y;
    }

    /**
     * @return Point's stringified, human-readable version
     */
    @Override
    public String toString() {
        return "Point( " + x + ", " + y + " )";
    }
}
