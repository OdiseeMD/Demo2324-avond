fun main() {
    val printText: () -> Unit


    val delayPrinter = { timeString: String, minutes: Int ->
        "$timeString + $minutes minuten"
    }


    printText = printDisplay(false, delayPrinter) { println(it) }

    printText()
}

fun printDisplay(
    isOnTime: Boolean,
    delayString: ((String, Int) -> String)? = null,
    printer: (String) -> Unit,
): () -> Unit {
    val onTime = {
        printer("🚂 is op tijd")
    }
    val toLate = {
        printer("🚂 is te laat")
        if (delayString != null) {
            printer(delayString("12:00", 10))
        }
    }

    return if (isOnTime) {
        onTime
    } else {
        toLate
    }
}
