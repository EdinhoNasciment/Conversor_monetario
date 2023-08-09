package br.edu.ifsp.conversormonetario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final double DOLAR_VALUE= 5.0;
    private final double REAL_VALUE= 0.2;

    private EditText inputEditText;
    private Button dolarButton;
    private Button realButton;
    private TextView resultView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findById();
        setClick();
    }

    public void onClick(View v){
        if (v == dolarButton){
            converterDolar();
        }
        if (v == realButton){
            converterReal();
        }
    }

    private void findById(){
        inputEditText = findViewById(R.id.edittext_value);
        dolarButton = findViewById(R.id.calculate_dolar);
        realButton = findViewById(R.id.calculate_real);
        resultView = findViewById(R.id.textview_value);

    }

    private void setClick(){
        dolarButton.setOnClickListener(this);
        realButton.setOnClickListener(this);
    }
    private void converterReal() {

        double value = 0;
        String stringValue;


        stringValue = inputEditText.getText().toString();
        try {
            value = Double.valueOf(stringValue);
        }catch (NumberFormatException e){
            value = 0;
        }

        value = value * DOLAR_VALUE;
        resultView.setText(String.valueOf(value));

    }

    private void converterDolar() {

        double value = 0;
        String stringValue;


        stringValue = inputEditText.getText().toString();
        try {
            value = Double.valueOf(stringValue);
        }catch (NumberFormatException e){
            value = 0;
        }

        value = value / DOLAR_VALUE;
        resultView.setText(String.valueOf(value));
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}