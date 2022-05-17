package stringaddcalc;

public class StringAddCalculator {

    private static NumberValidator numberValidator;
    public static int splitAndSum(String text) {
        numberValidator = new NumberValidator(text);
        return numberValidator.checkNumberValidate();
    }


}
