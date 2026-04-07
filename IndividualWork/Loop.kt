fun main(){

    //while
var i = 0
while (i < 5) {
  println(i)
  i++
} 
println("****************")
//do while
var i2 = 0
do {
  println(i2)
  i2++
  }
while (i2 < 5) 
println("****************")
//break
var i3 = 0
while (i3 < 10) {
  println(i3)
  i3++
  if (i3 == 4) {
    break
  }
}
println("****************")
//continue
var i4 = 0
while (i4 < 10) {
  if (i4 == 4) {
    i4++
    continue
  }
  println(i4)
  i4++
}


}