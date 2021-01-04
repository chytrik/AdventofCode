package adventcode

import java.io.File

/*
    --- Day 4: Passport Processing ---

    Detekce, které pasy obsahují všechna požadovaná pole.
    Očekávaná pole jsou následující:

        byr (Rok narození)
        iyr (Rok vydání)
        eyr (Rok vypršení platnosti)
        hgt (Výška)
        hcl (Barva vlasů)
        ecl (Barva očí)
        pid (Číslo pasu)
        cid (ID země)     -- OPTIONAL

    Data pasu jsou ověřována v dávkových souborech (váš logický vstup). Každý pas je reprezentován jako posloupnost
    key:value párů oddělených mezerami nebo novými řádky.
    Pasy jsou odděleny prázdnými řádky.

    Pokud je pole povinné, tak se na vstupu zadá pole obsahující dvojice, kde každá určije jméno tagu
        např.
        listOf("byr","0","iyr","0","eyr","0","hgt","0","hcl","0","ecl","0","pid","0")
    druhá část dvojice určuje, jestli je nutná kontrola
        např.
        listOf("byr","1","iyr","1","eyr","1","hgt","1","hcl","1","ecl","1","pid","1")

    Každé pole má přísná pravidla ohledně toho, jaké hodnoty jsou platné pro automatické ověření:

    byr(Rok narození) - čtyři číslice; alespoň 1920 a maximálně 2002.
    iyr(Rok vydání) - čtyři číslice; alespoň 2010 a maximálně 2020.
    eyr(Rok vypršení platnosti) - čtyři číslice; alespoň 2020 a maximálně 2030.
    hgt(Výška) - číslo, za kterým následuje buď cmnebo in:
    Pokud cm, počet musí být alespoň 150 a maximálně 193.
    Pokud in, počet musí být alespoň 59 a maximálně 76.
    hcl(Barva vlasů) - znak # a následuje přesně šest znaků 0-9 nebo a-f.
    ecl(Oční stíny) - přesně jeden z následujících: amb blu brn gry grn hzl oth.
    pid (Passport ID) - devítimístné číslo, včetně úvodních nul.
    cid (ID země) - ignorováno, chybí nebo není.
 */
fun passportProcessing(listTags: List<String>): Int {
    val passportLines = File("passport.txt").readLines()
    // Vytvořím ze vstupního pole List obsahující seznam tagů
    val mandatoryTags = listTags.slice(listTags.indices step 2)
    // Vytvořím ze vstupního pole List obsahující seznam příznaků pro kontrolu
    val checkTags = listTags.slice(1 until listTags.size step 2)
    var vpohode = 0
    var passportForm = ArrayList<String>()
    /*
       Porovnání proběhne tak, že mám pole tagů (byr, iyr, ...), které chci aby byly obsaženy.
       Z TXT souborů si čtu tagy a k nim hodnoty až do prázdného řádku, což je jeden kompletní formulář.
       Nejdříve načtu pole ve formě TAG:HODNOTA, ty potom převedu na řetězec a ještě oddělím pole dvojtečkehou,
       takže vznikne řetezec TAG1:HODNOTA1:TAG2:HODNOTA2:...
       Z řetězce načtu jen tagy, co mě zajímají, tzn. sudé pozoce a to pomocí metody pole.slice(ax.indices step 2)
       Následně porovnám dvě pole, vzniklé pole tagů formuláře vs pole očekávaných tagů
    */
    passportLines.forEach {
        // Prázdný řádek je nová kolekce
        if (it.isNotEmpty()) passportForm.addAll(it.trim().split(" "))
        else {
            // Pozn. šlo by i použít filtr jako: val findValue = passportForm.filter { a -> a.contains("byr") }
            // Převedu pole na CSV a jako oddělovač prvků použiju dvojtečku, protože ta už je obsažena
            // a jakmile mám CSV s dvojtečkami, tak zpátky na pole
            val ax = passportForm.joinToString(separator = ":").split(":")
            val bx = ax.slice(ax.indices step 2)
            // Kontrola přítomností povinných tagů = Porovnání nalezených tagů s těmi, které se požadují
            if (bx.containsAll(mandatoryTags)) {
                if (!checkTags.contains("1")) vpohode++ else {
                    var checkStatus = true
                    mandatoryTags.forEachIndexed { index, s ->
                        if (checkTags[index] == "1")
                            when (s) {
                                "byr" -> if (!byrCheck(ax[ax.indexOf(s) + 1])) checkStatus = false
                                "iyr" -> if (!iyrCheck(ax[ax.indexOf(s) + 1])) checkStatus = false
                                "eyr" -> if (!eyrCheck(ax[ax.indexOf(s) + 1])) checkStatus = false
                                "hgt" -> if (!hgtCheck(ax[ax.indexOf(s) + 1])) checkStatus = false
                                "hcl" -> if (!hclCheck(ax[ax.indexOf(s) + 1])) checkStatus = false
                                "ecl" -> if (!eclCheck(ax[ax.indexOf(s) + 1])) checkStatus = false
                                "pid" -> if (!pidCheck(ax[ax.indexOf(s) + 1])) checkStatus = false
                            }
                    }
                    // Jestliže během kontroly status zůstal na TRUE, tak je pas v pořádku
                    if (checkStatus) vpohode++
                }
            }
            // Inicializace kolekce pro načtení seznamu tagů dalšího pasu
            passportForm = ArrayList()
        }
    }
    return vpohode
}

// kontrolni funkce pro validitu pasů
// ----------------------------------
fun byrCheck(inPar: String) = try {
    inPar.toInt() in 1920..2002
} catch (e: NumberFormatException) {
    false
}

fun iyrCheck(inPar: String) = try {
    inPar.toInt() in 2010..2020
} catch (e: NumberFormatException) {
    false
}

fun eyrCheck(inPar: String) = try {
    inPar.toInt() in 2020..2030
} catch (e: NumberFormatException) {
    false
}

fun hgtCheck(inPar: String) = try {
    ((inPar.substring(0,inPar.lastIndex-1).toInt() in 150..193 &&
            inPar.substring(inPar.lastIndex-1,inPar.lastIndex+1) == "cm") ||
            (inPar.substring(0,inPar.lastIndex-1).toInt() in 59..76 &&
                    inPar.substring(inPar.lastIndex-1,inPar.lastIndex+1) == "in"))
} catch (e: NumberFormatException) {
    false
}

fun hclCheck(inPar: String) =
    """#([0-9a-f]{3}|[0-9a-f]{6}|[0-9a-f]{8})""".toRegex().containsMatchIn(inPar)

fun eclCheck(inPar: String) =
    inPar in arrayOf("amb","blu","brn","gry","grn","hzl","oth")

fun pidCheck(inPar: String) =
    """^\d{9}$""".toRegex().containsMatchIn(inPar)