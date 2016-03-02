package hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _282ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<String>();
        helper(result, num, "", target, 0, 0, 0, '#');
        return result;
    }
    
    //少考虑了乘法比加法先算的问题，而且在计算过程中，有很多是重复的计算，就像dp那样
    public HashMap<String, Integer> helper1(String num) {
    	HashMap<String, Integer> map = new HashMap<>();
    	if(num.length()>1 && num.charAt(0)=='0') return map;
    	if(numBiggerThanMax(num)){
    		map.put(num, Integer.valueOf(num));
    	}
    	for(int i = 1; i<num.length(); i++) {
    		HashMap<String, Integer> left = helper1(num.substring(0, i));
    		HashMap<String, Integer> right = helper1(num.substring(i));
    		for(String keyLeft : left.keySet()) {
    			for(String keyRight : right.keySet()) {
    				map.put(keyLeft+"+"+keyRight, Integer.valueOf(left.get(keyLeft))+Integer.valueOf(right.get(keyRight)));
    				map.put(keyLeft+"-"+keyRight, Integer.valueOf(left.get(keyLeft))-Integer.valueOf(right.get(keyRight)));
    				map.put(keyLeft+"*"+keyRight, Integer.valueOf(left.get(keyLeft))*Integer.valueOf(right.get(keyRight)));
    			}
    		}
    	}
    	return map;
    }
    
    public void helper(List<String> result, String num, String path, int target, int idx, long value, long preValue, char preOperator){
    	if(idx == num.length()) {
    		if(target ==value){
    			result.add(path);
    		}
    	}
    	for(int i = idx; i < num.length(); i++) {
    		if(i != idx && num.charAt(idx)=='0') break;
    		long cur = Long.parseLong(num.substring(idx,i+1));
    		if(idx == 0){
    			helper(result, num, path+String.valueOf(cur), target, i+1, cur, cur, '+');
    		}else{
    			helper(result, num, path+"+"+String.valueOf(cur), target, i+1, value+cur, cur, '+');
    			helper(result, num, path+"-"+String.valueOf(cur), target, i+1, value-cur, cur, '-');
    			if(preOperator=='+' || preOperator=='*') {
    				helper(result, num, path+"*"+String.valueOf(cur), target, i+1, value-preValue+preValue*cur, preValue*cur, '+');
    			}else if(preOperator=='-') {
    				helper(result, num, path+"*"+String.valueOf(cur), target, i+1, value+preValue-preValue*cur, preValue*cur, '-');
    			}
    		}
    	}
    }
    
    public boolean numBiggerThanMax(String num) {
    	try{
    		int number = Integer.valueOf(num);
    		return true;
    	}catch(Exception e){
    		return false;
    	}
    }
    
    public static void main(String[] args) {
    	_282ExpressionAddOperators a = new _282ExpressionAddOperators();
    	String num = "3456237490";
    	System.out.println(a.addOperators(num, 9191));
	}
}
