fun main() {
    val file = FileHelper.getFile("input1.txt")
    var sum = 0
    try {
        file.forEachLine { line ->
            sum += processLine2(line)
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

val dictionary = mapOf(
    "one" to 1,
    "two" to 2,
    "three" to 3,
    "four" to 4,
    "five" to 5,
    "six" to 6,
    "seven" to 7,
    "eight" to 8,
    "nine" to 9,
)

fun processLine2(line: String): Int {
    var firstDigit = -1
    var lastDigit = -1
    var buffer = StringBuffer()
    for (character in line) {
        if (character.isDigit()) {
            buffer = StringBuffer()
            if (firstDigit == -1) {
                firstDigit = character.digitToInt()
                lastDigit = firstDigit
            } else {
                lastDigit = character.digitToInt()
            }
        } else {
            buffer.append(character)
            val currentWord = buffer.toString()
            val foundMatch = dictionary.entries.firstOrNull { (word, _) -> currentWord.endsWith(word) }?.value
            if (foundMatch != null) {
                if (firstDigit == -1) {
                    firstDigit = foundMatch
                    lastDigit = firstDigit
                } else {
                    lastDigit = foundMatch
                }
            }
        }
    }
    return "$firstDigit$lastDigit".toInt()
}