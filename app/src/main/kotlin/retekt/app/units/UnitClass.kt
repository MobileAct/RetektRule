package retekt.app.units

class UnitClass {

    fun fail1() = ""

    fun fail2() = fail1()

    fun fail3(): String {
        return ""
    }

    fun success1() = Unit

    fun success2(): Unit {

    }

    fun success3() {

    }

    private fun ignorePrivateFunction1() = ""

    private fun ignorePrivateFunction2() = ignorePrivateFunction1()

    private fun ignorePrivateFunction3(): String {
        return ""
    }
}