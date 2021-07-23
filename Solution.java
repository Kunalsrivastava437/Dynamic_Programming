/* Duplicate Elements */
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        int[] arr=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    return true;
                }
            }
        }return false;
    }
    public static void main(String[] args){
        Solution abc = new Solution();
        int[] k={0,4,3,6};
        System.out.println(abc.containsDuplicate(k));
    }
}