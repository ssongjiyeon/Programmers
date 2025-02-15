import kotlin.math.max

fun main(args: Array<String>) {
    val N = readln().toInt()
    val str = readln()
    var plus = 0

    for(i in 0..N-1) {
        val now = str[i].code - 48
        plus += now
    }

    println(plus)
}