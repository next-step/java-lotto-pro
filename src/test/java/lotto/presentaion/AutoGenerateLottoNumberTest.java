package lotto.presentaion;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.MockedStatic;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.infrastructure.datashared.UiSharedData;
import lotto.presentation.AutoGenerateLottoNumber;
import lotto.presentation.Screen;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AutoGenerateLottoNumberTest {
  private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private static final PrintStream originalOut = System.out;
  private static final InputStream originalIn = System.in;

  private static MockedStatic<UiSharedData> uiSharedData;

  @BeforeAll
  public static void beforeClass() {
    uiSharedData = mockStatic(UiSharedData.class);
  }

  @AfterAll
  public static void afterClass() {
    uiSharedData.close();
  }

  @BeforeEach
  public void setUpStreams() {
    System.setOut(new PrintStream(outContent));
  }

  @AfterEach
  public void restoreStreams() {
    System.setOut(originalOut);
    System.setIn(originalIn);
    System.out.println(outContent.toString().trim());
  }

  @DisplayName("로또 자동생성결과를 출력")
  @Test
  void print_autoGenerateLotto() {
    // given
    Lottos buyLottos = Lottos.valueOf(Lotto.valueOf("1", "3", "4", "11", "13", "14"),
                                      Lotto.valueOf("11", "13", "14", "21", "23", "24"));

    when(UiSharedData.getBuyLottos()).thenReturn(buyLottos);

    Screen autoGenerate = new AutoGenerateLottoNumber();

    // when
    autoGenerate.render();

    // then
    assertThat(outContent.toString().trim()).contains("[1, 3, 4, 11, 13, 14]", "[11, 13, 14, 21, 23, 24]");
  }
}
