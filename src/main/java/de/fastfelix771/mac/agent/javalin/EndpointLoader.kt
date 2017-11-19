package de.fastfelix771.mac.agent.javalin

import de.fastfelix771.mac.agent.endpoints.misc.API
import de.fastfelix771.mac.agent.endpoints.misc.Endpoint
import de.fastfelix771.mac.agent.endpoints.v1.TestKotlin
import io.javalin.Handler
import io.javalin.Javalin
import org.reflections.Reflections

object EndpointLoader {
	
	fun load(app: Javalin, version: API) {
		val path = version.internalPath;
		val reflections = Reflections(path)
		val endpoints = reflections.getTypesAnnotatedWith(Endpoint::class.java)
		
		for (endpoint in endpoints) {
			val annotation = endpoint.getAnnotation(Endpoint::class.java)
			
			val url = annotation.value;
			val apiVersion = annotation.api;
			
			if (apiVersion != version) continue;
			
			app.get("/${version}/$url/".replace("//", "/"), endpoint.newInstance() as Handler)
			println("Loaded API ${version} Endpoint '${endpoint.simpleName}', mapped to '$url'")
		}
	}
	
}