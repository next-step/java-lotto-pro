package step3.component;

import java.util.ArrayList;
import java.util.List;
import step3.domain.Lotto;
import step3.domain.LottoNumber;
import util.NumberUtils;

public class StringSplitLottoGenerator implements LottoGeneratorable {

    private static final String DELIMITER = ",";

    @Override
    public Lotto generate(String numbers) {
        final List<LottoNumber> lottoNumbers = new ArrayList<>();

        for (final String number : numbers.split(DELIMITER)) {
            lottoNumbers.add(new LottoNumber(NumberUtils.parseInt(number.replace(" ", ""))));
        }

        return new Lotto(lottoNumbers);
    }
}
