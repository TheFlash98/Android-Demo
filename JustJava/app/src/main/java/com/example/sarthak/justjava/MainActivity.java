package com.example.sarthak.justjava;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;


public class MainActivity extends AppCompatActivity {
    int n = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void change(View view)
    {
        if(view.getId()==R.id.substract)
        {
            if(n>0){
                n--;
            }
        }
        else if(view.getId()==R.id.add){
            n++;
        }
        display(n);

    }

    public void submitOrder(View view){
        displayPrice(n*5);
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL, "sample@gmail.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Coffee Please");
        intent.putExtra(Intent.EXTRA_TEXT, "I want "+n+" cups of coffee");

        startActivity(Intent.createChooser(intent, "Send Email"));
    }
    private void display(int number){
        TextView quantityTextView = (TextView)findViewById(R.id.quantity_text_view);
        quantityTextView.setText(""+number);

    }
    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
}
