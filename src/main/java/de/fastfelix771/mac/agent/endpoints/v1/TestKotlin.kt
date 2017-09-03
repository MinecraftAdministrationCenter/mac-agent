package de.fastfelix771.mac.agent.endpoints.v1

import io.javalin.Context
import io.javalin.Handler
import de.fastfelix771.mac.agent.misc.Endpoint

@Endpoint("/test/kotlin")
class TestKotlin : Handler {

	override fun handle(ctx: Context) {
		ctx.result("kotlin handler working")
		ctx.status(201)
	}

}