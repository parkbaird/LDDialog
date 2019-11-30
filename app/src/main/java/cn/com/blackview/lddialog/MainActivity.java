package cn.com.blackview.lddialog;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.text);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new LDDialog.Builder(MainActivity.this)
                        .setTitle("是否下载这个时间段的视频？")
                        .setContent("StartTime：00:22 \n EndTime: 00:28")
                        .setPositiveButton(new IDialog.OnClickListener() {
                            @Override
                            public void onClick(IDialog dialog) {
                                dialog.dismiss();
                            }
                        })
                        .setNegativeButton(new IDialog.OnClickListener() {
                            @Override
                            public void onClick(IDialog dialog) {
                                dialog.dismiss();
                            }
                        })
                        .show();
            }
        });
    }
}
