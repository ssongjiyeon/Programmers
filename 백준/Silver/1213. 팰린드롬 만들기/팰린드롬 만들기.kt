import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val name = br.readLine().toCharArray().sortedDescending()
    val pallin = mutableListOf<Char>()
    var soleChar = true
    var idx = 0

    while(idx < name.size) {
        if(idx + 1 < name.size && name[idx] == name[idx + 1]) {
            pallin.add(0, name[idx])
            pallin.add(pallin.size, name[idx])
            idx += 2
        } else if(soleChar) {
            soleChar = false
            pallin.add(pallin.size / 2, name[idx])
            idx++
        } else {
            print("I'm Sorry Hansoo")
            return;
        }
    }

    print(pallin.joinToString(""))

}