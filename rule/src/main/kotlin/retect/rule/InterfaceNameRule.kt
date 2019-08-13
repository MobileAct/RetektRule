package retect.rule

import io.gitlab.arturbosch.detekt.api.*
import org.jetbrains.kotlin.psi.KtClass

class InterfaceNameRule(config: Config) : Rule(config) {

    private val interfacePattern by LazyRegex("interfacePattern", "^I[A-Z][A-Za-z0-9]*")

    override val issue = Issue(
        "InterfaceNaming",
        Severity.Style,
        "A interface's name must fit the naming pattern defined in the projects configurations",
        debt = Debt.FIVE_MINS
    )

    override fun visitClass(klass: KtClass) {
        super.visitClass(klass)

        if (klass.isInterface().not()) {
            return
        }

        if (klass.name?.matches(interfacePattern) != true) {
            report(
                CodeSmell(
                    issue,
                    Entity.from(klass),
                    message = "interface ${klass.name} must match the pattern: $interfacePattern"
                )
            )
        }
    }
}