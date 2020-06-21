package me.scraplesh.hotsdraft.data

import android.annotation.SuppressLint
import android.content.Context
import android.webkit.JavascriptInterface
import android.webkit.WebView
import android.webkit.WebViewClient

class WebCrawler(context: Context) {
  @SuppressLint("SetJavaScriptEnabled")
  private val webView = WebView(context).apply {
    settings.javaScriptEnabled = true
    addJavascriptInterface(this@WebCrawler, JAVASCRIPT_ANCHOR)
    webViewClient = object : WebViewClient() {
      override fun onPageFinished(view: WebView, url: String) {
        loadUrl("javascript:window.$JAVASCRIPT_ANCHOR.processHtml('<html>'+document.getElementsByTagName('html')[0].innerHTML+'</html>');");
      }
    }
  }
  private lateinit var callback: (String) -> Unit

  fun loadPage(url: String, callback: (String) -> Unit) {
    this.callback = callback
    webView.loadUrl(url)
  }

  @JavascriptInterface
  fun processHtml(html: String) {
    callback(html)
  }

  private companion object {
    const val JAVASCRIPT_ANCHOR = "HTMLOUT"
  }
}
