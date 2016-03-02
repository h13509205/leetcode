package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class _249GroupShiftedStrings {
	public char[] alphabet = {'a', 'b', 'c','d', 'e', 'f', 'g', 'h', 'i',
			'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
			'u', 'v', 'w', 'x', 'y', 'z'};
    public List<List<String>> groupStrings(String[] strings) {
    	List<List<String>> result = new ArrayList<>();
    	HashMap<String, List<String>> map = new HashMap<>();
    	for(int i = 0; i < strings.length; i++) {
    		String start = getStart(strings[i]);
    		if(map.containsKey(start)) {
    			map.get(start).add(strings[i]);
    		}else{
    			List<String> list = new ArrayList<>();
    			list.add(strings[i]);
    			map.put(start, list);
    		}
    	}
    	//居然还要排序过后才能通过，不知道为什么
    	for(String key : map.keySet()) {
    		List<String> list = map.get(key);
            Collections.sort(list);
            result.add(list);
    		//result.add(map.get(key));
    	}
    	return result;
    }
    
    public String getStart(String s) {
    	StringBuffer sb = new StringBuffer();
    	sb.append('a');
    	int cur = 0;
    	for(int i = 0; i < s.length()-1; i++) {
    		cur = cur - s.charAt(i) + s.charAt(i+1);
    		if(cur < 0) {
    			cur = cur + 26;
    		}else if(cur >= 26) {
    			cur = cur - 26;
    		}
    		sb.append(alphabet[cur]);
    	}
    	return sb.toString();   	
    }
    
    public static void main(String[] args) {
		_249GroupShiftedStrings a = new _249GroupShiftedStrings();
		String[] strings = {"fpbnsbrkbcyzdmmmoisaa",
		                     "cpjtwqcdwbldwwrryuclcngw",
		                     "a",
		                     "fnuqwejouqzrif",
		                     "js",
		                     "qcpr",
		                     "zghmdiaqmfelr",
		                     "iedda",
		                     "l",
		                     "dgwlvcyubde",
		                     "lpt",
		                     "qzq",
		                     "zkddvitlk",
		                     "xbogegswmad",
		                     "mkndeyrh",
		                     "llofdjckor",
		                     "lebzshcb",
		                     "firomjjlidqpsdeqyn",
		                     "dclpiqbypjpfafukqmjnjg",
		                     "lbpabjpcmkyivbtgdwhzlxa",
		                     "wmalmuanxvjtgmerohskwil",
		                     "yxgkdlwtkekavapflheieb",
		                     "oraxvssurmzybmnzhw",
		                     "ohecvkfe",
		                     "kknecibjnq",
		                     "wuxnoibr",
		                     "gkxpnpbfvjm",
		                     "lwpphufxw",
		                     "sbs",
		                     "txb",
		                     "ilbqahdzgij",
		                     "i",
		                     "zvuur",
		                     "yfglchzpledkq",
		                     "eqdf",
		                     "nw",
		                     "aiplrzejplumda",
		                     "d",
		                     "huoybvhibgqibbwwdzhqhslb",
		                     "rbnzendwnoklpyyyauemm"};
		String b = "rbnzendwnoklpyyyauemm";
		String c = "rbnzendwnoklpyyyauemm";
		System.out.println(b == c);
		System.out.println(a.groupStrings(strings));
	}
}
