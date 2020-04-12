package subtask3

class Abbreviation {

    fun abbreviationFromA(a: String, b: String): String {
        var list = mutableListOf<Int>()
        var a = a.toUpperCase()
        var result = false
        b.toCharArray().forEach { i ->
            if (a.contains(i)) {
                result = true
                list.add(a.indexOf(i))
            } else {
                result = false
            }
        }
        if (result) {
            for (i in 0..list.size - 2) {
                if (list[i] < list[i + 1]) result = true else result = false
            }
        }
        if (result) return "YES" else return "NO"
    }
}
