package basic

import "math"

func SecondLargestNumber(arr []int) int {
	max := math.MinInt
	secondMax := math.MinInt

	for _, num := range arr {
		if max < num {
			secondMax = max
			max = num
		} else if secondMax < num && num != max {
			secondMax = num
		}
	}

	if secondMax == math.MinInt {
		return max
	}

	return secondMax
}
