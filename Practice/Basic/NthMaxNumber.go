package basic

import "fmt"

func NthLargestNumber(arr []int, n int) int {

	unique := make(map[int]bool)
	topN := make([]int, 0, n)

	for _, num := range arr {
		if unique[num] {
			continue
		}
		unique[num] = true

		// Insert in sorted order in topN
		inserted := false
		for i := 0; i < len(topN); i++ {
			if num > topN[i] {
				topN = append(topN[:i+1], topN[i:]...)
				topN[i] = num
				inserted = true
				fmt.Println("L: topN:", topN)
				break
			}
		}
		if !inserted && len(topN) < n {
			topN = append(topN, num)
		}

		if len(topN) > n {
			topN = topN[:n] // keep only top n
		}
	}

	if len(topN) < n {
		return 0
	}

	fmt.Println("topN:", topN)

	return topN[n-1]
}
