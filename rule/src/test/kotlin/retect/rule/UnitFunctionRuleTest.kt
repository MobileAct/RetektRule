package retect.rule

import io.gitlab.arturbosch.detekt.test.TestConfig
import io.gitlab.arturbosch.detekt.test.compileAndLint
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class UnitFunctionRuleTest {

    @Test
    fun testNoWarning_withIgnorePrivateFunction() {
        val config = TestConfig(mapOf("ignorePrivateFunction" to "true"))
        val findings = UnitFunctionRule(config).compileAndLint(
            """
                class Test {
                    fun a() {}
                    fun b() = Unit
                    private fun c(): String {
                        return ""
                    }
                    private fun d() = ""
                    private fun e(): String = ""
                }
            """.trimIndent()
        )
        assertEquals(0, findings.size)
    }

    @Test
    fun testWarning_withIgnorePrivateFunction() {
        val config = TestConfig(mapOf("ignorePrivateFunction" to "true"))
        val findings = UnitFunctionRule(config).compileAndLint(
            """
                class Test {
                    fun a(): String {
                        return ""
                    }
                    fun b(): String = ""
                    fun c(): String = b()
                }
            """.trimIndent()
        )
        assertEquals(3, findings.size)
    }

    @Test
    fun testNoWarning_withoutIgnorePrivateFunction() {
        val config = TestConfig(mapOf("ignorePrivateFunction" to "false"))
        val findings = UnitFunctionRule(config).compileAndLint(
            """
                class Test {
                    fun a() {}
                    fun b() = Unit
                    private fun c(): Unit {}
                    private fun d() = Unit
                }
            """.trimIndent()
        )
        assertEquals(0, findings.size)
    }

    @Test
    fun testWarning_withoutIgnorePrivateFunction() {
        val config = TestConfig(mapOf("ignorePrivateFunction" to "false"))
        val findings = UnitFunctionRule(config).compileAndLint(
            """
                class Test {
                    fun a(): String {
                        return ""
                    }
                    fun b(): String = ""
                    fun c(): String = b()
                    private fun d(): String = ""
                    private fun e(): String{
                        return ""
                    }
                }
            """.trimIndent()
        )
        assertEquals(5, findings.size)
    }
}