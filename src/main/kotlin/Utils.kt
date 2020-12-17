package adventcode

import java.io.File

/*
Zpráva o výdajích je samozřejmě mnohem větší. Najděte dvě položky, které součet 2020;
co dostanete, když je znásobíte dohromady?
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

/*
Každý řádek uvádí zásady hesla a poté heslo.
Zásady hesla označují nejnižší a nejvyšší počet opakování daného písmena, aby bylo heslo platné.
Například "1-3 a:" znamená, že heslo musí obsahovat "a" alespoň 1x a 3x.
*/
fun rulePasswords() {
    val passwordLines = File("passwords1.txt").readLines()
    var vpohode = 0
    passwordLines.forEach{ p ->

        // vytvorim si pole retezcu, z puvodniho je rozdelim podle mezer
        val passSplit: List<String> = p.split(" ")

        // najdu si min a max, opet rozdelim podle znamenka minus
        val numMinMax = passSplit[0].split("-")

        // odstranim dvojtecku ze znaku pro pravidlo
        val ruleChar = passSplit[1].replace(":", "")

        /*
        Count occurrences of a given character in a string
            fun countOccurrences(s: String, ch: Char): Int {
                return s.filter { it == ch }.count()
            }
        */
        // lze najit hodnotu v poli i pomoci array.contains("value")
        // fce ruleChar.single() prevede jednoznakovy retezec na char
        //
        // najdu pocet vyskytu znaku v retezci v tomto pripade v <it> coz je index z retezce passSplit[2]
        val ruleCharCount = passSplit[2].filter { it == ruleChar.single() }.count()
        if (ruleCharCount in numMinMax[0].toInt()..numMinMax[1].toInt() ) vpohode++
    }
    println("Platných hesel podle zásad je $vpohode")
}

/*
 Pravidlo popisuje dvě pozice v hesle, kde 1 znamená první znak, 2 znamená druhý znak atd.
 (Buďte opatrní; Zásady společnosti Toboggan nemají koncept „indexu nula“!)
 Přesně jedna z těchto pozic musí obsahovat dané písmeno.

    Priklad:
    1-3 a: abcde
    1-3 b: cdefg
    2-9 c: ccccccccc

    1-3 a: abcdeje platný : pozice 1 obsahuje "a" a pozice 3 ne.
    1-3 b: cdefgje neplatná : pozice 1 ani pozice 3 neobsahuje "b".
    2-9 c: cccccccccje neplatný : pozice 2 i pozice 9 obsahují "c".
*/
fun rule2Passwords() {
    val passwordLines = File("passwords1.txt").readLines()
    var vpohode = 0
    passwordLines.forEach { p ->
        val passSplit: List<String> = p.split(" ")
        val numFirstSecond = passSplit[0].split("-")
        val ruleChar = passSplit[1].replace(":", "")
        // podminka
        // if (a==1 && b==0 || a==0 && b==1) "true" else "false"
        // if (znak==znakVyskytFirst && znak!=znakVyskytSecond || znak!=znakVyskytFirst && znak==znakVyskytSecond) "true"
        if (ruleChar.single() == passSplit[2][numFirstSecond[0].toInt()-1] && ruleChar.single() != passSplit[2][numFirstSecond[1].toInt()-1]
            || ruleChar.single() != passSplit[2][numFirstSecond[0].toInt()-1] && ruleChar.single() == passSplit[2][numFirstSecond[1].toInt()-1])
            vpohode++
        //println(passSplit.toString() + "#" + passSplit[2][numFirstSecond[0].toInt()-1] + "#" + passSplit[2][numFirstSecond[1].toInt()-1])
    }
    println("Platných hesel podle zásad je $vpohode")
}

/*
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
fun tobogan(x0: Int, y0: Int): Int {
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
    println("Počet stromů na svahu podle vzorce vpravo $x0 a dolů $y0 je $treeCount")
    return treeCount
}