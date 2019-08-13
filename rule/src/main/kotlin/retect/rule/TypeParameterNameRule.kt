package retect.rule

import io.gitlab.arturbosch.detekt.api.*
import org.jetbrains.kotlin.psi.KtTypeParameter

class TypeParameterNameRule(config: Config) : Rule(config) {

    private val typeParameterPattern by LazyRegex("typeParameterPattern", "^[A-Z]|(T([A-Z][a-z0-9]+)+)\$")

    override val issue = Issue(
        "TypeParameterNaming",
        Severity.Style,
        "A type parameter's name must fit the naming pattern defined in the projects configurations",
        debt = Debt.FIVE_MINS
    )

    override fun visitTypeParameter(parameter: KtTypeParameter) {
        super.visitTypeParameter(parameter)

        if (parameter.name?.matches(typeParameterPattern) != true) {
            report(
                CodeSmell(
                    issue,
                    Entity.from(parameter),
                    message = "type parameter ${parameter.name} must match the pattern: $typeParameterPattern"
                )
            )
        }
    }
}