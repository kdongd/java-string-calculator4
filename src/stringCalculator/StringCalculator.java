package stringCalculator;

import java.util.Scanner;

public class StringCalculator {

    private int result;

    public String input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("계산식을 입력하세요(예:2 + 3 * 4 / 5): ");
        return scanner.nextLine();
    }

    public String[] splitFormula(String formula) {
        return formula.split(" ");
    }

    public void calculate(String[] values) {
        try {
            int number = Integer.parseInt(values[0]);

            for (int i = 1; i < values.length; i += 2) {
                Operator operator = Operator.conversion(values[i]);
                int nextNumber = Integer.parseInt(values[i + 1]);

                number = operator.operation(number, nextNumber);
            }

            this.result = number;

        } catch (NumberFormatException e) {
            System.out.println("숫자가 아닌 값이 입력되었습니다.");
            this.result = 0; // 오류 시 기본값 반환
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("잘못된 계산식입니다. 연산자와 숫자를 올바르게 입력하세요.");
            this.result = 0;
        } catch (IllegalArgumentException e) {
            System.out.println("지원하지 않는 연산자가 있습니다.");
            this.result = 0;
        }
    }

    public void output() {
        System.out.println("결과: " + result);
    }

    public void run() {
        String formula = input(); //입력
        String[] values = splitFormula(formula); //분리
        calculate(values); //계산
        output(); //출력
    }
}


