/**
 * Created by Vipin KT on 03/06/20
 */
object Config {

    object Application {
        const val APPLICATION_ID = "com.ktvipin.mvvmstarter"
        const val VERSION_CODE = 1
        const val VERSION_NAME = "1.0.0"
        const val COMPILE_SDK_VERSION = 29
        const val MIN_SDK_VERSION = 21
        const val TARGET_SDK_VERSION_ = 29
    }

    object SigningConfigs {

        object Debug {
            const val NAME = "config_debug"
            const val KEY_ALIAS = "demo"
            const val KEY_PASSWORD = "123456789"
            const val STORE_PASSWORD = "123456789"
            const val STORE_FILE = "demo_debug_key"
        }

        object Release {
            const val NAME = "config_debug"
            const val KEY_ALIAS = "demo"
            const val KEY_PASSWORD = "123456789"
            const val STORE_PASSWORD = "123456789"
            const val STORE_FILE = "demo_release_key"
        }
    }

    object Key {
        const val API_DOMAIN = "API_DOMAIN"
    }
}