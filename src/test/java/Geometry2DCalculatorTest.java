import Exceptions.IllegalArgumentException;
import Exceptions.IllegalStateException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sandbox.Geometry2DCalculator;

public class Geometry2DCalculatorTest {
    Geometry2DCalculator geometry2DCalculator;

    @Before
    public void initialization() throws IllegalArgumentException {
        geometry2DCalculator = new Geometry2DCalculator(new Geometry2DCalculator.Triangle(3, 4, 5), new Geometry2DCalculator.Circle(1), new Geometry2DCalculator.Parallelogram.Builder(10,20).setAngleInDegs(90));
    }
    @Test
    public void testTriangleSquare() throws IllegalStateException {
        Assert.assertEquals(6, geometry2DCalculator.getTriangleSquare(geometry2DCalculator.triangleInstance), 1e-100);
    }
    @Test
    public void testTriangleExceptions(){
        Assert.assertThrows(IllegalArgumentException.class,() -> {
            geometry2DCalculator.triangleInstance.setAb(-22);
        });
        Assert.assertThrows(IllegalStateException.class, () ->{geometry2DCalculator.triangleInstance.setAb(100); geometry2DCalculator.getTriangleSquare(geometry2DCalculator.triangleInstance);});
    }

    @Test
    public void testCircleSquare() throws IllegalStateException {
        Assert.assertEquals(3.141592653589793, geometry2DCalculator.getCircleSquare(geometry2DCalculator.circleInstance), 1e-10);
    }
    @Test
    public void testCircleExceptions(){
        Assert.assertThrows(IllegalArgumentException.class,() -> {
            geometry2DCalculator.circleInstance.setRadius(-22);
        });
    }

    @Test
    public void testParallelogramSquare() throws IllegalStateException {
        Assert.assertEquals(200, geometry2DCalculator.getParallelogramSquare(geometry2DCalculator.parallelogramInstance), 1e-100);
    }
    @Test
    public void testParallelogramExceptions(){
        Assert.assertThrows(IllegalArgumentException.class,() -> {Object object = new Geometry2DCalculator.Parallelogram.Builder(-999,20).setAngleInDegs(0);});
        Assert.assertThrows(IllegalStateException.class, () ->{
            geometry2DCalculator.parallelogramInstance = new Geometry2DCalculator.Parallelogram.Builder(10,20).build();
            geometry2DCalculator.getParallelogramSquare(geometry2DCalculator.parallelogramInstance);
        });
    }

}
