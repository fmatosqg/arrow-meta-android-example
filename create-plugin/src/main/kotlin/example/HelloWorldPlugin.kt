package example

import arrow.meta.CliPlugin
import arrow.meta.Meta
import arrow.meta.invoke
import arrow.meta.quotes.Transform
import arrow.meta.quotes.namedFunction

val Meta.helloWorld: CliPlugin
    get() =
        "Hello World" {
            meta(
                namedFunction(this, { name == "helloWorld" }) { c ->
                    Transform.replace(
                        replacing = c,
                        newDeclaration =
                        """|fun helloWorld3(): String = "Hello ΛRROW Meta 123 4!"
               |""".function.syntheticScope
                    )
                }
            )
        }