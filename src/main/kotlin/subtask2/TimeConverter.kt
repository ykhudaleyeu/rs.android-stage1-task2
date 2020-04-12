package subtask2

class TimeConverter {

    fun toTextFormat(hour: String, minute: String): String {

        var nextHour = getStringNumRepresentation((hour.toInt() + 1).toString())
        var dif = 60 - minute.toInt()
        var difAbs = getStringNumRepresentation(dif.toString())
        var restMin = dif % 10
        var restDozMin = dif - restMin

        var literalHour = getStringNumRepresentation(hour)
        var literalMin = getStringNumRepresentation(minute)
        var result = ""
        if (minute.toInt() < 30 && minute.toInt() != 0) {
            if (minute.toInt() != 15) result = "$literalMin minutes past $literalHour" else result =
                "quarter past $literalHour"
        }
        if (minute.toInt() == 0) result = "$literalHour o' clock"
        if (minute.toInt() == 30) result = "half past $literalHour"
        if (minute.toInt() > 30 && minute.toInt() < 60) {
            if (minute.toInt() != 45 && dif < 20) result = "$difAbs minutes to $nextHour"
            if (minute.toInt() != 45 && dif > 20) result =
                "${getStringNumRepresentation(restDozMin.toString())} ${getStringNumRepresentation(
                    restMin.toString()
                )} minutes to $nextHour"
            if (minute.toInt() == 45) result = "quarter to $nextHour"
        }
        return result
    }

    fun getStringNumRepresentation(value: String): String {
        var literalMin = ""
        when (value.toInt()) {
            1 -> literalMin = "one"
            2 -> literalMin = "two"
            3 -> literalMin = "three"
            4 -> literalMin = "four"
            5 -> literalMin = "five"
            6 -> literalMin = "six"
            7 -> literalMin = "seven"
            8 -> literalMin = "eight"
            9 -> literalMin = "nine"
            10 -> literalMin = "ten"
            11 -> literalMin = "eleven"
            12 -> literalMin = "twelve"
            13 -> literalMin = "thirteen"
            14 -> literalMin = "fourteen"
            15 -> literalMin = "fifteen"
            16 -> literalMin = "sixteen"
            17 -> literalMin = "seventeen"
            18 -> literalMin = "eighteen"
            19 -> literalMin = "nineteen"
            20 -> literalMin = "twenty"
            30 -> literalMin = "thirty"
            40 -> literalMin = "forty"
            50 -> literalMin = "fifty"
            60 -> literalMin = "sixty"
        }
        return literalMin
    }
}
