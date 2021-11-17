package lotto.domain;

import lotto.dto.LottoTicketDTO;
import lotto.exception.IllegalLottoNumberSizeException;
import lotto.exception.NumberDuplicationException;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {
    public static final int LOTTO_NUMBER_SIZE = 6;
    public static final int FROM_INDEX = 0;
    public static final int START_INCLUSIVE = 1;
    public static final int END_INCLUSIVE = 45;
    public static final int LOTTO_PRICE = 1000;

    private final List<LottoNumber> lottoNumbers;

    public LottoTicket(List<Integer> lottoNumbers) {
        checkLottoNumberSize(lottoNumbers);
        checkNumberDuplication(lottoNumbers);
        Collections.sort(lottoNumbers);
        this.lottoNumbers = getLottoNumbers(lottoNumbers);
    }

    public static LottoTicket generateRandomLottoTicket() {
        List<Integer> lottoNumbers = IntStream.rangeClosed(START_INCLUSIVE, END_INCLUSIVE)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(lottoNumbers);
        return new LottoTicket(lottoNumbers.subList(FROM_INDEX, LOTTO_NUMBER_SIZE));
    }

    private List<LottoNumber> getLottoNumbers(List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .map(LottoNumber::from)
                .collect(Collectors.toList());
    }

    private void checkNumberDuplication(List<Integer> lottoNumbers) {
        if (new HashSet<>(lottoNumbers).size() < LOTTO_NUMBER_SIZE) {
            throw new NumberDuplicationException();
        }
    }

    private void checkLottoNumberSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalLottoNumberSizeException();
        }
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

    public Prize getPrize(WinningLottoNumbers winningLottoNumbers) {
        int sameNumberCount = 0;
        for (LottoNumber lottoNumber : lottoNumbers) {
            sameNumberCount = increaseSameNumberCount(winningLottoNumbers, sameNumberCount, lottoNumber);
        }
        return Prize.valueOf(sameNumberCount, isBonusNumber(winningLottoNumbers));
    }

    private boolean isBonusNumber(WinningLottoNumbers winningLottoNumbers) {
        return winningLottoNumbers.hasBonusNumber(lottoNumbers);
    }

    private int increaseSameNumberCount(WinningLottoNumbers winningLottoNumbers, int sameNumberCount, LottoNumber lottoNumber) {
        if (winningLottoNumbers.contains(lottoNumber)) {
            sameNumberCount++;
        }
        return sameNumberCount;
    }

    public LottoTicketDTO toDTO() {
        return new LottoTicketDTO(lottoNumbers.stream()
                .map(LottoNumber::toDTO)
                .collect(Collectors.toList()));
    }
}
