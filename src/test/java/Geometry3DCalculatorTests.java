import Exceptions.*;
import Exceptions.IllegalArgumentException;
import Exceptions.IllegalStateException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sandbox.Geometry2DCalculator;
import sandbox.Geometry3DCalculator;

public class Geometry3DCalculatorTests {

    Geometry3DCalculator geometry3DCalculator;

    @Before
    public void initialization() throws CylinderParametersException, RegularTetrahedronParametersException, ConeParametersException {
        geometry3DCalculator = new Geometry3DCalculator(new Geometry3DCalculator.Cone(30, 10), new Geometry3DCalculator.Cylinder(10, 30), new Geometry3DCalculator.RegularTetrahedron(10));
    }

    @Test
    public void testConeVolume() throws FigureStateException {
        Assert.assertEquals(Math.PI * 1000, geometry3DCalculator.getConeVolume(geometry3DCalculator.coneInstance), 1e-100);
    }

    @Test
    public void testConeParameterExceptions() {
        Assert.assertThrows(ConeParametersException.class, () -> {
            geometry3DCalculator.coneInstance.setHeight(-22);
        });
        Assert.assertThrows(ConeParametersException.class, () -> {
            geometry3DCalculator.coneInstance.setRadius(0);
        });
    }

    @Test
    public void testCylinderVolume() throws FigureStateException {
        Assert.assertEquals(3.141592653589793 * 3000, geometry3DCalculator.getCylinderVolume(geometry3DCalculator.cylinderInstance), 1e-10);
    }

    @Test
    public void testCylinderParameterExceptions() {
        Assert.assertThrows(CylinderParametersException.class, () -> {
            geometry3DCalculator.cylinderInstance.setRadius(0);
        });
        Assert.assertThrows(CylinderParametersException.class, () -> {
            geometry3DCalculator.cylinderInstance.setHeight(-1);
        });
    }

    @Test
    public void testTetrahedronVolume() throws FigureStateException {
        Assert.assertEquals((double) 1000 / 6 / Math.sqrt(2), geometry3DCalculator.getRegularTetrahedronVolume(geometry3DCalculator.tetrahedronInstance), 1e-100);
    }

    @Test
    public void testTetrahedronParameterExceptions() {
        Assert.assertThrows(RegularTetrahedronParametersException.class, () -> {
            geometry3DCalculator.tetrahedronInstance.setEdgeLength(0);
        });
        Assert.assertThrows(RegularTetrahedronParametersException.class, () -> {
            geometry3DCalculator.tetrahedronInstance.setHeight(-1);
        });
        Assert.assertThrows(RegularTetrahedronParametersException.class, () -> {
            geometry3DCalculator.tetrahedronInstance.setSquareOfBase(0);
        });
    }

}
