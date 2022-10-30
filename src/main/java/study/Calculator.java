package study;

public class Calculator {

    public static int sumNumbers(String[] numbers) {
        int sum = 0;
        for(String num : numbers){
            sum += StringUtils.stringToInt(num);
        }
        return sum;
    }
}
