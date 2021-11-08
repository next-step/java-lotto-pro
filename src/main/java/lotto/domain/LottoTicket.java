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
    public static final int END_EXCLUSIVE = 46;
    private final List<LottoNumber> lottoNumbers;

    public LottoTicket(List<Integer> lottoNumbers) {
        checkLottoNumberSize(lottoNumbers);
        checkNumberDuplication(lottoNumbers);
        this.lottoNumbers = getLottoNumbers(lottoNumbers);
    }

    public static LottoTicket generateRandomLottoTicket() {
        List<Integer> lottoNumbers = IntStream.range(START_INCLUSIVE, END_EXCLUSIVE).boxed().collect(Collectors.toList());
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

    public int getSameNumberCount(LottoTicket lottoTicket2) {
        int sameNumberCount = 0;
        for (LottoNumber lottoNumber : lottoNumbers) {
            sameNumberCount = increaseSameNumberCount(lottoTicket2, sameNumberCount, lottoNumber);
        }
        return sameNumberCount;
    }

    private int increaseSameNumberCount(LottoTicket lottoTicket2, int sameNumberCount, LottoNumber lottoNumber) {
        if (lottoTicket2.lottoNumbers.contains(lottoNumber)) {
            sameNumberCount++;
        }
        return sameNumberCount;
    }

    public LottoTicketDTO toDTO() {
        return new LottoTicketDTO(lottoNumbers.stream()
                .map(LottoNumber::toDTO)
                .collect(Collectors
                        .toList()));
    }
}
