package hard;

import java.util.Stack;

public class _32LongestValidParentness {
	//push s' index
	//因为push“()”没有任何信息在里面，而push index则可以计算中间的长度
	public int longestValidParentheses(String s) {
		Stack<Integer> stack = new Stack<>();
		int len = s.length();
		for(int i = 0; i < len; i++) {
			if(s.charAt(i) == '(') {
				stack.push(i);
			}else {
				if(stack.isEmpty()) {
					stack.push(i);
				}else if(s.charAt(stack.peek()) == '('){
					stack.pop();
				}else {
					stack.push(i);
				}
			}
		}
		int max = 0;
		int last = len;
		while(!stack.isEmpty()) {
			int cur = stack.pop();
			max = Math.max(max, last-cur-1);
			last = cur;
		}
		max = Math.max(max, last+1-1);
		return max;
	}
	
	
	
	//dp要超时，也是没想到
    public int longestValidParenthesesDP(String s) {
    	int len = s.length();
        if(len < 2) return 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i = 0; i < len-1; i++) {
        	if(s.charAt(i)=='(' && s.charAt(i+1)==')') {
        		dp[i][i+1] = true;
        		i++;
        	}
        }
        for(int size = 4; size <= len; size+=2) {
        	for(int i = 0; i <= len-size; i++) {
        		if(dp[i+1][i+size-2] && s.charAt(i)=='(' && s.charAt(i+size-1)==')'){
        			dp[i][i+size-1] = true;
        			i = i+size-1;
        			continue;
        		}
        		for(int j = 2; j < size; j+=2) {
        			if(dp[i][i+j-1] && dp[i+j][i+size-1]){
        				dp[i][i+size-1] = true;
        				i = i+size-1;
        				break;
        			}
        		}
        	}
        }
        int max = 0;
        for(int i = 0; i < len; i++) {
        	for(int j = i+1; j < len; j++) {
        		if(dp[i][j]) {
        			max = Math.max(max, j-i+1);
        		}
        	}
        }
        return max;
    }
    
    public static void main(String[] args) {
		_32LongestValidParentness a = new _32LongestValidParentness();
		String s = "(()(()()()(()())()(()()))()()())()(((()())((())(()()((()((((())(())()()(())()(()(()(())))))))(()()()))()()))))))(()())))((())())))()(((()(()))())((())))(())(((()()))))())))((()((()()(()))())(()))(())((())()(((()(((()))))()))()()())()()()(()(()(()()()(()(())(())))())()))())(())((())(()((((())((())((())(()()(((()))(()(((())())()(())))(()))))))(()(()(()))())(()()(()(((()()))()(())))(()()(())))))(()(()()())))()()())))))((())(()()(((()(()()))(())))(((()))())())())(((()((()((()())((()))(()()((()(())())(()))()())())))))()(()())))()()))(((()(()))((()((((())((())))((())()()))())()(((()()(((()))))))(((()))()(()(((())(())()()()))))()))()))))()(()))()()()))))()(()))()()(()())))(()))()())(())()())(())()()))(()())))((()())))())))))((()))())()()))))()))(((())(())()))()()((()))(((()))))((()((()))(())(((()))()()()())())())))(()(((())()())(())(((()()((())()))(()()(((())))((()(((()))(((((()(((())())))(())(()()((()(()(())())(((((())((()()))())(()())))()()()(()(((((((())))(()()()()((()(((())())())())))())())())))()((((())(((()()()())()))()()(()(()()))()))(())(()())))))()())()())))()()(())))))))((())()()(((()))()))())))))((()())((()())(((())()())()))(()(()()(((()(())()))()())()()(())()(()))))()))()()))))(())(()()(())((()))(()))((())))))(())))()))(()()(())))())()((())()))((()()(()())()()(()))())(((())()(((()((())()(()()()((()(()())(()())())((((())))())())))(()))(((())((()))))((()()(((())((())()()()))((()())()()())())))))((((()((()())))(())(())()()()(((((())())()()()(())())()((()(()())(((())((((()((()(((()))(()()))())()()(()(()(())))()))())))(()()(()))))))(()()())()()))()(())()(";
		//System.out.println(s.length());
		long before = System.currentTimeMillis();
		System.out.println(a.longestValidParentheses(s));
		long end = System.currentTimeMillis();
		System.out.println(end-before);
	}
}
