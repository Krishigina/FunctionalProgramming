package profile

fun main() {
    val profiles = ProfilesRepository.profiles
    var filtered = filter(profiles, object: Condition{
        override fun isSuitable(person: Person): Boolean {
            return person.age > 25
        }
    })
    filtered = filter(filtered, object: Condition{
        override fun isSuitable(person: Person): Boolean {
            return person.gender.equals(Gender.MALE)
        }
    })
    filtered = filter(filtered, object: Condition{
        override fun isSuitable(person: Person): Boolean {
            return person.firstName.startsWith("A")
        }
    })
    for (person in filtered){
        println(person)
    }
}
fun filter(profiles: List<Person>, condition: Condition): List<Person>{
    val result = mutableListOf<Person>()
    for (person in profiles){
        if (condition.isSuitable(person)){
            result.add(person)
        }
    }
    return result
}