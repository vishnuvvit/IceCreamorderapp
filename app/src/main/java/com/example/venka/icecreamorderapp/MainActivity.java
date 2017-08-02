package com.example.venka.icecreamorderapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView q,orderSummary;
    Button in,de,order;
    EditText n;
    CheckBox c1,c2;

    private static final int base_price = 40;
    private static final int chocolate_topping = 15;
    private static final int dry_fruit_topping = 60;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        in =(Button) findViewById(R.id.id_plus_button);
        de =(Button)findViewById(R.id.id_minus_button);
        order=(Button)findViewById(R.id.id_order_button);

        q=(TextView)findViewById(R.id.id_quantity_value_text);
        orderSummary=(TextView)findViewById(R.id.id_price_value_text);

        n= (EditText)findViewById(R.id.id_name_edit);
        c1= (CheckBox)findViewById(R.id.id_chocolate_check);
        c2=(CheckBox)findViewById(R.id.id_dry_fruit_check);

        de.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int value=Integer.parseInt(q.getText().toString());
                if(value>0)
                    value--;
                q.setText(String.valueOf(value));
            }
        });

    }

    public void increaseQuantity(View view) {

        int value=Integer.parseInt(q.getText().toString());
        value++;
        q.setText(String.valueOf(value));
    }
    public void calculatePrice(View v)
    {
        /*int value=Integer.parseInt(q.getText().toString());
        int price = value * 40;
        p.setText("Rs "+String.valueOf(price)+" /-");*/
        displayName();
        displayToppings();
        displayQuantity();
        displayTotalPrice();

    }

    private void displayQuantity() {
        String text=q.getText().toString();
        String t="Ordered "+text+" icecreams";
        String x=orderSummary.getText().toString();
        orderSummary.setText(x+"\n"+t);
    }

    private void displayTotalPrice() {
        int quantity=Integer.parseInt(q.getText().toString());
        int price = 0;
        if(c1.isChecked()){
            price += quantity * (base_price+chocolate_topping);
        }
        if(c2.isChecked()){
            price += quantity * (base_price+dry_fruit_topping);

        }
        if(!c1.isChecked() && !c2.isChecked()){
            price += quantity * base_price;
        }
        String x=orderSummary.getText().toString();
        orderSummary.setText(x+"\nTotal Price is Rs "+String.valueOf(price)+" /-");

    }

    private void displayToppings(){
        String text;
        if (c1.isChecked()) {
            text = c1.getText().toString() + ": true";
        } else {
            text = c1.getText().toString() + ": false";
        }
        String x = orderSummary.getText().toString();
        orderSummary.setText(x + "\n" + text);
        if (c2.isChecked()) {
            text = c2.getText().toString() + ": true";
        } else {
            text = c2.getText().toString() + ": false";
        }
        x = orderSummary.getText().toString();
        orderSummary.setText(x + "\n" + text);

    }

    private void displayName(){
        String name=n.getText().toString();
        String t="Name :"+name;
        orderSummary.setText(t);
    }
}
