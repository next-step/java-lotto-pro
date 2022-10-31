package step3.model.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import step3.model.value.ErrMsg;
import step3.model.value.Rule;

public class InputValidation {

    private InputValidation() {
        throw new AssertionError();
    }
    private static final String NUMBER_REGEX = "^[0-9]+$";

    public static void validateNumber(String input){
        if(!input.matches(NUMBER_REGEX)){
            throw new IllegalArgumentException(ErrMsg.NOT_NUMBER);
        }
    }
    public static void validateEmpty(String input){
        if(input == null || input.isEmpty()){
            throw new IllegalArgumentException(ErrMsg.EMPTY_INPUT);
        }
    }
}
