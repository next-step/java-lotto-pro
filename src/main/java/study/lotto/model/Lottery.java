package study.lotto.model;

import study.lotto.model.exception.IllegalLotterySizeException;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lottery {
    public static final int LOTTO_NUMBER_COUNT = 6;
    private static final String ILLEGAL_LOTTERY_SIZE_ERROR_MESSAGE =
            "로또는 6개의 서로 다른 로또번호를 가지고 있어야 합니다.";

    private final Set<LottoNumber> lottoNumbers = new HashSet<>();

    private Lottery(final Set<Integer> lottoNumbers) {
        validate(lottoNumbers);
        addAll(lottoNumbers);
    }

    private Lottery(final List<Integer> lottoNumbers) {
        this(new HashSet<>(lottoNumbers));
    }

    private void addAll(Set<Integer> lottoNumbers) {
        for (final Integer lottoNumber : lottoNumbers) {
            this.lottoNumbers.add(LottoNumber.valueOf(lottoNumber));
        }
    }

    public static Lottery valueOf(final List<Integer> lottoNumbers) {
        return new Lottery(lottoNumbers);
    }

    public static Lottery valueOf(final Set<Integer> lottoNumbers) {
        return new Lottery(lottoNumbers);
    }


    public boolean contains(final LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

    public boolean containsAll(final Set<LottoNumber> lottoNumbers) {
        return this.lottoNumbers.containsAll(lottoNumbers);
    }

    private void validate(final Set<Integer> lottoNumbers) {
        validateNotNull(lottoNumbers);
        validateSize(lottoNumbers);
    }

    private void validateNotNull(final Set<Integer> lottoNumbers) {
        if (lottoNumbers == null) {
            throw new IllegalLotterySizeException(ILLEGAL_LOTTERY_SIZE_ERROR_MESSAGE);
        }
    }

    private void validateSize(final Set<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalLotterySizeException(ILLEGAL_LOTTERY_SIZE_ERROR_MESSAGE);
        }
    }

    public Set<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableSet(lottoNumbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lottery that = (Lottery) o;

        return lottoNumbers != null ? lottoNumbers.equals(that.lottoNumbers) : that.lottoNumbers == null;
    }

    @Override
    public int hashCode() {
        return lottoNumbers != null ? lottoNumbers.hashCode() : 0;
    }
}