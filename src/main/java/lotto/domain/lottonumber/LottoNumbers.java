package lotto.domain.lottonumber;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.lottonumber.factory.LottoNumberFactoryImpl;
import lotto.domain.lottonumber.purchase.Purchase;
import lotto.domain.winningnumber.WinningNumber;

public class LottoNumbers {

    private static final String LINEBREAK = "\n";
    private static final String RESULT_HEADER_TEXT = "개를 구매했습니다." + LINEBREAK;
    private List<LottoNumber> lottoNumbers = new ArrayList<>();

    public LottoNumbers(Purchase purchase) {
        LottoNumberFactoryImpl lottoNumberFactory = new LottoNumberFactoryImpl();
        int lottoNumberCount = purchase.makeLottoNumberCount();
        for (int i = 0; i < lottoNumberCount; i++) {
            lottoNumbers.add(lottoNumberFactory.createLottoNumber());
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder().append(lottoNumbers.size()).append(RESULT_HEADER_TEXT);
        for (LottoNumber lottoNumber : lottoNumbers) {
            result.append(lottoNumber.toString()).append(LINEBREAK);
        }
        return result.toString();
    }

    public List<Integer> createMatchCount(WinningNumber winningNumber) {
        return lottoNumbers.stream()
                .map(lottoNumber -> winningNumber.matchNumber(lottoNumber.createIterator()))
                .collect(Collectors.toList());
    }
}
