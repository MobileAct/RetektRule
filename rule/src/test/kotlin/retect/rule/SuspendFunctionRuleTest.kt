package retect.rule

import io.gitlab.arturbosch.detekt.test.TestConfig
import io.gitlab.arturbosch.detekt.test.compileAndLint
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SuspendFunctionRuleTest {

    @Test
    fun testNoWarning_withIgnorePrivateFunction() {
        val config = TestConfig(mapOf("ignorePrivateFunction" to "true"))
        val findings = SuspendFunctionRule(config).compileAndLint(
            """
                class Test {
                    suspend fun a(){}
                    private fun b(){}
                }
            """.trimIndent()
        )
        assertEquals(0, findings.size)
    }

    @Test
    fun testWarning_withIgnorePrivateFunction() {
        val config = TestConfig(mapOf("ignorePrivateFunction" to "true"))
        val findings = SuspendFunctionRule(config).compileAndLint(
            """
                class Test {
                    fun a(){}
                    private fun b(){}
                }
            """.trimIndent()
        )
        assertEquals(1, findings.size)
    }

    @Test
    fun testNoWarning_withoutIgnorePrivateFunction() {
        val config = TestConfig(mapOf("ignorePrivateFunction" to "false"))
        val findings = SuspendFunctionRule(config).compileAndLint(
            """
                class Test {
                    suspend fun a(){}
                    private suspend fun b(){}
                }
            """.trimIndent()
        )
        assertEquals(0, findings.size)
    }

    @Test
    fun testWarning_withoutIgnorePrivateFunction() {
        val config = TestConfig(mapOf("ignorePrivateFunction" to "false"))
        val findings = SuspendFunctionRule(config).compileAndLint(
            """
                class Test {
                    fun a(){}
                    private fun b(){}
                }
            """.trimIndent()
        )
        assertEquals(2, findings.size)
    }
}