package jp.gr.java_conf.spnumerology

fun judgeMasterNum(num : Int) : Int  {
    val tempNum = when (num) {
        10 -> 1
        11 -> 11
        22 -> 22
        33 -> 33
        else ->  0
    }
    return tempNum
}

fun changeConsonant (alphabet : String) : Int {
    val resultConsonant = when (alphabet) {

        "b" -> 2
        "c" -> 3
        "d" -> 4
        "f" -> 6
        "g" -> 7
        "h" -> 8
        "j" -> 1
        "k" -> 2
        "l" -> 3
        "m" -> 4
        "n" -> 5
        "p" -> 7
        "q" -> 8
        "r" -> 9
        "s" -> 1
        "t" -> 2
        "v" -> 4
        "w" -> 5
        "x" -> 6
        "y" -> 7
        "z" -> 8
        "B" -> 2
        "C" -> 3
        "D" -> 4
        "F" -> 6
        "G" -> 7
        "H" -> 8
        "J" -> 1
        "K" -> 2
        "L" -> 3
        "M" -> 4
        "N" -> 5
        "P" -> 7
        "Q" -> 8
        "R" -> 9
        "S" -> 1
        "T" -> 2
        "V" -> 4
        "W" -> 5
        "X" -> 6
        "Y" -> 7
        "Z" -> 8
        else -> 0
    }

    return resultConsonant
}

fun changeVowels (alphabet : String) : Int {
    val resultVowels = when (alphabet) {

        "a" -> 1
        "e" -> 5
        "i" -> 9
        "o" -> 6
        "u" -> 3
        "A" -> 1
        "E" -> 5
        "I" -> 9
        "O" -> 6
        "U" -> 3
        else -> 0
    }

    return resultVowels
}