package com.example.examenprom;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentListado extends Fragment {
    MuseoListener listener;
    private final Museo[] datos = {
            new Museo("Persona 1", "Museo de Bellas Artes de Bilbao", "Abandoibarra Et. 2,48001 Bilbao\t","http://www.museobilbao.com/"),
            new Museo("Persona 2", "Museo Guggenheim de Bilbao", "Museo Plaza 2 (Estación de metro de Moyúa) 48009 Bilbao","https://www.guggenheim-bilbao.eus/"),
            new Museo("Persona 3", "Museo San Telmo", "Plaza Zuloaga 1, 20003 San Sebastián - Donostia","https://www.santelmomuseoa.eus"),
            new Museo("Persona 4", "Azkuna Zentroa", "Plaza Arriquibar, 4, 48008 Bilbao","https://www.azkunazentroa.eus"),
            new Museo("Persona 5", "Museo de Bellas Artes", "Paseo Fray Francisco, 8  01007 Vitoria-Gasteiz",""),
            new Museo("Persona 6", "Tabakalera", "Plaza de las cigarreras, 1,20012 San Sebastián - Donostia","https://www.tabakalera.eu/eu"),
            new Museo("Persona 7", "Museo Diocesano de Arte Sacro", "Catedral de Maria Inmaculada  c/ Cadena y Eleta s/n 01008 Vitoria-Gasteiz","")
    };
    private ListView lstListado;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_listado, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lstListado = (ListView) getView().findViewById(R.id.lstCanciones);
        lstListado.setAdapter(new AdaptadorMuseo(this));
        //Asignamos el evento onItemClick() a la lista de los correos
        lstListado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (listener != null)
                    listener.onMuseoSeleccionado((Museo) lstListado.getAdapter().getItem(position));
            }
        });

    }


    class AdaptadorMuseo extends ArrayAdapter<Museo> {
        Activity context;

        AdaptadorMuseo(Fragment context) {
            super(context.getActivity(), R.layout.listitem_museos, datos);
            this.context = context.getActivity();
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.listitem_museos, null);

            TextView lblDe = (TextView) item.findViewById(R.id.nomMuseo);
            lblDe.setText(datos[position].getNombre());

            TextView lblAsunto = (TextView) item.findViewById(R.id.descripcion);
            lblAsunto.setText(datos[position].getLocalizacion());
            return (item);
        }
    }

    public void setMuseoListener(MuseoListener listener) {
        this.listener = listener;
    }
}
