package profile

class ConditionMale : Condition {
    override fun isSuitable(person: Person): Boolean {
        return person.gender == Gender.MALE
    }
}