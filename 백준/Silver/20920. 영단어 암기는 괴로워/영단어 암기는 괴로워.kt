import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val words = mutableMapOf<String, Int>()

    for(i in 1..N) {
        val word = br.readLine()
        if(word.length < M) continue

        if(words.containsKey(word)) {
            words[word] = words.getValue(word) + 1
        } else {
            words[word] = 1
        }
    }

    val answer = words.entries.sortedWith (
        compareByDescending<Map.Entry<String, Int>> { it.value }
            .thenByDescending { it.key.length }
            .thenBy { it.key }
    )

    val sb = StringBuilder()
    answer.forEach {
        sb.append(it.key + "\n")
    }
    println(sb)
}