package com.example.Lab_A1_A2_android_suresh_c0818723;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductsViewHolder> {

    private Context mCtx;
    private List<Product> productList;

    public ProductAdapter(Context mCtx, List<Product> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ProductsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_products, parent, false);
        return new ProductsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductsViewHolder holder, int position) {
        Product t = productList.get(position);
        holder.textViewProductName.setText(t.getProductName());
        holder.textViewProductDesc.setText(t.getProductDescription());
        holder.textViewProductPrice.setText(t.getProductPrice());
        holder.textViewProviderName.setText(t.getProviderName());
        holder.textViewProviderEmail.setText(t.getProviderEmail());
        holder.textViewProviderPhone.setText(t.getProviderPhone());
        holder.textViewProviderLocation.setText(t.getProviderLocation());
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class ProductsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textViewProductName,textViewProductDesc,
                textViewProductPrice,textViewProviderName,textViewProviderEmail,
                textViewProviderPhone,textViewProviderLocation;

        public ProductsViewHolder(View itemView) {
            super(itemView);

            textViewProductName = itemView.findViewById(R.id.textViewProductName);
            textViewProductDesc = itemView.findViewById(R.id.textViewProductDescription);
            textViewProductPrice = itemView.findViewById(R.id.textViewProductPrice);
            textViewProviderName = itemView.findViewById(R.id.textViewProviderName);
            textViewProviderEmail = itemView.findViewById(R.id.textViewProviderEmail);
            textViewProviderPhone = itemView.findViewById(R.id.textViewProviderPhone);
            textViewProviderLocation = itemView.findViewById(R.id.textViewProviderLocation);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Product product = productList.get(getAdapterPosition());

            Intent intent = new Intent(mCtx, UpdateProductActivity.class);
            intent.putExtra("product", product);

            mCtx.startActivity(intent);
        }
    }
}