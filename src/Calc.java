import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Calc {


    public static String calc() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите два числа(Римских или Арабских");
        System.out.print("Input: ");
        String input = sc.nextLine();
        System.out.println("Output: "+parse(input));
        return input;
    }

    public static String parse(String input) throws Exception {
        int number1;
        int number2;
        String operation;
        String result;
        Boolean isRoman;
        String inputX=input.replaceAll("[~!@#$%^&()? ]","");
        String[] operands = inputX.split("[+\\-*/]");
        if (operands.length != 2)
            throw new Exception("Фотмат математической операции не удовлетворяет заданию - два операнда и один оператор");
        operation = typeOfOperation(input);
        if (operation == null) throw new Exception("Строка не является математической операцией");
        if (!Roman.isRoman(operands[0]) && !Roman.isRoman(operands[1])) {
            number1 = Integer.parseInt(operands[0]);
            number2 = Integer.parseInt(operands[1]);
            isRoman = false;
        } else if (Roman.isRoman(operands[0]) && Roman.isRoman(operands[1])) {
            number1 = Roman.convertToArab(operands[0]);
            number2 = Roman.convertToArab(operands[1]);
            isRoman = true;
        } else {
            throw new Exception("Используются одновременно разные системы счисления");

        }
        if (number1 > 10 || number1 < 1 || number2 > 10 || number2 < 1) {
            throw new Exception("Ведите числа от 1 до 10");
        }
        int arithmeticOperation = calc(number1, number2, operation);
        if (isRoman) {
            if (arithmeticOperation <= 0) {
                throw new Exception("В римской системе нет отрицательных чисел и 0");
            }
            result = Roman.convertToRoman(arithmeticOperation);
        } else {
            result = String.valueOf(arithmeticOperation);
        }
        return result;
    }


    static String typeOfOperation(String input) {
        String[] operations = new String[]{"+", "-", "*", "/"};
        for (int i = 0; i < operations.length; i++) {
            if (input.contains(operations[i])) {
                return operations[i];
            }
        }
        return null;
    }

    static int calc(int a, int b, String oper) {
switch (oper){
    case "+"-> {return a+b;}
    case "-"-> {return a-b;}
    case "*"-> {return a*b;}
    case "/"-> {return a/b;}
    default -> {return -1;}
}
//        if (oper.equals("+")) return a + b;
//        if (oper.equals("-")) return a - b;
//        if (oper.equals("*")) return a * b;
//        if (oper.equals("/")) return a / b;
//        else return -1;
    }
}



