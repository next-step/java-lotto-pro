package calculator.util;

import calculator.constant.Regex;

import java.util.regex.Pattern;

public class Validator {
    public boolean isNullOrEmpty(String text){
        return text == null || text.isEmpty();
    }
    public void isNumber(String number){
        if(!isOnlyNumber(number))
            throw new IllegalArgumentException();
    }
    private boolean isOnlyNumber(String number){
        return Pattern.matches(Regex.ONLY_NUMBER.getRegex(), number);
    }
    public void isPositiveNumber(int number){
        if(number < 0)
            throw new IllegalArgumentException();
    }
}
