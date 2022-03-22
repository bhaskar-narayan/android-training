package com.carmedia2p0.capture.data.datastore

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.single
import javax.inject.Inject

class AppDataStore @Inject constructor(
    @ApplicationContext private val context: Context
) {

    private val Context.prefDataStore by preferencesDataStore(NAME)

    companion object {
        private const val NAME = "PREF_SHARED_PREFS_NAME"
        private val IS_LOGGED_IN = booleanPreferencesKey("is_logged_in")
        private val USERNAME = stringPreferencesKey("username")
    }

    var isLoggedIn: Flow<Boolean>
        get() = context.prefDataStore.data.map {
            it[IS_LOGGED_IN] ?: false
        }
        set(value) {
            suspend {
                context.prefDataStore.edit {
                    it[IS_LOGGED_IN] = value.single()
                }
            }
        }

    var username: Flow<String>
        get() = context.prefDataStore.data.map {
            it[USERNAME] ?: ""
        }
        set(value) {
            suspend {
                context.prefDataStore.edit {
                    it[USERNAME] = value.single()
                }
            }
        }

    suspend fun clearDatastore() {
        context.prefDataStore.edit { preferences ->
            preferences.clear()
        }
    }
}
