package com.gugudan.gugudan;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class GuGUDanActivity extends AppCompatActivity {

    Button bt0, bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, btCancel, btEnter;
    ProgressBar pb;
    public static final int INCREMENT_PRG = 1;

    int dan, num, myans, answer;
    int Count = 0;

    public static final int Exit = Menu.FIRST;
    public static final int Start = Menu.FIRST + 1;

    public void setView(){

        Random r= new Random();             //랜덤한 값을 받아오기위한 r변수 선언
        dan = r.nextInt(8)+2;        //1~9중 랜덤한 수 dan에 넣기
        num = r.nextInt(9)+1;       //같은의미. 1~9사이의 숫자중 랜덤한 수 num에 넣기

        TextView question = (TextView)findViewById(R.id.result1);
        question.setText(Integer.toString(dan) + " * " + Integer.toString(num));
        TextView tv = (TextView)findViewById(R.id.result2);
        tv.setText("");

    }

    Handler ClockHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what)
            {
                case INCREMENT_PRG :
                    // getMax() : ProgressBar의 최대치
                    // getProgress() : ProgressBar의 현재진행 정도
                    if(pb.getMax() != pb.getProgress())
                    {
                        pb.incrementProgressBy(1);
                        // incrementProgressBy() : ProgressBar를 증가시키는 메소드
                        // 5 : 5%만큼 증가시킴
                        sendEmptyMessageDelayed(INCREMENT_PRG, 1000);
                        // sendEmptyMessageDelayed() : 몇초후에 증가시킬지 정하는 메소드
                        // INCREMENT_PRG : 자기자신
                        // 1000 : 1초 대기 후 진행
                    }
                    else
                    {
                        Intent ri = getIntent();
                        ri.putExtra("key", "" + Count);
                        setResult(RESULT_OK, ri);
                        finish();
                    }
                    break;

            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gu_gudan);
        //setContentView(R.layout.activity_list);

        ClockHandler.sendEmptyMessage(INCREMENT_PRG);
        setView();

        bt0 = (Button)findViewById(R.id.btn0);
        bt1 = (Button)findViewById(R.id.btn1);
        bt2 = (Button)findViewById(R.id.btn2);
        bt3 = (Button)findViewById(R.id.btn3);
        bt4 = (Button)findViewById(R.id.btn4);
        bt5 = (Button)findViewById(R.id.btn5);
        bt6 = (Button)findViewById(R.id.btn6);
        bt7 = (Button)findViewById(R.id.btn7);
        bt8 = (Button)findViewById(R.id.btn8);
        bt9 = (Button)findViewById(R.id.btn9);
        btCancel = (Button)findViewById(R.id.btnCancel);
        btEnter = (Button)findViewById(R.id.btnEnter);

        pb = (ProgressBar)findViewById(R.id.progressBar);
        pb.setMax(60);
        pb.setProgress(0);


        bt0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView tv = (TextView)findViewById(R.id.result2);
                tv.append("0");

            }
        });

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView tv = (TextView)findViewById(R.id.result2);
                tv.append("1");

            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView tv = (TextView)findViewById(R.id.result2);
                tv.append("2");

            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView tv = (TextView)findViewById(R.id.result2);
                tv.append("3");

            }
        });

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView tv = (TextView)findViewById(R.id.result2);
                tv.append("4");

            }
        });

        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView tv = (TextView)findViewById(R.id.result2);
                tv.append("5");

            }
        });

        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView tv = (TextView)findViewById(R.id.result2);
                tv.append("6");

            }
        });

        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView tv = (TextView)findViewById(R.id.result2);
                tv.append("7");

            }
        });

        bt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView tv = (TextView)findViewById(R.id.result2);
                tv.append("8");

            }
        });

        bt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView tv = (TextView)findViewById(R.id.result2);
                tv.append("9");

            }
        });

        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView tv = (TextView)findViewById(R.id.result2);
                tv.setText("");

            }
        });

        btEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView tv = (TextView)findViewById(R.id.result2);
                TextView count = (TextView)findViewById(R.id.result3);

                myans = Integer.parseInt(tv.getText().toString());
                answer = dan * num;


                if (myans == answer)
                {
                    Count++;
                    count.setText(Integer.toString(Count));
                    setView();
                }
                else
                {
                    count.setText(Integer.toString(Count));
                    setView();
                }

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        menu.add(Menu.NONE, Exit, Menu.NONE, "Exit");
        menu.add(Menu.NONE, Start, Menu.NONE, "Start");

        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case Exit :

                //CountTv = (TextView)findViewById(R.id.result3);
                //String myCount = CountTv.getText().toString();

                Intent ri = getIntent();
                ri.putExtra("key", "" + Count);
                setResult(RESULT_OK, ri);
                finish();
//                Intent li = new Intent();
//                li.setClass(GuGUDanActivity.this, ListActivity.class);
//                startActivityForResult(li, 1);
                break;

            case Start :

                Intent i = new Intent();
                i.setClassName(GuGUDanActivity.this, "com.gugudan.gugudan.GuGUDanActivity");
                startActivityForResult(i, 2);
                break;
        }

        return super.onOptionsItemSelected(item);

    }

}



