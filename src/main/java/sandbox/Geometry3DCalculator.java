package sandbox;

import exceptions.ConeParametersException;
import exceptions.CylinderParametersException;
import exceptions.FigureStateException;
import exceptions.RegularTetrahedronParametersException;

public class Geometry3DCalculator {

    public Cone coneInstance;
    public RegularTetrahedron tetrahedronInstance;
    public Cylinder cylinderInstance;

    public static class Cone {
        private double height;
        private double radius;

        public Cone() {
        }

        public Cone(double height, double radius) throws ConeParametersException {
            if (height <= 0 || radius <= 0) {
                throw new ConeParametersException("Cone height and radius couldn`t be less or equal 0");
            }
            this.height = height;
            this.radius = radius;
        }

        public double getHeight() {
            return height;
        }

        public void setHeight(double height) throws ConeParametersException {
            if (height > 0) {
                this.height = height;
            } else {
                throw new ConeParametersException("Cone height and radius couldn`t be less or equal 0");
            }
        }

        public double getRadius() {
            return radius;
        }

        public void setRadius(double radius) throws ConeParametersException {
            if (radius > 0) {
                this.radius = radius;
            } else {
                throw new ConeParametersException("Cone height and radius couldn`t be less or equal 0");
            }
        }
    }

    public static class RegularTetrahedron {
        private double squareOfBase;
        private double height;
        private double edgeLength;

        public RegularTetrahedron() {
        }

        public RegularTetrahedron(double edgeLength) throws RegularTetrahedronParametersException {
            if (edgeLength <= 0) {
                throw new RegularTetrahedronParametersException("Tetrahedron`s edge couldn`t be less or equal than 0");
            }
            this.edgeLength = edgeLength;
        }

        public RegularTetrahedron(double squareOfBase, double height) throws RegularTetrahedronParametersException {
            if (squareOfBase <= 0 || height <= 0) {
                throw new RegularTetrahedronParametersException("Tetrahedron`s height or base square couldn`t be less or equal than 0");
            }
            this.squareOfBase = squareOfBase;
            this.height = height;
        }

        public double getSquareOfBase() {
            return squareOfBase;
        }

        public void setSquareOfBase(double squareOfBase) throws RegularTetrahedronParametersException {
            if (squareOfBase > 0) {
                this.squareOfBase = squareOfBase;
            }
            throw new RegularTetrahedronParametersException("Tetrahedron`s base square couldn`t be less or equal than 0");
        }

        public double getHeight() {
            return height;
        }

        public void setHeight(double height) throws RegularTetrahedronParametersException {
            if (height > 0) {
                this.height = height;
            }
            throw new RegularTetrahedronParametersException("Tetrahedron`s height couldn`t be less or equal than 0");
        }

        public double getEdgeLength() {
            return edgeLength;
        }

        public void setEdgeLength(double edgeLength) throws RegularTetrahedronParametersException {
            if (edgeLength > 0) {
                this.edgeLength = edgeLength;
            }
            throw new RegularTetrahedronParametersException("Tetrahedron`s edge length couldn`t be less or equal than 0");
        }
    }

    public static class Cylinder {
        private double radius;
        private double height;

        public Cylinder() {
        }

        public Cylinder(double radius, double height) throws CylinderParametersException {
            if (radius <= 0 || height <= 0) {
                throw new CylinderParametersException("Cylinder radius or height couldn`t be less or equal 0");
            }
            this.radius = radius;
            this.height = height;
        }

        public double getRadius() {
            return radius;
        }

        public void setRadius(double radius) throws CylinderParametersException {
            if (radius > 0) {
                this.radius = radius;
            } else {
                throw new CylinderParametersException("Cylinder radius couldn`t be less or equal 0");
            }
        }

        public double getHeight() {
            return height;
        }

        public void setHeight(double height) throws CylinderParametersException {
            if (height > 0) {
                this.height = height;
            } else {
                throw new CylinderParametersException("Cylinder height couldn`t be less or equal 0");
            }
        }
    }

    public Geometry3DCalculator() {
    }

    public Geometry3DCalculator(Cone cone, Cylinder cylinder, RegularTetrahedron tetrahedron) {
        coneInstance = cone;
        cylinderInstance = cylinder;
        tetrahedronInstance = tetrahedron;
    }

    public double getConeVolume(Cone cone) throws FigureStateException {
        if (cone.getRadius() <= 0 || cone.getHeight() <= 0) {
            throw new FigureStateException("There are too less parameters to resolve Cone volume");
        } else {
            double volume;
            volume = cone.getHeight() * cone.getRadius() * cone.getRadius() * Math.PI / 3;
            return volume;
        }
    }

    public double getRegularTetrahedronVolume(RegularTetrahedron tetrahedron) throws FigureStateException {
        if ((tetrahedron.getSquareOfBase() <= 0 || tetrahedron.getHeight() <= 0) && (tetrahedron.getEdgeLength() <= 0)) {
            throw new FigureStateException("There are too less parameters to resolve regular Tetrahedron  volume");
        } else {
            if(tetrahedron.getEdgeLength() <= 0){
                double volume;
                volume = tetrahedron.getHeight() * tetrahedron.getSquareOfBase() / 3;
                return volume;
            } else {
                double volume;
                volume = tetrahedron.getEdgeLength() * tetrahedron.getEdgeLength() * tetrahedron.getEdgeLength() / 6 / Math.sqrt(2);
                return volume;
            }
        }
    }

    public double getCylinderVolume(Cylinder cylinder) throws FigureStateException {
        if (cylinder.getRadius() <= 0 || cylinder.getHeight() <= 0) {
            throw new FigureStateException("There are too less parameters to resolve Cylinder volume");
        } else {
            double volume;
            volume = cylinder.getHeight() * cylinder.getRadius() * cylinder.getRadius() * Math.PI;
            return volume;
        }
    }
 
}
