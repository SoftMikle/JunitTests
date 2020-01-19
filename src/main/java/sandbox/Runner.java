package sandbox;

import Exceptions.IllegalArgumentException;
import Exceptions.IllegalStateException;

public class Runner {
    public static void main(String[] args) {
        try {
            Geometry2DCalculator geometry2DCalculator = new Geometry2DCalculator(new Geometry2DCalculator.Triangle(3, 4, 6), new Geometry2DCalculator.Circle(22.0), new Geometry2DCalculator.Parallelogram.Builder(2,4).setAngleInDegs(90));
            System.out.println(geometry2DCalculator.getTriangleSquare(geometry2DCalculator.triangleInstance));
            System.out.println(geometry2DCalculator.getCircleSquare(geometry2DCalculator.circleInstance));
            System.out.println(geometry2DCalculator.getParallelogramSquare(geometry2DCalculator.parallelogramInstance));
        } catch (IllegalArgumentException | IllegalStateException e){
            e.printStackTrace();
        }



    }
}
