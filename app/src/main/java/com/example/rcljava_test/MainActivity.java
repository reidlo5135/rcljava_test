package com.example.rcljava_test;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View.OnClickListener;

import org.ros2.rcljava.RCLJava;
import org.ros2.rcljava.node.Node;

public class MainActivity extends AppCompatActivity {

    @Override
    public final void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RCLJava.rclJavaInit();
    }
}