package de.fastfelix771.mac.agent.endpoints.v1

import de.fastfelix771.mac.agent.endpoints.misc.API
import de.fastfelix771.mac.agent.endpoints.misc.Endpoint
import de.fastfelix771.mac.agent.endpoints.misc.RequestMethod
import io.javalin.Context
import io.javalin.Handler

@Endpoint("/test/kotlin", api = API.v1, method = RequestMethod.GET, status = 200)
class TestKotlin : Handler {

	override fun handle(ctx: Context) {
		ctx.status(200)
		ctx.json(TestResponse("test"))
	}

}

data class TestResponse(var message: String, val timestamp: Long = System.currentTimeMillis())