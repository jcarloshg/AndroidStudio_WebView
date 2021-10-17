package com.example.web_view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    WebView webView;
    Button btn_outlook, btn_google, btn_previous, btn_next;

    private int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init_webView();
        init_components();
        set_onClick_buttons();

    }

    private void set_onClick_buttons() {
        btn_outlook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl("https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=13&rver=7.3.6963.0&wp=MBI_SSL&wreply=https%3a%2f%2fwww.microsoft.com%2fes-mx%2f&lc=2058&id=74335&aadredir=1");
            }
        });
        btn_google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl("https://www.google.com/webhp?hl=es-419&sa=X&sqi=2&pjf=1&ved=0ahUKEwiNxoulrNLzAhUaQPUHHXyXBDcQPAgI");
            }
        });
        btn_previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contador = contador == 0 ? 1 : contador - 1;
                webView.loadUrl("https://www.liverpool.com.mx/tienda/page-" + contador + "?s=relojes");
            }
        });
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contador += 1;
                webView.loadUrl("https://www.liverpool.com.mx/tienda/page-" + contador + "?s=relojes");
            }
        });

    }

    private void init_components() {
        btn_outlook = (Button) findViewById(R.id.btn_outlook);
        btn_google = (Button) findViewById(R.id.btn_google);
        btn_previous = (Button) findViewById(R.id.btn_previous);
        btn_next = (Button) findViewById(R.id.btn_next);
    }

    private void init_webView() {
        webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://serviciosdigitalesplus.com/cartas/");
    }


}