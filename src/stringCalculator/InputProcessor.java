package stringCalculator;

import java.util.Scanner;

public class InputProcessor {
    private final Scanner scanner = new Scanner(System.in);

    public String input() {
        System.out.print("계산식을 입력하세요(예:2 + 3 * 4 / 5): ");
        return scanner.nextLine();
    }
}
