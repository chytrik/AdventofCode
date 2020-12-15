package adventcode

/*
    Vytiskne vstypni menu
 */
fun printMenu(): Int {
    while (true) {
        println("/-------------------\\")
        println("| Adventní kódování |")
        println("\\------------------/")
        println()
        println("Menu:")
        println("0 .. kontrola reportu, nalezení 2 čísel dávající součet 2020 a tisk jejich násobku")
        println("1 .. kontrola reportu, nalezení 3 čísel dávající součet 2020 a tisk jejich násobku")
        println("2 .. kontrola hesel, nalezení platných hesel podle zásady, že musí obsahovat min a max daného písmene")
        println("3 .. kontrola hesel, nalezení platných hesel podle zásady, že musí obsahovat 1 a nebo 2 výskyty daného písmene")
        println("4 .. sáňkařská dráha, sledování svahů a počítání všech stromů, se kterými se setkáte pro svah vpravo 3, dolů 1")
        println()
        println("Vyber cislo pro zvolenou operaci")
        val inputChoice: Int = try { readLine()!!.toInt() } catch (e: NumberFormatException) { 9 }
        if (inputChoice in 0..4) return inputChoice
        else {
            println("!!!    Chybne zadana hodnota    !!!")
            println()
            println("- STISKNETE ENTER a ZADEJTE ZNOVU -")
            readLine()
            println("\n\n\n")
        }
    }
}