## My Explanation

Consider one complete binary tree represented in array

arr : 10 30 50 20 35 15
Ind : 0  1  2  3  4  5

	0	  10
	  /    \
1	 30		50   2
	/  \	/
  3  20 4 35	15  5

N = 6

--->
startInd = (6/2)- 1 = 3 - 1 = 2 
i = 2
heapify(arr, 5, 2);
largest = 2
left = 2*i + 1 = 2*2 + 1 = 5
left > largest ; arr[5] > arr[2]; 15 > 50 --> No
No change....

--> 
i = 1
heapify(arr, 5, 1)
largest = 1
left = 2*1 + 1 = 3
right = 2*1 + 2 = 4
a[3] > a[1]; 20 > 30 --> No
a[4] > a[1]; 35 > 30 --> Yes
largest = 4
now, 4 != 1
swap(arr,i,largest); swap(arr,1,4);
		10
	  /    \
	 35		50  
	/  \	/
   20  30	15

heapify(arr, 5,4) return nothing since its leaf node

-->
i=0
heapify(arr, 5,0)
largest = 0
left = 2*0 + 1 = 1
right = 2*0 + 2 = 2
a[1] > a[0]; 35 > 10 --> Yes
Largest = 1
a[2] > a[0]; 50 > 10 --> Yes
largest = 2
now, 2 != 1
swap(arr,i,largest); swap(arr,0,2);
		50
	  /    \
	 35		10  
	/  \	/
   20  30	15

heapify(arr,5, 2)
largest = 2
left = 2*2 + 1 = 2*2 + 1 = 5
arr[5] > arr[2]; 15 > 10 --> Yes
largest = 5;
swap(arr,i,largest); swap(arr,2,);
