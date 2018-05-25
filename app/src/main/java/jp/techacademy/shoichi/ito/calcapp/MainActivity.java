package jp.techacademy.shoichi.ito.calcapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ボタン設定
        Button button1 = (Button) findViewById(R.id.tasubutton); //Viewのid(tasubutton)をbutton1に紐付け
        button1.setOnClickListener(this); //button1のクリックした時の処理(イベントリスナー)を設定

        Button button2 = (Button) findViewById(R.id.hikubutton);
        button2.setOnClickListener(this);

        Button button3 = (Button) findViewById(R.id.kakerubutton);
        button3.setOnClickListener(this);

        Button button4 = (Button) findViewById(R.id.warubutton);
        button4.setOnClickListener(this);
    }




    //num1、num2、answerの宣言
    double num1;
    double num2;
    double answer;



    @Override
    public void onClick(View v) {
        // ここに処理を追加

        //SecondActivityへ遷移する処理
        Intent intent = new Intent(this,SecondActivity.class);

        EditText edittext1 = (EditText) findViewById(R.id.edittext1);
        EditText edittext2 = (EditText) findViewById(R.id.edittext2);


        try {
            num1 = Double.parseDouble(edittext1.getText().toString());
            num2 = Double.parseDouble(edittext2.getText().toString());
        } catch (NumberFormatException e) {


            // エラー時の処理
            if (edittext1.getText().toString() == "") { //edittextの入力された文字が空白なら実行
                Toast.makeText(MainActivity.this, "数値を入力して下さい",
                        Toast.LENGTH_SHORT).show();

            } else if (edittext2.getText().toString() == "") { //edittext2の入力された文字が空白なら実行
                Toast.makeText(MainActivity.this, "数値を入力して下さい",
                        Toast.LENGTH_SHORT).show();
            }

        }

        // クリック時の処理
        if (v.getId() == R.id.tasubutton) {
            answer = num1 + num2;

        } else if (v.getId() == R.id.hikubutton) {
            answer = num1 - num2;

        } else if (v.getId() == R.id.kakerubutton) {
            answer = num1 * num2;

        } else if (v.getId() == R.id.warubutton) {
            answer = num1 / num2;
        }



        intent.putExtra("VALUE1", answer);
        startActivity(intent);
    }
}
