package step3;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.LottoNumber;
import step3.domain.LottoNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LottoNumberTest {

    @Test
    @DisplayName("1-45 범위에 오는 수만 넣을 수 있습니다. ")
    public void wrongNumber() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new LottoNumber(-1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new LottoNumber(46));
    }

    @Test
    @DisplayName("1-45 범위에서 6자리 추출")
    public void random() {
        Assertions.assertEquals(6, LottoNumbers.getRandomSixNumbers().getLottoNumbers().size());
    }

    @Test
    @DisplayName("수동 6자리 숫자 넣기")
    public void split() {
        List<Integer> comparableList = Arrays.asList(1,2,3,4,5,6);
        LottoNumbers lottoNumbers = LottoNumbers.gainNumbers("1, 2, 3, 4, 5, 6");
        int result = lottoNumbers.getLottoNumbers().stream()
                    .mapToInt(LottoNumber::getLottoNumber)
                    .boxed()
                    .collect(Collectors.toList())
                    .stream()
                    .filter(lotto -> comparableList.stream().noneMatch(Predicate.isEqual(lotto)))
                    .collect(Collectors.toList()).size();
        ;
        Assertions.assertEquals(0, result);
    }
}
