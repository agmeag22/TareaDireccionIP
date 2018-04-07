package com.meag.ipaddress;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText clientip, clientsubnet, totalips, clientips, broadcastedittext, netid, mask, bitshost, bitsred;
    private Validations validador = new Validations();
    private NetOp op = new NetOp();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clientip = findViewById(R.id.clientip);
        clientsubnet = findViewById(R.id.clientsubnet);
        totalips = findViewById(R.id.totalipsinput);
        clientips = findViewById(R.id.clientipsinput);
        broadcastedittext = findViewById(R.id.broadcastinput);
        netid = findViewById(R.id.netidinput);
        mask = findViewById(R.id.mascarainput);
        bitshost = findViewById(R.id.bitsdehostinput);
        bitsred = findViewById(R.id.bitsderedinput);
    }


    public void calcular(View v) {
        String ip = clientip.getText().toString();
        String subnet = clientsubnet.getText().toString();

        Log.d("IP", "calcular: " + ip);
        if (!ip.matches("") && !subnet.matches("")) {
            if (validador.validate(ip) && Integer.parseInt(subnet) <= 32 && Integer.parseInt(subnet) >= 0) { // Se valida si la ip es valida y ademas si la mascara se encuentra entre 0 y 32
                op.generateIPs(clientip, clientsubnet, totalips, clientips, broadcastedittext, netid, mask, bitshost, bitsred,ip, subnet);

                Log.d("IP", "LA IP ES VALIDA: " + ip);
            }
        }
    }
}
