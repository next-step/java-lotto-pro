package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Lotto {

    public static final int MAX_COUNT_OF_ONE_LINE = 6;
    public static final String ERROR_MESSAGE_NUMBER_COUNT = "반드시 로또 한게임당 번호는 %d개 이어야 합니다.";
    public static final String ERROR_MESSAGE_DUPLICATED_NUMBER = "중복 번호가 존재할 수 없습니다.";

    private final List<LottoNumber> lineOfLottoNumber;

    public Lotto(List<LottoNumber> lottoNumbers) {
        validateLottoNumbers(lottoNumbers);

        Collections.sort(lottoNumbers);

        this.lineOfLottoNumber = lottoNumbers;
    }

    public Lotto(LottoFactory lottoFactory) {
        this(lottoFactory.generateLineOfLottoNumber());
    }

    public Lotto(int... numbers) {
        this(convertIntArrayToLottoNumbers(numbers));
    }

    private static List<LottoNumber> convertIntArrayToLottoNumbers(int... numbers) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            lottoNumbers.add(new LottoNumber(number));
        }
        return lottoNumbers;
    }

    private void validateLottoNumbers(List<LottoNumber> lottoNumbers) {
        validateLottoNumberCount(lottoNumbers.size());
        validateNoDuplicatedNumber(lottoNumbers);
    }

    private void validateLottoNumberCount(int size) {
        if (size != MAX_COUNT_OF_ONE_LINE) {
            throw new IllegalArgumentException(String.format(ERROR_MESSAGE_NUMBER_COUNT, MAX_COUNT_OF_ONE_LINE));
        }
    }

    private void validateNoDuplicatedNumber(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> lottoNumberSet = new HashSet<>(lottoNumbers);

        if (lottoNumberSet.size() != MAX_COUNT_OF_ONE_LINE) {
            throw new IllegalArgumentException(ERROR_MESSAGE_DUPLICATED_NUMBER);
        }
    }

    public List<String> getStatus() {
        List<String> lottoStatus = new ArrayList<>();

        for (LottoNumber lottoNumber : lineOfLottoNumber) {
            lottoStatus.add(lottoNumber.getNumberString());
        }

        return lottoStatus;
    }

    public int countMatchingFromLotto(Lotto lotto) {
        return (int) lineOfLottoNumber.stream()
                .filter(lotto.lineOfLottoNumber::contains)
                .count();
    }

    public int countMatchingFromLottoNumber(LottoNumber bonusNumber) {
        return (int) lineOfLottoNumber.stream()
                .filter(bonusNumber::equals)
                .count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lotto)) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lineOfLottoNumber, lotto.lineOfLottoNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lineOfLottoNumber);
    }
}
