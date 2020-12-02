package adventcode

import java.io.File

fun getGreeting(): String {
    val words = mutableListOf<String>()
    words.add("Hello,")
    words.add("world!")

    return words.joinToString(separator = " ")
}

fun readReport(numberVal: Int): List<Int> {
    val reportLines = File("report1.txt").readLines()
    when (numberVal) {
        0 -> {
            val copyreportLines = reportLines.toList()
            reportLines.forEach { r ->
                copyreportLines.forEach { c ->
                    if (c.toInt() + r.toInt() == 2020) return listOf(c.toInt(), r.toInt(), 0)
                }
            }
        }
        1 -> {
            val copyreportLines1 = reportLines.toList()
            val copyreportLines2 = reportLines.toList()
            reportLines.forEach { r ->
                copyreportLines1.forEach { c1 ->
                    copyreportLines2.forEach { c2 ->
                        if (c1.toInt() + c2.toInt() + r.toInt() == 2020) return listOf(c1.toInt(), c2.toInt(), r.toInt())
                    }
                }
            }
        }
    }
    return listOf(0,0,0)
}

fun printMenu(): Int {
    while (true) {
        println("/------------------\\")
        println("| Adventi kodovani |")
        println("\\-----------------/")
        println()
        println("Menu:")
        println("0 .. kontrola reportu, nalezeni 2 cisel davajici soucet 2020 a tisk jejich nasobku")
        println("1 .. kontrola reportu, nalezeni 3 cisel davajici soucet 2020 a tisk jejich nasobku")
        println()
        println("Vyber cislo pro zvolenou operaci")
        val inputChoice: Int = try { readLine()!!.toInt() } catch (e: NumberFormatException) { 9 }
        if (inputChoice in 0..1) return inputChoice
        else {
            println("!!!    Chybne zadana hodnota    !!!")
            println()
            println("- STISKNETE ENTER a ZADEJTE ZNOVU -")
            readLine()
            println("\n\n\n")
        }
    }
}

fun main() {
    // Uvitani uz je passe, ale nechavam ho tady zakomentovane
    // println(getGreeting())
    val choiceMenu = printMenu()
    when (choiceMenu) {
        0 -> {
            // prvni zadani
            val (x, y) = readReport(0)
            println("$x + $y, a to je " + x * y)
        }
        1 -> {
            // druhe zadani
            val (x, y, z) = readReport(1)
            println("$x + $y + $z, a to je " + x * y * z)
        }

    }
}
