package com.example.tp3_mobile

import android.app.Service
import android.content.Intent
import android.net.Uri
import android.os.Binder
import android.os.IBinder
import androidx.documentfile.provider.DocumentFile
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader

class JsonFileService : Service() {

    private val binder = LocalBinder()

    inner class LocalBinder : Binder() {
        fun getService(): JsonFileService = this@JsonFileService
    }

    fun readJsonFile(uri: Uri): String {
        val documentFile = DocumentFile.fromSingleUri(this, uri)
        documentFile?.let { file ->
            val inputStream = contentResolver.openInputStream(file.uri)
            val reader = BufferedReader(InputStreamReader(inputStream))
            val stringBuilder = StringBuilder()
            var line: String?
            while (reader.readLine().also { line = it } != null) {
                stringBuilder.append(line)
            }
            reader.close()

            return stringBuilder.toString()
        }
        return ""
    }

    fun parseJson(jsonString: String): JSONObject {
        return JSONObject(jsonString)
    }

    override fun onBind(intent: Intent?): IBinder? {
        return binder
    }
}