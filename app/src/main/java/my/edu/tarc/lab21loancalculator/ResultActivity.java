package my.edu.tarc.lab21loancalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ResultActivity extends AppCompatActivity {
    ImageView ImageViewResult;
    TextView TextviewPayment;
    String status;
    double payment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //To get the intent
        Intent intent=getIntent();//Asking "who called me"
        double payment = intent.getDoubleExtra(MainActivity.LOAN_PAYMENT,0);
        String status = intent.getStringExtra(MainActivity.LOAN_STATUS);
        ImageViewResult = (ImageView)findViewById(R.id.imageView);
        TextviewPayment = (TextView)findViewById(R.id.textViewMonthlyPayment);
        //ToDo: display outputs
        TextviewPayment.setText("Monthly Payment : " + payment);
        if (status.equals("Approves"))
        ImageViewResult.setImageResource(R.drawable.up);

        else
        ImageViewResult.setImageResource(R.drawable.down);

    }

    public void closeActivity(View view){

        //Terminate an acitivity
        finish();
    }
}
