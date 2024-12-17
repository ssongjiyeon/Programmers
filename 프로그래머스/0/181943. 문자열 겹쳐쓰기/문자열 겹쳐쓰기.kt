class Solution {
    fun solution(my_string: String, overwrite_string: String, s: Int): String {
        var answer: String = my_string.substring(0, s) + overwrite_string
        var otherString = my_string.substring(s + overwrite_string.length)
        
        return answer + otherString
    }
}