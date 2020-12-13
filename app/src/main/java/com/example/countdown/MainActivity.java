package com.example.countdown;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{
    private int recLen = 30;
    private TextView txtView;
    private Button mButton;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        txtView = (TextView)findViewById(R.id.textView);
        mButton=findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message message = handler.obtainMessage(1);     // Message
                handler.sendMessageDelayed(message, 1000);
            }
        });



    }

    final Handler handler=new Handler() {

        public void handleMessage(Message msg){         // handle message
            switch (msg.what) {
                case 1:
                    recLen--;
                    txtView.setText("" + recLen);
            }
            if(recLen > 0){
                Message message = handler.obtainMessage(1);
                handler.sendMessageDelayed(message, 1000);      // send message
            }else{
                txtView.setVisibility(View.GONE);
            }


            super.handleMessage(msg);
        }
    };
}
