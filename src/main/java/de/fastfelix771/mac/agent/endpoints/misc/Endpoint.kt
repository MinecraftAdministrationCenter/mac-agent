package de.fastfelix771.mac.agent.endpoints.misc

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class Endpoint (val value: String, val api: API, val method: RequestMethod, val status: Int)