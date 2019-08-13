package retect.rule

import io.gitlab.arturbosch.detekt.api.*
import org.jetbrains.kotlin.psi.KtNamedFunction
import org.jetbrains.kotlin.psi.psiUtil.isPrivate

class UnitFunctionRule(config: Config) : Rule(config) {

    private val isIgnorePrivateFunction = config.valueOrDefault("ignorePrivateFunction", true)

    override val issue = Issue(
        "UnitFunction",
        Severity.Warning,
        "All function is required void-return",
        debt = Debt.FIVE_MINS
    )

    override fun visitNamedFunction(function: KtNamedFunction) {
        super.visitNamedFunction(function)

        if ((function.isPrivate().not() || isIgnorePrivateFunction.not()) && isUnitFunction(function).not()) {
            report(
                CodeSmell(
                    issue,
                    Entity.from(function),
                    message = "function ${function.name} must be void-return"
                )
            )
        }
    }

    private fun isUnitFunction(function: KtNamedFunction): Boolean {
        if (function.hasDeclaredReturnType()) {
            return function.typeReference?.typeElement?.text == "Unit"
        } else {
            if (function.bodyBlockExpression != null) {
                return true
            }
            val bodyExpression = function.bodyExpression
            return bodyExpression == null || bodyExpression.text == "Unit"
        }
    }
}