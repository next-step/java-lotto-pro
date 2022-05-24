package lotto.domain;

import calculator.domain.StringSplitter;
import java.util.ArrayList;
import java.util.List;

public class ManualLottos {

    private final Lottos lottos;

    private ManualLottos(int count, Lottos lottos) {
        validate(count, lottos);
        this.lottos = lottos;
    }

    public static ManualLottos of(int count, String[] inputNumbers) {
        List<Lotto> lottos = new ArrayList<>();
        for (int index = 0; index < inputNumbers.length; index++) {
            Lotto lotto = createLotto(StringSplitter.split(inputNumbers[index]));
            lottos.add(lotto);
        }
        return new ManualLottos(count, Lottos.from(lottos));
    }

    public Lottos getLottos() {
        return lottos;
    }

    private static Lotto createLotto(String[] numbers) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (String lottoNumber : numbers) {
            lottoNumbers.add(LottoNumber.from(lottoNumber));
        }
        return new Lotto(lottoNumbers.toArray(new LottoNumber[numbers.length]));
    }

    private static void validate(int lottoSize, Lottos lottos) {
        if (lottoSize != lottos.size()) {
            throw new IllegalArgumentException("입력한 수동으로 구매할 로또 수와 입력한 로또번호 수는 같아야 합니다.");
        }
    }
}
