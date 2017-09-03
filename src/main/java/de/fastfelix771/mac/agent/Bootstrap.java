package de.fastfelix771.mac.agent;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Bootstrap {
	
	public static void main(String[] args) {
		MacAgent.INSTANCE.initialize(args);
	}

}
