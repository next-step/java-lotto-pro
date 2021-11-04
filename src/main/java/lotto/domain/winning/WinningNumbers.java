package lotto.domain.winning;

import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoTicket;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningNumbers {

    private final LottoTicket winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningNumbers(Set<LottoNumber> winningNumbers, int bonusNumber) {
        validateDuplication(winningNumbers, new LottoNumber(bonusNumber));
        this.winningNumbers = new LottoTicket(winningNumbers);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        this(winningNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toSet()), bonusNumber);
    }

    private void validateDuplication(Set<LottoNumber> winningNumbers, LottoNumber bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호가 당첨 번호와 중복됩니다.");
        }
    }

    public int matchCount(Set<LottoNumber> lottoNumbers) {
        return (int) lottoNumbers.stream()
                .filter(winningNumbers::isContains)
                .count();
    }

    public boolean isMatchBonus(Set<LottoNumber> lottoNumbers) {
        return lottoNumbers.stream()
                .anyMatch(lottoNumber -> lottoNumber.getLottoNumber() == bonusNumber.getLottoNumber());
    }

    public Set<LottoNumber> getWinningNumbers() {
        return Collections.unmodifiableSet(winningNumbers.getLottoNumbers());
    }
}
