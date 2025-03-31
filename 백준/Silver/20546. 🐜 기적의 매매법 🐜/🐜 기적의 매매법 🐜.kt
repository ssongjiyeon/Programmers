import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val won = br.readLine().toInt()
    val stocks = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    var j = Asset(money = won)
    var s = Asset(money = won)

    for(i in 0..13) {
        j = bnp(j, stocks[i])
    }

    for(i in 0..10) {
        s = timing(s, i, stocks)
    }

    val jTotal = total(j, stocks[13])
    val sTotal = total(s, stocks[13])
    if(jTotal == sTotal) {
        println("SAMESAME")
    } else if(jTotal < sTotal) {
        println("TIMING")
    } else {
        println("BNP")
    }
}

data class Asset (
    var stockCnt: Int = 0,
    var money: Int = 0
)

fun total(person: Asset, stock: Int): Int {
    return person.money + ( stock * person.stockCnt )
}

fun bnp(person: Asset, stock: Int): Asset {
    if(stock <= person.money) {
        val cnt = person.money / stock
        val money = person.money - ( stock * cnt )

        person.stockCnt += cnt
        person.money = money
    }

    return person
}

fun timing(person: Asset, idx: Int, stocks: IntArray): Asset {
    if(stocks[idx] < stocks[idx+1] && stocks[idx+1] < stocks[idx+2] && stocks[idx+2] < stocks[idx+3]) {
        val money = stocks[idx+3] * person.stockCnt
        person.money += money
        person.stockCnt = 0
    }

    if(stocks[idx] > stocks[idx+1] && stocks[idx+1] > stocks[idx+2] && stocks[idx+2] > stocks[idx+3]) {
        val cnt = person.money / stocks[idx+3]
        val money = person.money - ( stocks[idx+3] * cnt )

        person.stockCnt += cnt
        person.money = money
    }

    return person
}