package camp.nextstep.edu.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.step3.LottoTest.createLottoNumberList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class IssuedHistoryTest {
    private final List<Lotto> printList = new ArrayList<Lotto>() {{
        add(new Lotto(createLottoNumberList(new int[]{1, 2, 3, 4, 5, 6})));
        add(new Lotto(createLottoNumberList(new int[]{1, 2, 3, 4, 5, 7})));
        add(new Lotto(createLottoNumberList(new int[]{1, 2, 3, 9, 10, 11})));
    }};

    List<IssuedInformation> issuedInformationList = Arrays.asList(
            new IssuedInformation(IssuedMode.Auto, printList),
            new IssuedInformation(IssuedMode.Manual, printList)
    );

    @DisplayName("IssuedInformation 정보들을 입력받는다.")
    @Test
    void createTest() {

        assertThat(new IssuedHistory(issuedInformationList)).isEqualTo(new IssuedHistory(Arrays.asList(
                new IssuedInformation(IssuedMode.Auto, printList),
                new IssuedInformation(IssuedMode.Manual, printList)
        )));
    }

    @DisplayName("잘못된 인자값을 입력시 에러를 발생한다.")
    @Test
    void invalidCreateTest()  {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new IssuedHistory(null));

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new IssuedHistory(Collections.emptyList()));
    }

    @DisplayName("출력테스트")
    @Test
    void printTest() {
        assertThat(new IssuedHistory(issuedInformationList).toString()).isEqualTo("수동으로 3장, 자동으로 3개를 구매했습니다.");
    }
}
