package lotto;

import java.util.*;

public class Lotto {

    private static final String LOTTO_SIZE_ERROR = "로또 번호의 수는 6개이어야 합니다.";
    private static final String LOTTO_NUMBER_DUPLICATE_ERROR = "로또번호는 중복된 숫자를 가질 수 없습니다.";
    private static final int LOTTO_NUMBER_COUNT = 6;
    private final List<LottoNumber> lottoNumbers;

    private Lotto(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new RuntimeException(LOTTO_SIZE_ERROR);
        }
        Collections.sort(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private static void validateDuplication(List<LottoNumber> lottoNumbers) {
        ifConflictThrows(lottoNumbers);
    }

    private static void ifConflictThrows(List<LottoNumber> lottoNumbers) {
        LinkedList<LottoNumber> validator = new LinkedList<>(lottoNumbers);
        for (int i = 0; i < LOTTO_NUMBER_COUNT; i++) {
            LottoNumber lottoNumber = validator.removeFirst();
            ifConflictThrows(lottoNumber, validator);
            validator.addLast(lottoNumber);
        }
    }

    private static void ifConflictThrows(LottoNumber lottoNumber, LinkedList<LottoNumber> validator) {
        if (validator.contains(lottoNumber)) {
            throw new RuntimeException(LOTTO_NUMBER_DUPLICATE_ERROR);
        }
    }

    public static Lotto valueOf(LottoNumberGenerateStrategy strategy) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < LOTTO_NUMBER_COUNT; i++) {
            lottoNumbers.add(strategy.generate());
        }
        validateDuplication(lottoNumbers);
        return new Lotto(lottoNumbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public String toString() {
        String[] toString = new String[lottoNumbers.size()];
        for (int i = 0; i < toString.length; i++) {
            toString[i] = lottoNumbers.get(i).toString();
        }
        return "[" +
            String.join(",", toString) +
            "]";
    }
}
