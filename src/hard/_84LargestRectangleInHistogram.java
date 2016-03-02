package hard;

import java.util.Stack;

public class _84LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
    	int maxArea = 0;
    	Stack<Integer> stack = new Stack<>();
    	for(int i = 0; i <= heights.length; i++) {
    		if(stack.isEmpty() || (i!=heights.length && heights[stack.peek()]<=heights[i])) {
    			stack.push(i);
    		}else{
    			int height = heights[stack.pop()];
    			int len = stack.isEmpty()?i:i-stack.peek()-1;
    			maxArea = Math.max(maxArea, height*len);
    			i--;
    		}
    	}
    	return maxArea;
    }
    
    public static void main(String[] args) {
		_84LargestRectangleInHistogram a = new _84LargestRectangleInHistogram();
		int[] heights = new int[]{1};
		System.out.println(a.largestRectangleArea(heights));
	}
}
