package lotto.model.factory;

import java.util.List;
import lotto.model.lotto.Lotto;

public interface ILottoFactory {

    List<Lotto> generateAuto(int lottoCount);

}
