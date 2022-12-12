import Shape.*;

public class Main {
    public static void main(String[] args) {

        CoordinateSystem coordinateSystem = null;

        if (args.length == 0) {
            coordinateSystem = new CoordinateSystem("src/Teszt/teszt1.txt");
        } else if (args.length == 1) {
            coordinateSystem = new CoordinateSystem(args[0]);
        } else {
            coordinateSystem = new CoordinateSystem();

            for (String arg : args) {
                coordinateSystem.read(arg);
            }
        }

        coordinateSystem.setPoint(new Point(3, 3));
        System.out.println("Closest Shape: " + coordinateSystem.getClosestShape().toString());

    }
}