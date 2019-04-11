package fjc.lengket.akuarium;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.security.Permission;

public class PermissionPrompter extends Activity implements View.OnClickListener {

    Button btnIzinkan;

    private final int RQ_PERMIS = 13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission_prompter);
        this.btnIzinkan = findViewById(R.id.btnIzinkan);
        this.btnIzinkan.setOnClickListener(this);
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if(requestCode == RQ_PERMIS) {
            if(grantResults.length < 2 || grantResults[0] != PackageManager.PERMISSION_GRANTED || grantResults[1] != PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(getApplicationContext(), "Izin yang diperlukan tidak terpenuhi. Mohon berikan persetujuan untuk semua izin yang diperlukan.", Toast.LENGTH_SHORT).show();
                return;
            }

            setResult(Activity.RESULT_OK);
            finish();
        }
    }

    @Override
    public void onClick(View v) {
        if(v == btnIzinkan) {
            ActivityCompat.requestPermissions(this, new String[] {
                    android.Manifest.permission.READ_EXTERNAL_STORAGE,
                    android.Manifest.permission.CAMERA
            },RQ_PERMIS);
        }
    }
}
