package lotto.domain;

import static lotto.constant.LottoConstant.LOTTO_LINE_LENGTH;
import static lotto.constant.LottoConstant.SEPARATOR;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import lotto.dto.LottoLineDTO;
import lotto.exception.LottoLineDuplicationException;
import lotto.exception.LottoLineSizeException;

public class LottoLine {

    private static final int DEFAULT_VALUE = 0;
    private final List<LottoNumber> lottoLine;

    public LottoLine(List<Integer> lottoNumbers) {
        validateLottoLine(lottoNumbers);
        this.lottoLine = toLottoLine(lottoNumbers);
    }

    public LottoLine(final String inputs) {
        List<Integer> numbers = Arrays.stream(inputs.split(SEPARATOR))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
        validateLottoLine(numbers);
        this.lottoLine = toLottoLine(numbers);
    }

    private void validateLottoLine(List<Integer> lottoNumbers) {
        validateLottoLineSize(lottoNumbers);
        validateLottoLineDuplication(lottoNumbers);
    }

    private void validateLottoLineSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_LINE_LENGTH) {
            throw new LottoLineSizeException();
        }
    }

    private void validateLottoLineDuplication(List<Integer> lottoNumbers) {
        if (new HashSet<>(lottoNumbers).size() != LOTTO_LINE_LENGTH) {
            throw new LottoLineDuplicationException();
        }
    }

    private List<LottoNumber> toLottoLine(List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
            .map(LottoNumber::from)
            .collect(Collectors.toList());
    }

    public LottoRank getMatchCount(LottoLine compareLottoLine, LottoNumber bonusNumber) {
        int matchCount = DEFAULT_VALUE;
        for (LottoNumber lottoNumber : lottoLine) {
            matchCount = calculateMatchCount(compareLottoLine, matchCount, lottoNumber);
        }
        return LottoRank.findMatch(matchCount, hasBonusNumber(bonusNumber));
    }

    private int calculateMatchCount(LottoLine compareLottoLine, int matchCount,
        LottoNumber lottoNumber) {
        if (compareLottoLine.contains(lottoNumber)) {
            matchCount++;
        }
        return matchCount;
    }

    private boolean contains(LottoNumber lottoNumber) {
        return lottoLine.contains(lottoNumber);
    }

    public boolean hasBonusNumber(LottoNumber bonusNumber) {
        return lottoLine.contains(bonusNumber);
    }

    public LottoLineDTO toLottoLineDTO() {
        return new LottoLineDTO(lottoLine.stream()
            .map(LottoNumber::toLottoNumberDTO)
            .collect(Collectors
                .toList()));
    }

    @Override
    public String toString() {
        return lottoLine.toString();
    }
}
