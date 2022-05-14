package camp.nextstep.edu.step3;

import java.util.*;

public class Lotto {
    private static final int VALID_SIZE = 6;
    private List<LottoNumber> lottoNumbers = new ArrayList<>();

    public Lotto(List<LottoNumber> lottoNumbers) {
        validationSize(lottoNumbers);
        this.lottoNumbers.addAll(lottoNumbers);
        Collections.sort(this.lottoNumbers);
    }

    private void validationSize(List<LottoNumber> lottoNumbers) {
        if (Objects.isNull(lottoNumbers) || lottoNumbers.size() < VALID_SIZE) {
            throw new IllegalArgumentException("invalid LottoNumbers");
        }
    }

    public Hit checkTo(final Lotto prizeLotto) {
        return Hit.valueOf(prizeLotto.checkBy(this.lottoNumbers));
    }

    private int checkBy(List<LottoNumber> userLottoNumbers) {
        return userLottoNumbers.stream()
                .filter(this.lottoNumbers::contains)
                .toArray().length;
    }


    private void sortedLottoNumbers(final LottoNumber[] lottoNumbers) {
        this.lottoNumbers = Arrays.asList(lottoNumbers);
        Collections.sort(this.lottoNumbers);
    }

    private void validationInputSize(final int inputSize) {
        if (!Objects.equals(VALID_SIZE, inputSize)) {
            throw new IllegalArgumentException("LottoNumberArray invalid size : " + inputSize);
        }
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
        return lottoNumbers.toString();
    }
}
