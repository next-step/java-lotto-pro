package lotto.domain.lottonumber;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.lottonumber.factory.LottoNumberFactory;
import lotto.domain.lottonumber.purchase.Purchase;
import lotto.domain.matcher.count.MatchCount;
import lotto.domain.winningnumber.WinningNumber;

public class LottoNumbers {

    private static final String LINEBREAK = "\n";
    private static final String RESULT_HEADER_TEXT = "개를 구매했습니다." + LINEBREAK;
    private List<LottoNumber> lottoNumbers = new ArrayList<>();

    public LottoNumbers(Purchase purchase, LottoNumberFactory lottoNumberFactory) {
        int lottoNumberCount = purchase.makeLottoNumberCount();
        for (int i = 0; i < lottoNumberCount; i++) {
            lottoNumbers.add(lottoNumberFactory.createLottoNumber());
        }
    }

    public void addManualLottoNumbers(List<String> manualLottoNumbers, LottoNumberFactory lottoNumberFactory) {
        List<LottoNumber> makeManualLottoNumbers = lottoNumberFactory.createManualLottoNumbers(manualLottoNumbers);
        makeManualLottoNumbers.addAll(lottoNumbers);
        lottoNumbers = new ArrayList<>();
        lottoNumbers.addAll(makeManualLottoNumbers);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (LottoNumber lottoNumber : lottoNumbers) {
            result.append(lottoNumber.toString()).append(LINEBREAK);
        }
        return result.toString();
    }

    public List<MatchCount> createMatchCount(WinningNumber winningNumber) {
        return lottoNumbers.stream()
                .map(lottoNumber -> new MatchCount(winningNumber.matchNumber(lottoNumber.createIterator()),
                        winningNumber.isMatchBonus(lottoNumber.createIterator())))
                .collect(Collectors.toList());
    }
}
