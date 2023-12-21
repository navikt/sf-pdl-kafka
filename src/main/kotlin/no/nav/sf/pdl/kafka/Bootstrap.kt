package no.nav.sf.pdl.kafka

import isTombstoneOrSalesforceTagged
import reduceByWhitelist

val application = KafkaPosterApplication<String, String>(
    envAsSettings(env_POSTER_SETTINGS),
    filter = if (devContext) ::isTombstoneOrSalesforceTagged else null,
    modifier = ::reduceByWhitelist
)

fun main() = application.start()
