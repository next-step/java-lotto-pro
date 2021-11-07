package lotto.domain;

import lotto.constant.LottoRank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static lotto.constant.LottoConfig.MAX_COUNT_OF_ONE_LINE;

public class Lotto {
    private final List<LottoNumber> lineOfLottoNumber;

    public Lotto() {
        List<LottoNumber> lottoNumbers = LottoRandomFactory.generateLineOfLottoNumber();

        validateLottoNumbers(lottoNumbers);

        Collections.sort(lottoNumbers);

        this.lineOfLottoNumber = lottoNumbers;
    }

    public Lotto(List<Integer> numbers) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            lottoNumbers.add(new LottoNumber(number));
        }

        validateLottoNumbers(lottoNumbers);

        Collections.sort(lottoNumbers);

        this.lineOfLottoNumber = lottoNumbers;
    }

    private void validateLottoNumbers(List<LottoNumber> lottoNumbers) {
        validateLottoNumberCount(lottoNumbers.size());
        validateNoDuplicatedNumber(lottoNumbers);
    }

    private void validateLottoNumberCount(int size) {
        if (size != MAX_COUNT_OF_ONE_LINE) {
            throw new IllegalArgumentException("반드시 로또 한게임당 번호는 " + MAX_COUNT_OF_ONE_LINE + "개 이어야 합니다.");
        }
    }

    private void validateNoDuplicatedNumber(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> lottoNumberSet = new HashSet<>(lottoNumbers);

        if (lottoNumberSet.size() != MAX_COUNT_OF_ONE_LINE) {
            throw new IllegalArgumentException("반드시 로또 한게임당 번호는 " + MAX_COUNT_OF_ONE_LINE + "개 이어야 합니다.");
        }
    }

    public List<String> getStatus() {
        List<String> lottoStatus = new ArrayList<>();

        for (LottoNumber lottoNumber : lineOfLottoNumber) {
            lottoStatus.add(lottoNumber.getNumberString());
        }

        return lottoStatus;
    }

    public LottoRank checkMatchRank(Lotto lotto) {
        int matchingNumberCount = (int) lineOfLottoNumber.stream()
                .filter(lotto.lineOfLottoNumber::contains)
                .count();

        return LottoRank.findRank(matchingNumberCount);
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
