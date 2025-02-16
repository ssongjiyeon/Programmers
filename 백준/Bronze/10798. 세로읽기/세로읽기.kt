import kotlin.math.max

fun main() {
    val toy = Array(5, { Array(15, {' '}) })

    for(i in 0..4) {
        val str = readln()

        str.forEachIndexed { idx, c ->
            toy[i][idx] = c
        }
    }

    var answer = ""
    for(j in 0..14) {
        for(i in 0..4) {
            answer += toy[i][j]
        }
    }

    println(answer.replace(" ", ""))
}