package camp.nextstep.edu.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.step3.LottoTest.createLottoNumberList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class IssuedInformationTest {
    private List<Lotto> manualLotto;

    @BeforeEach
    void setUp() {
        manualLotto = Collections.singletonList(new Lotto(createLottoNumberList(new int[]{1, 2, 3, 4, 5, 6})));
    }

    @DisplayName("발급된 모드와 정보를 가진다.")
    @Test
    void createTest() {
        assertThat(new IssuedInformation(IssuedMode.Manual, manualLotto)).isEqualTo(new IssuedInformation(IssuedMode.Manual, manualLotto));
    }

    @DisplayName("잘못된 정보를 입력시 에러를 발생한다.")
    @Test
    void invalidCreateTest() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new IssuedInformation(IssuedMode.Manual,null));
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new IssuedInformation(IssuedMode.Manual, Collections.emptyList()));

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new IssuedInformation(null, manualLotto));
    }

    @DisplayName("출력 테스트")
    @Test
    void printTest() {
        assertThat(new IssuedInformation(IssuedMode.Manual, manualLotto).toString())
                .isEqualTo("수동으로 1장");
        assertThat(new IssuedInformation(IssuedMode.Auto, manualLotto).toString())
                .isEqualTo("자동으로 1개");
    }
}