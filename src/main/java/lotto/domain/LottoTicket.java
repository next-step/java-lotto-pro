package lotto.domain;

import lotto.message.InputMessage;

import java.util.*;

import static lotto.domain.LottoNumbers.LOTTO_NUMBERS;

public class LottoTicket {
    public static final int LOTTO_SIZE = 6;

    private final List<LottoNumber> lottoTicket;

    public LottoTicket(List<LottoNumber> lottoTicket) {
        validate(lottoTicket);
        this.lottoTicket = lottoTicket;
    }

    private void validate(List<LottoNumber> lottoNumbers) {
        validateDigits(lottoNumbers);
        validateUnique(lottoNumbers);
    }

    private void validateUnique(List<LottoNumber> lottoNumbers) {
        Set<Integer> numbers = new HashSet<>();
        for (LottoNumber lottoNumber : lottoNumbers) {
            numbers.add(lottoNumber.getLottoNumber());
        }

        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(InputMessage.INVALID_LOTTO_UNIQUE);
        }
    }

    private void validateDigits(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(InputMessage.INVALID_LOTTO_DIGITS);
        }
    }

    public int match(LottoTicket target) {
        List<LottoNumber> copyLottoTicket = new ArrayList<>(lottoTicket);
        copyLottoTicket.retainAll(target.lottoTicket);
        return copyLottoTicket.size();
    }

    public static LottoTicket makeAuto() {
        List<LottoNumber> shuffledNumbers = shuffle();
        List<LottoNumber> autoNumbers = subList(shuffledNumbers);
        Collections.sort(autoNumbers);

        return new LottoTicket(autoNumbers);
    }

    private static List<LottoNumber> shuffle() {
        List<LottoNumber> copyNumbers = new ArrayList<>(LOTTO_NUMBERS);
        Collections.shuffle(copyNumbers);
        return copyNumbers;
    }

    private static List<LottoNumber> subList(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.subList(0, LOTTO_SIZE);
    }

    public List<Integer> matchList(List<LottoTicket> tickets) {
        List<Integer> matchList = new ArrayList<>();
        for (LottoTicket ticket : tickets) {
            matchList.add(match(ticket));
        }
        return matchList;
    }

    public List<LottoNumber> getLottoTicket() {
        return new ArrayList<>(lottoTicket);
    }
}
