package com.manuico.paginasamarillasapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;

import com.manuico.paginasamarillasapp.R;
import com.manuico.paginasamarillasapp.adapters.CompanyAdapter;
import com.manuico.paginasamarillasapp.models.Company;
import com.manuico.paginasamarillasapp.repositories.CompanyRepository;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    SearchView textCategory;
    Button findButton;

    private RecyclerView recyclerView;
    CompanyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textCategory = (SearchView) findViewById(R.id.text_input);
        findButton = findViewById(R.id.find_button);

        recyclerView = findViewById(R.id.companiesList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CompanyAdapter(this);
        List<Company> companies = CompanyRepository.getCompanies();
        adapter.setCompanies(companies);

        recyclerView.setAdapter(adapter);

        findButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), SearchResultActivity.class);
                intent.putExtra("category", textCategory.getQuery().toString());
                startActivity(intent);
            }
        });
    }
}
