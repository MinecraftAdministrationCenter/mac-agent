package de.fastfelix771.mac.agent.config

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlAttribute
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement(name = "app-config")
@XmlAccessorType(XmlAccessType.FIELD)
class AppConfig {
	
	@XmlAttribute(name = "hide-version")
	val hideVersion = true
	
}