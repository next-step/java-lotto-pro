package lotto.auto;

import lotto.domain.Shuffleable;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FirstStateTest {
    private FirstState firstState;
    private PrintStream standardOut;
    private OutputStream captor;

    @BeforeEach
    void setUp() {
        firstState = new FirstState(new FirstStateView(), new NothingShuffler());
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @DisplayName("구입할 금액을 묻는다")
    @Test
    void test() {
        firstState.printQuestion(System.out);
        assertThat(captor.toString().trim()).isEqualTo("구입금액을 입력해 주세요.");
    }

    @DisplayName("구입금액을 입력 받고 결과를 출력한다")
    @Test
    void testAnswer() {
        assertThat(firstState.getResult("2000")).containsExactly("[1, 2, 3, 4, 5, 6]", "[1, 2, 3, 4, 5, 6]");
    }

    static class NothingShuffler implements Shuffleable {
        @Override
        public <E> void shuffle(List<E> list) {
            // 리스트를 섞지 않는다
        }
    }
}
