package study.lotto.domain;

import study.lotto.domain.number.LottoNumber;
import study.lotto.domain.order.OrderType;
import study.message.LottoExceptionCode;
import study.util.NumberUtil;

import java.util.*;

public class Lotto {

    private static final int LOTTO_SIZE = 6;
    private final OrderType orderType;

    private final Set<LottoNumber> numbers;

    public Lotto(Set<LottoNumber> lottoNumbers, OrderType orderType) {
        if(lottoNumbers.size() == LOTTO_SIZE) {
            this.numbers = lottoNumbers;
            this.orderType = orderType;
            return;
        }

        throw new IllegalArgumentException(LottoExceptionCode.NOT_MATCH_LOTTO_SIZE.getMessage());
    }

    public LottoStatus drawLots(WinningLotto winningLotto) {
        return LottoStatus.getLottoStatus(
                matchNumbers(winningLotto),
                winningLotto.isMatchBonusBall(this)
        );
    }

    private int matchNumbers(WinningLotto winningLotto) {
        int result = NumberUtil.INIT_ZERO;

        for(LottoNumber lottoNumber : numbers) {
            result += winningLotto.matchNumber(lottoNumber);
        }

        return result;
    }

    public boolean contains(LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    public boolean isManual() {
        return orderType.isManual();
    }

    public boolean isAuto() {
        return orderType.isAuto();
    }

    @Override
    public String toString() {
        List<LottoNumber> lottoNumbers = new ArrayList<>(numbers);
        Collections.sort(lottoNumbers);

        return Arrays.toString(lottoNumbers.toArray());
    }
}
