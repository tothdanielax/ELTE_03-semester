package Shape;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Shape {
    /**
     * The center point of the Shape
     */
    protected Point centerPoint;

    /**
     * The side-length of the Shape
     * **Circle's side-length is handled as diameter
     */
    protected double sideLength;

    /**
     * The radius of the Shape
     * Only used in Circle calculations,
     * included here because of the task description
     */
    protected double radius;

    /**
     * The list of the vertices (clock-wise)
     */
    protected ArrayList<Point> vertices;


    /**
     * The list of the (direction) vectors from each vertices to another one (clock-wise, like A->B, B->C)
     */
    protected ArrayList<Point> verticesVectors;


    /**
     * @param centerPoint is the Center Point of the Shape
     * @param sideLength  is the side-length of the Shape
     *                    **side-length is handled as the diameter of a Circle
     *                    Constructor initializes the Vertices and VerticesVectors lists too
     */
    protected Shape(Point centerPoint, double sideLength) throws IllegalArgumentException {
        if (sideLength <= 0) {
            throw new IllegalArgumentException();
        }

        this.centerPoint = centerPoint;
        this.sideLength = sideLength;

        initializeVerticesList();
        initializeVerticesVectors();
    }

    /**
     * Initialize the list of the Shape's Vertices
     */
    protected abstract void initializeVerticesList();

    /**
     * Initializes the verticesVectors list, based on the Shape's vertices
     */
    protected void initializeVerticesVectors() {
        verticesVectors = new ArrayList<>();

        if (vertices != null && !vertices.isEmpty()) {
            Point start = vertices.get(0);
            Point terminal, vector;

            for (int i = 1; i < vertices.size(); i++) {
                terminal = vertices.get(i);
                vector = new Point(terminal.getX() - start.getX(), terminal.getY() - start.getY());
                verticesVectors.add(vector);

                start = terminal;
            }

            terminal = vertices.get(0);
            vector = new Point(terminal.getX() - start.getX(), terminal.getY() - start.getY());
            verticesVectors.add(vector);
        }

    }

    /**
     * @param point is the chosen Point
     * @return is the closest distance between the Shape and the Point
     */
    public Double getDistance(Point point) {

        //a,b,c
        ArrayList<Double> scalarProductThird = getScalarProductsThirdComponent(point);
        if (isSignSameAcrossElements(scalarProductThird)) {
            return 0.0;
        } else {
            //d
            return findMinOfPointAndVerticesDistance(point);
        }

    }

    /**
     * @param point is the chosen Point
     * @return is a scalar/dot product's third component list,
     * calculated by the Point and the Vertices Vectors (list) of the Shape
     */
    protected ArrayList<Double> getScalarProductsThirdComponent(Point point) {
        ArrayList<Double> scalarProductThird = new ArrayList<>();

        Point vectorPoint, vectorVertices;

        for (int i = 0; i < vertices.size(); i++) {
            vectorPoint = new Point(point.getX() - vertices.get(i).getX(), point.getY() - vertices.get(i).getY());
            vectorVertices = verticesVectors.get(i);

            double thirdComponent = vectorVertices.getX() * vectorPoint.getY() - vectorVertices.getY() * vectorPoint.getX();

            scalarProductThird.add(thirdComponent);
        }

        return scalarProductThird;
    }

    /**
     * @param scalarProductThird is an inline generated scalar/dot product's third component list
     * @return is a check if all elements in the list has the identical number sign
     */
    protected boolean isSignSameAcrossElements(ArrayList<Double> scalarProductThird) {
        boolean hasPlus = false;
        boolean hasNeg = false;

        for (Double i : scalarProductThird) {
            if (i < 0) {
                hasNeg = true;
            } else if (i > 0) {
                hasPlus = true;
            }

        }

        return hasPlus != hasNeg;
    }

    /**
     * @param point is the chosen Point
     * @return is the minimum distance of the Shape's vertices and the chosen Point
     */
    protected double findMinOfPointAndVerticesDistance(Point point) {
        ArrayList<Double> pointAndVerticesDistance = new ArrayList<>();

        for (Point v : vertices) {
            double distance = Math.sqrt(Math.pow((v.getX() - point.getX()), 2) + Math.pow((v.getY() - point.getY()), 2));

            pointAndVerticesDistance.add(distance);
        }

        return Collections.min(pointAndVerticesDistance);
    }

//    protected ArrayList<Line> getSidesStraightLine(Point p) {
//
//        ArrayList<Line> sidesStraightLine = new ArrayList<>();
//
//        for (Point vectorSide : verticesVectors) {
//            Point normalVector = new Point(vectorSide.getY() * -1, vectorSide.getX());
//
//            Line e = new Line(normalVector.getX(), normalVector.getY());
//            e.setResult(vectorSide);
//
//            sidesStraightLine.add(e);
//        }
//
//        return sidesStraightLine;
//    }
//
//    protected ArrayList<Double> getIntersectionsOnSide(Point point) {
//        ArrayList<Double> intersectionOnSide = new ArrayList<>();
//        ArrayList<Line> sidesStraightLine = getSidesStraightLine(point);
//
//        for(int i = 0; i < vertices.size(); i++) {}
//
//
//        return intersectionOnSide;
//    }

    public abstract String toString();

    /**
     * @return SageMath friendly string
     */
    public String toSageMath() {
        StringBuilder str = new StringBuilder();

        str.append("Shape([");

        for (Point v : vertices) {
            str.append("(" + v.getX() + "," + v.getY() + "),");
        }

        str.append("], fill=False)");

        return str.toString();
    }
}
