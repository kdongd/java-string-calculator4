package stringCalculator;


public class StringCalculator {

    private int parseNumber(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다." + e);
        }
    }

    public int calculate(String[] values) {
        try {
        int number = parseNumber(values[0]);

            for (int i = 1; i < values.length; i += 2) {
                Operator operator = Operator.conversion(values[i]);
                int nextNumber = Integer.parseInt(values[i + 1]);

                number = operator.operation(number, nextNumber);
            }
            return number;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("잘못된 계산식입니다. 연산자와 숫자를 올바르게 입력하시오." , e);
        }
    }
}


