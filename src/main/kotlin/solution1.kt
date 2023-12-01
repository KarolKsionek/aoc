fun main() {
    val file = FileHelper.getFile("input1.txt")
    var sum = 0
    try {
        file.forEachLine { line ->
            sum += processLine(line)
        }
    } catch (e: Exception) {
        println("An error occurred: ${e.message}")
    }

    println("Result is $sum")
}

fun processLine(line: String): Int {
    var firstDigit = -1
    var lastDigit = -1
    for (character in line) {
        if (character.isDigit()) {
            if (firstDigit == -1) {
                firstDigit = character.digitToInt()
                lastDigit = firstDigit
            } else {
                lastDigit = character.digitToInt()
            }
        }
    }
    return "$firstDigit$lastDigit".toInt()
}