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
            println("$x + $y, a to je " + x * y)
        }
        1 -> {
            // druhe zadani
            val (x, y, z) = readReport(1)
            println("$x + $y + $z, a to je " + x * y * z)
        }
        2 -> rulePasswords()
        3 -> rule2Passwords()
        4 -> tobogan()
    }
}
