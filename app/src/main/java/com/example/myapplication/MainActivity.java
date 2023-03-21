package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class MainActivity extends AppCompatActivity {

    // Instanciación de las variables
    private EditText editTextNumberDecimal;
    private TextView textViewOrigen, textViewDestino, textViewValorIntroducido, textViewConvertido, textViewResultadoConv;
    private Button button_convert;
    private Spinner spinner3, spinner4;
    private CustomAdapter adapter_rla; //!!!


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Inicialización de las variables a partir de los elementos xml con findViewById por los identificadores
        editTextNumberDecimal = (EditText) findViewById(R.id.valorIntroducido);
        textViewOrigen = (TextView) findViewById(R.id.textViewOrigen);
        textViewDestino = (TextView) findViewById(R.id.textViewDestino);
        textViewValorIntroducido = (TextView) findViewById(R.id.textViewValorIntroducido);
        button_convert = (Button) findViewById(R.id.button_convert);
        spinner3 = (Spinner) findViewById(R.id.spinner_origen);
        spinner4 = (Spinner) findViewById(R.id.spinnerDestino);

        //Una vez definidas e inicializadas las variables, se pueden hacer acciones

        // Definimos una variable de tipo Array de String con las distintas unidades métricas
        //que se van a ofertar en los spinners
        String[] unidades = {"Kilómetro cuadrado", "Metro cuadrado", "Milla cuadrada",
                "Yarda cuadrada", "Pie cuadrado", "Pulgada cuadrada", "Hectárea", "Acre"};

        /*Toast notification =Toast.maketext(this, text, TOAST.length_long )
        * notifiction.show()*/

        // Hay que relacionar los spinners con su formato (CustomAdapter)!!!!

        //El spinner es un desplegable y tiene 3 elementos:
        //la lista de valores posibles que tiene el desplegable (por ejun array)
        // //y un adptador predefinido, que es elemento intermedio entre los datos y el spinner (elemento visual)
        //el adaptador se define
        //String [] ciudades = {}:
        //ArrayAdapter<String> adaptador = new ArrayAdapter<String> (this, android.R.layout.simple_spinner_item, ciudades

        //vamos a usar un layout predefinido el de dentro, es un layout que ya existe. no lo he definido yo

        //rellenamos la varaible del spinner con listavalores.setAdapter(adaptador)
        adapter_rla = new CustomAdapter(this, unidades);

        spinner3.setAdapter(adapter_rla);

        spinner4.setAdapter(adapter_rla);
        // Selecciona el valor por defecto del segundo spinner para            evitar que ambos spinners comiencen con el mismo valor
        spinner4.setSelection(1);

        String valorOrigen = spinner3.getSelectedItem().toString();
        String valorDestino = spinner4.getSelectedItem().toString();

        if((valorOrigen == "cm") && (valorDestino=="Metro")){

            //String resultado;
            //tvMensaje.setText(resultado);
        }
        //Se va a usar el km cuadrado como estándar a partir del cual realizar el resto de conversiones de unidades
        // Se guardan en un array las conversiones de las diferentes unidades definidades en el array Strin[] unidades
        //según su posición con respecto a metros cuadrados


        //Array de conversión a unidad única(km^2)
        Double[] indiceConversionDesdeKm2 = {1.0, 1000000.0, 0.39, 1195990.0, 10763910.41670972, 1550003100.0062, 100.0, 247.105381};

        //[0] --> convertir de km^2 a km^2, [1] --> convertir de km^2 a m^2
        //[3]--> convertir de km^2 a milla^2, [4] --> convertir de km^2 a yarda^2
        //[5]--> convertir de km^2 a pie^2, [6] --> convertir de km^2 a pulgada^2
        //[7]--> convertir de km^2 a hectárea, [8] --> convertir de km^2 a acre



        /*
        * // Cuando se selecciona un item del spinner de origen, se genera un evento...

        spinnerOrigen.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView,View view, int i, long l) {
                // Si no se selecciona nada en el primer spinner
                spinners:
                if (spinnerOrigen.getSelectedItem().toString().isEmpty())
                         {
                    // Se deshabilita el edittext para meter el valor a convertir
                    //y se alerta al usuario para que seleccione un item
                    editTextNumberDecimal.setEnabled(false);

                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                    alertDialog.setMessage("Seleccione una unidad de origen.").show();
                }

                //Si ha seleccionado una opción, se habilita el editTextNumberDecimal
                else {
                    editTextNumberDecimal.setEnabled(true);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }


        });


         //Cuando se selecciona opción del spinnerDestino, se genera un evento
            spinnerDestino.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView,View view, int i, long l) {
                    // Si no se selecciona nada en el primer spinner
                    spinners:
                    if (spinnerDestino.getSelectedItem().toString().isEmpty())
                    {
                        // Se deshabilita el edittext para meter el valor a convertir
                        //y se alerta al usuario para que seleccione un item
                        editTextNumberDecimal.setEnabled(false);

                        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                        alertDialog.setMessage("Seleccione una unidad de destino.").show();
                    }

                    //Si ha seleccionado una opción, se habilita el editTextNumberDecimal
                    else {
                        editTextNumberDecimal.setEnabled(true);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            * */
        // Evento que se activará al seleccionar un elemento del

        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                                            @Override
                                                            public void onItemSelected(AdapterView<?> adapterView,
                                                                                       View view, int i, long l) {
                                                                // Si se selecciona la misma opción en los dos
                                                                spinners:
                                                                if(spinner3.getSelectedItemPosition() ==
                                                                        spinner4.getSelectedItemPosition()) {

                                                                    button_convert.setEnabled(false);
                                                                    editTextNumberDecimal.setEnabled(false);

                                                                    AlertDialog.Builder alerta_rla = new
                                                                            AlertDialog.Builder(MainActivity.this);
                                                                    alerta_rla.setMessage("Por favor, seleccione una opción distinta").show();
                                                                }else{

                                                                    button_convert.setEnabled(true);
                                                                    editTextNumberDecimal.setEnabled(true);
                                                                }
                                                            }
                                                            @Override
                                                            public void onNothingSelected(AdapterView<?> adapterView)
                                                            {
                                                            }
                                                        });


        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                                           @Override
                                                           public void onItemSelected(AdapterView<?> adapterView,
                                                                                      View view, int i, long l) {
                                                               // Si se selecciona la misma opción en los dos
                                                               spinners:
                                                               if(spinner3.getSelectedItemPosition() ==
                                                                       spinner4.getSelectedItemPosition()) {

                                                                   button_convert.setEnabled(false);
                                                                   editTextNumberDecimal.setEnabled(false);

                                                                   AlertDialog.Builder alerta_rla = new
                                                                           AlertDialog.Builder(MainActivity.this);
                                                                   alerta_rla.setMessage("Por favor, seleccione una opción distinta").show();
                                                               }else{

                                                                   button_convert.setEnabled(true);
                                                                   editTextNumberDecimal.setEnabled(true);
                                                               }
                                                           }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {
            }
        });



                                                               //Cuando se hace clic sobre el botón de convertir, se genera otro evento
        //se define un evento que se ejcuta cuando alguien haga click en el botón
        //cuando haga clic se ejectuará el código
        button_convert.setOnClickListener(new View.OnClickListener() {

            //La forma más dinámica de poder llamar a un botón
            //es la manera dinamica de generar una ccion ssobre el botón
            @Override
            public void onClick(View view) {

                // Guardar las posiciones de los items seleccionados en los spinners de origen y de destino
                int spinnerOrigenItemPosition = spinner3.getSelectedItemPosition();
                int spinnerDestinoItemPosition = spinner4.getSelectedItemPosition();
                try {
                    // Dentro del bloque try se intenta...

                    //Parsear a Double el valor a convertir introducido por el usuario
                    //int valorIntroducidoDouble = Integer.parseInt(editTextNumberDecimal.getText().toString());

                    int valorIntroducidoDouble = 2;
                    // Se corrobora que el valor (double) sea superior a 0 (no se pueden meter valores negativos)

                    if (valorIntroducidoDouble > 0) {
                        //Al comprobar que sea positivo el valor, se pasa a metros cuadrados, que es
                        //el "estándar" a partir del cual se calcula el resto de unidades métricas

                        Double resultadoConversion = valorIntroducidoDouble * indiceConversionDesdeKm2[spinnerOrigenItemPosition] / indiceConversionDesdeKm2[spinnerDestinoItemPosition];

                        // Se pide que el resultado de la conversión solo tenga dos decimales
                       // BigDecimal bigDecimal_rla = new BigDecimal(resultadoConversion).setScale(2, RoundingMode.HALF_UP);
                        //resultadoConversion = bigDecimal_rla.doubleValue();


                        //Cuando se obtiene el resultado de la conversión, se muestra en el textViewResultadoConv
                        //indicando también las unidades métricas

                        textViewResultadoConv.setText(resultadoConversion + " " );

                        //Se ponen en visible tanto el textView con el resultado como su "etiqueta" (textViewResultado)
                        textViewConvertido.setVisibility(View.VISIBLE);
                        textViewResultadoConv.setVisibility(View.VISIBLE);
                    } else {

                        AlertDialog.Builder alertDialog2 = new AlertDialog.Builder(MainActivity.this);
                        alertDialog2.setMessage("El valor introducido no puede ser negativo.").show();


                    }

                }
                //Si en el bloque try salta alguna excepción, se pasa al bloque catch

                catch (Exception ex1) {
                    //Se muestra un error en el textView donde se introduce el valor a convertir
                    editTextNumberDecimal.setError("Ey. error macho");
                }
            }
        });
    }

}