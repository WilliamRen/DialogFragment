package com.example.dialogfragment;

import android.os.Bundle;
import android.view.Menu;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends FragmentActivity implements OnClickListener{
    private TextView text;      // �e�L�X�g
    private Button startBtn;    // �{�^��

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // �e�L�X�g
        text = (TextView)findViewById(R.id.textView1);
        // �{�^��
        startBtn = (Button) findViewById(R.id.button1);
        startBtn.setOnClickListener(this);
    }

    /*
     * �{�^���N���b�N�C�x���g
     */
	@Override
    public void onClick(View v) {
        // �X�^�[�g�{�^��
        if (v == startBtn) {
            CustomDialogFragment dialog = new CustomDialogFragment();
            dialog.show(getSupportFragmentManager(), "dialog");
        }
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    
    @SuppressLint("ValidFragment")
    public class CustomDialogFragment extends DialogFragment {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            Dialog dialog = new Dialog(getActivity());
            // �_�C�A���O�̃A�j���[�V����
            dialog.getWindow().getAttributes().windowAnimations = R.style.Animation_CustomDialog;
            // �^�C�g����\��
            dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
            // �t���X�N���[��
            dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
            dialog.setContentView(R.layout.dialog_custom);
            // �w�i�𓧖��ɂ���
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            // �_�C�A���O�̊O���N���b�N���Ă�dismiss�����Ȃ�
            dialog.setCanceledOnTouchOutside(false);
            // ���b�Z�[�W��n��
            TextView message = (TextView) dialog.findViewById(R.id.message);
            message.setText(text.getText());
            // OK �{�^���̃��X�i
            dialog.findViewById(R.id.positive_button).setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    dismiss();
                }
            });
            // Close �{�^���̃��X�i
            dialog.findViewById(R.id.close_button).setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    dismiss();
                }
            });
            return dialog;
        }
    }
}
