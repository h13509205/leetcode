package easy;

public class _266PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        int[] alphabet = new int[128];
        for(int i = 0; i < s.length(); i++) {
        	alphabet[s.charAt(i)] = alphabet[s.charAt(i)] ^ 1;
        }
        int result = 0;
        for(int i = 0; i < alphabet.length; i++) {
        	result = result + alphabet[i];
        }
        return result<=1;
    }
    
    public static void main(String[] args) {
		_266PalindromePermutation a = new _266PalindromePermutation();
		String s = "carerac";
		System.out.println(a.canPermutePalindrome(s));
	}
}
