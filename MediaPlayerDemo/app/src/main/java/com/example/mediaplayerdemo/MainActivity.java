package com.example.mediaplayerdemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp;
    Button btnPlay,btnPause,btnStop,btnSong;
    TextView txtSong;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==2)
        {
            if(resultCode==RESULT_OK)
            {
                Uri uri=Uri.parse(data.getData().getPath());

                txtSong.setText(data.getData().getPath());
                mp=MediaPlayer.create(MainActivity.this,uri);
                btnPlay.setEnabled(true);
                btnStop.setEnabled(true);
                btnPause.setEnabled(true);
                Log.d("Path",data.getData().getPath());

            }
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlay=findViewById(R.id.btnPlay);
        btnPause=findViewById(R.id.btnPause);
        btnStop=findViewById(R.id.btnStop);
        btnSong=findViewById(R.id.btnSong);
        txtSong=findViewById(R.id.txtSong);


        btnSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("*/*");
                startActivityForResult(intent,2);
            }
        });



        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mp=MediaPlayer.create(MainActivity.this,R.raw.song);
                mp.start();
                Toast.makeText(MainActivity.this, "Player Started", Toast.LENGTH_SHORT).show();
            }
        });

        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.pause();
            }
        });


        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.stop();
                mp.release();
            }
        });
    }
}
