package sorting

// QuickSort sorts an array of integers using the quicksort algorithm.
// It is a recursive function that partitions the array into two halves
// around a pivot element, and then sorts each half.
//
// Parameters:
//   - array: The slice of integers to be sorted.
//   - lowIndex: The starting index of the portion of the array to be sorted.
//   - highIndex: The ending index of the portion of the array to be sorted.
//
// The function does not return any value as it sorts the array in place.
func QuickSort(array []int, lowIndex int, highIndex int) {

	if lowIndex >= highIndex {
		return
	}

	leftPointer := lowIndex
	rightPointer := highIndex

	for leftPointer < rightPointer {

		pivot := array[highIndex]

		for array[leftPointer] <= pivot && leftPointer < rightPointer {
			leftPointer++
		}

		for array[rightPointer] >= pivot && leftPointer < rightPointer {
			rightPointer--
		}

		swap(array, leftPointer, rightPointer)

	}

	swap(array, leftPointer, highIndex)

	QuickSort(array, lowIndex, leftPointer-1)
	QuickSort(array, leftPointer+1, highIndex)

}

// swap exchanges the elements at the specified indices in the given slice.
// Parameters:
// - arr: The slice of integers where the elements will be swapped.
// - index1: The index of the first element to be swapped.
// - index2: The index of the second element to be swapped.
func swap(arr []int, index1 int, index2 int) {
	arr[index1], arr[index2] = arr[index2], arr[index1]
}
