import java.util.*;

class MaxMinSumofArray{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : "); int N = sc.nextInt();

        int[] a = new int[N];
        System.out.println("Enter the element of the array one on each line : ")
        for (int i=0;i<N ; i++ ) { 
            a[i] = sc.nextInt();                        
        }         

        Solution s = new Solution(); //creating the object of the class

        System.out.println("The sum of max and min of the array : " + s.findSum(a,N));       
    }    
}

class Solution
{ 
    public static int findSum(int A[],int N) 
    {
        //code here
        if(N == 1) return A[0]+A[0]; // if the array has only one element the max and min is the same element
        
        int max,min; //is array has more than one element
        if(A[0] > A[1]){ //consider max as first element and min as the second element
            max = A[0];
            min = A[1];
        }else{ //consider max as the second element and min as the second element
            max = A[1];
            min = A[0];
        }
        
        if(N == 2){ //if the array size is 2
            return max+min;    
        }
        
        //if the array size is greater than 2
        for(int i=2; i<N; i++){
            if(A[i] > max) //if the element is greater than the current max
                max = A[i];
            else if(A[i] < min) // if the element is smaller than the current min
                min = A[i];
        }
        // System.out.print(max);
        // System.out.print(min);
        return max+min;
    }
}
