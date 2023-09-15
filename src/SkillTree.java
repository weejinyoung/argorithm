import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SkillTree {
    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_trees = {"C", "D", "CB", "BDA"};
        int answer = skill_trees.length;

        for (String skill_tree : skill_trees) {
            Queue<String> skill_queue = new LinkedList<>(List.of(skill.split("")));
            for (String skill_tree_char : skill_tree.split("")) {
                if (skill_queue.contains(skill_tree_char)) {
                    if (skill_queue.peek().equals(skill_tree_char)) {
                        skill_queue.poll();
                    } else {
                        answer--;
                        break;
                    }
                }
            }
        }

        System.out.println(answer);


    }
}

