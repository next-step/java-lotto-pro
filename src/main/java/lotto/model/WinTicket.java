package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class WinTicket extends LottoTicket {
    private final LottoNumber bonusNumber;

    private WinTicket(List<LottoNumber> numbers, LottoNumber bonusNumber) {
        super(numbers);
        this.bonusNumber = bonusNumber;
    }

    public static WinTicket of(List<Integer> numbers, Integer bonusNumber) {
        final List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            lottoNumbers.add(new LottoNumber(number));
        }
        final LottoNumber bonusLottoNumber = new LottoNumber(bonusNumber);
        return new WinTicket(lottoNumbers, bonusLottoNumber);
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
