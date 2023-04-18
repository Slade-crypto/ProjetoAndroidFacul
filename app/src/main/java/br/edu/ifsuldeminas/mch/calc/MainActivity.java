package br.edu.ifsuldeminas.mch.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import de.congrace.exp4j.Calculable;
import de.congrace.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "ifsuldeminas.mch.calc";
    private Button buttonEquals, buttonC, buttonD, buttonZero, buttonOne, buttonTwo, buttonThree, buttonFour,
            buttonFive, buttonSix, buttonSeven, buttonEight, buttonNine, buttonPlus, buttonMinus, buttonMultiply, buttonDivide, buttonComma;
    private TextView textViewResultado, textViewUltimaExpressao;
    private String expressao = "";

    private void adicionarOperacao(char operacao) {
        if (expressao.length() > 0) {
            char ultimoCaractere = expressao.charAt(expressao.length() - 1);
            if (ultimoCaractere == operacao) {
                // Se o último caractere já for a operação, não adiciona novamente
                return;
            } else if (ultimoCaractere == '-' || ultimoCaractere == '+' || ultimoCaractere == '/') {
                // Se o último caractere for um sinal diferente da operação, substitui pelo sinal da operação
                expressao = expressao.substring(0, expressao.length() - 1) + "";
            }
        } else {
            // Se a expressão estiver vazia, não adiciona o sinal da operação
            return;
        }

        // Adiciona o sinal da operação à expressão
        expressao += operacao;
        textViewUltimaExpressao.setText(expressao);
        textViewResultado.setText("");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResultado = findViewById(R.id.textViewResultadoID);
        textViewUltimaExpressao = findViewById(R.id.textViewUltimaExpressaoID);

        buttonEquals = findViewById(R.id.buttonIgualID);
        buttonC = findViewById(R.id.buttonResetID);
        buttonD = findViewById(R.id.buttonDeleteID);
        buttonZero = findViewById(R.id.buttonZeroID);
        buttonOne = findViewById(R.id.buttonUmID);
        buttonTwo = findViewById(R.id.buttonDoisID);
        buttonThree = findViewById(R.id.buttonTresID);
        buttonFour = findViewById(R.id.buttonQuatroID);
        buttonFive = findViewById(R.id.buttonCincoID);
        buttonSix = findViewById(R.id.buttonSeisID);
        buttonSeven = findViewById(R.id.buttonSeteID);
        buttonEight = findViewById(R.id.buttonOitoID);
        buttonNine = findViewById(R.id.buttonNoveID);
        buttonPlus = findViewById(R.id.buttonSomaID);
        buttonMinus = findViewById(R.id.buttonSubtracaoID);
        buttonMultiply = findViewById(R.id.buttonMultiplicacaoID);
        buttonDivide = findViewById(R.id.buttonDivisaoID);
        buttonComma = findViewById(R.id.buttonVirgulaID);



        buttonZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expressao += "0";
                textViewUltimaExpressao.setText(expressao);
            }
        });

        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expressao += "1";
                textViewUltimaExpressao.setText(expressao);
            }
        });

        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expressao += "2";
                textViewUltimaExpressao.setText(expressao);
            }
        });

        buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expressao += "3";
                textViewUltimaExpressao.setText(expressao);
            }
        });

        buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expressao += "4";
                textViewUltimaExpressao.setText(expressao);
            }
        });
        buttonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expressao += "5";
                textViewUltimaExpressao.setText(expressao);
            }
        });

        buttonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expressao += "6";
                textViewUltimaExpressao.setText(expressao);
            }
        });

        buttonSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expressao += "7";
                textViewUltimaExpressao.setText(expressao);
            }
        });

        buttonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expressao += "8";
                textViewUltimaExpressao.setText(expressao);
            }
        });

        buttonNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expressao += "9";
                textViewUltimaExpressao.setText(expressao);
            }
        });

        buttonComma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (expressao.isEmpty()) {
                    // Se a expressão estiver vazia, não adiciona o sinal de ponto
                    return;
                }

                char ultimoCaractere = expressao.charAt(expressao.length() - 1);
                if (ultimoCaractere == '.') {
                    // Se o último caractere já for um ponto, não adiciona novamente
                    return;
                } else if (ultimoCaractere == '-' || ultimoCaractere == '*' || ultimoCaractere == '/' || ultimoCaractere == '+') {
                    // Substitui o último operador por um ponto
                    expressao = expressao.substring(0, expressao.length() - 1) + ".";
                } else {
                    // Adiciona o sinal de ponto à expressão
                    expressao += ".";
                }

                textViewUltimaExpressao.setText(expressao);
                textViewResultado.setText("");
            }
        });

        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (expressao.isEmpty()) {
                    return;
                }

                char ultimoCaractere = expressao.charAt(expressao.length() - 1);
                if (ultimoCaractere == '+') {
                    // Se o último caractere já for uma soma, não adiciona novamente
                    return;
                } else if (ultimoCaractere == '-' || ultimoCaractere == '*' || ultimoCaractere == '/') {
                    // Se o último caractere for um sinal diferente de soma, substitui pelo sinal de soma
                    expressao = expressao.substring(0, expressao.length() - 1);
                }

                // Adiciona o sinal de soma à expressão
                expressao += "+";
                textViewUltimaExpressao.setText(expressao);
                textViewResultado.setText("");
            }
        });

        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (expressao.isEmpty()) {
                    return;
                }

                char ultimoCaractere = expressao.charAt(expressao.length() - 1);
                if (ultimoCaractere == '-') {
                    return;
                } else if (ultimoCaractere == '+' || ultimoCaractere == '*' || ultimoCaractere == '/') {
                    expressao = expressao.substring(0, expressao.length() - 1) + "";
                }

                // Adiciona o sinal de subtração à expressão
                expressao += "-";
                textViewUltimaExpressao.setText(expressao);
                textViewResultado.setText("");
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //um experimento utilizando um método hehe
                adicionarOperacao('*');
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adicionarOperacao('/');
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expressao = "";
                textViewUltimaExpressao.setText("");
                textViewResultado.setText("");
            }
        });

        buttonD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (expressao.length() > 0) {
                    expressao.substring(0, expressao.length() - 1); //começa pelo indice 0 da expressao e cria uma nova string tirando 1 do tamanho da expressao
                    textViewUltimaExpressao.setText(expressao);
                    textViewResultado.setText("");
                }
            }
        });

        buttonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Verifica se a expressão não termina com um sinal matemático
                if (expressao.endsWith("+") || expressao.endsWith("-") || expressao.endsWith("*") || expressao.endsWith("/")) {
                    return;
                }

                try {
                    Calculable calculo = new ExpressionBuilder(expressao).build();
                    double resultado = calculo.calculate();

                    textViewResultado.setText(String.valueOf(resultado));
                    textViewUltimaExpressao.setText(expressao);

                    // Limpa a expressão e adiciona o resultado como nova expressão
                    expressao = String.valueOf(resultado);
                } catch (Exception e) {
                    Log.e(TAG, "Erro ao calcular expressão: " + e.getMessage());
                }
            }
        });

    }

}