package view;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.io.PrintStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

@DisplayName("안내 문구 프린터")
class GuidePrinterTest {

	@Test
	@DisplayName("객체화")
	void instance() {
		assertThatNoException()
			.isThrownBy(() -> GuidePrinter.of(mock(PrintStream.class), "guide"));
	}

	@Test
	@DisplayName("프린터 없이 객체화하면 IllegalArgumentException")
	void instance_nullPrinter_thrownIllegalArgumentException() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> GuidePrinter.of(null, "guide"))
			.withMessageContaining("'printer' must not be null");
	}

	@ParameterizedTest(name = "{displayName}[{index}] {1} guide can not be instanced")
	@DisplayName("안내 문구가 없는 상태로 객체화하면 IllegalArgumentException")
	@NullAndEmptySource
	void instance_emptyGuide_thrownIllegalArgumentException(String guide) {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> GuidePrinter.of(mock(PrintStream.class), guide))
			.withMessageContaining("'guide' must not be empty");
	}

	@Test
	@DisplayName("출력")
	void print() {
		//given
		PrintStream mockPrintStream = mock(PrintStream.class);
		String guide = "guide";

		//when
		GuidePrinter.of(mockPrintStream, guide).print();

		//then
		verify(mockPrintStream, only()).println(eq(guide));
	}
}
