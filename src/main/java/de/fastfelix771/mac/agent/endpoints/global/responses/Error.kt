package de.fastfelix771.mac.agent.endpoints.global.responses

import io.javalin.Context

enum class Error(val message: String, val errorCode: Int) {

	UNKNOWN_ENDPOINT ("The requested endpoint doesn't exist!", 404),
	OTHER("An unknown / unspecified error occurred!", 500),
	NOT_AUTHENTICATED("Missing or invalid authentication token!", 403),
	NOT_AUTHORIZED("Your token is not authorized for this operation!", 401);

	infix fun close(ctx: Context) {
		ctx.status(this.errorCode)
		ctx.json(ErrorResponse(this))
	}

}