import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Calculator {
    public static void main(String[] args) {
        // 입력: 빼기기능(on/off) + 출력 커스텀 넘버(1,2,3) + 정수,+,-
        //
        // 출력: 결과값이 음수 일시 출력 x
        // 관련 없는 문자가 들어오면 오류를 출력
        // split으로 풀려 했지만
        //integer와 +와 -이외의 것을 기준으로 나누어준다.
        //문제점: 숫자와 +와 -가 연달아 있을시 분간 불가
        ArrayList<String> input = new ArrayList<>();
        inputToArrayList(args, input);
        String filteringInput = filtering(subtractionFunctionFlag(input), input);
        String[] arr = filteringInput.split(" ");
        printResult(printCustomNum(input), filteringInput, calculate(arr));
    }

    // 모든 입력을 한곳으로 모으기 위해 ArrayList에 넣음
    static ArrayList inputToArrayList(String[] args, ArrayList<String> input) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String temp;
        for (String s : args) {
            input.add(s);
        }
        while (true) {
            try {
                temp = br.readLine();
                if (temp == null) {
                    break;
                }
            } catch (IOException e) {
                System.exit(1);
                break;
            }
            st = new StringTokenizer(temp);
            while (st.hasMoreTokens()) {
                input.add(st.nextToken());
            }
        }
        return input;
    }

    //뺴기 기능의 유무
    static boolean subtractionFunctionFlag(ArrayList<String> arr) {
        String s = arr.get(0);
        if (s.equals("on")) {
            return true;
        } else if (s.equals("off")) {
            return false;
        } else {
            System.out.println("SubtractionFunction can choose");
            System.out.println("only \"on\" or \"off\"");
            System.exit(1);
            return false;
        }
    }

    //출력 커스텀 넘버
    public static int printCustomNum(ArrayList<String> arr) {
        String s = arr.get(1);
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

    // 기존 input에서 관련 없는 문자가 있는지 확인
    // 관련 없는 문자가 있다면 오류 출력 후 프로그램 종료
    public static String filtering(boolean subtractionFunctionFlag, ArrayList<String> arr) {
        String input = "";
        String stringTemp;
        String num;
        for (int i = 2; i < arr.size(); i++) {
            num = "";
            for (int j = 0; j < arr.get(i).length(); j++) {
                stringTemp = Character.toString(arr.get(i).charAt(j));
                if (stringTemp.matches("[0-9]") == true) {
                    num += stringTemp;
                } else if (stringTemp.equals("+")) {
                    input += num + " " + stringTemp + " ";
                    num = "";
                } else if (stringTemp.equals("-")) {
                    if (subtractionFunctionFlag == true) {
                        input += num + " " + stringTemp + " ";
                        num = "";
                    } else {
                        System.out.println("Do you want subtractionFunction?");
                        System.out.println("Start again and subtractionFunction turn on!!");
                        System.exit(1);
                    }
                } else if (stringTemp.matches("[\s]")) {
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

    static boolean isDigit(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // +를 만나면 뒷 숫자를 더해주고 -를 만나면 뒷 숫자를 빼줌
    public static int calculate(String[] arr) {
        int result = Integer.parseInt(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].equals("+")) {
                result += Integer.parseInt(arr[i + 1]);
            } else if (arr[i].equals("-")) {
                result -= Integer.parseInt(arr[i + 1]);
            }
        }
        return result;
    }

    static void printResult(int printCustomNum, String input, int result) {
        if (result >= 0) {
            switch (printCustomNum) {
                case 1: {
                    System.out.printf("%d", result);
                }
                case 2: {
                    System.out.printf("정답은 %d입니다.", result);
                }
                case 3: {
                    System.out.printf("%s의 정답은 %d입니다.", input, result);
                }
            }
        } else {
            System.out.println("Result is under 0");
        }
    }

}


