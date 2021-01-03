package adventcode

import java.io.File

/*
    --- Day 3: Toboggan Trajectory ---
    
    Sáňkařská dráha může sledovat pouze několik konkrétních svahů (rozhodli jste se pro levnější model, který preferuje
    racionální čísla); začněte počítáním všech stromů, se kterými se setkáte pro svah a to vzorcem => vpravo x0, dolů y0

    Můj tip: Pro otestování použít soubor tobogan0.txt, kde má být výsledek
        7 stromů pro x0=3, y0=1
        2 stromy pro x0=1, y0=1.
        3 stromy pro x0=5, y0=1.
        4 stromy pro x0=7, y0=1.
        2 stromy pro x0=1, y0=2
    a pro zvolení menu = 5 je odpověď násobení 336 u tobogan0.txt.
 */
fun tobogganTrajectory(x0: Int, y0: Int): Long {
    val toboganLines = File("tobogan.txt").readLines()
    // X-ová souřadnice na svahu (pozn. Y-ová není potřeba, to určuje řádek, který se posouvá automaticky)
    var x = 1
    var y = 0
    // počet stromů na cestě po svahu
    var treeCount = 0
    // Použiji rozšířenou metodu forEachIndexed, která provádí danou akci na každém prvku
    // a poskytuje sekvenční index s prvkem. Index použiji pro získaní informace, na kterém jsem řádku
    toboganLines.forEachIndexed { i, line ->
        /*
            Prodloužení řádku vzoru svahu
            Zadání, zahrnující stromovou genetiku a stabilitu biomu, že se stejný vzor mnohokrát opakuje doprava
         */
        val toboganLong = line.length
        val toboganPattern = line.repeat(x/toboganLong+1)
        // To, na kterém jsem řádku je určené pomocí rowCount, který se postupně zvyšuje
        if (i==y) {
            if (toboganPattern[x-1] == "#".single()) treeCount++
            y+=y0
            x+=x0
        }
    }
    return treeCount.toLong()
}