package step3.model.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import step3.model.value.ErrMsg;
import step3.model.value.Rule;

public class InputValidation {
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

    public static void validateLength(List<String> lottoNumbers) {
        if(lottoNumbers.size()!= Rule.LOTTO_NUMBER_LENGTH){
            throw new IllegalArgumentException(ErrMsg.WRONG_LENGTH);
        }
    }

    public static void validateDuplication(List<String> lottoNumbers) {
        Set lottoNumberSet = new HashSet(lottoNumbers);
        if(lottoNumberSet.size()!=lottoNumbers.size()){
            throw new IllegalArgumentException(ErrMsg.DUPLICATED_INPUT);
        }
    }

    public static void validateIntRange(int number) {
        if(number< Rule.MIN_NUM || number>Rule.MAX_NUM){
            throw new IllegalArgumentException(ErrMsg.WRONG_RANGE);
        }
    }

    public static void validateTicketLength(List<Integer> ticket) {
        if(ticket.size()!= Rule.LOTTO_NUMBER_LENGTH){
            throw new IllegalArgumentException(ErrMsg.WRONG_LENGTH);
        }
    }
}
