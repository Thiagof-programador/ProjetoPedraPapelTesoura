package com.thiagofcs.pedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionarPedra(View view) {
        verificarGanhador("pedra");
    }

    public void selecionarPapel(View view) {
        verificarGanhador("papel");
    }

    public void selecionarTesoura(View view) {
        verificarGanhador("tesoura");
    }

    private String gerarEscolhaAlteatoriaApp() {
        String[] opcoes = {"pedra", "papel", "tesoura"};
        int numeroAleatorio = new Random().nextInt(3);
        ImageView imagemApp = findViewById(R.id.image_app);
        String escolhaDoApp = opcoes[numeroAleatorio];
        switch (escolhaDoApp) {
            case "pedra":
                imagemApp.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imagemApp.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imagemApp.setImageResource(R.drawable.tesoura);
                break;
        }

        return escolhaDoApp;
    }

    private void verificarGanhador(String escolhaDoUsuario) {
        String escolhaApp = gerarEscolhaAlteatoriaApp();
        TextView textoResultado = findViewById(R.id.text_resultado);

        if (
                (escolhaApp == "pedra" && escolhaDoUsuario == "tesoura") ||
                        (escolhaApp == "tesoura" && escolhaDoUsuario == "papel") ||
                        (escolhaApp == "papel" && escolhaDoUsuario == "pedra")
        ) {
            textoResultado.setText("Voce Perdeu :)");
        } else if (
                (escolhaDoUsuario == "pedra" && escolhaApp == "tesoura") ||
                        (escolhaDoUsuario == "tesoura" && escolhaApp == "papel") ||
                        (escolhaDoUsuario == "papel" && escolhaApp == "pedra")
        ) {
            textoResultado.setText("Voce Ganhou (:");
        } else {
            textoResultado.setText("Empatamos ;)");
        }
    }
}
