package camp.nextstep.edu.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottoPaperTest {
    private final List<Lotto> printList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        printList.add(new Lotto(LottoTest.createLottoNumberList(new int[]{1, 2, 3, 4, 5, 6})));
        printList.add(new Lotto(LottoTest.createLottoNumberList(new int[]{1, 2, 3, 4, 5, 7})));
        printList.add(new Lotto(LottoTest.createLottoNumberList(new int[]{1, 2, 3, 9, 10, 11})));
    }

    @DisplayName("생성시 Lotto[] 를 입력 받는다.")
    @Test
    void createTest() {

        assertThat(new LottoPaper(printList)).isEqualTo(new LottoPaper(printList));
    }

    @DisplayName("생성시 입력값 이 잘못된 경우 RuntimeException 을 던지다.")
    @Test
    void invalidInputTest() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoPaper(Collections.emptyList()));

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoPaper(Collections.emptyList()));
    }

    @DisplayName("당첨번호 인 Lotto 를 입력하고 결과로 Total 를 반환한다.")
    @Test
    void checkAllTest() {
        Lotto result = new Lotto(LottoTest.createLottoNumberList(new int[]{1, 2, 3, 4, 6, 12}));
        assertThat(new LottoPaper(printList).checkAll(result, new LottoNumber(5))).isEqualTo(new LottoResult(Arrays.asList(Hit.FOUR, Hit.FIVE_BONUS, Hit.THREE)));
    }

    @DisplayName("checkAll 메소드 호출시 null 을 입력할수 없다.")
    @Test
    void parameterIsNotNull() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoPaper(printList).checkAll(null, null));

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoPaper(printList).checkAll(new Lotto(LottoTest.createLottoNumberList(new int[]{1, 2, 3, 10, 11, 12})), null));
    }

    @DisplayName("로또를 구매했으면 구매장수를 알수있다.")
    @Test
    void numberOfPurchasesTest() {
        assertThat(new LottoPaper(printList).numberOfPurchases()).isEqualTo(printList.size());
    }
}
