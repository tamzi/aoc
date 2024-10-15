package aoc2015.solution.day1



fun notQuiteLisp(instructions: String): Int {
    var floor = 0
    for (char in instructions) {
        when (char) {
            '(' -> floor++
            ')' -> floor--
        }
    }
    return floor
}

fun main() {
    // link to the input file in resources
    val instructions = object {}.javaClass.getResource("/001Input.txt")?.readText()

    // link to the function 'notQuiteLisp' above to get the result and print it
    if (instructions != null) {
        println(notQuiteLisp(instructions))
    } else {
        println("Error: Input file not found.")
    }
}