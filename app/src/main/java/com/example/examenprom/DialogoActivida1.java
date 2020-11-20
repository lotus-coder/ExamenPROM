package com.example.examenprom;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.DialogFragment;
public class DialogoActivida1 extends AppCompatDialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("¡¡ATENCION!!")
                .setMessage("Operacion cancelada a peticion del usuario")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        try {
                            MainActivity.termina();
                            System.exit(0);
                        } catch (Throwable throwable) {
                            throwable.printStackTrace();
                        }
                    }
                });
        return builder.create();
    }
}

