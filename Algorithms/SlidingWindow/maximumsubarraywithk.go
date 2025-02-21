package slidingwindow

func MaximumSubarrayWithK(inputArray []int, k int) int {

	maxSum := 0
	currentSum := 0
	for i := 0; i < len(inputArray); i++ {
		currentSum += inputArray[i]

		if i >= k-1 {
			if currentSum > maxSum {
				maxSum = currentSum
			}
			currentSum -= inputArray[i-(k-1)]
		}
	}

	return maxSum

}
