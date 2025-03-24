import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val str = br.readLine()
    var answer = ""
    var temp = mutableListOf<Char>()
    var tag = false

    for(s in str) {
        if(s == '<') {
            tag = true
            temp.add('<')
        } else if(s == '>') {
            tag = false
            temp.add('>')

            answer += temp.joinToString("")
            temp = mutableListOf()
        } else if(tag) {
            temp.add(s)
        } else if(s == ' ') {
            temp.add(' ')
            answer += temp.joinToString("")
            temp = mutableListOf()
        } else {
            temp.add(0, s)
        }
    }

    println(answer + temp.joinToString(""))
}