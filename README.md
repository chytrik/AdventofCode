# Adventní kódování

## Spuštění
Vytvoření build pomocí příkazu
```
./gradlew build
```
následně zavolat
```bash
java -jar build/libs/AdventofCode-1.0-SNAPSHOT.jar
```

## Vzory kódů, které jsem použil při řešení

---
Příklad načtení každého řádku ze souboru a jeho vytištění na terminál

```kotlin
    File("report1.txt").forEachLine {
            println(it)
    }
```
---  
Použít Array konstruktor, který přebírá velikost pole a funkci, která může vrátit počáteční hodnotu každého prvku pole vzhledem k jeho indexu a nasledne vytisteni na terminal

```kotlin
    val asc = Array(5) { i -> (i * i).toString() }
        asc.forEach { println(it) }
```
---
Priklad vytvoreni souboru a zapisu do souboru

```kotlin
    File("data.txt").writeText("Hello world!")
```
---
Jednoduchá smyčka

```kotlin
    // For loop

    for (i in 0..10) { println (i)}

    // ForEach
    (0..10) .forEach { println (it)}

    // Prace s collections - Sbírky
    // For loop

    val list = listOf (1, 2, 3) .filter (it == 2)
    for (i in list) { println (i)}

    // ForEach
    listOf (1, 2, 3) .filter (it == 2) .forEach { println (it)}
```