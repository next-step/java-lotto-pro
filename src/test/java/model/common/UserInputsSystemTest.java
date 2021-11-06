package model.common;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Collection;
import java.util.Scanner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("사용자 입력들")
class UserInputsSystemTest {

	@Test
	@DisplayName("객체화")
	void instance() {
		assertThatNoException()
			.isThrownBy(() -> UserInputsSystem.of(mock(GuidePrinter.class), mock(Scanner.class), "3"));
	}

	@Test
	@DisplayName("안내 프린터 없이 객체화하면 IllegalArgumentException")
	void instance_nullGuidePrinter_illegalArgumentExceptionThrown() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> UserInputsSystem.of(null, mock(Scanner.class), "3"))
			.withMessage("'guidePrinter' must not be null");
	}

	@Test
	@DisplayName("스캐너 없이 객체화하면 IllegalArgumentException")
	void instance_nullScanner_thrownIllegalArgumentException() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> UserInputsSystem.of(mock(GuidePrinter.class), null, "4"))
			.withMessage("'scanner' must not be null");
	}

	@Test
	@DisplayName("숫자 형태가 아닌 입력 갯수로 객체화 하면 IllegalArgumentException")
	void instance_invalidCount_thrownIllegalArgumentException() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> UserInputsSystem.of(mock(GuidePrinter.class), mock(Scanner.class), ""))
			.withMessageContaining("must be number format");
	}

	@Test
	@DisplayName("입력 갯수를 음수로 객체화 하면 IllegalArgumentException")
	void instance_negativeCount_thrownIllegalArgumentException() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> UserInputsSystem.of(mock(GuidePrinter.class), mock(Scanner.class), "-1"))
			.withMessage("'count' must be more than zero");
	}

	@Test
	@DisplayName("입력 제공")
	void inputs() {
		//given
		Scanner mockScanner = mock(Scanner.class);
		GuidePrinter mockPrinter = mock(GuidePrinter.class);

		String anyString = "anyString";
		when(mockScanner.nextLine())
			.thenReturn(anyString);

		//when
		Collection<String> inputs = UserInputsSystem.of(mockPrinter, mockScanner, "3").inputs();

		//then
		assertAll(
			() -> assertThat(inputs).containsExactly(anyString, anyString, anyString),
			() -> verify(mockPrinter, only()).print()
		);
	}
}
