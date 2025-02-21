package sorting

func InsertionSort(inputArray []int) {
	for i := 1; i < len(inputArray); i++ {

		currentValue := inputArray[i]

		j := i - 1

		for j >= 0 && inputArray[j] > currentValue {
			inputArray[j+1] = inputArray[j]
			j--
		}

		inputArray[j+1] = currentValue

	}
}
