package de.fastfelix771.mac.agent.config

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlRootElement
import javax.xml.bind.annotation.XmlAttribute

@XmlRootElement(name = "server-config")
@XmlAccessorType(XmlAccessType.FIELD)
class ServerConfig {
	
	@XmlAttribute(name = "ip")
	val ip = "0.0.0.0"
	
	@XmlAttribute(name = "port")
	val port = 8080
	
	@XmlAttribute(name = "max-requests-per-second")
	val requestLimit = 4096
	
}