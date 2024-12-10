package com.example.google

import android.app.ProgressDialog
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.example.google.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val dialog = ProgressDialog(this)
        dialog.setTitle("Yuklanmoqda")
        dialog.setMessage("Kutib turing")

        binding.webView.settings.javaScriptEnabled=true

        binding.editText.addTextChangedListener{
           if(binding.editText.text.isNotBlank()){
                val sorov = binding.editText.text.toString()
                val url = "https://www.google.com/search?q= $sorov"
                binding.webView.loadUrl(url)
            }else{
            Toast.makeText(this, "Qidirishga hech narsa yo'q", Toast.LENGTH_SHORT).show()
        }
        }
        binding.webView.webViewClient = object :WebViewClient(){
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                dialog.show()
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                dialog.dismiss()
            }
        }
    }
}