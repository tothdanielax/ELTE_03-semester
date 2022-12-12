package Shape;

import java.util.ArrayList;

public class Square extends Shape {
    public Square(Point centerPoint, double sideLength) {
        super(centerPoint, sideLength);
    }

    @Override
    public void initializeVerticesList() {
        vertices = new ArrayList<>();

        Point v1 = new Point(centerPoint.getX() - sideLength / 2, centerPoint.getY() + sideLength / 2);
        Point v2 = new Point(centerPoint.getX() + sideLength / 2, centerPoint.getY() + sideLength / 2);
        Point v3 = new Point(centerPoint.getX() + sideLength / 2, centerPoint.getY() - sideLength / 2);
        Point v4 = new Point(centerPoint.getX() - sideLength / 2, centerPoint.getY() - sideLength / 2);

        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        vertices.add(v4);
    }

    @Override
    public String toString() {
        return "Square( central point: ( x: " + centerPoint.getX() + ", y: " + centerPoint.getY() + " ), side-length: " + sideLength + " )";
    }
}
