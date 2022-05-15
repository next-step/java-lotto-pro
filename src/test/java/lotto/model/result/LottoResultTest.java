package lotto.model.result;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lotto.model.money.Money;
import lotto.model.number.LottoNumber;
import lotto.model.number.LottoNumbers;
import lotto.model.purchased.PurchasedLotto;
import lotto.type.LottoGeneratorType;
import lotto.type.LottoWinningPriceType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    @Test
    @DisplayName("로또 수익률을 검증한다.")
    void 로또의_결과값을_출력() {
        Map<LottoWinningPriceType, List<PurchasedLotto>> lottoWinningPriceTypeListMap = new HashMap<>();
        lottoWinningPriceTypeListMap.put(LottoWinningPriceType.THREE,
            generatePurchasedLotto(new int[]{1, 2, 3, 4, 5, 6}));
        lottoWinningPriceTypeListMap.put(LottoWinningPriceType.FOUR,
            generatePurchasedLotto(new int[]{5, 9, 38, 41, 43, 44}));

        LottoResult lottoResult = new LottoResult(lottoWinningPriceTypeListMap, new Money(100_000));

        assertEquals(lottoResult.getWinningRate(), 0.55);
    }

    private List<PurchasedLotto> generatePurchasedLotto(int[] numbers) {
        List<PurchasedLotto> purchasedLottos = new ArrayList<>();
        Set<LottoNumber> lottoNumberList = generateLottoNumberList(numbers);

        purchasedLottos.add(
            new PurchasedLotto(LottoNumbers.fromLottoNumberSet(lottoNumberList), LottoGeneratorType.AUTO));
        return purchasedLottos;
    }

    private Set<LottoNumber> generateLottoNumberList(int[] numbers) {
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        for (int number : numbers) {
            lottoNumbers.add(new LottoNumber(number));
        }
        return lottoNumbers;
    }

}
