package de.fastfelix771.mac.agent.endpoints.global.responses

import de.fastfelix771.mac.agent.endpoints.misc.Response

class ErrorResponse(val error: Error): Response(false, error.message)