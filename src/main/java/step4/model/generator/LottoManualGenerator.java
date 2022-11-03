package step4.model.generator;

import step4.constant.ErrorMessageConstant;
import step4.exception.LottoFormatException;
import step4.model.Lotto;
import step4.model.LottoBuyCount;
import step4.model.Lottos;

import java.util.List;
import java.util.stream.Collectors;

public class LottoManualGenerator implements LottoGenerator {

    private final List<String> lottos;

    public LottoManualGenerator(List<String> results, LottoBuyCount lottoBuyCount) {
        if (!lottoBuyCount.isEqualValue(results.size())) {
            throw new LottoFormatException(ErrorMessageConstant.MANUAL_BUY_LOTTO_EQUAL_NOT_SIZE);
        }
        this.lottos = results;
    }

    @Override
    public Lottos createLottos() {
        return new Lottos(lottos.stream().map(Lotto::new).collect(Collectors.toList()));
    }
}
