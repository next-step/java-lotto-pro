package lotto.domain;

import java.util.Set;

public class MockNumberGenerator implements LottoNumberGenerator {
    private final Set<LottoNumber> lottoNumbers;

    public MockNumberGenerator(Set<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    @Override
    public Set<LottoNumber> generate() {
        return this.lottoNumbers;
    }
}