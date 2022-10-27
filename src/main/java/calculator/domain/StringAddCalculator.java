package calculator.domain;

public class StringAddCalculator {
    private Input input;
    
    private StringAddCalculator(String str) {
        input = new Input(str);
    }
    
    public static int splitAndSum(String str) {
        StringAddCalculator calc = new StringAddCalculator(str);
        
        String[] numberStrArr = calc.split();
        return calc.sum(numberStrArr);
    }
    
    private String[] split() {
        return input.split();
    }
    
    private int sum(String[] numberStrArr) {
        return new Result(numberStrArr).sum();
    }
}
