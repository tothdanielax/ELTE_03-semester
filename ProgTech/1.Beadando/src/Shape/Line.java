package Shape;

public class Line {
    /**
     * "A"x of Line equation
     */
    private double a;

    /**
     * "B"y of Line equation
     */
    private double b;

    /**
     * Result of Line equation
     */
    private double result;


    /**
     * @param a "A"x of Line equation
     * @param b "B"x of Line equation
     */
    public Line(double a, double b) {
        this.a = a;
        this.b = b;
    }

    /**
     * @param e is another Line, namely a projected straight line on the side of a Shape
     * @return is the intersection Point of the two lines (parameter and this)
     */
    public Point getLinesIntersectionPointThroughPoint(Line e, Point point) {
        double c1 = result * -1;

        double a2 = e.getA();
        double b2 = e.getB();
        double r2 = e.result * -1;

        return new Point(((b * r2 - b2 * c1) / (a * b2 - a2 * b)), ((c1 * a2 - r2 * a) / (a * b2 - a2 * b)));
    }

    /**
     * @return a class variable
     */
    public double getA() {
        return a;
    }

    /**
     * @return b class variable
     */
    public double getB() {
        return b;
    }

    /**
     * @param point is the (x,y) Point of a vertices,
     *              we calculate the result by this vertices
     */
    public void setResult(Point point) {
        this.result = a * point.getX() + b * point.getY();
    }


    /**
     * @return Line's stringified, human-readable version
     */
    @Override
    public String toString() {
        return "Line( " + a + "a * " + b + "b = " + result + " )";
    }
}
