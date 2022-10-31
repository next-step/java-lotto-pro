package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public interface LottoGenerator {

    LottoNumbers generateLottoNumber();

}
