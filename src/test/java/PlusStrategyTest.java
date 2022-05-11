import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import domain.EmptyPlusStrategy;
import domain.PlusStrategy;
import domain.PlusStrategyFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("더하기 식에 대한 테스트 코드")
class PlusStrategyTest {
    private PlusStrategyFactory factory;

    @BeforeEach
    void setUp() {
        factory = new PlusStrategyFactory();
    }

    @Test
    @DisplayName("팩토리 클래스에 공백을 전달하면 EmptyPlusStrategy 를 반환해야 한다")
    void blank_test() {
        String given = "";
        PlusStrategy plusStrategy = factory.getStrategy(given);

        assertTrue(plusStrategy instanceof EmptyPlusStrategy);
        assertThat(plusStrategy.result(given)).isEqualTo(0);
    }

    @Test
    @DisplayName("팩토리 클래스에 null을 전달하면 EmptyPlusStrategy 를 반환하고 결과는 0이어야 한다")
    void null_test() {
        String given = null;
        PlusStrategy plusStrategy = factory.getStrategy(given);

        assertTrue(plusStrategy instanceof EmptyPlusStrategy);
        assertThat(plusStrategy.result(given)).isEqualTo(0);
    }

}
