package hard;

public class _123BestTimeToBuyAndSellStock3 {
	//memory limit exceeded 需要计算的东西太多，可以省略一部分
    public int maxProfit(int[] prices) {
    	if(prices.length<2) return 0;
        int[][] dp = new int[prices.length][prices.length];
        for(int i = 0; i < dp.length-1; i++) {
        	dp[i][i+1] = prices[i+1] - prices[i];
        }
        for(int gap = 2; gap < dp.length; gap++) {
        	for(int start=0; start<dp.length-gap; start++) {
        		dp[start][start+gap] = max(prices[start+gap]-prices[start], dp[start][start+gap-1], dp[start+1][start+gap]);
        	}
        }
        int max = 0;
        for(int mid = 1; mid < dp.length-1; mid++) {
        	max = Math.max(max, dp[0][mid]+dp[mid+1][dp.length-1]);
        }
        return Math.max(max, dp[0][dp.length-1]);
    }
    
    public int max(int... nums) {
    	int max = Integer.MIN_VALUE;
    	for(int num:nums) {
    		max = Math.max(max, num);
    	}
    	return max;
    }
    
    public int maxProfit2(int[] prices) {
    	int len = prices.length;
    	if(len<2) return 0;
    	int[][] dp1 = new int[3][len]; //以i结尾卖出股票的局部最大值ֵ
    	int[][] dp2 = new int[3][len]; //全局最大值
    	dp1[1][1] = prices[1]-prices[0];
    	dp1[2][1] = prices[1]-prices[0];
    	dp2[1][1] = prices[1]-prices[0];
    	dp2[2][1] = prices[1]-prices[0];
    	for(int i=2; i<len; i++) {
    		int money = prices[i]-prices[i-1];
    		dp1[1][i] = Math.max(money, dp1[1][i-1]+money);
    		dp1[2][i] = max(dp1[1][i-1]+money, dp2[1][i-2]+money, dp1[2][i-1]+money);
    		dp2[1][i] = Math.max(dp2[1][i-1], dp1[1][i]);
    		dp2[2][i] = max(dp2[2][i-1], dp1[2][i]);
    	}
    	return max(dp2[2][len-1], 0);
    }
    
    public static void main(String[] args) {
		_123BestTimeToBuyAndSellStock3 a = new _123BestTimeToBuyAndSellStock3();
		int[] prices = new int[]{3,2,6,5,0,3};
		System.out.println(a.maxProfit2(prices));
	}
}
