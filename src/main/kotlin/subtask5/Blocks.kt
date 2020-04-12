package subtask5

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.reflect.KClass


class Blocks {

    // TODO: Complete the following function
    fun getData(blockA: Array<Any>, blockB: KClass<*>): Any {

        var str = ""
        var num = 0
        var date = mutableListOf<String>()
        var type = blockB.javaObjectType.kotlin
        var typeStr = blockB.javaObjectType.kotlin.toString()
        if (typeStr.contains("String")) {
            blockA.forEach {
                if (it.javaClass.kotlin.equals(type)) str += it.toString()
            }
            return str
        }
        if (typeStr.contains("Int")) {
            blockA.forEach { if (it.javaClass.kotlin.equals(type)) num += it.toString().toInt() }
            return num
        }
        if (typeStr.contains("LocalDate")) {
            blockA.forEach { it ->
                if (it.javaClass.kotlin.equals(type)) date.add(it.toString().replace("-", "."))
            }
            return LocalDate.parse(date.maxBy { it }, DateTimeFormatter.ofPattern("yyyy.MM.d")).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
        }
        return this
    }
}
