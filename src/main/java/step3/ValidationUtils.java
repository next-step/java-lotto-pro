package step3;

public class ValidationUtils {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final String LOTTO_RANGE_EXCEPTION = "로또번호는 1부터 45까지의 숫자여야 합니다.";
    
    public static int parseInt(String input) {
        try {
            int parseNumber = Integer.parseInt(input);
            validLottoNumber(parseNumber);
            return Integer.parseInt(input);
        }
        catch (Exception e){
            throw new IllegalArgumentException(LOTTO_RANGE_EXCEPTION);
        }
    }
    
    private static void validLottoNumber(int parseNumber) {
        if (parseNumber < LOTTO_MIN_NUMBER || parseNumber > LOTTO_MAX_NUMBER ){
            throw new IllegalArgumentException(LOTTO_RANGE_EXCEPTION);
        }
    }
}
