package com.auidbook.formanimations;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int MIN_PASSWORD_LENGTH = 8;

    private TextView mTextViewEmail;
    private TextInputLayout mTextInputLayoutEmail;
    private TextView mTextViewPassword;
    private TextInputLayout mTextInputLayoutPassword;
    private View mViewSuccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button_save).setOnClickListener(this);
        mTextInputLayoutEmail = (TextInputLayout) findViewById(R.id.input_email);
        mTextViewEmail = (TextView) mTextInputLayoutEmail.findViewById(R.id.email);
        mTextInputLayoutPassword = (TextInputLayout) findViewById(R.id.input_password);
        mTextViewPassword = (TextView) mTextInputLayoutPassword.findViewById(R.id.password);
        mViewSuccess = findViewById(R.id.success);
    }

    @Override
    public void onClick(View v) {
        boolean hasError = false;

        // Validate email address
        if (Patterns.EMAIL_ADDRESS.matcher(mTextViewEmail.getText()).matches()) {
            mTextInputLayoutEmail.setErrorEnabled(false);
        } else {
            mTextInputLayoutEmail.setError(getString(R.string.email_error));
            hasError = true;
        }

        // Validate password
        if (mTextViewPassword.getText().length() >= MIN_PASSWORD_LENGTH) {
            mTextInputLayoutPassword.setErrorEnabled(false);
        } else {
            mTextInputLayoutPassword.setError(getString(R.string.password_error));
            hasError = true;
        }

        if (hasError) {
            mViewSuccess.setVisibility(View.GONE);
        } else {
            mViewSuccess.setVisibility(View.VISIBLE);
        }
    }
}
