package adventcode

import java.io.File

fun getGreeting(): String {
    val words = mutableListOf<String>()
    words.add("Hello,")
    words.add("world!")

    return words.joinToString(separator = " ")
}

fun readReport1(): Pair<Int,Int> {

    val reportLines = File("report1.txt").readLines()
    val copyreportLines = reportLines.toList()
    reportLines.forEach{ r ->
        copyreportLines.forEach{ c ->
            if (c.toInt() + r.toInt() == 2020)  return Pair(c.toInt(), r.toInt())
        }
    }
    return Pair(0,0)
}

fun main() {
    //println(getGreeting())
    // prvni zadani
    val (x,y) = readReport1()
    println("$x + $y, a to je " + x*y)
    // druhe zadani

}
