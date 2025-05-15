package basic

import (
	"strings"
	"unicode"
)

func IsPalindrome(str string) bool {
	if len(str) < 3 {
		return true
	}

	str = strings.ToLower(str)
	left := 0
	right := len(str) - 1

	for left < right {
		leftChar := rune(str[left])
		rightChar := rune(str[right])

		// If both characters are letters
		if unicode.IsLetter(leftChar) && unicode.IsLetter(rightChar) {
			if leftChar != rightChar {
				return false
			}
			left++
			right--
		} else {
			// Skip non-letter characters
			if !unicode.IsLetter(leftChar) {
				left++
			}
			if !unicode.IsLetter(rightChar) {
				right--
			}
		}
	}

	return true
}
