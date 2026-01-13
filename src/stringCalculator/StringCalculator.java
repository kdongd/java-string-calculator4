package stringCalculator;

import java.util.Scanner;

public class StringCalculator {

    public static void calculate() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("계산식을 입력하세요(예:2 + 3 * 4 / 5): ");

            String value = scanner.nextLine();
            String[] values = value.split(" ");

            int number = Integer.parseInt(values[0]);

            for (int i = 1; i < values.length; i += 2) {
                Operator operator = Operator.conversion(values[i]);
                int nextNumber = Integer.parseInt(values[i + 1]);

                number = operator.operation(number, nextNumber);
            }
            System.out.println("결과:" + number);
        }
        catch (NumberFormatException e){
            System.out.println("숫자가 아닌 값이 입력되었습니다.");
        }
    }

}
