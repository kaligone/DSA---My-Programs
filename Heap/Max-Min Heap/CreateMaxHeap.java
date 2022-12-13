import java.util.*;

class CreateMaxHeap{
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the size of the array :"); int n = sc.nextInt();

		System.out.println("Enter the element of array one on each line :");
		int[] a = new int[n];
		for(int i=0; i<n; i++){
			a[i] = sc.nextInt();
		}

		buildMaxHeap(a, a.length);
		System.out.print("Max heap : ");
		for (int x : a) {
			System.out.print(x+" ");
		}
	}

	//max heap formatio for each sub tree
	static void heapify(int a[], int N, int i){
		int largest = i; // consider the i index node as the largest currently
		int left = 2*i + 1; // left child of the largest index node
		int right = 2*i + 2; // right child of the smalledt index node
		if(left <=N && a[left] > a[largest]) // check if left child greater than the root i.e largest 
			largest = left; // if left is larger than the root then new larger is left child
		if(right <=N && a[right] > a[largest]) // check if right child greater than the root i.e largest
			largest = right; // if right is larger than the root then new larger is right child

		if(largest != i){ // if the new largest is not the root node itself
			swap(a,i,largest); // swap the new largest and the current root node since its max-heap
			heapify(a, N, largest); // here we recursively call the func for the index of largest
			// where currently the root is swapped and placed
			// so that to check if the subtree below that is satisfying the property of the Max heap
		}
	}

/*
NOTE : Consider fact that the leaf nodes need not to be heapified as they already follow the heap property.
So we have to apply the buildMaxHeap from the last non-leaf node
Leaf node starts from the N/2 ..... N
So the last non-leaf node = N/2 - 1 (Array starts with the zero)

	  0	   	  10
	  		/     \
    1	  30     50   2
	      /   \   /
	3   20  4 35 15     5

Here N=6 (array length)
So first non leaf node = 6/2 -1 = 3-1 = 2

Now if current node is i = 1
Then its 
left = 2*i + 1 = 2*1 + 1 = 3
Right = 2*i + 2 = 2*1 + 2 = 4 

*/
	static void buildMaxHeap(int[] arr, int N){
		int startInd = (N/2)-1;
		for(int i=startInd; i>=0; i--){ // so we repeat the heapify function for all the leaf nodes
			heapify(arr,N-1,i); //main function 
		}
	}

	static void swap(int[] a, int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
