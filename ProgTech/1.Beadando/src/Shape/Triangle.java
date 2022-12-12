package Shape;

import java.util.ArrayList;

public class Triangle extends Shape {
    /**
     * @param centerPoint is the center point of the Triangle
     * @param sideLength here is the side-length of the Triangle
     */
    public Triangle(Point centerPoint, double sideLength) {
        super(centerPoint, sideLength);
    }

    /**
     * Initialize the triangle's Vertices list (Triangle has 3 vertices)
     * Makes calculus based on the center point of Triangle,
     * then creates the 3 vertices by it and add to the Vertices list
     */
    @Override
    public void initializeVerticesList() {
        vertices = new ArrayList<>();

        double verticesDistanceFromCenterPoint = (sideLength * Math.sqrt(3)) / 3;
        double sidePer2DistanceFromCenterPoint = (sideLength * Math.sqrt(3)) / 6;

        Point v1 = new Point(centerPoint.getX() - sideLength / 2, centerPoint.getY() - sidePer2DistanceFromCenterPoint);
        Point v2 = new Point(centerPoint.getX(), centerPoint.getY() + verticesDistanceFromCenterPoint);
        Point v3 = new Point(centerPoint.getX() + sideLength / 2, centerPoint.getY() - sidePer2DistanceFromCenterPoint);

        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
    }

    /**
     * @return Triangle's stringified, human-readable version
     */
    @Override
    public String toString() {
        return "Triangle( central point: ( x: " + centerPoint.getX() + ", y: " + centerPoint.getY() + " ), side-length: " + sideLength + " )";
    }
}
