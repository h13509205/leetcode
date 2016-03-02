package medium;

import java.util.ArrayList;
import java.util.List;

public class _320GeneralizedAbbreviation {
    public List<String> generateAbbreviations(String word) {
    	List<String> result = new ArrayList<>();
    	if(word.isEmpty()) {
    		result.add(word);
    		return result;
    	}
    	StringBuffer sb = new StringBuffer();
    	helper(result, word, sb, 0, 0);
    	return result;
    }
    
    public void helper(List<String> result, String word, StringBuffer sb, int idx, int num) {
    	if(idx == word.length()) {
    		result.add(sb.toString());
    	}else{
    		char temp = word.charAt(idx);
    		if(num == 0) {
    			sb.append(temp);
    			helper(result, word, sb, idx+1, 0);
    			sb.deleteCharAt(sb.length()-1);
    			sb.append(1);
    			helper(result, word, sb, idx+1, 1);
    			sb.deleteCharAt(sb.length()-1);
    		}else{
    			sb.append(temp);
    			helper(result, word, sb, idx+1, 0);
    			sb.deleteCharAt(sb.length()-1);
    			
    			sb.delete(sb.length()-String.valueOf(num).length(), sb.length());
    			sb.append(String.valueOf(num+1));
    			helper(result, word, sb, idx+1, num+1);
    			sb.delete(sb.length()-String.valueOf(num+1).length(), sb.length());
    			sb.append(String.valueOf(num));
    		}
    	}
    }
    
    
    public static void main(String[] args) {
		_320GeneralizedAbbreviation a = new _320GeneralizedAbbreviation();
		String word = "word";
		StringBuffer sb = new StringBuffer();
		//sb.append(118);
		sb.delete(0,0);
		System.out.println(a.generateAbbreviations(word));
	}
}
