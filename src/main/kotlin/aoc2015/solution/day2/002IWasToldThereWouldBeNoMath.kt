package aoc2015.solution.day2

/**
 * --- Day 2: I Was Told There Would Be No Math ---
 *
 * The elves are running low on wrapping paper, and so they need to submit an order for more.
 * They have a list of the dimensions (length l, width w, and height h) of each present,
 * and only want to order exactly as much as they need.
 *
 * Fortunately, every present is a box (a perfect right rectangular prism), which makes calculating the required wrapping paper for each gift a little easier: find the surface area of the box, which is 2*l*w + 2*w*h + 2*h*l. The elves also need a little extra paper for each present: the area of the smallest side.
 * For example:
 * A present with dimensions 2x3x4 requires 2*6 + 2*12 + 2*8 = 52 square feet of wrapping paper plus 6 square feet of slack, for a total of 58 square feet.
 * A present with dimensions 1x1x10 requires 2*1 + 2*10 + 2*10 = 42 square feet of wrapping paper plus 1 square foot of slack, for a total of 43 square feet.
 * All numbers in the elves' list are in feet. How many total square feet of wrapping paper should they order?
 *
 */


/**
 * Question analysis:
 * To find Surface area of the box to be wrapped:
 * - 2*l*w + 2*w*h + 2*h*l
 *
 * To find the area of the smallest side:
 * - min(l*w, w*h, h*l)
 *
 * Total wrapping paper needed, which is the total wrapping paper needed for each present:
 * - Surface area + area of the smallest side
 *
 * - 2*l*w + 2*w*h + 2*h*l + min(l*w, w*h, h*l)
 *
 *  To find the total wrapping paper needed for all presents:
 *  - sum of the total wrapping paper needed for each present
 *
 *
 *  For example:
 *  - 2x3x4
 *  - 2*6 + 2*12 + 2*8 + min(6, 8, 12) = 52 + 6 = 58
 *  - 1x1x10
 *  - 2*1 + 2*10 + 2*10 + min(1, 10, 10) = 42 + 1 = 43
 *  To find the total wrapping paper needed for all presents:
 *  - sum of the total wrapping paper needed for each present
 *  - 58 + 43 = 101
 *
 * */
fun thereWouldBeNoMath(l: Int, w: Int, h: Int): Int {
    //Since box has 6 sides, we need to calculate the area of each side and add them together.
    //But the sides of the box reflect each other, so we can calculate the area of 3 sides and multiply by 2
    //Brute force way to calculate the area of each side:
    val side1 = l * w
    val side2 = w * h
    val side3 = h * l
    val surfaceArea = 2 * side1 + 2 * side2 + 2 * side3

    //To find the area of the smallest side:
    val smallestSide = listOf(side1, side2, side3).minOrNull()!!

    //to get the total wrapping paper needed, which is the total wrapping paper needed for each present:
    return surfaceArea + smallestSide
}

