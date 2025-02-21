package main

import (
	recursion "algorithm/Recursion"
	slidingwindow "algorithm/SlidingWindow"
	"algorithm/sorting"
	"fmt"
)

func main() {
	recursion.Example1(3)

	/* for i := 0; i < 10; i++ {
		 recursion.Pow(i, 2)
		 recursion.Fibonacci(i)
	} */

	arr := []int{1, 3, 2, 5, 4}
	sorting.SelectionSort(arr)
	fmt.Println("SelectionSort: ", arr)

	arr = []int{1, 3, 2, 5, 4}
	fmt.Println("QuickSort B: ", arr)
	sorting.QuickSort(arr, 0, len(arr)-1)

	fmt.Println("QuickSort: ", arr)

	arr = []int{1, 3, 2, 5, 4}
	sorting.InsertionSort(arr)
	fmt.Println("InsertionSort: ", arr)

	arr = []int{1, 3, 2, 5, 4}
	sorting.BoubleSort(arr)
	fmt.Println("BoubleSort: ", arr)

	fmt.Println("Sliding Window:", slidingwindow.MaximumSubarrayWithK([]int{100, 200, 300, 400}, 2))
}
