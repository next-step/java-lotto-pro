package lotto.presentaion;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Strings;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.infrastructure.datashared.UiSharedData;
import lotto.presentation.Screen;
import lotto.presentation.SettingLatestWinLotto;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SettingLatestWinLottoTest {
  private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private static final PrintStream originalOut = System.out;
  private static final InputStream originalIn = System.in;

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

  @DisplayName("지난 주 당첨 번호를 입력하는 화면 테스트")
  @Test
  void input_latestWinLotto() {
    // given
    System.setIn(new ByteArrayInputStream(Strings.join("1, 10, 11, 12, 13, 14").with("\n").getBytes()));

    Screen settingLatestWinLotto = new SettingLatestWinLotto();

    // when
    Assertions.assertThatExceptionOfType(NoSuchElementException.class).isThrownBy(
      () -> {
              settingLatestWinLotto.render();
            }
    );

    // then
    assertThat(outContent.toString().trim()).contains("지난 주 당첨 번호를 입력해 주세요.");
  }

  @DisplayName("지난주 당첨번호 입력화면은 보너스 번호를 입력을 받는다.")
  @Test
  void input_bonusNumber() {
    // given
    System.setIn(new ByteArrayInputStream(Strings.join("1, 10, 11, 12, 13, 14", "7").with("\n").getBytes()));

    Screen settingLatestWinLotto = new SettingLatestWinLotto();

    // when
    settingLatestWinLotto.render();

    // then
    assertThat(outContent.toString().trim()).contains("보너스 볼을 입력해 주세요.");
    assertThat(UiSharedData.getLatestWinLotto()).isEqualTo(Lotto.valueOf("1","10","11","12","13","14"));
    assertThat(UiSharedData.getBonusNumber()).isEqualTo(LottoNumber.valueOf("7"));
  }
}
