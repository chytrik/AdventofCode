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
        // --------------------------------------------------------------- Day1
        0 -> {
            val (x, y) = reportRepair(0)
            println("Kontrola reportu je $x + $y, a to je " + x * y)
        }
        1 -> {
            val (x, y, z) = reportRepair(1)
            println("Kontrola reportu je $x + $y + $z, a to je " + x * y * z)
        }
        // --------------------------------------------------------------- Day2
        2 -> println("Platných hesel podle zásad je " + passwordPhilosophy())
        3 -> println("Platných hesel podle zásad je " + passwordPhilosophy2())
        // --------------------------------------------------------------- Day3
        4 -> println("Počet stromů na svahu podle vzorce vpravo 3 a dolů 1 je " + tobogganTrajectory(3,1))
        5 ->
            // x0=3, y0=1 * x0=1, y0=1 * x0=5, y0=1 * x0=7, y0=1 * x0=1, y0=2
            println("Výsledek násobení počtu stromů na každém ze svahů je "
                    + tobogganTrajectory(3,1) * tobogganTrajectory(1,1) *
                    tobogganTrajectory(5,1) * tobogganTrajectory(7,1) * tobogganTrajectory(1,2))
        // --------------------------------------------------------------- Day4
        6 -> println("Počet platných pasů je " + passportProcessing())
    }
}
