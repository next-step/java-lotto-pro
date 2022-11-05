package lotto;

import static lotto.Constant.LOTTO_END_NUMBER;
import static lotto.Constant.LOTTO_NUMBER_SIZE;
import static lotto.Constant.LOTTO_START_NUMBER;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoNumberGenerator {
    private static final List<Integer> lottoNumberKeys = new ArrayList<>();

    static {
        for (int number = LOTTO_START_NUMBER; number <= LOTTO_END_NUMBER; number++) {
            lottoNumberKeys.add(number);
        }
    }

    public List<Integer> autoGenerateNumbers() {
        Collections.shuffle(lottoNumberKeys);
        return lottoNumberKeys.stream()
                .limit(LOTTO_NUMBER_SIZE)
                .collect(Collectors.toList());
    }

    public List<Integer> manualGenerateNumbers() {
        final Scanner scanner = new Scanner(System.in);
        final Spliter spliter = new Spliter();
        Optional<String> inputOptional = Optional.ofNullable(scanner.nextLine());
        String input = inputOptional.orElse("");
        Validate.validateLottoNumber(input);
        Validate.validateLottoNumberCount(input);
        Validate.validateLottoNumberRange(input);
        Validate.validateLottoNumberDuplicate(input);
        return spliter.splitToList(input);
    }
}
