package adventcode

/*
fun getGreeting(): String {
    val words = mutableListOf<String>()
    words.add("Hello,")
    words.add("world!")

    return words.joinToString(separator = " ")
}
*/

fun main() {
    // Uvitani uz je passe, ale nechavam ho tady zakomentovane
    // println(getGreeting())
    //
    when (printMenu()) {
        0 -> {
            // prvni zadani
            val (x, y) = readReport(0)
            println("Kontrola reportu je $x + $y, a to je " + x * y)
        }
        1 -> {
            // druhe zadani
            val (x, y, z) = readReport(1)
            println("Kontrola reportu je $x + $y + $z, a to je " + x * y * z)
        }
        2 -> rulePasswords()
        3 -> rule2Passwords()
        4 -> tobogan(3,1)
        5 -> {
            // x0=3, y0=1 * x0=1, y0=1 * x0=5, y0=1 * x0=7, y0=1 * x0=1, y0=2
            val toboLength: Long = tobogan(3,1).toLong() * tobogan(1,1).toLong() *
                    tobogan(5,1).toLong() * tobogan(7,1).toLong() * tobogan(1,2).toLong()
            println("Výsledek násobení počtu stromů na každém ze svahů je $toboLength")
        }
    }
}
