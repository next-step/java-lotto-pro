public class StringAddCalculator {
    public static int splitAndSum(String expression) {
        if(isEmptyExpression(expression)) {
            return 0;
        }
        return -1;
    }

    private static boolean isEmptyExpression(String expression){
       return expression == null || "".equals(expression);
    }
}
