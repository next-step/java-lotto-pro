package utils;

import java.lang.reflect.Field;
import java.util.Scanner;

public class Console {
	private static Scanner scanner;

	 public static String read() {
	 	return get().nextLine();
	 }

	 public static void close() {
	 	get().close();
	 }

	 private static Scanner get() {
	 	if ( scanner == null || scannerIsClosed()) {
	 		scanner = new Scanner(System.in);
		}
	 	return scanner;
	 }

	 // From NextStep Utils
	 private static boolean scannerIsClosed() {
		 try {
			 Field sourceClosedField = Scanner.class.getDeclaredField("sourceClosed");
			 sourceClosedField.setAccessible(true);
			 return sourceClosedField.getBoolean(scanner);
		 } catch (NoSuchFieldException | IllegalAccessException e) {
			 System.out.println("리플렉션 중 에러 발생");
		 }
		 return true;
	 }
}
