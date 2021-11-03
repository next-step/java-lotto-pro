package lotto.controller;

import lotto.model.LottoNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;


public class LottoNumberRandomGeneratorTest {

    @DisplayName("[정상] 로또번호_생성_테스트")
    @ParameterizedTest
    @CsvSource(value = {"46:-800:0"}, delimiter = ':')
    void 로또번호_생성_테스트(int lottoNumber) {
        // given
        LottoNumberRandomGenerator lottoNumberRandomGenerator = new LottoNumberRandomGenerator();
        // when
        List<LottoNumber> lottoNumberList = lottoNumberRandomGenerator.getLottoNumberList();
        // then
        Assertions.assertFalse(lottoNumberList.contains(new LottoNumber(lottoNumber)));

    }
}
