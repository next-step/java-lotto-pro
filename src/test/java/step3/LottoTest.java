//package step3;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestInstance;
//import step3.domain.Lotto;
//
//
//public class LottoTest {
//
//    Lotto lotto = new Lotto();
//
//    @BeforeEach
//    void given() {
//        lotto = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
//        lotto.match(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7)), 6);
//    }
//
//    @Test
//    @DisplayName("로또 숫자는 1-45")
//    void 로또_숫자_범위() {
//        lotto.gainAutoNumbers().forEach(ball -> {
//            Assertions.assertTrue(0 < ball && ball <= 45);
//        });
//    }
//
//    @Test
//    @DisplayName("자동 로또 번호와 당첨 번호 비교")
//    void when() {
//        lotto.match(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7)), 6);
//    }
//
//    @AfterAll
//    @DisplayName("자동 로또 번호와 당첨 번호 비교")
//    void then() {
//        Assertions.assertEquals(5, lotto.getMatchCount());
//        Assertions.assertTrue(lotto.hasBonusNumber());
//    }
//
//
//}
