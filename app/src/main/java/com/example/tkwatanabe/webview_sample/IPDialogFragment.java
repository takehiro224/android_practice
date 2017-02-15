package com.example.tkwatanabe.webview_sample;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by tkwatanabe on 2017/02/15.
 */

public class IPDialogFragment extends android.app.DialogFragment {
    /**
     */
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder aBuilder = new AlertDialog.Builder(getActivity());
        Dialog dialog = aBuilder.setTitle("削除しますか?")
                .setPositiveButton("削除",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                DialogFragmentActivity dfActivity = (DialogFragmentActivity) getActivity();
                                dfActivity.toastShow("Delete!");
                            }
                        })
                .setNegativeButton("キャンセル",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                DialogFragmentActivity dfActivity = (DialogFragmentActivity) getActivity();
                                dfActivity.toastShow("Cancel");
                            }
                        })
                .create();
        return dialog;
    }
}
