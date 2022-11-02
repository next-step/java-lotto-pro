package lotto.utils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LottoValidationUtils {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final Pattern LOTTO_COMMA_PATTERN
            = Pattern.compile("^(\\d|\\s)+,(\\d|\\s)+,(\\d|\\s)+,(\\d|\\s)+,(\\d|\\s)+,(\\d|\\s)+$");
    private static final Pattern NUMBER_POSITIVE = Pattern.compile("^[0-9]+$");
    private static final int LOTTO_PRICE = 1000;


    private LottoValidationUtils() {
    }

    public static String validLottoMoney(String money) {
        validEmpty(money);
        validPositiveNumber(money);
        validLottoPrice(Integer.parseInt(money));
        return money;
    }

    private static void validEmpty(String money) {
        if (StringUtils.isNullOrEmpty(money)) {
            throw new IllegalArgumentException("금액을 입력해주세요.");
        }
    }

    private static void validPositiveNumber(String money) {
        Matcher matcher = NUMBER_POSITIVE.matcher(money);
        if (!matcher.find()) {
            throw new IllegalArgumentException("금액은 숫자만 입력가능합니다.");
        }
    }

    private static void validLottoPrice(int purchasePrice) {
        if (purchasePrice < LOTTO_PRICE || (purchasePrice % LOTTO_PRICE) != 0) {
            throw new IllegalArgumentException("로또 금액은 1000원 단위로 입력해야 합니다.");
        }
    }

    public static void validLottoNumbers(String lottoNumbers) {
        validNullOrEmpty(lottoNumbers);
        checkLottoPattern(lottoNumbers);
    }


    private static void validNullOrEmpty(String lottoNumbers) {
        if (StringUtils.isNullOrEmpty(lottoNumbers)) {
            throw new IllegalArgumentException("로또 번호를 입력해주세요.");
        }
    }

    private static void checkLottoPattern(String lottoNumbers) {
        Matcher matcher = LOTTO_COMMA_PATTERN.matcher(lottoNumbers);
        if (!matcher.find()) {
            throw new IllegalArgumentException("로또 번호 형식이 올바르지 않습니다.");
        }
    }

    public static void checkDuplicatedBonusNumber(List<Integer> lottoNumbers, int bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨된 로또 번호와 보너스 번호는 일치할 수 없습니다.");
        }
    }

    public static int validLottoNumber(String number) {
        int convertNumber = convertToInt(number);
        checkRangeLottoNumber(convertNumber);
        return convertNumber;
    }

    private static int convertToInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    private static void checkRangeLottoNumber(int number) {
        if (number < MIN_LOTTO_NUMBER || MAX_LOTTO_NUMBER < number) {
            throw new IllegalArgumentException("로또 번호는 1~45 까지만 입력 가능합니다.");
        }
    }

}
