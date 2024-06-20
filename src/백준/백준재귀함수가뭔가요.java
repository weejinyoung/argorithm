package 백준;


import java.io.*;

public class 백준재귀함수가뭔가요 {

    private static int N;

    private static final String START_SENTENCE = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.";
    private static final String FIRST_SENTENCE = "\"재귀함수가 뭔가요?\"";
    private static final String SECOND_SENTENCE = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
    private static final String THIRD_SENTENCE = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
    private static final String FOURTH_SENTENCE = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
    private static final String ANSWER_SENTENCE = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";
    private static final String LAST_SENTENCE = "라고 답변하였지.";

    private static void recursion(int n) {
        StringBuilder sb = new StringBuilder();
        for(int i = n; i < N; i++) {
            sb.append("____");
        }
        String underbar = sb.toString();
        System.out.println(underbar + FIRST_SENTENCE);
        if(n == 0) {
            System.out.println(underbar + ANSWER_SENTENCE);
            System.out.println(underbar + LAST_SENTENCE);
            return;
        }
        System.out.println(underbar + SECOND_SENTENCE);
        System.out.println(underbar + THIRD_SENTENCE);
        System.out.println(underbar + FOURTH_SENTENCE);
        recursion(n - 1);
        System.out.println(underbar + LAST_SENTENCE);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        System.out.println(START_SENTENCE);
        recursion(N);
    }
}