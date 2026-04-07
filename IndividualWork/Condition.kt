fun main(){
    /*
Less than: a < b
Less than or equal to: a <= b
Greater than: a > b
Greater than or equal to: a >= b
Equal to a == b
Not Equal to: a != b
 */

/* Kotlin has the following conditionals:

Use if to specify a block of code to be executed, if a specified condition is true
Use else to specify a block of code to be executed, if the same condition is false
Use else if to specify a new condition to test, if the first condition is false
Use when to specify many alternative blocks of code to be executed
Note: Unlike Java, if..else can be used as a statement or as an expression (to assign a value to a variable) in Kotlin. 
*/
val time = 20
val greeting2 = if (time < 18) {
  "Good day."
} else {
  "Good evening."
}
println(greeting2)

val day = 4

val result = when (day) {
  1 -> "Monday"
  2 -> "Tuesday"
  3 -> "Wednesday"
  4 -> "Thursday"
  5 -> "Friday"
  6 -> "Saturday"
  7 -> "Sunday"
  else -> "Invalid day."
}
println(result)
println("****************")
}