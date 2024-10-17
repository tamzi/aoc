package aoc2015.solution.day2

/**
 * --- Day 2: I Was Told There Would Be No Math ---
 *
 * --- Part Two ---
 * The elves are also running low on ribbon.
 * Ribbon is all the same width, so they only have to worry about the length they need to order,
 * which they would again like to be exact.
 *
 * The ribbon required to wrap a present is the shortest distance around its sides, or
 * the smallest perimeter of any one face.
 * Each present also requires a bow made out of ribbon as well; the feet of ribbon required for the perfect bow
 * is equal to the cubic feet of volume of the present.
 *
 * Don't ask how they tie the bow, though; they'll never tell.
 *
 * For example:
 *
 * A present with:
 *  dimensions 2x3x4 requires 2+2+3+3 = 10 feet of ribbon to wrap the present plus 2*3*4 = 24 feet of ribbon for the bow,
 * for a total of 34 feet.
 *
 * A present with:
 * dimensions 1x1x10 requires 1+1+1+1 = 4 feet of ribbon to wrap the present plus 1*1*10 = 10 feet of ribbon for the bow,
 * for a total of 14 feet.
 *
 * How many total feet of ribbon should they order?
 */


/**
 * Question analysis:
 * Ribbon required to wrap a present == the shortest distance around its sides.
 *
 * From our math when calculating shortest distance == smallest perimeter of any one face.
 *
 *  NOTE: Distance around a surface == perimeter of the surface.
 *  Perimeter of a rectangle == 2 * (length + width)
 *
 * Each present also requires a bow made out of ribbon as well;
 * the feet of ribbon required for the perfect bow is equal to the cubic feet of volume of the present.
 *
 * From our math when calculating Cubic feet of volume == volume
 * NOTE: Cubic feet of volume of the present == volume length * width * height
 * Volume of the present(Cuboid/rectangle with height) == length * width * height
 *
 * To find the total feet of ribbon required:
 * Smallest perimeter of any one face + Cubic feet of volume of the present
 *
 * We can find the smallest perimeter of any one face:
 * - We can find the smallest side of the present by finding the area of each side and getting the smallest area.
 * - or we need to find the smallest side of the present.
 *
 * To find the cubic feet of volume of the present: we need to multiply the dimensions of the present.
 *
 * To get the total feet of ribbon required, we need to add the smallest perimeter of any one face and the cubic feet of volume of the present.
 *
 * */
fun thereWouldBeNoMathPart2(l: Int, w: Int, h: Int): Int {
    //Since box has 6 sides, we need to calculate the perimeter of each side and add them together.
    //But the sides of the box reflect each other, so we can calculate the area of 3 sides and multiply by 2
    //Brute force way to calculate the perimeter of each side:
    val side1FacePerimeter = 2 * l + 2 * w
    val side2FacePerimeter = 2 * w + 2 * h
    val side3FacePerimeter = 2 * h + 2 * l

    //Smallest perimeter of any one face:
    val smallestPerimeterOfFace = listOf(side1FacePerimeter, side2FacePerimeter, side3FacePerimeter).minOrNull()!!

    //Find the cubic feet of volume of the present:
    val cubicVolume = l * w * h

    // smallestPerimeterOfFace + cubicVolume to get the total feet of ribbon required
    return smallestPerimeterOfFace + cubicVolume

}



fun main() {
    // link to the input file in resources
    val noMathInputPart2 = object {}.javaClass.getResource("/002Input.txt")?.readText()

    // function to get the result and print it
    if (noMathInputPart2 != null) {
        val totalWrappingPaper = noMathInputPart2.lines().map {
            val (l, w, h) = it.split("x").map { it.toInt() }
            thereWouldBeNoMathPart2(l, w, h)
        }.sum()
        println(totalWrappingPaper)
        // if the file does not exist, we print an error message as shown
    } else {
        println("Error: Input file not found.")
    }
}




