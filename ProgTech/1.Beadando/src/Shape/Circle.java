package Shape;

import java.util.ArrayList;

public class Circle extends Shape {
    /**
     * @param centerPoint is the center point of the Circle
     * @param sideLength here is the diameter of the Circle
     */
    public Circle(Point centerPoint, double sideLength) {
        super(centerPoint, sideLength);
    }

    /**
     * Initialize an empty Vertices list as Circle doesn't have vertices
     * Initialize radius by sideLength / 2 (what is diameter / 2)
     */
    @Override
    public void initializeVerticesList() {
        vertices = new ArrayList<>();
        this.radius = this.sideLength / 2;
    }

    /**
     * @param point is the "random" point chosen on the Coordinate System
     * @return is the distance between the Circle Shape and the point
     */
    @Override
    public Double getDistance(Point point) {
        double euclideanDistance =  Math.sqrt(Math.pow(centerPoint.getX() - point.getX(), 2) + Math.pow(centerPoint.getY() - point.getY(), 2));

        return Math.max(euclideanDistance - radius, 0);
    }

    /**
     * @return Circle's stringified, human-readable version
     */
    @Override
    public String toString() {
        return "Circle( central point: ( x: " + centerPoint.getX() + ", y: " + centerPoint.getY() + " ), side-length: " + sideLength + ", radius: " + radius + " )";
    }
}
