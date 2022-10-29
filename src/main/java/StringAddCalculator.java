public class StringAddCalculator {
    public static int splitAndSum(String text) {
        CalculatorInput calculatorInput = new CalculatorInput(text);

        if (calculatorInput.isEmpty()) {
            return 0;
        }

        Numbers numbers = new Numbers(calculatorInput.getNumbers());
        return numbers.sum();
    }
}
