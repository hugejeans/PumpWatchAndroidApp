package com.pumpwatch.hugejeans.pumpwatch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView greetingView;

    private Button gobutton;
    private EditText urlEditText;
    private WebView browser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        greetingView = (TextView) findViewById(R.id.greeting);

        gobutton = (Button) findViewById(R.id.button);
        urlEditText = (EditText) findViewById(R.id.editText);
        browser = (WebView) findViewById(R.id.webview);
        browser.setWebViewClient(new MyBrowser());

        gobutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = urlEditText.getText().toString();

                browser.getSettings().setLoadsImagesAutomatically(true);
                browser.getSettings().setJavaScriptEnabled(true);
                browser.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                browser.loadUrl(url);
            }
        });
    }

    // Create a new class to extend WebViewClient and override URL loading.
    // This allows links inside the WebView to be clicked and followed.
    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_settings) {
            // TODO: open new activity
            greetingView.setText(R.string.todo);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
