package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.QuickContactBadge;
import android.widget.Toast;

import com.example.calculator.databinding.ActivityMainBinding;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
       binding.btn1.setOnClickListener(v -> binding.edittxt.setText(binding.edittxt.getText()+"1"));
       binding.btn2.setOnClickListener(v -> binding.edittxt.setText(binding.edittxt.getText()+"2"));
       binding.btn3.setOnClickListener(v -> binding.edittxt.setText(binding.edittxt.getText()+"3"));
       binding.btn4.setOnClickListener(v -> binding.edittxt.setText(binding.edittxt.getText()+"4"));
       binding.btn6.setOnClickListener(v -> binding.edittxt.setText(binding.edittxt.getText()+"6"));
       binding.btn7.setOnClickListener(v -> binding.edittxt.setText(binding.edittxt.getText()+"7"));
       binding.btn8.setOnClickListener(v -> binding.edittxt.setText(binding.edittxt.getText()+"8"));
       binding.btn9.setOnClickListener(v -> binding.edittxt.setText(binding.edittxt.getText()+"9"));
       binding.btn0.setOnClickListener(v -> binding.edittxt.setText(binding.edittxt.getText()+"0"));
       binding.btn5.setOnClickListener(v -> binding.edittxt.setText(binding.edittxt.getText()+"5"));
       binding.btnClear.setOnClickListener(v -> binding.edittxt.setText(""));
        binding.btnPlus.setOnClickListener(v -> binding.edittxt.setText(binding.edittxt.getText()+"+"));
        binding.btnMinus.setOnClickListener(v -> binding.edittxt.setText(binding.edittxt.getText()+"-"));
        binding.btnMul.setOnClickListener(v -> binding.edittxt.setText(binding.edittxt.getText()+"*"));
        binding.btnDiv.setOnClickListener(v -> binding.edittxt.setText(binding.edittxt.getText()+"/"));
        binding.btnMod.setOnClickListener(v -> binding.edittxt.setText(binding.edittxt.getText()+"%"));
        binding.btnDot.setOnClickListener(v -> binding.edittxt.setText(binding.edittxt.getText()+"."));
        binding.btnBack.setOnClickListener(v -> {
       String value=binding.edittxt.getText().toString().trim();
       if (!value.isEmpty()){
           if (value.length()>0){
               binding.edittxt.setText(value.substring(0,value.length()-1));
           }
       }
        });
        binding.btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Evaluate(binding.edittxt.getText().toString().trim());
            }
        });
    }

    private void Evaluate(String value) {
        try{
            Expression expression=new ExpressionBuilder(value).build();
            double result=expression.evaluate();
            binding.edittxt.setText(Double.toString(result));
        }catch (Exception e){
            Toast.makeText(this, "Error:-"+e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
}
