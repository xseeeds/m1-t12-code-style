import java.util.ArrayDeque;
import java.util.Deque;

public class ReversePolishNotationCalculator {
    public int calculatePolishNotation(String str) {
        String[] parts = str.split(" ");
        Deque<Integer> numbers = new ArrayDeque<>();
        int index = 0;
        while (index != parts.length) {
            if (parts[index].isBlank()) {
                index++;
                continue;
            }
            if (isOperation(parts[index])) {
                int operandOne = numbers.pop();
                int operandTwo = numbers.pop();
                switch (parts[index]) {
                    case "+" -> numbers.push(operandOne + operandTwo);
                    case "-" -> numbers.push(operandTwo - operandOne);
                    case "*" -> numbers.push(operandOne * operandTwo);
                }
            } else {
                numbers.push(Integer.parseInt(parts[index]));
            }
            index++;
        }
        return numbers.pop();
    }

    private boolean isOperation(String part) {
        return part.equals("+") || part.equals("-") || part.equals("*");
    }
}
