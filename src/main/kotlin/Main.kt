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
        2 -> println("Platných hesel podle zásad je " + rulePasswords())
        3 -> println("Platných hesel podle zásad je " + rule2Passwords())
        4 -> println("Počet stromů na svahu podle vzorce vpravo 3 a dolů 1 je " + tobogan(3,1))
        5 ->
            // x0=3, y0=1 * x0=1, y0=1 * x0=5, y0=1 * x0=7, y0=1 * x0=1, y0=2
            println("Výsledek násobení počtu stromů na každém ze svahů je "
                    + tobogan(3,1) * tobogan(1,1) *
                    tobogan(5,1) * tobogan(7,1) * tobogan(1,2))

    }
}
