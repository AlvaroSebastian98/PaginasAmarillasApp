package com.manuico.paginasamarillasapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.manuico.paginasamarillasapp.R;
import com.manuico.paginasamarillasapp.activities.DetailCompanyActivity;
import com.manuico.paginasamarillasapp.models.Company;

import java.util.ArrayList;
import java.util.List;

public class CompanyAdapter extends RecyclerView.Adapter<CompanyAdapter.ViewHolder> {

    private static final String TAG = CompanyAdapter.class.getSimpleName();

    private AppCompatActivity activity;

    private List<Company> companies;

    public CompanyAdapter(AppCompatActivity activity) {
        this.activity = activity;
        companies = new ArrayList<>();
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    @NonNull
    @Override
    // Qué layout va a usar y mantenerlo precargado
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_company, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    // Cómo se va a enlazar el dato en cada item layout(ViewHolder)
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        final Company company = this.companies.get(position);

        viewHolder.nameText.setText(company.getName());
        viewHolder.addressText.setText(company.getAddres());
        viewHolder.phoneText.setText(company.getPhone());


        final Context context = viewHolder.itemView.getContext();
        int resourceid = context.getResources().getIdentifier(company.getLogo(), "drawable", context.getPackageName());

        viewHolder.pictureImage.setImageResource(resourceid);

        //Definiendo el evento onclick
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: " + company);

                Intent intent = new Intent(v.getContext(), DetailCompanyActivity.class);
                intent.putExtra("id", company.getId());
                activity.startActivity(intent);
            }
        });
    }

    @Override
    // Definimos la cantidad de items
    public int getItemCount() {
        return companies.size();
    }

    // La clase ViewHolder enlaza y lo guarda en memoria, hace más rapido el proceso (aunque no es obligatorio)
    class ViewHolder extends RecyclerView.ViewHolder {
        TextView categoryText;
        TextView nameText;
        TextView addressText;
        TextView phoneText;
        TextView emailText;
        TextView urlText;
        ImageView pictureImage;
        TextView infoText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pictureImage = itemView.findViewById(R.id.picture_image);
            nameText = itemView.findViewById(R.id.fullname_text);
            addressText = itemView.findViewById(R.id.address_text);
            phoneText = itemView.findViewById(R.id.number_text);

        }
    }

}
