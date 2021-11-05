package lotto.component;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import lotto.infrastructure.component.Label;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LabelTest {
  private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private static final PrintStream originalOut = System.out;

  @BeforeEach
  public void setUpStreams() {
    System.setOut(new PrintStream(outContent));
  }

  @AfterEach
  public void restoreStreams() {
    System.setOut(originalOut);
    System.out.println(outContent.toString().trim());
  }

  @DisplayName("설정된 문구가 화면에 출력된다.")
  @Test
  void render_printText() {
    // given
    Label label = new Label("Label 테스트입니다.");

    // when
    label.render();

    // then
    assertThat(outContent.toString().trim()).contains("Label 테스트입니다.");
  }

  @DisplayName("문구를 변견하여 화면에 출력된다.")
  @Test
  void render_changePrintText() {
    // given
    Label label = new Label("Label 테스트입니다.");

    // when
    label.setPrintText("Label이 변경되었습니다.");
    label.render();

    // then
    assertThat(outContent.toString().trim()).contains("Label이 변경되었습니다.");
  }
}
