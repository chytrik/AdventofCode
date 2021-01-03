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
 */
 fun passportProcessing(): Int {
    //definice polí - jen ty povinné
    val findValues = arrayOf("byr", "iyr","eyr","hgt","hcl","ecl","pid").toList()
    val passportLines = File("passport.txt").readLines()
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
            if (bx.containsAll(findValues)) vpohode++
            // Inicializace kolekce
            passportForm = ArrayList()
        }
    }
    return vpohode
 }