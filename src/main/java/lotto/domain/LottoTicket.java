package lotto.domain;

import lotto.message.InputMessage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoTicket {
    public static final int SIZE = 6;
    public static final int PRICE = 1000;

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

        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException(InputMessage.INVALID_LOTTO_UNIQUE);
        }
    }

    private void validateDigits(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != SIZE) {
            throw new IllegalArgumentException(InputMessage.INVALID_LOTTO_DIGITS);
        }
    }

    public int match(LottoTicket target) {
        List<LottoNumber> copyLottoTicket = new ArrayList<>(lottoTicket);
        copyLottoTicket.retainAll(target.lottoTicket);
        return copyLottoTicket.size();
    }

    public List<LottoNumber> getLottoTicket() {
        return new ArrayList<>(lottoTicket);
    }

    public boolean contains(LottoNumber bonusNumber) {
        return lottoTicket.contains(bonusNumber);
    }

    @Override
    public String toString() {
        return "LottoTicket{" +
            "lottoTicket=" + lottoTicket +
            '}';
    }
}
