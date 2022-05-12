import java.util.List;

public class StringAddCalculator {

    public static int splitAndSum(String expression) {
        if(isEmptyExpression(expression)) {
            return 0;
        }
        ExpressionInterpretor expressionInterpretor = new ExpressionInterpretor(expression);
        return sum(expressionInterpretor.getNumbers());
    }

    private static boolean isEmptyExpression(String expression){
       return expression == null || "".equals(expression);
    }

    private static int sum(List<Integer> numbers){
        int sum = 0;
        for(int number : numbers){
            sum += number;
        }
        return sum;
    }
}
