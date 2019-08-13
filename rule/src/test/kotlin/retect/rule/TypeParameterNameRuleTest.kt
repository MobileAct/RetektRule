package retect.rule

import io.gitlab.arturbosch.detekt.api.Config
import io.gitlab.arturbosch.detekt.test.compileAndLint
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TypeParameterNameRuleTest {

    @Test
    fun testNoWarning() {
        val findings = TypeParameterNameRule(Config.empty).compileAndLint(
            """
                class Value<T, R> : IValue<T, R>
                interface IValue<T, R>
                class Action<TSource, TResult> : IAction<TSource, TResult>
                interface IAction<TSource, TResult>
            """.trimIndent()
        )
        assertEquals(0, findings.size)
    }

    @Test
    fun testWarning() {
        val findings = TypeParameterNameRule(Config.empty).compileAndLint(
            """
                class Action<Result> : IAction<Result>
                interface IAction<Result>
            """.trimIndent()
        )
        assertEquals(2, findings.size)
    }
}