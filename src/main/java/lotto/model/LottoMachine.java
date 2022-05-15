package lotto.model;

import static java.util.stream.Collectors.toList;
import static lotto.constants.LottoConstant.LOTTO_PRICE;

import java.util.List;
import java.util.stream.Stream;

public class LottoMachine {
    private final Count count;
    private LottoNumbers lottoNumbers;

    public LottoMachine(String inputMoney) {
        Money money = Money.of(inputMoney);
        validateAmount(money);
        count = calculateCount(money);
    }

    private List<LottoNumber> generateAutomaticLottoNumber(int count) {
        return Stream.generate(LottoNumberGenerator::auto)
                .map(LottoNumber::new)
                .limit(count)
                .collect(toList());
    }

    public void submitManualLottoNumber(List<LottoNumber> manualLottoNumbers) {
        Count manualCount = Count.of(manualLottoNumbers.size());
        validateManualLottoNumberSize(manualCount);
        List<LottoNumber> automaticLottoNumbers = generateAutomaticLottoNumber(this.count.subtract(manualCount));

        this.lottoNumbers = new LottoNumbers(manualLottoNumbers, automaticLottoNumbers);
    }

    private void validateManualLottoNumberSize(Count manualCount) {
        if (this.count.compareTo(manualCount) < 0) {
            throw new IllegalArgumentException("수동 입력 갯수가 구매할 수 있는 횟수보다 큽니다.");
        }
    }

    public LottoNumbers getLottoNumbers() {
        return this.lottoNumbers;
    }

    private void validateAmount(Money money) {
        if (money.compareTo(LOTTO_PRICE) < 0) {
            throw new IllegalArgumentException("로또 한 장의 금액보다 입력한 금액이 적습니다.");
        }
    }

    private Count calculateCount(Money money) {
        return Count.of(money.divide(LOTTO_PRICE));
    }
}
