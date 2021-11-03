package lotto.domain;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoTicket {
    private static final int LOTTO_NUMBER_SIZE = 6;

    private final Set<LottoNumber> lottoNumbers;

    private LottoTicket(Set<LottoNumber> lottoNumbers) {
        validateSize(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoTicket from(int... lottoNumbers) {
        return new LottoTicket(Arrays.stream(lottoNumbers)
                .mapToObj(LottoNumber::from)
                .collect(Collectors.toSet()));
    }

    private void validateSize(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개의 중복되지 않는 숫자 입니다.");
        }
    }

    public Set<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }
}
