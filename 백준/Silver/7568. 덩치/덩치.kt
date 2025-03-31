import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val person = mutableListOf<Spec>()

    repeat(N) {
        val ( x, y ) = br.readLine().split(" ").map { it.toInt() }
        person.add(Spec(y, x))
    }

    val rank = mutableListOf<Int>()
    for(i in 0..N-1) {
        var cnt = 1

        for(j in 0..N-1) {
            if(i == j) continue

            if(person[i].height < person[j].height && person[i].weight < person[j].weight) {
                cnt++
            }
        }

        rank.add(cnt)
    }

    println(rank.joinToString(" "))
}

data class Spec (
    var height: Int = 0,
    var weight: Int = 0
)
