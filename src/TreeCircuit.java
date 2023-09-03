import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class TreeCircuit {

    static Map<String, String[]> bTree = new HashMap<>();

    static class BTreeAction {
        void preorderTraversal(String node) {
            if (node.equals(".")) {
                return;
            }
            System.out.print(node);
            preorderTraversal(bTree.get(node)[0]);
            preorderTraversal(bTree.get(node)[1]);
        }

        void inorderTraversal(String node) {
            if (node.equals(".")) {
                return;
            }
            inorderTraversal(bTree.get(node)[0]);
            System.out.print(node);
            inorderTraversal(bTree.get(node)[1]);
        }

        void postorderTraversal(String node) {
            if (node.equals(".")) {
                return;
            }
            postorderTraversal(bTree.get(node)[0]);
            postorderTraversal(bTree.get(node)[1]);
            System.out.print(node);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String parent = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();
            bTree.put(parent, new String[]{left, right});
        }

        BTreeAction bTreeAction = new BTreeAction();
        bTreeAction.preorderTraversal("A");
        System.out.println();
        bTreeAction.inorderTraversal("A");
        System.out.println();
        bTreeAction.postorderTraversal("A");
        System.out.println();
    }

}
