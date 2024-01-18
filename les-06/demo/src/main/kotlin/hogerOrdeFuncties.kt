fun main() {
    val people = listOf(
        Person("Jan", "ABC", 12),
        Person("Piet", "XYZ", 23),
        Person("Joris", "MNO", 34)
    )

    people.forEach {
        println(it)
    }

    val fullnames = people.map { "${it.firstname} ${it.lastname}" }
    println(people)
    println(fullnames)
    val peopleAbove18 = people.filter { it.age > 18 }
    println(peopleAbove18)

    val splitPeople = people.groupBy { it.age > 18 }

    println(splitPeople)

    val totalAge = people.fold(0) { acc, person ->
        acc + person.age
    }


    println(totalAge)

    people.sortedBy { it.lastname }.forEach { println(it) }
}

data class Person(val firstname: String, val lastname: String, val age: Int)