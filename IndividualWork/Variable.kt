fun main(){
/*
Variable Names
A variable can have a short name (like x and y) or more descriptive names (age, sum, totalVolume).

The general rule for Kotlin variables are:

Names can contain letters, digits, underscores, and dollar signs
Names should start with a letter
Names can also begin with $ and _ (but we will not use it in this tutorial)
Names are case sensitive ("myVar" and "myvar" are different variables)
Names should start with a lowercase letter and it cannot contain whitespace
Reserved words (like Kotlin keywords, such as var or String) cannot be used as names
 */


     println("Hello World")
     println(3 + 3)
     // This is a comment
     /* The code below will print the words Hello World
to the screen, and it is amazing */
var name = "John"
var lastname =" Doe"
val birthyear = 1975

println(name)          // Print the value of name
println(birthyear)     // Print the value of birthyear
println("Hello " + name)
val fullName = name + lastname
println(fullName)
println("My name is $name $lastname")
/*
The difference between var and val is that variables
 declared with the var keyword can be changed/modified, 
while val variables cannot.
 */
var name2: String = "Neslihan" // String
val birthyear2: Int = 2002 // Int

println(name2)
println(birthyear2)

/*val name3 = "John"
name3 = "Robert"  // Error (Val cannot be reassigned)
println(name3))*/

val x = 5
val y = 6
println(x + y) // Print the value of x + y 

val myNum: Int = 5                // Int
val myDoubleNum: Double = 5.99    // Double
val myLetter: Char = 'D'          // Char
val myBoolean: Boolean = true     // Boolean
val myText: String = "Hello"      // String

/*
Number types are divided into two groups:
Integer types store whole numbers, positive or negative (such as 123 or -456), without decimals.
Valid types are Byte, Short, Int and Long.
Floating point types represent numbers with a fractional part, containing one or more decimals. 
There are two types: Float and Double. */

val x2: Int = 5
val y2: Long = x2.toLong()
println(y2)

var greeting: String = "Hello"
println(greeting)

var txt = "Hello World"
var txt2 = "Hello World"

println(txt[0]) // first element (H)
println(txt[2]) // third element (l)
println(txt.uppercase())   // Outputs "HELLO WORLD"
println(txt.lowercase())   // Outputs "hello world"
println(txt.compareTo(txt2))  // Outputs 0 (they are equal)

var txt3 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
println("The length of the txt string is: " + txt3.length)

var txt4 = "Please locate where 'locate' occurs!"
println(txt4.indexOf("locate"))  // Outputs 7

val isKotlinFun: Boolean = true
val isFishTasty: Boolean = false
println(isKotlinFun)   // Outputs true
println(isFishTasty)   // Outputs false 

val x3 = 10
val y3 = 9
println(x3 > y3) // Returns true, because 10 is greater than 9

println(10 == 15); // Returns false, because 10 is not equal to 15




}