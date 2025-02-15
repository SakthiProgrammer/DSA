package recursion

import "fmt"

func Example1(num int) {
	if num > 0 {
		fmt.Println(num, " ")
		Example1(num - 1)
		fmt.Println(num, " ")
	}
}
