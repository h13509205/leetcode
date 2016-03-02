package easy;

import java.util.HashMap;

public class _246StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('8', '8');
        map.put('6', '9');
        map.put('9', '6');
        for(int i = 0; i < (num.length()+1)/2; i++) {
        	char front = num.charAt(i);
        	char behind = num.charAt(num.length()-1-i);
        	if(!map.containsKey(front) || map.get(front)!=behind) {
        		return false;
        	}
        }
        return true;
    }
    public static void main(String[] args) {
		_246StrobogrammaticNumber a = new _246StrobogrammaticNumber();
		String num = "1";
		System.out.println(a.isStrobogrammatic(num));
	}
}
