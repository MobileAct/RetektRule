package retect.rule

import io.gitlab.arturbosch.detekt.api.Config
import io.gitlab.arturbosch.detekt.test.compileAndLint
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class InterfaceNameRuleTest {

    @Test
    fun testNoWarning() {
        val findings = InterfaceNameRule(Config.empty).compileAndLint(
            """
                interface ITest {}
                interface IValue<T>
                interface IStringValue : IValue<String>
            """.trimIndent()
        )
        assertEquals(0, findings.size)
    }

    @Test
    fun testWarning() {
        val findings = InterfaceNameRule(Config.empty).compileAndLint(
            """
                interface Test {}
                interface Value<T>
                interface StringValue : Value<String>
                interface VALUE
                interface VAL_LUE
            """.trimIndent()
        )
        assertEquals(5, findings.size)
    }
}