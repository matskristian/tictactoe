/**
 * BMI
 */
fun main() {
    print("Oppgi din vekt: ")
    val vekt: String? = readLine()

    print("Oppgi din høyde: ")
    val høyde: String? = readLine()

    try {
        val doubleHøyde: Double = høyde!!.toDouble()
        val doubleVekt: Double = vekt!!.toDouble()
        val bmi = (doubleVekt / (doubleHøyde * doubleHøyde))
        println("Din BMI = $bmi")
        when (bmi) {
            in 0.0..18.49 -> println("undervekt")
            in 18.5..24.99 -> println("normalvekt")
            in 25.0..29.99 -> println("overvekt")
            else -> println("fedme")
        }
    } catch (e: Exception) {
        println("Feil format på innlest tall. ${e.message}" )
    }
}