package lotto.model;

import java.util.List;

public class WinTicket {

    private final LottoTicket lottoTicket;

    private final LottoNumber bonusNumber;

    public WinTicket(LottoTicket lottoTicket, LottoNumber bonusNumber) {
        this.lottoTicket = lottoTicket;
        this.bonusNumber = bonusNumber;
    }

    public static WinTicket of(List<Integer> numbers, int bonusNumber) {
        return new WinTicket(LottoTicket.of(numbers), new LottoNumber(bonusNumber));
    }

    public int calculateNumberOfMatch(LottoTicket lottoTicket) {
        return this.lottoTicket.calculateNumberOfMatch(lottoTicket);
    }

    public boolean matchBonusNumber(List<LottoNumber> numbers) {
        return numbers.contains(bonusNumber);
    }
}
