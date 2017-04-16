package fundamentals.bags_queues_and_stacks;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by patriknygren on 2017-04-03.
 * Ex. 1.3.4
 */
public class Ex_1_3_4 {

    public static void main(String[] args) {
        String input = "[()]{}{[()()]()}";
        Paranthesis paranthesis = new Paranthesis(input);
        StdOut.print(paranthesis.isBalanced());
    }

    static class Paranthesis {
        private final String pars;
        private final Map<Character, Character> surroundingPairs;

        Paranthesis(String pars) {
            this.pars = pars;
            this.surroundingPairs = new HashMap<>();
            surroundingPairs.put(')', '(');
            surroundingPairs.put('}', '{');
            surroundingPairs.put(']', '[');
        }

        public boolean isBalanced() {
            Stack<Character> stack = new Stack<>();
            for (char c : pars.toCharArray()) {
                if (c == '(' || c == '{' || c == '[')
                    stack.push(c);
                else if (c == ')' || c == '}' || c == ']') {
                    if (surroundingPairs.get(c) != stack.pop())
                        return false;
                }
            }
            return true;
        }

    }

}

