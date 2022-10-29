package step3.domain.lotto;

import step3.domain.statistics.WinningLottoType;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static step3.domain.lotto.LottoNumber.END_INCLUSIVE;
import static step3.domain.lotto.LottoNumber.START_INCLUSIVE;
import static step3.type.ErrorMessageType.LOTTO_NUMBER_WRONG_SIZE;

public class LottoNumbers {

    public static final int DEFAULT_LOTTO_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers() {
        this.lottoNumbers = createLottoNumbers();
    }

    public LottoNumbers(final List<LottoNumber> lottoNumbers) {
        validateLottoSize(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public WinningLottoType getWinningLottoType(WinningLottoNumbers winningLottoNumbers) {
        int matchCount = match(winningLottoNumbers);
        return WinningLottoType.findByMatchCount(matchCount);
    }

    private int match(WinningLottoNumbers winningLottoNumbers) {
        return (int) winningLottoNumbers.getLottoNumbers().stream()
                .filter(this.lottoNumbers::contains)
                .count();
    }

    private void validateLottoSize(final List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != DEFAULT_LOTTO_SIZE) {
            throw new IllegalArgumentException(LOTTO_NUMBER_WRONG_SIZE.getMessage());
        }
    }

    private List<LottoNumber> createLottoNumbers() {
        return pickNumberInRange().stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private List<Integer> pickNumberInRange() {
        List<Integer> integers = IntStream.range(START_INCLUSIVE, END_INCLUSIVE)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(integers);
        return integers.subList(0, DEFAULT_LOTTO_SIZE);
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        return "LottoNumbers{" +
                "lottoNumbers=" + lottoNumbers +
                '}';
    }
}
