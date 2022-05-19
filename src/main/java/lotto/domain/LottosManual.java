package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LottosManual {
    private static final String MANUAL_LOTTO_LENGTH_ERROR_MESSAGE = "수동 로또 번호는 7자리의 숫자여야만 합니다.";
    private static final String NUMBER_FORMAT_ERROR_MESSAGE = "번호는 1이상 45이하의 정수만 가능합니다.";
    private static final String NUMBER_FORMAT_ONLY_INTEGER_ERROR_MESSAGE = "번호는 정수만 가능합니다.";
    private static final String MANUAL_LOTTO_NUMBER_DUPLICATE_ERROR_MESSAGE = "수동 로또 번호는 중복이 불가능합니다.";
    private final List<List<Integer>> manualLottos;

    public LottosManual(final List<String> manualLottosString) {
        this.manualLottos = createManualLottos(manualLottosString);
    }

    private List<List<Integer>> createManualLottos(final List<String> manualLottosString) {
        final List<List<Integer>> manualLottos = new ArrayList<>();
        for (final String manualLottoString : manualLottosString) {
            final String[] splittedManualLottos = manualLottoString.split(",");
            checkManualLottoSize(splittedManualLottos);
            final List<Integer> manualLottoNumbers = createManualLottoNumbers(splittedManualLottos);
            checkManualLottoNumbersDuplicated(manualLottoNumbers);
            manualLottos.add(manualLottoNumbers);
        }
        return manualLottos;
    }

    private void checkManualLottoSize(final String[] splittedManualLotto) {
        if (splittedManualLotto.length != Lotto.MANUAL_LOTTO_SIZE) {
            throw new IllegalArgumentException(MANUAL_LOTTO_LENGTH_ERROR_MESSAGE);
        }
    }

    private List<Integer> createManualLottoNumbers(final String[] splittedManualLottos) {
        final List<Integer> manualLottoNumbers = new ArrayList<>();
        for (final String manualLottoNumber : splittedManualLottos) {
            final Integer number = parseInt(manualLottoNumber.trim());
            checkNumberRangeOneToFourtyFive(number);
            manualLottoNumbers.add(number);
        }
        return manualLottoNumbers;
    }

    private Integer parseInt(final String manualLottoNumber) {
        Integer number;
        try {
            number = Integer.parseInt(manualLottoNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ONLY_INTEGER_ERROR_MESSAGE);
        }
        return number;
    }

    private void checkNumberRangeOneToFourtyFive(final Integer number) {
        if (number < Lotto.LOTTO_MIN_NUMBER) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR_MESSAGE);
        }
        if (number > Lotto.LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR_MESSAGE);
        }
    }

    private void checkManualLottoNumbersDuplicated(final List<Integer> manualLottoNumbers) {
        int distinctCount = new HashSet<>(manualLottoNumbers).size();
        if (distinctCount != manualLottoNumbers.size()) {
            throw new IllegalArgumentException(MANUAL_LOTTO_NUMBER_DUPLICATE_ERROR_MESSAGE);
        }
    }

    public List<List<Integer>> getManualLottos() {
        return this.manualLottos;
    }
}
