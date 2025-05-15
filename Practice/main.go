package main

import (
	"fmt"
	basic "practice/Basic"
)

func main() {
	fmt.Println("Hello World")

	arr1 := []int{1, 2, 5, 1, 9, 10, 0}
	resInt := basic.MaxNumber(arr1)
	fmt.Println("Max in Arr: ", resInt)

	// arr1 = []int{1, 2, 4, 12, 23}

	resInt = basic.SecondLargestNumber(arr1)
	fmt.Println("SecondMax in Arr: ", resInt)

	resInt = basic.NthLargestNumber(arr1, 4)
	fmt.Println("NthMaxNumber: ", resInt)

	str := "#aba  **)(ba&"
	resBool := basic.IsPalindrome(str)

	fmt.Println("IsPalindrome: ", resBool)

	arr1 = []int{0, 3, 1}
	resInt = basic.FindMissingNumber(arr1)

	fmt.Println("FindMissingNumber: ", resInt)

	arr1 = []int{1, 2}
	resInt = basic.FindMissingNumber(arr1)

	fmt.Println("FindMissingNumber: ", resInt)
}
