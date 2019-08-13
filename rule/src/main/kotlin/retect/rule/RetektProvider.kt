package retect.rule

import io.gitlab.arturbosch.detekt.api.Config
import io.gitlab.arturbosch.detekt.api.RuleSet
import io.gitlab.arturbosch.detekt.api.RuleSetProvider

class RetektProvider : RuleSetProvider {

    override val ruleSetId = "retekt"

    override fun instance(config: Config): RuleSet {
        return RuleSet(
            ruleSetId,
            listOf(
                InterfaceNameRule(config),
                TypeParameterNameRule(config),
                SuspendFunctionRule(config),
                UnitFunctionRule(config)
            )
        )
    }
}