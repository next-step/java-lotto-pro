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

    private final List<LottoNumber> lottoNumbers;
    private LottoNumber bonusNumber;

    public LottoTicket(List<Integer> lottoNumbers) {
        checkLottoNumberSize(lottoNumbers);
        checkNumberDuplication(lottoNumbers);
        this.lottoNumbers = getLottoNumbers(lottoNumbers);
    }

    public LottoTicket(List<Integer> lottoNumbers, int bonusNumber) {
        checkLottoNumberSize(lottoNumbers);
        checkNumberDuplication(lottoNumbers);
        this.lottoNumbers = getLottoNumbers(lottoNumbers);
        this.bonusNumber = LottoNumber.from(bonusNumber);
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

    public Prize getPrize(LottoTicket targetLottoTicket) {
        int sameNumberCount = 0;
        boolean bonusNumber  = false;
        for (LottoNumber lottoNumber : lottoNumbers) {
            sameNumberCount = increaseSameNumberCount(targetLottoTicket, sameNumberCount, lottoNumber);
        }
        bonusNumber = isBonusNumber(targetLottoTicket, bonusNumber);
        return Prize.valueOf(sameNumberCount, bonusNumber);
    }

    private boolean isBonusNumber(LottoTicket targetLottoTicket, boolean bonusNumber) {
        if (lottoNumbers.contains(targetLottoTicket.bonusNumber)) {
            bonusNumber = true;
        }
        return bonusNumber;
    }

    private int increaseSameNumberCount(LottoTicket targetLottoTicket, int sameNumberCount, LottoNumber lottoNumber) {
        if (targetLottoTicket.contains(lottoNumber)) {
            sameNumberCount++;
        }
        return sameNumberCount;
    }

    private boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public LottoTicketDTO toDTO() {
        return new LottoTicketDTO(lottoNumbers.stream()
                .map(LottoNumber::toDTO)
                .collect(Collectors.toList()));
    }
}
