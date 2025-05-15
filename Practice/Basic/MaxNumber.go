package basic

import "math"

func MaxNumber(arr []int) int {
	max := math.MinInt

	for _, num := range arr {
		if max < num {
			max = num
		}
	}

	return max
}
