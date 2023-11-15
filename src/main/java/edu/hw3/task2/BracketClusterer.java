package edu.hw3.task2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public final class BracketClusterer {

    private BracketClusterer() {}

    public static List<String> clusterize(String input) {
        if (input == null) {
            return new ArrayList<>();
        }

        List<String> clusters = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        Map<Character, Character> bracketPairs = new HashMap<>();
        bracketPairs.put(')', '(');
        bracketPairs.put(']', '[');
        bracketPairs.put('}', '{');
        bracketPairs.put('>', '<');

        int start = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (bracketPairs.containsValue(c)) {
                stack.push(i);
            } else if (bracketPairs.containsKey(c) && !stack.isEmpty()
                && bracketPairs.get(c) == input.charAt(stack.peek())) {
                stack.pop();
                if (stack.isEmpty()) {
                    clusters.add(input.substring(start, i + 1));
                    start = i + 1;
                }
            }
        }

        return clusters;
    }


    public static String printList(List<String> clusters) {
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (String cluster : clusters) {
            result.append("\"").append(cluster).append("\"").append(", ");
        }
        if (clusters.size() >= 1) {
            result.delete(result.length() - 2, result.length());
        }
        result.append("]");
        return result.toString();
    }

}
