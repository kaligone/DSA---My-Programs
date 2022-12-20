/* Problem defination : Given an array which consists of only 0, 1 and 2. Sort the array without using any sorting algo */

/*********Solution 1 : T.C --> O(nlogn)**************
********Using Heap sort (Brute force method)

public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the size of the array :"); int n = sc.nextInt();
		System.out.println("Enter the element of array one on each line :");
		int[] a = new int[n];
		for(int i=0; i<n; i++){
			a[i] = sc.nextInt();
		}

        buildMaxHeap(a,a.length);
        HeapSortUtil(a,a.length);

        System.out.println("The sorted array is :");
        for(int x: a){
        	System.out.print(" "+x);
        }
	}

 	static void HeapSortUtil(int[]a, int N){
		for(int i=N-1; i>0; i--){ 
			swap(a,i,0); //swap 
			heapify(a,i-1,0);
		}
	}

// building the max heap from the given array
	static void swap(int[] a, int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	static void heapify(int[] a, int N, int i){
		int largest = i;
		int left = 2*i + 1;
		int right = 2*i + 2;

		if(left <=N && a[left] > a[largest])
			largest = left;
		if(right <=N && a[right] > a[largest])
			largest = right;

		if(largest != i){
			swap(a,i,largest);
			heapify(a,N,largest);
		}
	}

	static void buildMaxHeap(int a[],int N){
		int startInd = (N/2) - 1;
		for (int i=startInd;i>=0 ;i--) {
			heapify(a,N-1, i);
		}
	}

*/


/*
Solution 2 : Using priority queue

PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        for(int i=0;i<a.length;i++){

            pq.add(a[i]);

        }
		//elements are removed based on the priority order
		// that is the smallest element will be removed in each remove operation
        for(int i=0;i<a.length;i++){

            a[i]=pq.remove();

}

*/


/**********************Best approach :  T.C = O(N) ****************************/ 

import java.util.*;

class sort_array_with_012{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the size of the array :"); int n = sc.nextInt();
		System.out.println("Enter the element of array one on each line :");
		int[] a = new int[n];
		for(int i=0; i<n; i++){
			a[i] = sc.nextInt();
		}

		sortArray(a,n);
        
        System.out.println("The sorted array is :");
        for(int x: a){
        	System.out.print(" "+x);
        }

	}

	static void swap(int[] a, int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	static void sortArray(int[] a, int N){
		int l = 0; //low
		int m = 0; //mid
		int h = N-1; //high
		while(m <= h){
			if(a[m] == 0){
				swap(a,l,m);
				l++;
				m++;
			}
			else if(a[m] == 1){
				m++;
			}
			else if(a[m] == 2){
				swap(a,m,h);
				h--;
			}
		}
	}
}


/* How it works?
Here we are using three pointers low , mid and high
Initially low=mid = 0, high = n-1
Since we know , all 0's will be at the start of the array
and all 2's will be at the end of the array.

if number == 0, we swap it with the middle and increment low and mid

if number == 1, we just increment the mid

if number == 2, we swap it with the high and decrement the high

this goes till mid is less than or equal to the high

a = 2 0 1 0 2

l = 0
m = 0
h = 4
a[m] == 2
swap(m,h) = swap(0,4)
h = 3
a = 2 0 1 0 2

l = 0
m = 0
h = 3
a[m] == 2
swap(l,m) = swap(0,3)
h = 2
a = 0 0 1 2 2

l = 0
m = 0
h = 3
a[m] == 2
swap(m,h) = swap(0,4)
a = 2 0 1 0 2

.
.

*/
