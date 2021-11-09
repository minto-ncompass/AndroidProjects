package com.example.androidusecase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class ImageUploadActivity extends AppCompatActivity {

//    private static final int PERMISSION_CODE = 1000 ;
//    private static final int IMAGE_CAPTURE_CODE = 1001;
//    private static final int IMAGE_PICK_CODE = 1002;
    Button camerabtn, gallerybtn;
    ImageView image;
//
//    Uri image_uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_upload);

        image = findViewById(R.id.image_from_camera);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseProfilePicture();
            }
        });
    }

    private void chooseProfilePicture() {
        AlertDialog.Builder builder = new AlertDialog.Builder(ImageUploadActivity.this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.alert_dialog_image,null);
        builder.setCancelable(false);
        builder.setView(dialogView);

        ImageView imageCamera = dialogView.findViewById(R.id.imageview_camera);
        ImageView imageGallery = dialogView.findViewById(R.id.imageview_gallery);


        AlertDialog alertDialogImage = builder.create();
        alertDialogImage.show();

        imageCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkAndRequestPermissions()) {
                    takePictureFromCamera();
                    alertDialogImage.cancel();
                }
            }
        });


        imageGallery.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                takePictureFromGallery();
                alertDialogImage.cancel();
            }
        });
    }

    private void takePictureFromGallery() {
        Intent pickphoto = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(pickphoto, 1);
    }

    private void takePictureFromCamera(){
        Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(takePicture.resolveActivity(getPackageManager()) != null){
            startActivityForResult(takePicture, 2);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode)
        {
            case 1:
                if(resultCode == RESULT_OK){
                    Uri selectedImageUri = data.getData();
                    image.setImageURI(selectedImageUri);
                }
                break;

            case 2:
                if(resultCode == RESULT_OK){
                    Bundle bundle = data.getExtras();
                    Bitmap bitmapImage = (Bitmap) bundle.get("data");
                    image.setImageBitmap(bitmapImage);
                }

        }
    }

    private boolean checkAndRequestPermissions(){
        if(Build.VERSION.SDK_INT >= 23){
            int cameraPermission = ActivityCompat.checkSelfPermission(ImageUploadActivity.this,Manifest.permission.CAMERA);
            if(cameraPermission == PackageManager.PERMISSION_DENIED){
                ActivityCompat.requestPermissions(ImageUploadActivity.this, new String[]{Manifest.permission.CAMERA},20);
                return false;
            }
        }
    return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == 20 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            takePictureFromCamera();
        }
        else
            Toast.makeText(ImageUploadActivity.this,"Permission denied :(", Toast.LENGTH_SHORT).show();
    }
}

