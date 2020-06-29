package com.winbee.vaasant;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.winbee.vaasant.Models.UrlName;
import com.winbee.vaasant.Utils.ProgressBarUtil;

import java.util.Objects;

public class WebActivity extends AppCompatActivity {
    private WebView webView;
    private UrlName urlName;
    private ProgressBarUtil progressBarUtil;
    Button btm_asked_question;
    String Url;
    String googleDocs = "https://docs.google.com/viewer?url=";

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        webView =findViewById(R.id.myWebView);
        btm_asked_question=findViewById(R.id.btm_asked_question);


        progressBarUtil   =  new ProgressBarUtil(this);
        progressBarUtil.showProgress();
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            urlName = (UrlName) bundle.getSerializable("PDFURL");
            if(urlName!=null){
                System.out.println("Suree:"+urlName.getURL().equalsIgnoreCase("PDFURL"));
                Url=urlName.getURL();
        }
        }
        displayWebView();
        btm_asked_question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(WebActivity.this,AskedQuestionActivity.class);
                intent.putExtra("documentID",urlName.getDocumentId());
                startActivity(intent);
            }
        });
    }

    private void displayWebView() {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(googleDocs+Url);
                return true;

            }
        });
        webView.loadUrl(googleDocs+Url);

    }

}
