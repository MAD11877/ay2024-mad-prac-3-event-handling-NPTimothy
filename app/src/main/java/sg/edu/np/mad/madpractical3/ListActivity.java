package sg.edu.np.mad.madpractical3;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageView image = findViewById(R.id.image);
        image.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ListActivity.this);


                builder.setTitle("Profile");
                builder.setMessage("MADness");
                builder.setPositiveButton("View", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        Random random = new Random();
                        int randomInteger = random.nextInt(999999);

                        Intent activityName = new Intent(ListActivity.this, MainActivity.class);
                        activityName.putExtra("random", Integer.toString(randomInteger));
                        startActivity(activityName);
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        return;
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();

            }
        });

    }
}