// Time Complexity : O(N), one pass each time
// Space Complexity : O(N), result array equivalent to input length
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//do a front pass to calculate the greater rating on left side
//do a back pass to calculate the greater rating on right side
	//take the min of current value and result[i] + 1 value if result[i+1] is greater
//calculate the sum of result array


class Solution {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0) return 0;
        
        int n = ratings.length;
        int[] result = new int[n];
        Arrays.fill(result, 1);
        
        int sum = 0;
        
        //left pass to check lower rating on left side
        for(int i=0; i<n-1; i++){
            if(ratings[i+1]>ratings[i]){
                result[i+1] = 1 + result[i];
            }
        }
        
        //right pass to check greater rating on right side
        for(int i=n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                result[i] = Math.max(result[i], 1 + result[i+1]);
            }
        }
        
        for(int i=0; i<n; i++)
            sum += result[i];
        
        return sum;
    }
}
