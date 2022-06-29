fun main() {
    println("Hello World!")
    println(3)
    println(3*3)
    val year = 2022
    println("Year: " + year)

    val subjectName: String = "SIR1"
    var subjectYear: Int = 2022
    subjectYear++
    // subjectName++

    println("Subject name is $subjectName and the year of attendance is ${subjectYear - 1}")

//    subjectName = "SIR2"
//    subjectYear = 2023


    val a = subjectName
    val A = subjectYear

    val intVariable = 5          // Int
    val doubleVariable = 5.99    // Double
    val charVariable = 'D'       // Char
    val stringVariable = "Hello" // String
    val booleanVariable = true   // Boolean


    val one = 1                     // Int
    val threeBillion = 3000000000   // Long
    val oneLong = 1L                // Long
    val oneByte: Byte = 1           // Byte

    val floatValue = 1.2345567f
    val doubleValue = 1.234567

    val stringValue = "this is string"
    println(stringValue.length)

    println(stringValue.uppercase()) // Kreiranje novog objekta i njegovo štampanje
    println(stringValue) // Originalni nepromenjeni string

    val numberArray = arrayOf(1, 2, 3)
    val stringArray = arrayOf("one", "two", "three")

    println(stringArray[0])
    stringArray[2] = "four"

    if ("four" in stringArray) {
        print("yes")
    } else {
        print ("no")
    }

    for (stringValue in stringArray) {
        print(stringValue)
    }

    for (number in 0..10) {
        print(number)
    }

    for (letter in 'a'..'x') {
        print(letter)
    }

    val aa: Int = 4
    val bb: Float = aa.toFloat()

    // 100 i 50 su operandi, + operator
    var x = 100 + 50

    println(stringValue.uppercase())
    println(stringValue.lowercase())

    println(stringValue.compareTo("this is another string"))
    println(stringValue.indexOf("this"))
    println(stringValue.plus("concatenated string"))

    val isUppercase = true

    val address = if (isUppercase) stringValue.uppercase() else stringValue.lowercase()

    printText("This is function")

    printText()

    fun multiply(a: Int, b: Int): Int {
        return a * b
    }

    val result = multiply(5, 2)

    fun multiplyShorter(a: Int, b: Int) = a * b

    val resultShorter = multiplyShorter(2, 2)

    val student = Student1("Lena")
    student.index = 1295
    // student.firstName = "Lena"


    print(student.firstName)
}

fun printText(text: String? = "Default text for function") {
    println(text)
}


