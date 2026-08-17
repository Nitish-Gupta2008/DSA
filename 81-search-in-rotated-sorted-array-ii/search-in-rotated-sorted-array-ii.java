class Solution {
    public boolean search(int[] nums, int target) {
        int pivot=findPivotWithoutDuplicates(nums);

        // if pivote doesnt exist
        if(pivot == -1){
            return binarySearch(nums,target,0,nums.length-1);
        }
        // if ther piote exists
        if(nums[pivot]==target){
            return true;
        }
        // to see on which side of the arr it exist;
        if(target>=nums[0]){
            return binarySearch(nums,target,0,pivot-1);
        }
        // else of the right side of the arr
        return binarySearch(nums,target,pivot+1,nums.length-1);
    }
    // to find the pivot withoutduplicates;
    int findPivotWithoutDuplicates(int[] nums){
        int start=0;
        int end=nums.length-1;
        
        while(start<=end){
            int mid=start+(end-start)/2;

            if(mid<end && nums[mid]>nums[mid+1]){
                return mid;
            }
            if(mid>start && nums[mid]<nums[mid-1]){
                return mid-1;
            }
            // 3rd case if the 1st element mid element and the last element are equal to each other we have to skip the dupllicates number;

            if(nums[start]==nums[mid] && nums[mid]==nums[end]){
                // to see if the starting or the ending elemnts are the pivot

                // for starting element
                if(start<end && nums[start]>nums[start+1]){
                    return start;
                }
                start++;

                if(end>start && nums[end]<nums[end-1]){
                    return end-1;
                }
                end--;
                // case 4. the left side of arr is sorted so the pivot must be on the right side of the arr
            }else if(nums[start]<nums[mid] || nums[start]==nums[mid] && nums[mid]>nums[end]){
                    start=mid+1;
                }else{

                end=mid-1;
                }
            
        }
            return -1;
        }
        // use bianrysearch 
        
        boolean binarySearch(int[] nums, int target, int start, int end){
            while(start<=end){
                int mid=start+(end-start)/2;

                if(target>nums[mid]){
                    start=mid+1;
                }else if(target<nums[mid]){
                    end=mid-1;
                }else{
                
                
                return true;
                }
                    
            }
        return false;
        }
}
    