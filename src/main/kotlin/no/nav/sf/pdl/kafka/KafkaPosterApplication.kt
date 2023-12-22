package no.nav.sf.pdl.kafka

import mu.KotlinLogging
import no.nav.sf.pdl.kafka.nais.PrestopHook
import no.nav.sf.pdl.kafka.nais.ShutdownHook
import no.nav.sf.pdl.kafka.nais.enableNAISAPI

/**
 * KafkaPosterApplication
 * This is the top level of the integration. Its function is to setup a server with the required
 * endpoints for the kubernetes environement (see enableNAISAPI)
 * and create a work loop that alternatives between work sessions (i.e polling from kafka until we are in sync) and
 * an interruptable pause (configured with MS_BETWEEN_WORK).
 */
class KafkaPosterApplication<K, V>(
    val settings: List<KafkaToSFPoster.Settings> = listOf(),
    filter: ((String, Long) -> Boolean)? = null,
    modifier: ((String, Long) -> String)? = null
) {
    val pdlPoster = KafkaToSFPoster<K, V>(settings, filter, modifier)
    val gtPoster = KafkaToSFPoster<K, V>(settings)

    private val bootstrapWaitTime = envAsLong(env_MS_BETWEEN_WORK)

    private val log = KotlinLogging.logger { }
    fun start() {
        log.info { "Starting app ${envOrNull(env_DEPLOY_APP)} - context $devContext with poster settings ${envAsSettings(env_POSTER_SETTINGS)}" }
        enableNAISAPI {
            loop()
        }
        log.info { "Finished" }
    }

    private tailrec fun loop() {
        val stop = ShutdownHook.isActive() || PrestopHook.isActive()
        when {
            stop -> Unit.also { log.info { "Stopped" } }
            !stop -> {
                pdlPoster.runWorkSession(env(env_KAFKA_TOPIC_PERSONDOKUMENT))
                gtPoster.runWorkSession(env(env_KAFKA_TOPIC_GEOGRAFISKTILKNYTNING))
                conditionalWait(bootstrapWaitTime)
                loop()
            }
        }
    }
}
