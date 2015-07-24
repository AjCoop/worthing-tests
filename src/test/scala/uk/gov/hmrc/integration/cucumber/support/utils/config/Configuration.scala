package uk.gov.hmrc.integration.cucumber.support.utils.config

case class Configuration(DEFAULT_HOD_STUBS_ROOT_URL: String,
                            DEFAULT_HODS_ROOT_URL: String,
                            PORTAL_URL: String,
                            YTA_ROOT: String,
                            CA_FE_ROOT: String,
                            SA_PREFS_ROOT: String,
                            NOTIFICATION_MICROSERVICE_URL: String,
                            TAXS_ROOT_URL: String,
                            PAGE_TIMEOUT_SECS: Int
                          )

object Configuration {

  lazy val environment: Environment.Name = {
    val environmentProperty = System.getProperty("environment", "local").toLowerCase
    environmentProperty match {
      case "local" => Environment.Local
      case "nginx" => Environment.Nginx
      case "dev" => Environment.dev
      case "qa" => Environment.Qa
      case "staging" => Environment.Staging
      case _ => throw new IllegalArgumentException(s"Environment '$environmentProperty' not known")
    }
  }

  lazy val settings: Configuration = create()

  val OnePixelImageForSaPreferences = Configuration.settings.SA_PREFS_ROOT + "/sa/print-preferences/assets/images/tp.gif"


  private def create(): Configuration = {
    environment match {
      case Environment.dev =>
        new Configuration(
          DEFAULT_HOD_STUBS_ROOT_URL = "NOTAPPLICABLEFORQA",
          DEFAULT_HODS_ROOT_URL = "https://hods-proxy-dev.tax.service.gov.uk",
          PORTAL_URL = "https://online-dev.ibt.hmrc.gov.uk",
          YTA_ROOT = "https://www-dev.tax.service.gov.uk",
          SA_PREFS_ROOT = "https://www-dev.tax.service.gov.uk",
          CA_FE_ROOT = "https://www-dev.tax.service.gov.uk",
          NOTIFICATION_MICROSERVICE_URL = "http://notification.service",
          TAXS_ROOT_URL = "https://www-dev.tax.service.gov.uk",
          PAGE_TIMEOUT_SECS = 60
        )

      case Environment.Local =>
        new Configuration(
          DEFAULT_HOD_STUBS_ROOT_URL = "http://localhost:8080",
          DEFAULT_HODS_ROOT_URL = "http://localhost:8080",
          PORTAL_URL = "http://localhost:8080/portal",
          YTA_ROOT = "http://localhost:9020",
          SA_PREFS_ROOT = "http://localhost:9024",
          CA_FE_ROOT = "http://localhost:9025",
          NOTIFICATION_MICROSERVICE_URL = "http://localhost:8710",
          TAXS_ROOT_URL = "http://localhost:9217",
          PAGE_TIMEOUT_SECS = 60
        )

      case Environment.Nginx =>
        new Configuration(
          DEFAULT_HOD_STUBS_ROOT_URL = "http://localhost:8080",
          DEFAULT_HODS_ROOT_URL = "http://localhost:8080",
          PORTAL_URL = "http://localhost:8080/portal",
          YTA_ROOT = "http://localhost:10000",
          SA_PREFS_ROOT = "http://localhost:10000",
          CA_FE_ROOT = "http://localhost:10000",
          NOTIFICATION_MICROSERVICE_URL = "http://localhost:8710",
          TAXS_ROOT_URL = "http://localhost:10000",
          PAGE_TIMEOUT_SECS = 60
        )

      case Environment.Qa =>
        new Configuration(
          DEFAULT_HOD_STUBS_ROOT_URL = "NOTAPPLICABLEFORQA",
          DEFAULT_HODS_ROOT_URL = "https://hods-proxy-qa-right.tax.service.gov.uk",
          PORTAL_URL = "https://ibt.hmrc.gov.uk",
          YTA_ROOT = "https://web-qa.tax.service.gov.uk",
          SA_PREFS_ROOT = "https://web-qa.tax.service.gov.uk",
          CA_FE_ROOT = "https://web-qa.tax.service.gov.uk",
          NOTIFICATION_MICROSERVICE_URL = "http://notification.service",
          TAXS_ROOT_URL = "https://web-qa.tax.service.gov.uk",
          PAGE_TIMEOUT_SECS = 60
        )

      case _ => throw new IllegalArgumentException(s"Environment '$environment' not known")
    }
  }
}

object Environment extends Enumeration {
  type Name = Value
  val Local, dev, Nginx, Qa, Staging = Value
}

object GovernmentGateway extends Enumeration {
  type Name = Value
  val Local, ISV, REF, DR, Prod = Value

  def forEnvironment(env: Environment.Name): GovernmentGateway.Name = {
    env match {
      case Environment.Local => Local
      case Environment.Nginx => Local
      case Environment.dev => ISV
      case Environment.Qa => REF
      case Environment.Staging => REF
      case _ => throw new IllegalArgumentException(s"No gateway configuration for environment: '$env'")
    }
  }
}

