package my.edu.tarc.lab21loancalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String LOAN_STATUS = "status";
    public static final String LOAN_PAYMENT = "payment";
    EditText editTextVehiclePrice, editTextDownPayment,editTextRepayment,editTextInterestRate,editTextSalary;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextVehiclePrice=(EditText)findViewById(R.id.editTextVehiclePrice);
         editTextDownPayment= (EditText)findViewById(R.id.editTextDownpayment);
       editTextInterestRate=(EditText)findViewById(R.id.editTextInterestRate);
        editTextRepayment=(EditText)findViewById(R.id.editTextRepayment);
        editTextSalary=(EditText)findViewById(R.id.editTextSalary);


    }

    public void calculateLoan(View view){
        double TotalInterest,TotalLoan,MonthlyPayment,Salary30;

        TotalInterest=(Double.parseDouble(editTextVehiclePrice.getText().toString())-Double.parseDouble(editTextDownPayment.getText().toString()))*(Double.parseDouble(editTextInterestRate.getText().toString())/100)*(Double.parseDouble(editTextRepayment.getText().toString())/12);

        TotalLoan=(Double.parseDouble(editTextVehiclePrice.getText().toString())-Double.parseDouble(editTextDownPayment.getText().toString()))+TotalInterest;

        MonthlyPayment=TotalLoan/Double.parseDouble(editTextRepayment.getText().toString());

        Salary30=(Double.parseDouble(editTextSalary.getText().toString())/30)*100;


        //TODO: calculate repayment amount and determine the status of loan application
        double payment=MonthlyPayment;
        String status="Approves";



        //Define an Intent object
        Intent intent = new Intent(this,ResultActivity.class);
        //Use the putExtra method in pass data
        //format: putExtra (TAG,values)
        if (MonthlyPayment>Salary30){
            status="Approves";

        }
        else
            status="Reject";


        intent.putExtra(LOAN_PAYMENT,payment);
        intent.putExtra(LOAN_STATUS,status);
        startActivity(intent);

    }
    public void ResetResult(View view){
        editTextVehiclePrice.setText("");
        editTextDownPayment.setText("");
        editTextRepayment.setText("");
        editTextInterestRate.setText("");
        editTextSalary.setText("");
    }
}
