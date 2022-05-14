package lotto.view;

import static lotto.constants.LottoConstants.LOTTO_PRICE;
import static lotto.constants.LottoErrorMessage.INVALID_INPUT_BONUS_LOTTO_NUMBER;
import static lotto.constants.LottoErrorMessage.INVALID_INPUT_LOTTO_NUMBER;
import static lotto.constants.LottoErrorMessage.INVALID_INPUT_MONEY;
import static lotto.constants.LottoGuideMessage.INPUT_MONEY;
import static lotto.constants.LottoNumberConstants.LOTTO_NUMBER_MAX;
import static lotto.constants.LottoNumberConstants.LOTTO_NUMBER_MIN;
import static lotto.constants.LottoNumberConstants.LOTTO_NUMBER_SIZE;

import calculator.utils.StringToIntegerParser;
import calculator.utils.StringUtils;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.Money;
import lotto.utils.LottoNumberStringSplitter;
import lotto.utils.LottoNumberStringToIntegerParser;

public class LottoInputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_NUMBER_0_TO_9_REG_EXP = "^[0-9]+$";

    public Money inputMoney() {
        System.out.println(INPUT_MONEY);
        String inputMoney = readLine();

        if (!isValidMoney(inputMoney)) {
            System.out.printf((INVALID_INPUT_MONEY) + "%n", inputMoney);
            return inputMoney();
        }

        return convertToMoney(inputMoney);
    }

    private Money convertToMoney(String money) {
        int parseMoney = LottoNumberStringToIntegerParser.parse(money);
        return Money.from(parseMoney);
    }

    public List<Integer> inputLottoNumbers(String inputGuideMessage) {
        String[] splitInputNumbers = LottoNumberStringSplitter.split(readLine());
        if (isValidateSplitInputNumbers(splitInputNumbers)) {
            return LottoNumberStringToIntegerParser.parse(splitInputNumbers);
        }

        System.out.printf((INVALID_INPUT_LOTTO_NUMBER) + "%n", Arrays.asList(splitInputNumbers));
        System.out.println(inputGuideMessage);

        return this.inputLottoNumbers(inputGuideMessage);
    }

    public LottoNumber inputBonusBall(LottoNumbers lastWinningLottoNumbers, String inputGuideMessage) {
        String inputBonusBall = readLine();
        if (isValidateInputBonusBallNumber(lastWinningLottoNumbers, inputBonusBall)) {
            return LottoNumber.from(Integer.parseInt(inputBonusBall));
        }

        System.out.printf((INVALID_INPUT_BONUS_LOTTO_NUMBER) + "%n", inputBonusBall, lastWinningLottoNumbers.toString());
        System.out.println(inputGuideMessage);

        return this.inputBonusBall(lastWinningLottoNumbers, inputGuideMessage);
    }

    private boolean isValidateInputBonusBallNumber(LottoNumbers lastWinningLottoNumbers, String inputBonusBall) {
        return isValidateNumber(inputBonusBall)
            && isValidateLottoNumber(StringToIntegerParser.parseNumber(inputBonusBall))
            && isValidateBonusBallInLastWinningLottoNumbers(lastWinningLottoNumbers, inputBonusBall);
    }

    private boolean isValidateBonusBallInLastWinningLottoNumbers(
        LottoNumbers lastWinningLottoNumbers, String inputBonusBall) {
        return !lastWinningLottoNumbers.contains(inputBonusBall);
    }

    private boolean isValidateSplitInputNumbers(String[] splitInputNumbers) {
        List<String> numbers = Arrays.stream(splitInputNumbers).map(String::trim).collect(Collectors.toList());
        return isValidateNumbers(numbers)
            && isValidateLottoNumbers(numbers)
            && isValidateLottoNumberSize(numbers);
    }

    private boolean isValidateLottoNumberSize(List<String> numbers) {
        Set<String> numbersSet = new HashSet<>(numbers);
        return numbersSet.size() == LOTTO_NUMBER_SIZE;
    }

    private boolean isValidateLottoNumbers(List<String> numbers) {
        return numbers.stream()
            .filter(nonEmptyAndNumberMatch())
            .map(LottoNumberStringToIntegerParser::parse)
            .allMatch(this::isValidateLottoNumber);
    }

    private boolean isValidateLottoNumber(Integer number) {
        return LOTTO_NUMBER_MIN <= number && number <= LOTTO_NUMBER_MAX;
    }

    private Predicate<String> nonEmptyAndNumberMatch() {
        return number -> !StringUtils.isEmpty(number) && number.matches(INPUT_NUMBER_0_TO_9_REG_EXP);
    }

    private boolean isValidateNumber(String number) {
        return number.matches(INPUT_NUMBER_0_TO_9_REG_EXP);
    }

    private boolean isValidateNumbers(List<String> numbers) {
        return numbers.stream()
            .allMatch(number -> number.matches(INPUT_NUMBER_0_TO_9_REG_EXP));
    }

    private boolean isValidMoney(String money) {
        if (StringUtils.isEmpty(money)) {
            return false;
        }

        return money.matches(INPUT_NUMBER_0_TO_9_REG_EXP)
            && Integer.parseInt(money) >= LOTTO_PRICE;
    }

    private String readLine() {
        return scanner.nextLine();
    }
}
