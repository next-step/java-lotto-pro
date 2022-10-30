package utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputHandlerTest {

	PrintStream printStream;
	OutputStream outputStream;

	@BeforeEach
	void setup() {
		printStream = System.out;
		outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));
	}

	@Test
	void 잘못된_입력_후_정상값_입력() {
		command("Not a number", "1");
		int inputResult = InputHandler.inputPositiveInteger("TEST PROMPT");

		assertThat(inputResult).isEqualTo(1);
	}

	@Test
	void 음수_입력시_오류() {
		command("-1", "2");
		int inputResult = InputHandler.inputPositiveInteger("TEST PROMPT");
		assertThat(inputResult).isEqualTo(2);
	}

	private void command(String... commands) {
		byte[] buffer = String.join("\n", commands).getBytes();
		System.setIn(new ByteArrayInputStream(buffer));
	}
}
