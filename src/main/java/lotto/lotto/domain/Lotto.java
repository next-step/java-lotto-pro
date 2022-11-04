package lotto.lotto.domain;

import common.vo.Number;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    public static final String DUPLICATE_EXCEPTION_MESSAGE = "중복된 숫자를 입력할 수 없습니다.";
    public static final int LOTTO_SIZE = 6;

    private List<Number> numbers = new ArrayList<>();

    public Lotto(List<Integer> lottoNumbers) {
        validateSize(lottoNumbers);
        for (int lottoNumber : lottoNumbers) {
            add(lottoNumber);
        }
    }

    private void add(int lottoNumber) {
        validateLottoNumbers(lottoNumber);
        this.numbers.add(new Number(lottoNumber));
    }

    private void validateLottoNumbers(int lottoNumber) {
        for (Number number : this.numbers) {
            validateDuplicateNumber(lottoNumber, number);
        }
    }

    public List<Number> getLottos() {
        return this.numbers;
    }

    private void validateSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(LOTTO_SIZE + "개여야합니다.");
        }
    }

    private static void validateDuplicateNumber(int lottoNumber, Number number) {
        if (new Number(lottoNumber).equals(number)) {
            throw new IllegalArgumentException(DUPLICATE_EXCEPTION_MESSAGE);
        }
    }
}
