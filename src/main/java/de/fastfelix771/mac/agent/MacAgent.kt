package de.fastfelix771.mac.agent

import de.fastfelix771.mac.agent.javalin.JavalinServer

object MacAgent {
	
	fun initialize(args: Array<String>) {
		JavalinServer.start()
	}
	
}