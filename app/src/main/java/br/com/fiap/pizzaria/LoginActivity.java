package br.com.fiap.pizzaria;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.username)
    TextInputLayout username;

    @BindView(R.id.password)
    TextInputLayout password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        username.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                valida();
            }
        });
    }

    @OnClick(R.id.btConectar)
    public void conectar() {
        valida();

        Intent it = new Intent(this, MainActivity.class);
        it.putExtra("username", username.getEditText()
                .getText()
                .toString());
        it.putExtra("password", username.getEditText()
                .getText()
                .toString());
        startActivity(it);
        finish();
    }

    public void valida() {

        String erro = "";

        if (username.getEditText().getText().toString().isEmpty()) {
            username.setError("Login Não informado");
            erro = "1";
        } else {
            username.setError(null);
        }

        if (password.getEditText().getText().toString().isEmpty()) {
            password.setError("senha não informada");
            erro = "2";
        }

        if (erro.equals("")) {
            return;
        }
        ;
    }
}
