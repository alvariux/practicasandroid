package com.practica1.calculadora;

import android.support.annotation.BinderThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_txtNum1) EditText txtNum1;
    @BindView(R.id.main_txtNum2) EditText txtNum2;
    @BindView(R.id.main_txtResult) EditText txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


    }

    @OnClick(R.id.main_btnCalcular)
    public void calcular()
    {
        int n1 = Integer.parseInt(txtNum1.getText().toString());
        int n2 = Integer.parseInt(txtNum2.getText().toString());
        int resultado = 0;

        resultado = n1 + n2;

        txtResultado.setText(Integer.toString(resultado));
    }

    @OnClick(R.id.main_btnLimpiar)
    public void limpiar()
    {
        txtNum1.setText("");
        txtNum2.setText("");
        txtResultado.setText("");
    }
}
