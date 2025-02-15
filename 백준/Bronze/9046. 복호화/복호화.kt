import kotlin.math.max

fun main(args: Array<String>) {
    val N = readln().toInt()

    repeat(N) {
        val str = readln().replace(" ", "")
        val alpa = MutableList<Int>(26, {i -> 0})

        for(i in 0..str.length-1) {
            val idx = str[i].code - 97
            alpa[idx]++
        }

        val max = alpa.max()
        if(alpa.filter{ it == max }.size > 1) {
            println('?')
        } else {
            alpa.forEachIndexed { idx, it ->
                if(it == max) {
                    println((idx + 97).toChar())
                }
            }
        }
    }
}