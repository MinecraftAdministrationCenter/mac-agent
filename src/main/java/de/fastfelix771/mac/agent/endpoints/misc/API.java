package de.fastfelix771.mac.agent.endpoints.misc;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum API {
	
	GLOBAL("de.fastfelix771.mac.agent.endpoints.global"),
	v1("de.fastfelix771.mac.agent.endpoints.v1");
	
	public final String internalPath;

}
