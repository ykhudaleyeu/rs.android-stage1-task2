package subtask6

class Fibonacci {

    fun productFibonacciSequenceFor(n: Int): IntArray {
        var a = 0
        var b = 1
        var c = a
        lateinit var result: IntArray
        while (n > a * b) {
            a += b
            c = b
            b += a
        }
        if (a * b == n) result = intArrayOf(a, b, 1)
        if (a * c == n) result = intArrayOf(c, a, 1)
        if (a * b > n && a * c < n) result = intArrayOf(a, b, 0)
        if (a * b > n && a * c > n) result = intArrayOf(c, a, 0)
        return result
    }
}
