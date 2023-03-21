package com.example.myapplication;

/* Clase que define el formato del Adapter del Spinner personalizado
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
public class CustomAdapter extends ArrayAdapter<String> {
    // Declara las variables que formarán la estructura del spinner     personalizado
    Context contexto_rla;
    String[] texto_rla;

    public CustomAdapter(@NonNull Context context, String[] texto_rla) {
        super(context, R.layout.spinner_item_layout, texto_rla);
        this.contexto_rla = context;
        this.texto_rla = texto_rla;
        //this.imagenes_rla = imagenes_rla;
    }
    @Override
    // Establece cómo se mostrará la lista de valores al desplegar el     spinner

    public View getDropDownView(int position, @Nullable View
            convertView, @NonNull ViewGroup parent) {
        // LayoutInflater es un tipo de variable que sirve para         instanciar un archivo XML
        LayoutInflater inflater_rla = (LayoutInflater)
                contexto_rla.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // En este caso, instanciará el archivo XML con el spinner         personalizado
        View row_rla =
                inflater_rla.inflate(R.layout.spinner_item_layout, null);
        // Crea dos variables para guardar los TextView e ImageView         definidos en el "spinner_item_layout.xml"
        TextView tv_divisa_rla = (TextView)
                row_rla.findViewById(R.id.tv_divisa_rla);
        ImageView iv_bandera_rla = (ImageView)
                row_rla.findViewById(R.id.iv_bandera_rla);
        tv_divisa_rla.setText(texto_rla[position]);
        //iv_bandera_rla.setImageResource(imagenes_rla[position]);
        // Devuelve la fila del spinner personalizado
        return row_rla;
    }
    @Override
    // Establece cómo se mostrarán los valores en el spinner sin     desplegar
    public View getView(int position, @Nullable View convertView,
                        @NonNull ViewGroup parent) {
        // LayoutInflater para instanciar el archivo         "spinner_item_layout.xml"
        LayoutInflater inflater_rla = (LayoutInflater)
                contexto_rla.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row_rla =
                inflater_rla.inflate(R.layout.spinner_item_layout, null);
        // Variables para guardar los TextView e ImageView definidos         en el "spinner_item_layout.xml"
        TextView tv_divisa_rla = (TextView)
                row_rla.findViewById(R.id.tv_divisa_rla);
        ImageView iv_bandera_rla = (ImageView)
                row_rla.findViewById(R.id.iv_bandera_rla);
        tv_divisa_rla.setText(texto_rla[position]);
        //iv_bandera_rla.setImageResource(imagenes_rla[position]);
        // Devuelve la fila del spinner personalizado
        return row_rla;
    }
}


