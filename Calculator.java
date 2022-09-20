import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        float value;
        Scanner console = new Scanner(System.in);
        // Считываем первый операнд типа String, проверяем не введено ли 's' или 'c'
        String operand1Str = console.next();
        isSOrC(operand1Str.charAt(0));
        // Переводим строку в число
        float operand1 = Float.parseFloat(operand1Str);
        // Выполняем программу, проверяем не введено ли 's' или 'c'
        while (true) {
            float operand2;
            // Считываем операцию и второй операнд типа String, на случай если хотим ввести 's' или 'c'
            char operation = console.next().charAt(0);
            isSOrC(operation);
            String operand2Str = console.next();
            isSOrC(operand2Str.charAt(0));
            if (operation == '/' && operand2Str.equals("0")) {
                operand2 = checknull(operand2Str);
            } else {
                operand2 = Float.parseFloat(operand2Str);
            }
            value = calcul(operand1, operation, operand2);
            // Создаём строку с ответом
            String result = operand1 + " " + operation + " " + operand2 + " = " + value;
            System.out.println(result);
            // Присваиваем операнду 1 значение результата
            operand1 = value;
            System.out.println(operand1);
        }
    }

    private static float checknull(String operand2Str) {
        float operand2;
            System.out.println("Деление на ноль. Введите опреанд 2");
            Scanner console = new Scanner(System.in);
            operand2Str = console.next();
            isSOrC(operand2Str.charAt(0));
            return operand2 = Float.parseFloat(operand2Str);
    }

    // Метод, который проверяет не введено ли 's' или 'c'
    public static void isSOrC(char chr) {
        switch (chr) {
            case 's':
                System.out.println("Работа окончена");
                System.exit(0);
                break;
            case 'c':
                System.out.println("Начинаем заново. Перезапустите программу");
                System.exit(0);
                break;
        }
    }

    // Метод, в котором реализован выбор операции и её выполнение
    private static float calcul(float operand1, char operation, float operand2) {
        float result = 0;
        switch (operation) {
            case '+':
                result = operand1 + operand2;
                break;
            case '-':
                result = operand1 - operand2;
                break;
            case '*':
                result = operand1 * operand2;
                break;
            case '/':
                result = operand1 / operand2;
                break;
            default:
                System.out.println("Ошибка");
        }
        return result;
    }
}
