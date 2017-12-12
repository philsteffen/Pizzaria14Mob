package br.com.fiap.pizzaria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import br.com.fiap.pizzaria.Model.Pedido;
import butterknife.BindView;
import butterknife.OnClick;

import static android.R.attr.onClick;

public class MainActivity extends AppCompatActivity {

    Intent it;
    String username = "";
    String password = "";

    @BindView(R.id.Bacon)
    CheckBox Bacon;
    @BindView(R.id.Queijos)
    CheckBox Queijos;
    @BindView(R.id.Cala)
    CheckBox Cala;
    @BindView(R.id.choco)
    CheckBox Choco;
    @BindView(R.id.groupTamanho)
    RadioGroup groupTamanho;
    @BindView(R.id.pagamentos)
    Spinner Pagamentos;

    Pedido pedido = new Pedido();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        it = getIntent();
        if (it != null) {
            username = it.getStringExtra("username");
            password = it.getStringExtra("password");


        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bacon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    pedido.addSabor(Bacon.getText().toString());
                } else {
                    pedido.removerSabor(Bacon.getText().toString());
                }
            }
        });

        Cala.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    pedido.addSabor(Cala.getText().toString());
                } else {
                    pedido.removerSabor(Cala.getText().toString());
                }
            }
        });
        Queijos.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    pedido.addSabor(Queijos.getText().toString());
                } else {
                    pedido.removerSabor(Queijos.getText().toString());
                }
            }
        });
        Choco.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    pedido.addSabor(Choco.getText().toString());
                } else {
                    pedido.removerSabor(Choco.getText().toString());
                }
            }
        });
    }

    @OnClick(R.id.confirmar)
    public void fecharPedido() {

        pedido.setCliente(username);
        pedido.setTamanho(getTamanho());
        pedido.setFormaDePagamento(Pagamentos.getSelectedItem().toString());

        Intent i = new Intent(this, ConfirmarPedidoActivity.class);
        i.putExtra("Pedido", pedido);
        startActivity(i);
        finish();
    }

    public String getTamanho() {
        return ((RadioButton) findViewById(groupTamanho.getCheckedRadioButtonId())).getText().toString();
    }
}
