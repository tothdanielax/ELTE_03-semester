import Shape.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CoordinateSystem {
    /**
     * List of the shapes from the file, on the Coordinate System
     */
    private ArrayList<Shape> shapes;

    /**
     * The chosen point on the Coordinate System
     */
    private Point point;

    /**
      * Size of shapes ArrayList
     */
    private int numberOfShapes = 0;

    /**
     * @param fileName is the name of the file from to read
     */
    public CoordinateSystem(String fileName) {
        shapes = new ArrayList<>();
        read(fileName);
    }

    public CoordinateSystem() {
        shapes = new ArrayList<>();
    }


    /**
     * @param fileName is the name of the file from to read
     *                 Validating, processing file, then creating existences based on it
     */
    public void read(String fileName) {

        Scanner scanner = null;

        try {
            scanner = new Scanner(new File(fileName));
            numberOfShapes += scanner.nextInt();

            if(!scanner.hasNext()) {
                throw new NoSuchElementException();
            }

        } catch (FileNotFoundException e) {
            System.err.println("File not found! ");
            System.exit(-1);
        } catch (NullPointerException e) {
            System.err.println("File pathname is null! ");
            System.exit(-1);
        } catch (InputMismatchException e) {
            System.err.println("Next file input's type is wrong! ");
            System.exit(-1);
        } catch (NoSuchElementException e) {
            System.err.println("File is empty! " );
            System.exit(-1);
        }

        while (scanner.hasNext()) {

            String shapeType = scanner.next();
            Shape shape = null;

            try {
                switch (shapeType) {
                    case "C":
                        shape = new Circle(new Point(scanner.nextInt(), scanner.nextInt()), scanner.nextInt());
                        break;
                    case "T":
                        shape = new Triangle(new Point(scanner.nextInt(), scanner.nextInt()), scanner.nextInt());
                        break;
                    case "S":
                        shape = new Square(new Point(scanner.nextInt(), scanner.nextInt()), scanner.nextInt());
                        break;
                    case "H":
                        shape = new Hexagon(new Point(scanner.nextInt(), scanner.nextInt()), scanner.nextInt());
                        break;
                    default:
                        throw new IllegalArgumentException();
                };
            } catch (IllegalArgumentException e) {
                System.err.println("Illegal Shape type received! ");
                System.exit(-1);
            } catch (InputMismatchException e) {
                System.err.println("Input is not a number! ");
                System.exit(-1);
            } catch (NoSuchElementException e) {
                System.err.println("Input is invalid, could not read a full line! ");
                System.exit(-1);
            }

            shapes.add(shape);
        }
    }

    /**
     * @return is the index of the closest shape (in shapes list) to the chosen Point
     */
    public Shape getClosestShape() {
        ArrayList<Double> shapePointDistances = new ArrayList<>();

        for(Shape shape : shapes) {
            shapePointDistances.add(shape.getDistance(point));
        }

        int minIndex = 0;

        try {
            minIndex = shapePointDistances.indexOf(Collections.min(shapePointDistances));
        } catch (NoSuchElementException e) {
            System.err.println("Shapes list is empty! ");
            System.exit(-1);
        }

        return shapes.get(minIndex);
    }

    /**
     * @param point is the Point we want to choose
     */
    public void setPoint(Point point) {
        this.point = point;
    }

    /**
     * @return is the Point we chose at the beginning
     */
    public Point getPoint() {
        return point;
    }

    /**
     * A function what doesn't have effect on the execution, only helps to visualize in SageMath
     */
    public void printShapesForSageMath() {

        try {
            System.out.println("po = point((" + point.getX() + ", " + point.getY() + "), rgbcolor=hue(1), size=30)");
            for (int i = 0; i < shapes.size(); i++) {
                System.out.println("p" + i + "=" + shapes.get(i).toSageMath());
                i++;
            }
        } catch(NullPointerException e) {
            System.err.println("Point or shapes is null!");
            System.exit(-1);
        }

        StringBuilder str = new StringBuilder();
        str.append("show(po");
        for (int i = 1; i < shapes.size()+1; i++) {
            str.append(" + p" + i);
        }

       str.append(")");

        System.out.println(str.toString());
    }
}
