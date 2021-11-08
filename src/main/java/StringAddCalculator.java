
public class StringAddCalculator {
    public static int splitAndSum(String str){
        InputString inputString = new InputString(str);

        if(inputString.isNullOrEmpty()) {
            return 0;
        }
        if(inputString.isOneNumber()) {
            return Integer.parseInt(str);
        }

        inputString.setNumbers(inputString.splitToNumberArray());

        inputString.isValidNumber();

        return inputString.sumNumbers();
    }

}
