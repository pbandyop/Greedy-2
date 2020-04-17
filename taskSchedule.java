// Time Complexity : O(N), N is tasks length
// Space Complexity : O(1), charcaters are constant in frequencyCount array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//find max frequency and number of times it occurs
//next find the respective values

class Solution {
    public int leastInterval(char[] tasks, int n) {
 
        //base check
        if(tasks == null || tasks.length == 0) return 0;
        
        //initialize
        int maxFrequency = 0, maxOccurance = 0;
        
        //array for scheduling tasks
        int[] frequencyCount = new int[26];
        
        //calculate max frequency and max occurance
        for(char task: tasks){
            frequencyCount[task - 'A']++;
            //System.out.println(task - 'A');
            
            if(frequencyCount[task - 'A'] > maxFrequency){
                maxFrequency = frequencyCount[task - 'A'];
                maxOccurance = 1;
            }else if(frequencyCount[task - 'A'] == maxFrequency){
                maxOccurance++;
            }
            
        }
        System.out.println(maxOccurance);
        
        //A__A__A
        
        int partition = maxFrequency - 1;
        int emptySlots = partition * (n - (maxOccurance - 1));
        int remainingTasks = tasks.length - (maxFrequency * maxOccurance);
        int idle = Math.max(0, emptySlots - remainingTasks);
        
        return tasks.length + idle;
    }
}
