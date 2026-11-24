package com.lagradost.cloudstream3.ui.player

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

/** Opens Android's video picker and hands the selected URI to CloudStream's existing player. */
class LocalPickerActivity : AppCompatActivity() {
    private val pickVideo =
        registerForActivityResult(ActivityResultContracts.OpenDocument()) { uri ->
            if (uri != null) playLocal(uri)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val button = Button(this).apply {
            text = "Open a video"
            setOnClickListener { pickVideo.launch(arrayOf("video/*")) }
        }
        val root = FrameLayout(this)
        root.addView(button, FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT,
            Gravity.CENTER
        ))
        setContentView(root)
        if (savedInstanceState == null) pickVideo.launch(arrayOf("video/*"))
    }

    private fun playLocal(uri: Uri) {
        try {
            contentResolver.takePersistableUriPermission(uri, Intent.FLAG_GRANT_READ_URI_PERMISSION)
        } catch (_: Exception) {
            // Some providers do not support persistable URI grants.
        }
        val intent = Intent(this, DownloadedPlayerActivity::class.java).apply {
            action = Intent.ACTION_VIEW
            setDataAndType(uri, "video/*")
            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        }
        try {
            startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(this, "Could not open player: ${e.message}", Toast.LENGTH_LONG).show()
        }
    }
}
