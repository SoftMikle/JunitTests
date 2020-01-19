package sandbox;

import Exceptions.IllegalArgumentException;
import Exceptions.IllegalStateException;

public class Geometry2DCalculator {

    public Triangle triangleInstance;
    public Circle circleInstance;
    public Parallelogram parallelogramInstance;

    public static class Triangle {
        private double ab;
        private double bc;
        private double ac;

        public Triangle(double ab, double bc, double ac) throws IllegalArgumentException {
            if (ab <= 0.0 || bc <= 0.0 || ac <= 0.0) {
                throw new IllegalArgumentException("Side of triangle couldn`t be less or equal 0");
            }
            this.ab = ab;
            this.bc = bc;
            this.ac = ac;
        }

        public boolean isLegal() {
            if (ab + bc <= ac || ab + ac <= bc || ac + bc <= ab) {
                return false;
            }
            return true;
        }

        public double getAb() {
            return ab;
        }

        public void setAb(double ab) throws IllegalArgumentException {
            if (ab > 0.0) {
                this.ab = ab;
            } else {
                throw new IllegalArgumentException("Side of triangle couldn`t be less or equal 0");
            }
        }

        public double getBc() {
            return bc;
        }

        public void setBc(double bc) throws IllegalArgumentException {
            if (bc > 0.0) {
                this.bc = bc;
            } else {
                throw new IllegalArgumentException("Side of triangle couldn`t be less or equal 0");
            }
        }

        public double getAc() {
            return ac;
        }

        public void setAc(double ac) throws IllegalArgumentException {
            if (ac > 0.0) {
                this.ac = ac;
            } else {
                throw new IllegalArgumentException("Side of triangle couldn`t be less or equal 0");
            }
        }
    }

    public static class Circle {
        private double radius;

        public Circle(double radius) throws IllegalArgumentException {
            if (radius <= 0.0){
                throw new IllegalArgumentException("Radius of circle couldn`t be less or equal 0");
            }
                this.radius = radius;
        }

        public double getRadius() {
            return radius;
        }

        public void setRadius(double radius) throws IllegalArgumentException {
            if (radius > 0.0) {
                this.radius = radius;
            } else {
                throw new IllegalArgumentException("Radius of circle couldn`t be less or equal 0");
            }
        }
    }

    public static class Parallelogram{
        private double ab;
        private double bc;
        private double angleInDegs;
        private double angleInRads;

        private Parallelogram(Builder builder) {
            this.ab = builder.ab;
            this.bc = builder.bc;
            this.angleInDegs = builder.angleInDegs;
            this.angleInRads = builder.angleInRads;
        }

        public static class Builder{
            private double ab;
            private double bc;
            private double angleInDegs;
            private double angleInRads;

            public Builder( double ab, double bc) throws IllegalArgumentException {
                if (ab <= 0.0 || bc <= 0.0) {
                    throw new IllegalArgumentException("Side of parallelogram couldn`t be less or equal 0");
                }
                this.ab = ab;
                this.bc = bc;
            }

            public Builder setAb(double ab) throws IllegalArgumentException {
                if (ab > 0.0) {
                    this.ab = ab;
                } else {
                    throw new IllegalArgumentException("Side of Parallelogram couldn`t be less or equal 0");
                }
                return this;
            }

            public Builder setBc(double bc) throws IllegalArgumentException {
                if (bc > 0.0) {
                    this.bc = bc;
                } else {
                    throw new IllegalArgumentException("Side of Parallelogram couldn`t be less or equal 0");
                }
                return this;
            }

            public Builder setAngleInDegs(double angleInDegs) throws IllegalArgumentException {
                if (angleInDegs > 0.0) {
                    this.angleInDegs = angleInDegs;
                } else {
                    throw new IllegalArgumentException("Angle in degrees of Parallelogram couldn`t be less or equal 0");
                }
                return this;
            }

            public Builder setAngleInRads(double angleInRads) throws IllegalArgumentException {
                if (angleInRads > 0.0) {
                    this.angleInRads = angleInRads;
                } else {
                    throw new IllegalArgumentException("Angle in radians of Parallelogram couldn`t be less or equal 0");
                }
                return this;
            }

            public Parallelogram build(){
                return new Parallelogram(this);
            }
        }
    }

    public Geometry2DCalculator(Triangle triangle, Circle circle, Parallelogram.Builder parallelogram) {
        this.triangleInstance = triangle;
        this.circleInstance = circle;
        this.parallelogramInstance = parallelogram.build();
    }

    public double getTriangleSquare(Triangle triangle) throws IllegalStateException {
        if (triangle.isLegal()) {
            double square;
            double halfP;
            halfP = (triangle.ab + triangle.bc + triangle.ac) / 2;
            square = Math.sqrt(halfP * (halfP - triangle.ab) * (halfP - triangle.bc) * (halfP - triangle.ac));
            return square;
        } else {
            throw new IllegalStateException("Illegal state for triangle sides");
        }
    }

    public double getCircleSquare(Circle circle) {
        double square;
        square = circle.radius * circle.radius * Math.PI;
        return square;
    }

    public double getParallelogramSquare(Parallelogram parallelogram) throws IllegalStateException {
        if (parallelogram.angleInDegs > 0.0) {
            double square;
            double angle;
            angle = Math.sin(Math.PI * parallelogram.angleInDegs / 180);
            square = parallelogram.ab * parallelogram.bc * angle;
            return square;
        } else {
            if (parallelogram.angleInRads > 0.0) {
                double square;
                double angle;
                angle = Math.sin(parallelogram.angleInRads );
                square = parallelogram.ab * parallelogram.bc * angle;
                return square;
            }else {
                throw new IllegalStateException("Illegal state for Parallelogram - need more parameters to find square");
            }
        }
    }


}
