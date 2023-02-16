package com.example.androidhello;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText Num1, Num2, Operation;
    TextView ResultText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Num1 = findViewById(R.id.editText1);
        Num2 = findViewById(R.id.editText2);
        Operation = findViewById(R.id.editTextOperation);
        ResultText = findViewById(R.id.textViewResult);
        button = findViewById(R.id.button);

        button.setOnClickListener(this::onClick);
    }



    public void onClick(View v){
        Float num1 = 0.f, num2 = 0.f, result = 0.f;
        String task = null;
        try{
            num1 = Float.parseFloat(Num1.getText().toString());
            num2 = Float.parseFloat(Num2.getText().toString());
            task = Operation.getText().toString();

            switch (task){
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 == 0)
                        throw new ArithmeticException();
                    result = num1 / num2;
                    break;
            }


        }catch(ArithmeticException e){
            Toast.makeText(getApplicationContext(), "Нельзя делить на ноль", Toast.LENGTH_SHORT).show();
        }
        catch (NullPointerException e){
            Toast.makeText(getApplicationContext(), "Вы заполнили не все поля", Toast.LENGTH_SHORT).show();
        }
        catch (NumberFormatException e){
            Toast.makeText(getApplicationContext(), "Введены неверные значения", Toast.LENGTH_SHORT).show();
        }

        ResultText.setText("Результат: " + num1 + " " + task + " " + num2 + " = " + result);
    }

}