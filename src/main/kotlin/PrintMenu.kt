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
        println("Day1: 0 .. kontrola reportu, nalezení 2 čísel dávající součet 2020 a tisk jejich násobku")
        println("Day1: 1 .. kontrola reportu, nalezení 3 čísel dávající součet 2020 a tisk jejich násobku")
        println("Day2: 2 .. kontrola hesel, nalezení platných hesel podle zásady, že musí obsahovat min a max daného písmene")
        println("Day2: 3 .. kontrola hesel, nalezení platných hesel podle zásady, že musí obsahovat 1 a nebo 2 výskyty daného písmene")
        println("Day3: 4 .. sáňkařská dráha, sledování svahů a počítání všech stromů, se kterými se setkáte pro svah vpravo 3, dolů 1")
        println("Day3: 5 .. sáňkařská dráha, násobení výsledků z bodu 4 pro zadání vpravo:dolů => 1:1 x 3:1 x 5:1 x 7:1 x 1:2")
        println("Day4: 6 .. Kontrola pasů, zdali obsahují očekávané pole")
        println("Day4: 7 .. Kontrola pasů, zdali obsahují očekávané pole a to včetně kontroly hodnot polí")
        println()
        println("Vyber cislo pro zvolenou operaci")
        val inputChoice: Int = try { readLine()!!.toInt() } catch (e: NumberFormatException) { 9 }
        if (inputChoice in 0..7) return inputChoice
        else {
            println("!!!    Chybne zadana hodnota    !!!")
            println()
            println("- STISKNETE ENTER a ZADEJTE ZNOVU -")
            readLine()
            println("\n\n\n")
        }
    }
}