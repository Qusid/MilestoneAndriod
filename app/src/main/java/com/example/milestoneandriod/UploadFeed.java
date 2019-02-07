package com.example.milestoneandriod;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class UploadFeed extends AppCompatActivity {
    // Image loading result to pass to startActivityForResult method.
    private static int SELECT_PICTURE = 1;

    // GUI components
    private Button button;  // The button
    private ImageView image;// ImageView



    @Override

    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_feed);

        // Find references to the GUI objects
        button = findViewById(R.id.btnChoose);
        image =  findViewById(R.id.imagedisplay);


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_PICTURE) {

                //Get ImageURi and load with help of picasso
                //Uri selectedImageURI = data.getData();

                Picasso.with(UploadFeed.this).load(data.getData()).noPlaceholder().centerCrop().fit()
                        .into((ImageView) findViewById(R.id.imagedisplay));
            }

        }
    }

    public void SelectImage(View v) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_PICTURE);

    }
}

