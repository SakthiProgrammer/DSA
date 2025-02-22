package slidingwindow

func MaximumSubarrayWithK(inputArray []int, k int) int {

	maxSum := 0
	sum := 0
	j := 0
	i := 0
	for j < len(inputArray) {
		sum += inputArray[j]

		if j-i+1 < k {
			j++
		}

		if j-i+1 == k {
			if sum > maxSum {
				maxSum = sum
			}
			sum -= inputArray[i]
			i++
			j++
		}
	}

	return maxSum

}
