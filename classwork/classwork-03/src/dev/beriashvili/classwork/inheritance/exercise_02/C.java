package dev.beriashvili.classwork.inheritance.exercise_02;

class C extends B {
    double z;

    C(int x, int y) {
        super(x, y);
    }

    double getArithmeticMean() {
        return (x + y + z) / 3;
    }

    double getGeometricMean() {
        return Math.pow(x * y * z, 1.0 / 3);
    }

    double getMaximum() {
        return Math.max(x, Math.max(y, z));
    }
}
