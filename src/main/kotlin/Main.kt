package adventcode

import java.io.File

fun getGreeting(): String {
    val words = mutableListOf<String>()
    words.add("Hello,")
    words.add("world!")

    return words.joinToString(separator = " ")
}

fun readReport() {

    /*
    priklad nacteni kazdeho radku ze souboru a jeho vytisteni na terminal

    File("report1.txt").forEachLine {
        println(it)
    }*/

    /*
    použít9 Array konstruktor, který přebírá velikost pole a funkci, která může vrátit počáteční hodnotu
    každého prvku pole vzhledem k jeho indexu a nasledne vytisteni na terminal

    val asc = Array(5) { i -> (i * i).toString() }
    asc.forEach { println(it) }*/

    /*
    priklad vytvoreni souboru a zapisu do souboru
    File("data.txt").writeText("Hello world!")*/

    /*
    Jednoduchá smyčka

    // For loop
    for (i in 0..10) { println (i)}
    // ForEach
    (0..10) .forEach { println (it)}
    Sbírka
    // For loop
    val list = listOf (1, 2, 3) .filter (it == 2)
    for (i in list) { println (i)}
    // ForEach
    listOf (1, 2, 3) .filter (it == 2) .forEach { println (it)}
     */

    val reportLines = File("report1.txt").readLines()
    val copyreportLines = reportLines.toList()
    reportLines.forEach{ r ->
        copyreportLines.forEach{ c ->
            //if (c.toInt() + r.toInt() == 2020)
            println(c)
        }
    }

}
fun main() {
    //println(getGreeting())
    readReport()
}
