package com.example.try1;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Random;

public class Quiz extends AppCompatActivity {
    private TextView question,questionAttempted;
    private Button btnOpt1,btnOpt2,btnOpt3,btnOpt4;
    private ArrayList<QuizModel> list;
    Random random;
    int currScore = 0;
    int questAttempted = 0;
    int currentPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz);
        question = findViewById(R.id.question);
        questionAttempted = findViewById(R.id.questAttempted);
        btnOpt1 = findViewById(R.id.btnOpt1);
        btnOpt2 = findViewById(R.id.btnOpt2);
        btnOpt3 = findViewById(R.id.btnOpt3);
        btnOpt4 = findViewById(R.id.btnOpt4);
        list = new ArrayList<>();
        random = new Random();
        getQuizQuestion(list);
        currentPos = random.nextInt(list.size());
        setDataToView(currentPos);
        btnOpt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(list.get(currentPos).getAnswer().trim().toLowerCase().equals(btnOpt1.getText().toString().trim().toLowerCase())){
                    currScore++;
                }
                questAttempted++;
                currentPos = random.nextInt(list.size());
                setDataToView(currentPos);
            }
        });
        btnOpt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(list.get(currentPos).getAnswer().trim().toLowerCase().equals(btnOpt2.getText().toString().trim().toLowerCase())){
                    currScore++;
                }
                questAttempted++;
                currentPos = random.nextInt(list.size());
                setDataToView(currentPos);
            }
        });
        btnOpt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(list.get(currentPos).getAnswer().trim().toLowerCase().equals(btnOpt3.getText().toString().trim().toLowerCase())){
                    currScore++;
                }
                questAttempted++;
                currentPos = random.nextInt(list.size());
                setDataToView(currentPos);
            }
        });
        btnOpt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(list.get(currentPos).getAnswer().trim().toLowerCase().equals(btnOpt4.getText().toString().trim().toLowerCase())){
                    currScore++;
                }
                questAttempted++;
                currentPos = random.nextInt(list.size());
                setDataToView(currentPos);
            }
        });
    }

    private void getQuizQuestion(ArrayList<QuizModel> list) {
        list.add(new QuizModel("Төмендегі объект қандай деректер типі? L = [1, 23, ‘hello’, 1]","List","Dictionary","Tuple","Array","List"));
        list.add(new QuizModel("Төмендегі функциялардың қайсысы python тіліндегі жолды флотқа түрлендіреді?","int(x [,base])","long(x [,base] )","float(x)","str(x)","float(x)"));
        list.add(new QuizModel("Өрнектің шығысы қандай : 3*1**3","27","9","3","1","3"));
        list.add(new QuizModel("len() функциясы Python тілінде не істейді?","Жолдың немесе тізімнің ұзындығын қайтарады","Екі жолды біріктіреді"," Жолды кіші әріпке түрлендіреді","Жылжымалы нүктелі санды дөңгелектейді","Жолдың немесе тізімнің ұзындығын қайтарады"));
        list.add(new QuizModel("Төмендегілердің қайсысы Python тілінде бір жолға түсініктеме берудің дұрыс жолы болып табылады?","//","/","#","<>","#"));
        list.add(new QuizModel("print операторын қалай пайдалану керек?","print(\"Сәлем, Әлем!\")","display(\"Сәлем, Әлем!\")","show(\"Сәлем, Әлем!\")","output(\"Сәлем, Әлем!\")","print(\"Сәлем, Әлем!\")"));
        list.add(new QuizModel("Екі саның бөлігінен келесі көбейтуді анықтау үшін қандай операторды пайдалануға болады?","**","//","%","*","**"));
        list.add(new QuizModel("for циклі арқылы қандай элементтерді топтауға болады?","Барлық элементтер","Тек құралдар","Қатарлар"," Барлығы","Барлығы"));
        list.add(new QuizModel("Python-да қандай функцияның көмегімен көп аргументті шақыруға болады?","call","invoke","apply","execute","invoke"));
    }
    private void setDataToView(int currentPos){
        questionAttempted.setText("Questions Attempted : "+questAttempted+"/5");
        if(questAttempted == 5){
            showBottomSheet();
        } else{
            question.setText(list.get(currentPos).getQuestion());
            btnOpt1.setText(list.get(currentPos).getOpt1());
            btnOpt2.setText(list.get(currentPos).getOpt2());
            btnOpt3.setText(list.get(currentPos).getOpt3());
            btnOpt4.setText(list.get(currentPos).getOpt4());
        }

    }
    private void showBottomSheet(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(Quiz.this);
        View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score,(LinearLayout)findViewById(R.id.scoreL));
        TextView score = view.findViewById(R.id.score);
        Button button = view.findViewById(R.id.restart);
        Button btn = view.findViewById(R.id.buttonReturn);
        score.setText("Your score is \n"+currScore+"/5");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Quiz.this, IntroPythonActivity.class);
                startActivity(intent);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPos = random.nextInt(list.size());
                setDataToView(currentPos);
                questAttempted = 0;
                currScore = 0;
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(view);
        bottomSheetDialog.show();
    }
}
