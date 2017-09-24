package de.fastfelix771.mac.agent.util

import com.google.common.base.Supplier
import com.google.common.base.Suppliers
import java.nio.file.Path
import java.util.concurrent.TimeUnit
import javax.xml.bind.JAXB
import javax.xml.bind.JAXBContext
import javax.xml.bind.Marshaller

object ConfigUtil {
	
	fun save(config: Any, path: Path, overwrite: Boolean = false, encoding: String = "UTF-8", formatted: Boolean = true) {
		val file = path.toAbsolutePath().toFile()
		
		if (file.exists() && !overwrite) return
		else file.getParentFile().mkdirs()
		
		val context = JAXBContext.newInstance(config.javaClass)
		val marshaller = context.createMarshaller()
		
		marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding)
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, formatted)
		
		marshaller.marshal(config, file)
	}
	
	fun <T> load(configClass: Class<T>, path: Path, default: T? = null): T? {
		val config = JAXB.unmarshal(path.toAbsolutePath().toFile(), configClass)
		return if (config != null) config else default
	}
	
	fun <T> provide(configClass: Class<T>, path: Path, default: T? = null): Supplier<T?> {
		return Suppliers.memoizeWithExpiration(Provider(configClass, path, default), 5, TimeUnit.MINUTES)
	}
	
	private class Provider<T>(val configClass: Class<T>, val path: Path, val default: T? = null): Supplier<T> {
		
		override fun get(): T? {
			return load(configClass, path, default)
		}
		
	}
	
}