package lotto.generator;

import lotto.model.LottoNumbers;
import lotto.model.LottoQuantity;

import java.util.List;

public interface LottoGenerator {
  List<LottoNumbers> generate(LottoQuantity quantity);

}