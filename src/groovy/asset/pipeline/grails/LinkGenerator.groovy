package asset.pipeline.grails


import groovy.util.logging.Slf4j
import org.codehaus.groovy.grails.commons.GrailsApplication
import org.codehaus.groovy.grails.plugins.support.aware.GrailsApplicationAware
import org.codehaus.groovy.grails.web.mapping.DefaultLinkGenerator


@Slf4j
class LinkGenerator extends DefaultLinkGenerator implements GrailsApplicationAware {

	GrailsApplication grailsApplication

	def assetProcessorService


	LinkGenerator(String serverUrl) {
		super(serverUrl)
	}


	String resource(Map attrs) {
		return asset(attrs) ?: super.resource(attrs)
	}

	/**
	 * Finds an Asset from the asset-pipeline based on the file attribute.
	 * @param attrs [file]
	 */
	String asset(Map attrs) {
		assetProcessorService.asset(attrs, this)
	}
}
