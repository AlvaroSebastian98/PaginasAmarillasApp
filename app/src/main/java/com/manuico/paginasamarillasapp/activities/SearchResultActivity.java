package com.manuico.paginasamarillasapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.manuico.paginasamarillasapp.R;
import com.manuico.paginasamarillasapp.adapters.CompanyAdapter;
import com.manuico.paginasamarillasapp.models.Company;
import com.manuico.paginasamarillasapp.repositories.CompanyRepository;

import java.util.List;

public class SearchResultActivity extends AppCompatActivity {

    private String category;
    private TextView textFindInput;

    private RecyclerView recyclerView;
    CompanyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        textFindInput = findViewById(R.id.text_find_input);

        this.category = getIntent().getExtras().getString("category");
        textFindInput.setText("Busca: " + this.category);

        List<Company> companiesResult = CompanyRepository.findCompanies(category);

        recyclerView = findViewById(R.id.companiesListResult);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CompanyAdapter(this);
        adapter.setCompanies(companiesResult);

        recyclerView.setAdapter(adapter);
    }
}
