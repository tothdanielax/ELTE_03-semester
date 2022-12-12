package Shape;

import java.util.ArrayList;

public class Hexagon extends Shape {
    public Hexagon(Point centerPoint, double sideLength) {
        super(centerPoint, sideLength);
    }

    @Override
    public void initializeVerticesList() {
        vertices = new ArrayList<>();

        double height = (sideLength * Math.sqrt(3)) / 2;

        Point v1 = new Point(centerPoint.getX() - sideLength, centerPoint.getY());
        Point v2 = new Point(centerPoint.getX() - sideLength / 2, centerPoint.getY() + height);
        Point v3 = new Point(centerPoint.getX() + sideLength / 2, centerPoint.getY() + height);
        Point v4 = new Point(centerPoint.getX() + sideLength, centerPoint.getY());
        Point v5 = new Point(centerPoint.getX() + sideLength / 2, centerPoint.getY() - height);
        Point v6 = new Point(centerPoint.getX() - sideLength / 2, centerPoint.getY() - height);

        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        vertices.add(v4);
        vertices.add(v5);
        vertices.add(v6);
    }

    @Override
    public String toString() {
        return "Hexagon( central point: ( x: " + centerPoint.getX() + ", y: " + centerPoint.getY() + " ), side-length: " + sideLength + " )";
    }
}
