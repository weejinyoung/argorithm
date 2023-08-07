import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Stack;

public class Parenthesis {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Stack<String> stack = new Stack<>();
        ArrayList<String> results = new ArrayList<>();

        for(int i = 0; i < n; i++) {

            Boolean isTerminated = false;
            String[] prs = br.readLine().split("");


            for (String pr : prs) {
                if (Objects.equals(pr, "(")) {
                    stack.push(pr);
                } else {
                    if(stack.empty()) {
                        results.add("NO");
                        isTerminated = true;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
            if(!isTerminated) {
                if (stack.empty()) {
                    results.add("YES");
                } else {
                    results.add("NO");
                }
            }
            stack.clear();
        }
        for (String result : results) {
            System.out.println(result);
        }
    }
}
