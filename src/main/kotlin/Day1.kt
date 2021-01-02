package adventcode

import java.io.File

/*
Zpráva o výdajích je souboru report1.txt.
Cílem je najít dvě položky, u nichž je součet 2020;
A pak je znásobit dohromady.
*/
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