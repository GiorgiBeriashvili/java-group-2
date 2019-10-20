package dev.beriashvili.classwork.numeral_systems;

public class BinaryFromDecimal implements BinaryConverter {
    @Override
    public String convertFromDecimal(int decimal) {
        return Integer.toBinaryString(decimal);
    }
}
