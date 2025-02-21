package sorting

func MergeSort(inputArray []int) {
	inputLength := len(inputArray)

	if inputLength < 2 {
		return
	}

	midIndex := inputLength / 2
	leftHalf := make([]int, midIndex)
	rightHalf := make([]int, inputLength-midIndex)

	for i := 0; i < midIndex; i++ {
		leftHalf[i] = inputArray[i]
	}

	for i := midIndex; i < inputLength; i++ {
		rightHalf[i-midIndex] = inputArray[i]
	}

	MergeSort(leftHalf)
	MergeSort(rightHalf)

	merge(inputArray, leftHalf, rightHalf)
}

func merge(inputArray []int, leftHalf []int, rightHalf []int) {
	leftLength := len(leftHalf)
	rightLength := len(rightHalf)

	i := 0
	j := 0
	k := 0

	for i < leftLength && j < rightLength {
		if leftHalf[i] < rightHalf[j] {
			inputArray[k] = leftHalf[i]
			i++
		} else {
			inputArray[k] = rightHalf[j]
			j++
		}
		k++
	}

	for i < leftLength {
		inputArray[k] = leftHalf[i]
		i++
		k++
	}

	for j < rightLength {
		inputArray[k] = rightHalf[j]
		j++
		k++
	}
}
