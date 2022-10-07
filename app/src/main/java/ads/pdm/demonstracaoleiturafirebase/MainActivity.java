package ads.pdm.demonstracaoleiturafirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference BD = FirebaseDatabase.getInstance().getReference();

    private EditText txtNome;
    private EditText txtSobrenome;
    private EditText txtIdade;
    private Button btnEnviar;
    private TextView lblNome;
    private TextView lblSobrenome;
    private TextView lblIdade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNome = findViewById( R.id.txtNome );
        txtSobrenome = findViewById( R.id.txtSobrenome );
        txtIdade = findViewById( R.id.txtIdade );
        btnEnviar = findViewById( R.id.btnEnviar );
        lblNome = findViewById( R.id.lblNome );
        lblSobrenome = findViewById( R.id.lblSobrenome );
        lblIdade = findViewById( R.id.lblIdade );

        btnEnviar.setOnClickListener( new EscutadorBotao() );

        DatabaseReference dados = BD.child("dados");
        dados.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    Usuario usuario = dataSnapshot.getValue(Usuario.class);
                    lblNome.setText("Nome: " + usuario.getNome());
                    lblSobrenome.setText("Sobrenome: " + usuario.getSobrenome());
                    lblIdade.setText("Idade: " + Integer.toString(usuario.getIdade()));



                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }


        });



    }

    private class EscutadorBotao implements View.OnClickListener {
        @Override
        public void onClick(View view) {

            String nome, sobren;
            int idade;

            nome = txtNome.getText().toString();
            sobren = txtSobrenome.getText().toString();
            idade = Integer.parseInt( txtIdade.getText().toString() );

            Usuario u = new Usuario( nome, sobren, idade );



            BD.child( "dados" ).setValue( u );
        }
    }






}