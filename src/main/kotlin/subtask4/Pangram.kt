package subtask4


class Pangram {

    private var count = 0
    // TODO: Complete the following function
    fun getResult(inputString: String): String {
        var str = inputString.replace("\\s+".toRegex(), " ").trim()

        var result = ""
        var zeroString = ""
        var firstCount = ""
        var secCount = ""
        var thirdCount = ""
        var fourthCount = ""
        var fifthCount = ""
        var sixthCount = ""
        var sevenCount = ""
        var eightCount = ""
        var listOfWords = str.split(" ")
        if(str != "") {
            if (checkPangram(inputString)) {
                listOfWords!!.forEach { i ->
                    if (!isVowel(i)) {
                        zeroString += "0$i "
                    } else {
                        when (count) {
                            1 -> firstCount += "$count${convertVowel(i)} "
                            2 -> secCount += "$count${convertVowel(i)} "
                            3 -> thirdCount += "$count${convertVowel(i)} "
                            4 -> fourthCount += "$count${convertVowel(i)} "
                            5 -> fifthCount += "$count${convertVowel(i)} "
                            6 -> sixthCount += "$count${convertVowel(i)} "
                            7 -> sevenCount += "$count${convertVowel(i)} "
                            8 -> eightCount += "$count${convertVowel(i)} "
                        }
                        count = 0
                    }
                }
                result =
                    "$zeroString $firstCount $secCount $thirdCount $fourthCount $fifthCount $sixthCount $sevenCount $eightCount".replace(
                        "\\s+".toRegex(),
                        " "
                    ).trim()
            } else {
                listOfWords!!.forEach { i ->
                    if (!isConst(i)) {
                        zeroString += "0$i "
                    } else {
                        when (count) {
                            1 -> firstCount += "$count${convertConst(i)} "
                            2 -> secCount += "$count${convertConst(i)} "
                            3 -> thirdCount += "$count${convertConst(i)} "
                            4 -> fourthCount += "$count${convertConst(i)} "
                            5 -> fifthCount += "$count${convertConst(i)} "
                            6 -> sixthCount += "$count${convertConst(i)} "
                            7 -> sevenCount += "$count${convertConst(i)} "
                            8 -> eightCount += "$count${convertConst(i)} "
                        }
                        count = 0
                    }
                }
                result =
                    "$zeroString $firstCount $secCount $thirdCount $fourthCount $fifthCount $sixthCount $sevenCount $eightCount".replace(
                        "\\s+".toRegex(),
                        " "
                    ).trim()
            }
        }else{
            result = ""
        }
        return result
    }

    fun checkPangram(str: String): Boolean {
        val mark = BooleanArray(26)
        var index = 0
        for (i in 0 until str.length) {
            index =
                if ('A' <= str[i] && str[i] <= 'Z') str[i] - 'A' else if ('a' <= str[i] && str[i] <= 'z') str[i] - 'a' else continue
            mark[index] = true
        }
        for (i in 0..25) if (mark[i] == false) return false
        return true
    }

    fun isVowel(c: String): Boolean {
        val words = c.toUpperCase().toCharArray()
        var result = false
        for (i in words.indices) {
            val w = words[i]
            if (w == 'A' || w == 'E' || w == 'I' || w == 'O' || w == 'U' || w == 'Y') {
                ++count
                result = true
            }
        }
        return result
    }

    fun isConst(c: String): Boolean {
        val words = c.toUpperCase().toCharArray()
        var result = false
        for (i in words.indices) {
            val w = words[i]
            if (w == 'B' || w == 'C' || w == 'D' || w == 'F' || w == 'G' || w == 'H' || w == 'J' || w == 'K'
                || w == 'L' || w == 'M' || w == 'N' || w == 'P' || w == 'Q' || w == 'R' || w == 'S' || w == 'T' || w == 'V' || w == 'X' || w == 'Z' || w == 'W'
            ) {
                ++count
                result = true
            }
        }
        return result
    }

    fun convertVowel(c: String): String {
        var words = c.toCharArray()
        for (i in words.indices) {
            val z = words[i]
            if (z == 'a' || z == 'e' || z == 'i' || z == 'o' || z == 'u' || z == 'y')
            {
                words[i] = words[i].toUpperCase()
            }
        }
        return String(words)
    }

    fun convertConst(c: String): String {
        var words = c.toCharArray()
        for (i in words.indices) {
            val z = words[i]
            if (z == 'b' || z == 'c' || z == 'd' || z == 'f' || z == 'g' || z == 'h' || z == 'j' || z == 'k' || z == 'l' || z == 'm' || z == 'n' || z == 'p' ||
                z == 'q' || z == 'r' || z == 's' || z == 't' || z == 'v' || z == 'x' || z == 'z' || z == 'w')
            {
                words[i] = words[i].toUpperCase()
            }
        }
        return String(words)
    }
}
