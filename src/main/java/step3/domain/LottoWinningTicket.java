package step3.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoWinningTicket extends LottoTicket {

    private LottoNumber bonusNumber;

    // 번호 + 보너스 번호를 입력 받는 티켓
    public LottoWinningTicket(List<LottoNumber> numbers, LottoNumber bonusNumber) {
        super(numbers);
        validate(numbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }

    private void validate(List<LottoNumber> numbers, LottoNumber bonusNumber) {
        if (numbers.stream()
            .map(LottoNumber::getNumber)
            .collect(Collectors.toList())
            .contains(bonusNumber.getNumber())) {
            throw new IllegalArgumentException(
                "[ERROR] not valid bonus number. bonusNumber = " + bonusNumber);
        }
    }
}
