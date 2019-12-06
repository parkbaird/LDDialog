package cn.com.blackview.lddialog;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

// https://juejin.im/entry/5bac5016f265da0ae92a76ec
public class MainActivity extends AppCompatActivity {

    private String TAG = "ltnq";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.text);
        Button button = findViewById(R.id.btn_dialog);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new LDDialog.Builder(MainActivity.this)
                        .setTitle("提示")
                        .setContent("您好，我们将在30分钟处理，稍后通知您订单结果！")
//                        .setCancelableOutSide(true)
                        .setRightButton(new IDialog.OnClickListener() {
                            @Override
                            public void onClick(IDialog dialog) {
                                dialog.dismiss();
                            }
                        })
                        .setLeftButton(new IDialog.OnClickListener() {
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
