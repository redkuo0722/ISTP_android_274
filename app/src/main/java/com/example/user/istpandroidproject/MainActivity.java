package com.example.user.istpandroidproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView infoText;
    EditText nameText;
    RadioGroup optionGrp;
    Button confirmButton;
    String nameOfTheTrainer;
    int selectOptionIndex;
    static final String[] pokemonNames={
            "小火龍",
            "傑尼龜",
            "廟花種子"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("test", "this is a log");

        infoText=(TextView)findViewById(R.id.textView_pokeman1)
        nameText= (EditText) findViewById(R.id.editText_name);
        optionGrp=(RadioGroup)findViewById(R.id.RadioGroup_optionGroup);
        confirmButton=(Button)findViewById(R.id.button_confirm);
        confirmButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int viewId=v.getId(); // different button
        if(viewId==R.id.button_confirm){
            nameOfTheTrainer=nameText.getText().toString();

            int selectRadioButtonViewId=optionGrp.getCheckedRadioButtonId();
            View selectRadioButton=optionGrp.findViewById(selectRadioButtonViewId);
            selectOptionIndex=optionGrp.indexOfChild(selectRadioButton);

            String welcomeMsg=String.format("你好,訓練家%s歡迎來到神奇寶貝的世界. 你的第一個夥伴是%s",
                    nameOfTheTrainer,
                    pokemonNames[selectOptionIndex]
                    );
            infoText.setText(welcomeMsg);
        }
    }
}
