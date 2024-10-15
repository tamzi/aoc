package aoc2015.solution.day1


fun notQuiteLispPart2(instructions: String): Int {
    var floor = 0
    for ((index, char) in instructions.withIndex()) {
        when (char) {
            '(' -> floor++
            ')' -> floor--
        }
        if (floor == -1) {
            return index + 1 // Add 1 to account for 1-based indexing
        }
    }
    // THis returns -1 if basement is never entered
    return -1
}

fun main() {
    // link to the input file in resources
    val instructions = object {}.javaClass.getResource("/001Input.txt")?.readText()

    // link to the function 'notQuiteLispPart2' above to get the result and print it
    if (instructions != null) {
        println(notQuiteLispPart2(instructions))
    } else {
        println("Error: Input file not found.")
    }
}