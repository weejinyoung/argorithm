import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class SkillTree {
    public int solution(String skill, String[] skill_trees) {
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
        return answer;
    }
}

