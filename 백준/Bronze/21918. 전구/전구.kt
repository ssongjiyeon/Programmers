import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val ( N, M ) = br.readLine().split(" ").map { it.toInt() }
    var lights = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    repeat(M) {
        val ( option, param1, param2 ) = br.readLine().split(" ").map{ it.toInt() }
        lights = when(option) {
            1 -> option1(lights, param1, param2)
            2 -> option2(lights, param1, param2)
            3 -> option3(lights, param1, param2)
            4 -> option4(lights, param1, param2)
            else -> throw Exception()
        }
    }

    println(lights.joinToString(" "))
}

fun option1(lights: IntArray, i: Int, x: Int): IntArray {
    lights[i-1] = x
    return lights
}

fun option2(lights: IntArray, i: Int, x: Int): IntArray {
    for(idx in i..x) {
        lights[idx-1] = when(lights[idx-1]) {
            0 -> 1
            1 -> 0
            else -> -1
        }
    }

    return lights
}

fun option3(lights: IntArray, i: Int, x: Int): IntArray {
    for(idx in i..x) {
        lights[idx-1] = 0
    }

    return lights
}

fun option4(lights: IntArray, i: Int, x: Int): IntArray {
    for(idx in i..x) {
        lights[idx-1] = 1
    }

    return lights
}
