import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

fun main() {
    val device = Device("HP") // Geen new nodig

    device.turnOff()
    device.turnOn()

    println(device.brand)
    println(device.volume)
    device.volume = 75
}

class RangeChecker(initialValue: Int, private val minValue: Int, private val maxValue: Int) :
    ReadWriteProperty<Any?, Int> {

    var fieldValue = initialValue

    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return fieldValue
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        if (value in minValue..maxValue) {
            fieldValue = value
        }
    }
}

class Device(val brand: String, val model: String, initialVolume: Int = 50) {

    constructor(brand: String) : this(brand, "Unkown")

    var volume by RangeChecker(initialVolume, 0, 100)

    var batteryPercentage by RangeChecker(100, 0, 100)

    init {
        println("Init")
    }

    fun turnOn() {
        println("Device is turning on!")
    }

    fun turnOff() {
        println("Device is turning off!")
    }
}