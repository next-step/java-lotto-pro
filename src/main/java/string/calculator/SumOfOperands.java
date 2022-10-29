package string.calculator;

public class SumOfOperands {
    private final int result;

    public SumOfOperands(Operand[] operands) {
        Operand opResult = new Operand("0");
        for (Operand operand : operands) {
            opResult = opResult.add(operand);
        }
        result = opResult.value();
    }

    public int result() {
        return result;
    }
}
