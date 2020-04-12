package subtask1

import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.*


class DateFormatter {

    val mask = "d/M/yyyy"
    fun toTextDay(day: String, month: String, year: String): String {
        var day = day
        var month = month
        var year = year

        val m = listOf(
            "января", "февраля", "марта", "апреля", "мая", "июня",
            "июля", "августа", "сентября", "октября", "ноября", "декабря"
        )
        val locale = Locale("ru")
        lateinit var s: String

        if (isDateValid("$day/$month/$year")) {
            val date = LocalDate.parse("$day/$month/$year", DateTimeFormatter.ofPattern(mask))
            val text_day_of_the_week = date.dayOfWeek.getDisplayName(TextStyle.FULL, locale)
            lateinit var text_month: String
            when (month.toInt()) {
                1 -> text_month = m.get(0)
                2 -> text_month = m.get(1)
                3 -> text_month = m.get(2)
                4 -> text_month = m.get(3)
                5 -> text_month = m.get(4)
                6 -> text_month = m.get(5)
                7 -> text_month = m.get(6)
                8 -> text_month = m.get(7)
                9 -> text_month = m.get(8)
                10 -> text_month = m.get(9)
                11 -> text_month = m.get(10)
                12 -> text_month = m.get(11)
            }

            s = "$day $text_month, $text_day_of_the_week"
        } else {
            s = "Такого дня не существует"
        }
        return s
    }

    fun isDateValid(date: String?): Boolean {
        return try {
            val dateFormat: DateFormat = SimpleDateFormat(mask)
            dateFormat.isLenient = false
            dateFormat.parse(date)
            true
        } catch (e: ParseException) {
            false
        }
    }
}
