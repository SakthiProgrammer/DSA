package basic

/*
	Q: Find the Missing Number from 0 to n distinct Numbers

	Ex: 1
		arr = [3, 0, 1]
		res = 2
*/
func FindMissingNumber(arr []int) int {
	n := len(arr)
	result := n/2*(n+1) + (n%2)*(n+1)/2
	accRes := 0
	for _, num := range arr {
		accRes += num
	}

	return result - accRes
}
