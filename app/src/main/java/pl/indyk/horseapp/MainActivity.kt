package pl.indyk.horseapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import androidx.databinding.DataBindingUtil
import pl.indyk.horseapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var dataBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setDataToViewView()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setDataToViewView() {
        dataBinding.webView.apply {
            settings.apply {
                javaScriptEnabled = true
                domStorageEnabled = true
            }
            loadUrl(BASE_URL)
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && dataBinding.webView.canGoBack()) {
            dataBinding.webView.goBack()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }

    companion object {
        private const val BASE_URL = "https://indyk"
    }
}

