import java.util.ArrayList;

public class OurProgram{
    public static void main(String[] args) {
        // 입력: 출력 커스텀 넘버(1,2,3) + 정수,+,-
        // point: 커스텀 넘버 3인 경우 filteringInput이 필요!!
        //        claculate에서 -를 찾게 되면 커스텀 넘버에 맞춰 출력후 프로그램 종료
        // 출력: 커스텀 넘버에 맞춰 출력

        ArrayList<String> input= new ArrayList<>();
        OurProgramCalculator cal = new OurProgramCalculator();
        cal.inputToArrayList(args,input);
        String filteringInput = cal.filtering(input);
        String[] arr = filteringInput.split(" ");
        int result=cal.calculate(cal.printCustomNum(input),filteringInput,arr);
        cal.printResult(cal.printCustomNum(input),filteringInput,result);
    }





}
