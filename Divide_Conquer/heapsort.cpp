#include<bits/stdc++.h>
using namespace std;

void input(int arr[], int s)
{
	for(int i=0; i<s; i++)
		cin>>arr[i];
}

void printArray(int arr[], int s)
{
	cout<<"The sorted array is:"<<endl;
	for(int i=0; i<s; i++)
		cout<<arr[i]<<" ";
	cout<<endl;
}

void heapify(int arr[], int n, int i)
{
	int largest = i;
	int l = 2*i + 1;
	int r = 2*i + 2;

	if(l<n && arr[l] > arr[largest])
		largest = l;

	if(r<n && arr[r] > arr[largest])
		largest = r;

	if(largest != i)
	{
		swap(arr[i], arr[largest]);

		heapify(arr, n, largest);
		
	}

	//printArray(arr, n);
}

void heapSort(int arr[], int n)                       /*void heapSort(int arr[], int n) 
{ 
    // Build heap (rearrange array) 
    for (int i = n / 2 - 1; i >= 0; i--) 
        heapify(arr, n, i); 
  
    // One by one extract an element from heap 
    for (int i=n-1; i>0; i--) 
    { 
        // Move current root to end 
        swap(arr[0], arr[i]); 
  
        // call max heapify on the reduced heap 
        heapify(arr, i, 0); 
    } 
} */
{
	for(int i=n/2 - 1; i>=0; i--)
	{
		heapify(arr, n, i);
	}

	for(int i=(n - 1); i>0; i--)
	{
		swap(arr[0], arr[i]);
		heapify(arr, i, 0);
		//printArray(arr, i);

	}
}

int main()
{
	int size;
	cin>>size;
	int A[size];
	input(A, size);
	heapSort(A, size);
	printArray(A, size);
}