package com.manuico.paginasamarillasapp.activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.manuico.paginasamarillasapp.R;
import com.manuico.paginasamarillasapp.models.Company;
import com.manuico.paginasamarillasapp.repositories.CompanyRepository;

import static java.net.Proxy.Type.HTTP;

public class DetailCompanyActivity extends AppCompatActivity {

    private Integer id;

    private ImageView pictureImage;
    private TextView nameText;
    private TextView addressText;
    private TextView numberText;
    private TextView infoText;
    private TextView categoryText;

    Company company;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_company);

        pictureImage = findViewById(R.id.picture_image);
        nameText = findViewById(R.id.fullname_text);
        addressText = findViewById(R.id.address_text);
        numberText = findViewById(R.id.number_text);
        infoText = findViewById(R.id.info_text);
        categoryText = findViewById(R.id.category_text);

        this.id = getIntent().getExtras().getInt("id");

        company = CompanyRepository.getCompanyById(id);

        if(company != null) {
            int resourceid = getResources().getIdentifier(
                    company.getLogo(),
                    "drawable",
                    getPackageName()
            );
            pictureImage.setImageResource(resourceid);
            nameText.setText(company.getName());
            addressText.setText(company.getAddres());
            numberText.setText(company.getPhone());
            infoText.setText(company.getInfo());
            categoryText.setText(company.getCategory());
        }

    }

    public void searchWebPage(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+company.getUrl()));
        if(intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void sendEmail(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        String[] email = {company.getEmail()};

        intent.putExtra(Intent.EXTRA_EMAIL, email);
        if(intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void sendSMS(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("smsto:" + company.getPhone()));  // This ensures only SMS apps respond
        //intent.putExtra("sms_body", "Hola");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void share(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");

        intent.putExtra(Intent.EXTRA_TEXT, "Mejor "+ company.getCategory()+": " + "http://" + company.getUrl());
        if(intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void call(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + company.getPhone()));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
