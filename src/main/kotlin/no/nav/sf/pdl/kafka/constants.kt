package no.nav.sf.pdl.kafka

const val env_DEPLOY_APP = "DEPLOY_APP"
const val env_DEPLOY_CLUSTER = "DEPLOY_CLUSTER"
const val env_POSTER_SETTINGS = "POSTER_SETTINGS"

const val env_MS_BETWEEN_WORK = "MS_BETWEEN_WORK"

// Kafka environment dependencies
const val env_KAFKA_BROKERS = "KAFKA_BROKERS"
const val env_KAFKA_CLIENTID = "KAFKA_CLIENTID"
const val env_KAFKA_TOPIC_PERSONDOKUMENT = "KAFKA_TOPIC_PERSONDOKUMENT"
const val env_KAFKA_TOPIC_GEOGRAFISKTILKNYTNING = "KAFKA_TOPIC_GEOGRAFISKTILKNYTNING"
const val env_KAFKA_POLL_DURATION = "KAFKA_POLL_DURATION"
const val env_KAFKA_KEYSTORE_PATH = "KAFKA_KEYSTORE_PATH"
const val env_KAFKA_CREDSTORE_PASSWORD = "KAFKA_CREDSTORE_PASSWORD"
const val env_KAFKA_TRUSTSTORE_PATH = "KAFKA_TRUSTSTORE_PATH"
const val env_KAFKA_SCHEMA_REGISTRY = "KAFKA_SCHEMA_REGISTRY"
const val env_KAFKA_SCHEMA_REGISTRY_USER = "KAFKA_SCHEMA_REGISTRY_USER"
const val env_KAFKA_SCHEMA_REGISTRY_PASSWORD = "KAFKA_SCHEMA_REGISTRY_PASSWORD"

const val env_WHITELIST_FILE = "WHITELIST_FILE"

const val SF_PATH_oAuth = "/services/oauth2/token"

// Salesforce environment dependencies
const val env_SF_TOKENHOST = "SF_TOKENHOST"
const val env_SF_VERSION = "SF_VERSION"
const val env_HTTPS_PROXY = "HTTPS_PROXY" // Not in use (needed on prem?)
const val env_CONTEXT = "CONTEXT" // To check for dev context

// Salesforce required secrets
const val secret_SFClientID = "SFClientID"
const val secret_SFUsername = "SFUsername"

// Salesforce required secrets related to keystore for signed JWT
const val secret_keystoreJKSB64 = "keystoreJKSB64"
const val secret_KeystorePassword = "KeystorePassword"
const val secret_PrivateKeyAlias = "PrivateKeyAlias"
const val secret_PrivateKeyPassword = "PrivateKeyPassword"

const val numberOfSamplesInSampleRun = 222
const val SALESFORCE_VERSION = "v57.0"
