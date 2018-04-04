package com.yuoyanbo.commondialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.yuoyanbo.dialog.CommonDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button mBtnDialog = (Button) findViewById(R.id.btn_dialog);
        mBtnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CommonDialog commonDialog = new CommonDialog.Builder(MainActivity.this)
                        .setView(R.layout.dialog_test)
                        .setHeight(ViewGroup.LayoutParams.WRAP_CONTENT)
                        .setWidth(getResources().getDisplayMetrics().widthPixels)
                        .fromBottom()
                        .create();
                commonDialog.show();


            }
        });
    }
}
