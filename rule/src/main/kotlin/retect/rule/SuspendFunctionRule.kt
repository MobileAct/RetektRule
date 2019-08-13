package retect.rule

import io.gitlab.arturbosch.detekt.api.*
import org.jetbrains.kotlin.lexer.KtTokens
import org.jetbrains.kotlin.psi.KtNamedFunction
import org.jetbrains.kotlin.psi.psiUtil.isPrivate

class SuspendFunctionRule(config: Config) : Rule(config) {

    private val isIgnorePrivateFunction = config.valueOrDefault("ignorePrivateFunction", true)

    override val issue = Issue(
        "SuspendFunction",
        Severity.Warning,
        "All function is required suspend modifier",
        debt = Debt.FIVE_MINS
    )

    override fun visitNamedFunction(function: KtNamedFunction) {
        super.visitNamedFunction(function)
        if ((function.isPrivate().not() || isIgnorePrivateFunction.not()) && function.hasModifier(KtTokens.SUSPEND_KEYWORD).not()) {
            report(
                CodeSmell(
                    issue,
                    Entity.from(function),
                    message = "function ${function.name} must have suspend modifier"
                )
            )
        }
    }
}