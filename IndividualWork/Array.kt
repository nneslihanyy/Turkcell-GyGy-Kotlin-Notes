fun main(){
 val cars = arrayOf("Volvo", "BMW", "Ford", "Mazda")
println(cars[0])// Outputs Volvo 
cars[0] = "Opel"
println(cars[0])// Now outputs Opel instead of Volvo
println(cars.size) //Outputs 4

if ("Volvo" in cars) {
  println("It exists!")
} else {
  println("It does not exist.")
}
for (x in cars) {
  println(x)
}
println("**********************")
val nums = arrayOf(1, 5, 10, 15, 20)
for (x in nums) {
  println(x)
}
for (chars in 'a'..'x') {
  println(chars)
}

for (nums in 5..15) {
  if (nums == 10) {
    break
  }
  println(nums)
} 

for (nums in 5..15) {
  if (nums == 10) {
    continue
  }
  println(nums)
} 

}