import java.util.ArrayList;

public class OurProgramCalculator extends Calculator {
    public static String filtering(ArrayList<String> arr) {
        String input = "";
        String stringTemp;
        String num;

        for (int i = 1; i < arr.size(); i++) {
            num = "";
            for (int j = 0; j < arr.get(i).length(); j++) {
                stringTemp = Character.toString(arr.get(i).charAt(j));
                if (stringTemp.matches("[0-9]") == true) {
                    num += stringTemp;
                } else if (stringTemp.equals("+")) {
                    input += num + " " + stringTemp + " ";
                    num = "";
                } else if (stringTemp.equals("-")) {
                    input += num + " " + stringTemp + " ";
                    num = "";
                }
                else if (stringTemp.matches("[\s]")) {
                    continue;
                } else {
                    System.out.println("Input Error");
                    System.exit(1);
                }
            }
            if (num.length() != 0) {
                input += num;
            } else {
                System.out.println("Input Error");
                System.exit(1);
            }
            ; //마지막 Integer까지 더해줌
        }
        return input;
    }

    public static int printCustomNum(ArrayList<String> arr) {
        String s = arr.get(0);
        switch (s) {
            case "1": {
                return 1;
            }
            case "2": {
                return 2;
            }
            case "3": {
                return 3;
            }
            default: {
                System.out.println("PrintCustomNum can choose");
                System.out.println("only \"1\" or \"2\" or \"3\"");
                System.exit(1);
                return 0;
            }
        }
    }

    public static int calculate(int printCustomNum, String filteringInput, String[] arr) {
        int result;
        result = Integer.parseInt(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].equals("+")) {
                result += Integer.parseInt(arr[i + 1]);
            } else if (arr[i].equals("-")) {
                switch (printCustomNum) {
                    case 1: {
                        System.out.println(0);
                    }
                    case 2: {
                        System.out.printf("지원하지 않는 연산자입니다.");
                    }
                    case 3: {
                        System.out.printf("%s는 지원하지 않는 연산자입니다.", filteringInput);
                    }
                    System.exit(1);
                }
            }
        }
        return result;
    }
}
