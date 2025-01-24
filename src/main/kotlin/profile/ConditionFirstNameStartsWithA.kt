package profile

class ConditionFirstNameStartsWithA : Condition {
    override fun isSuitable(person: Person): Boolean {
        return person.firstName.startsWith("A")
    }
}