package de.fastfelix771.mac.agent.javalin

import de.fastfelix771.mac.agent.config.ServerConfig
import de.fastfelix771.mac.agent.endpoints.global.responses.Error
import de.fastfelix771.mac.agent.endpoints.misc.API
import de.fastfelix771.mac.agent.util.ConfigUtil
import io.javalin.Context
import io.javalin.Javalin
import java.nio.file.Paths

object JavalinServer {
	
	init {
		ConfigUtil.save(ServerConfig(), Paths.get("config", "server.xml"), true)
	}
	
	val config = ConfigUtil.load(ServerConfig().javaClass, Paths.get("config", "server.xml"))

	fun start() {
		if (config == null) {
			println("Configuration '${Paths.get("config", "server.xml").toAbsolutePath().toString()}' could not be loaded, please check!")
			return
		}
		
		val app = Javalin.create().apply {
			before({ ctx: Context ->
			 	ctx.status(404)
			})
			
			after({ ctx: Context ->
				if (ctx.status() == 404) {
					Error.UNKNOWN_ENDPOINT.send(ctx)
				}
			})
			
			port(config.port)
			ipAddress(config.ip)
		}
		
		EndpointLoader.load(app, API.GLOBAL)
		EndpointLoader.load(app, API.v1)
		
		app.start()
	}

}