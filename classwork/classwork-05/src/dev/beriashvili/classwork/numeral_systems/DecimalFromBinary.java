package dev.beriashvili.classwork.numeral_systems;

public class DecimalFromBinary implements DecimalConverter {
    @Override
    public Integer convertFromBinary(String binaryRepresentation) {
        return Integer.parseInt(binaryRepresentation, 2);
    }
}
