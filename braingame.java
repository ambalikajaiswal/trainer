package e.dell.trainer;

import android.os.CountDownTimer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button goButton;

    ArrayList<Integer> answers= new ArrayList<Integer>();
    int loactionOfCorrectAnswer;
TextView resultTextView;
int score= 0;
int numberOfQuestion=0;
TextView scoreTextView;
Button button2;
    Button button3;
    Button button4;
    Button button5;
    TextView sumTextView;
    TextView timerTextView;
    Button playAgainButton;
    ConstraintLayout gameLayout;


    public void playAgain(View view){

        score=0;
        numberOfQuestion=0;
        timerTextView.setText("30S");
        scoreTextView.setText(Integer.toString(score)+"/"+Integer.toString(numberOfQuestion));

        newQuestion();

        playAgainButton.setVisibility(View.INVISIBLE);
        resultTextView.setText("");
        new CountDownTimer(30100,1000){

            @Override
            public void onTick(long l) {
                timerTextView.setText(String.valueOf(l/1000 )+ "s");
            }

            @Override
            public void onFinish() {
                resultTextView.setText("done!");
                playAgainButton.setVisibility(View.VISIBLE);
            }
        }.start();

    }

    public void chooseAnswer(View view) {

        if (Integer.toString(loactionOfCorrectAnswer).equals(view.getTag().toString())) {

           resultTextView.setText("correct!");
           score++;
        }else{
            resultTextView.setText("wrong");
        }
        numberOfQuestion++;
        scoreTextView.setText(Integer.toString(score)+"/"+Integer.toString(numberOfQuestion));
         newQuestion();
    }
    public void start(View view){

        goButton.setVisibility(View.INVISIBLE);
        playAgain(findViewById(R.id.timerTextView));
        gameLayout.setVisibility(View.VISIBLE);

    }

    public  void newQuestion(){
        Random rand=new Random();

        int a=rand.nextInt(21);
        int b=rand.nextInt(21);

        sumTextView.setText(Integer.toString(a) + "+" +Integer.toString(b));

        loactionOfCorrectAnswer=rand.nextInt(4);

        answers.clear();

        for(int i=0;i<4;i++){

            if(i==loactionOfCorrectAnswer){
                answers.add(a+b);

            } else{
                int wrongAnswer= rand.nextInt(41);

                while(wrongAnswer==a+b){
                    wrongAnswer=rand.nextInt(41);
                }
                answers.add(wrongAnswer);
            }
        }
        button2.setText(Integer.toString(answers.get(0)));
        button3.setText(Integer.toString(answers.get(1)));
        button4.setText(Integer.toString(answers.get(2)));
        button5.setText(Integer.toString(answers.get(3)));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         sumTextView=findViewById(R.id.sumTextView);

         button2= findViewById(R.id.button2);
         button3= findViewById(R.id.button3);
         button4= findViewById(R.id.button4);
         button5= findViewById(R.id.button5);
        resultTextView=findViewById(R.id.resultTextView);
        scoreTextView=findViewById(R.id.scoreTextView);
        timerTextView=findViewById(R.id.timerTextView);
        playAgainButton=findViewById(R.id.playAgainButton);
        gameLayout=findViewById(R.id.gameLayout);

        goButton =findViewById(R.id.goButton);
      goButton.setVisibility(View.VISIBLE);
      gameLayout.setVisibility(View.INVISIBLE);








    }
}
