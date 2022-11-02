package step3.domain.generator;

import step3.domain.lotto.LottoNumber;

import java.util.List;

public interface LottoFactory {

    List<LottoNumber> create();

}
