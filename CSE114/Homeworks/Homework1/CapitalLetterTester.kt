//Edward Buckler
//111628438
//L05

import java.util.Scanner

object CapitalLetterTester {
    @JvmStatic
    fun main(args: Array<String>) {
        println("Enter a string :")
        val input = Scanner(System.`in`)
        val inputtedString = input.nextLine()
        var UpperCase = 0
        for (i in 0 until inputtedString.length) {
            val currentChar = inputtedString[i]
            if (Character.isUpperCase(currentChar)) {
                UpperCase++
            }
        }
        println("The number of uppercase letters is $UpperCase")
        input.close()
    }
}
