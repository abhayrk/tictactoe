package com.trial.tictactoe.tictactoe;

import android.content.Intent;
import android.support.v4.widget.ListViewAutoScrollHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button b00, b01, b02, b10, b11, b12, b20, b21, b22;
    Button breset,bquit;
    String[] btn_vals = new String[]{"","","","","","","","",""};
    int turn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b00 = (Button) findViewById(R.id.b00);
        b01 = (Button) findViewById(R.id.b01);
        b02 = (Button) findViewById(R.id.b02);
        b10 = (Button) findViewById(R.id.b10);
        b11 = (Button) findViewById(R.id.b11);
        b12 = (Button) findViewById(R.id.b12);
        b20 = (Button) findViewById(R.id.b20);
        b21 = (Button) findViewById(R.id.b21);
        b22 = (Button) findViewById(R.id.b22);
        breset = (Button) findViewById(R.id.breset);
        bquit = (Button) findViewById(R.id.bexit);

        turn = 1;
        b00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turn = SelectSquare(b00,turn);
                btn_vals[0] = b00.getText().toString();
                EndGame();
            }
        });

        b01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turn = SelectSquare(b01,turn);
                btn_vals[1] = b01.getText().toString();
                EndGame();
            }
        });

        b02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turn = SelectSquare(b02,turn);
                btn_vals[2] = b02.getText().toString();
                EndGame();
            }
        });

        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turn = SelectSquare(b10,turn);
                btn_vals[3] = b10.getText().toString();
                EndGame();
            }
        });

        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turn = SelectSquare(b11,turn);
                btn_vals[4] = b11.getText().toString();
                EndGame();
            }
        });

        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turn = SelectSquare(b12,turn);
                btn_vals[5] = b12.getText().toString();
                EndGame();
            }
        });

        b20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turn = SelectSquare(b20,turn);
                btn_vals[6] = b20.getText().toString();
                EndGame();
            }
        });

        b21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turn = SelectSquare(b21,turn);
                btn_vals[7] = b21.getText().toString();
                EndGame();
            }
        });


        b22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turn = SelectSquare(b22,turn);
                btn_vals[8] = b22.getText().toString();
                EndGame();
            }
        });

        breset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClearAll();
            }
        });

        bquit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }

    protected int SelectSquare(Button btn, int turn){
        if(btn.getText().toString()==""){
            if(turn == 1) {
                btn.setText(R.string.player1_symbol);
                turn = 2;
                //btn.setTag(btn.getId());
            }
            else{
                btn.setText(R.string.player2_symbol);
                turn = 1;
                //btn.setTag(btn.getId());
            }
        }
        return turn;
    }

    protected void ChangeAll(boolean setting)
    {
        b00.setEnabled(setting);
        b01.setEnabled(setting);
        b02.setEnabled(setting);
        b10.setEnabled(setting);
        b11.setEnabled(setting);
        b12.setEnabled(setting);
        b20.setEnabled(setting);
        b21.setEnabled(setting);
        b22.setEnabled(setting);
    }
    protected void ClearAll(){
        int i = 0;
        ChangeAll(true);
        b00.setText("");
        b01.setText("");
        b02.setText("");
        b10.setText("");
        b11.setText("");
        b12.setText("");
        b20.setText("");
        b21.setText("");
        b22.setText("");
        turn=1;
        btn_vals= new String[]{"","","","","","","","",""};
        Toast.makeText(MainActivity.this, "Cleared!! New Game", Toast.LENGTH_LONG).show();
    }

    public void EndGame(){

        List<int[]> winningCombos = new ArrayList<int[]>();

        winningCombos.add(new int[]{0,3,6});
        winningCombos.add(new int[]{1,4,7});
        winningCombos.add(new int[]{2,5,8});
        winningCombos.add(new int[]{0,1,2});
        winningCombos.add(new int[]{3,4,5});
        winningCombos.add(new int[]{6,7,8});
        winningCombos.add(new int[]{0,4,8});
        winningCombos.add(new int[]{2,4,6});

        for (int[] combo: winningCombos){
            if(btn_vals[combo[0]] == btn_vals[combo[1]] && btn_vals[combo[1]] == btn_vals[combo[2]]){
                if ((btn_vals[combo[0]].toUpperCase()).equals("X".toString().toUpperCase())){
                    Toast.makeText(MainActivity.this,"Player 1 Wins",Toast.LENGTH_LONG).show();
                    ChangeAll(false);
                    //ClearAll();
                    break;
                }
                else if ((btn_vals[combo[0]].toUpperCase()).equals("O".toString().toUpperCase())){
                    Toast.makeText(MainActivity.this,"Player 2 Wins",Toast.LENGTH_LONG).show();
                    ChangeAll(false);
                    //ClearAll();
                    break;
                }
            }
        }

    }
}
