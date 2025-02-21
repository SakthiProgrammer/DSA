package sorting

func BoubleSort(inputArray []int) {
	for i := 0; i < len(inputArray); i++ {
		for j := i + 1; j < len(inputArray); j++ {
			if inputArray[i] > inputArray[j] {
				inputArray[i], inputArray[j] =
					inputArray[j], inputArray[i]
			}
		}
	}
}
