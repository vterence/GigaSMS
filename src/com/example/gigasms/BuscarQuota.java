package com.example.gigasms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class BuscarQuota extends Activity {

	private Button btnOk;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_quota);
        btnOk = (Button) findViewById(R.id.button1);
        btnOk.setOnClickListener(new OnClickListener() {
				
			@Override
			public void onClick(View v) {
				try {
					executeHttpGet();
				} catch (Exception e) {	
					e.printStackTrace();
				}
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_buscar_quota, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
      // Captura o menu selecionado
       switch (item.getItemId()) {
          case R.id.help:
             TelaParametros();
             return true;
          default:
             return super.onOptionsItemSelected(item);
       }
    }
    
    private void TelaParametros() {
    	Intent it = new Intent(this, Param.class);
    	startActivity(it);
	}

    
    public void executeHttpGet() throws Exception {
        BufferedReader in = null;
        try {
            HttpClient client = new DefaultHttpClient();
            HttpGet request = new HttpGet();
            request.setURI(new URI("http://www.gigasms.com.br/api/quota?usuario=matheus&senha=matheus666"));
            HttpResponse response = client.execute(request);
            in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            StringBuffer sb = new StringBuffer("");
            String line = "";
            String NL = System.getProperty("line.separator");
            while ((line = in.readLine()) != null) {
                sb.append(line + NL);
            }
            in.close();
            String page = sb.toString();

            Toast toast = Toast.makeText(this, "Sms restantes: " + page.substring(3, page.length()), Toast.LENGTH_SHORT);
            toast.show();
        } finally {
      
        
        }
    }
}
