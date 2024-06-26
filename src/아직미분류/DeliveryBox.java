package 아직미분류;

import java.util.*;

class DeliveryBox {
    public int solution(int[] order) {
        int answer = 0;
        int[] priority = new int[order.length];

        for(int i = 0; i < order.length; i++){
            priority[order[i] - 1] = i;
        }

        Stack<Integer> stack = new Stack<>();

        int target = 0;

        for(int i = 0; i < priority.length; i++){
            if(priority[i] == target){
                target++;
            }else{
                stack.push(priority[i]);
            }
            while(!stack.isEmpty() && stack.peek() == target){
                stack.pop();
                target++;
            }
        }
        return target;
    }
}
