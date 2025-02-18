package main

import (
	recursion "algorithm/Recursion"
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
}
