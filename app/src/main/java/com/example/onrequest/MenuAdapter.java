package com.example.onrequest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.onrequest.schema.entity.item.MenuItem;
import com.example.onrequest.schema.entity.table.MenuTable;

import java.util.ArrayList;
import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {

    private final MenuTable menuTable;

    private final List<MenuItem> menuList;


    public MenuAdapter(MenuTable menuTable, List<MenuItem> menuList) {
        this.menuTable = menuTable;
        // armazenar na variável de instância o valor do parâmetro do construtor
        this.menuList = new ArrayList<>(menuList);
    }

    /**
     * Criar um novo ViewHolder sempre que for necessário
     *
     * @param parent   The ViewGroup into which the new View will be added after it is bound to
     *                 an adapter position.
     * @param viewType The view type of the new View.
     * @return
     */
    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Criar um objeto do tipo View com base no layout criado (contact_item.xml)
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_menu_details, parent, false);
        // criar e devolver um objeto do tipo ContactViewHolder
        return new MenuViewHolder(rootView);
    }

    /**
     * Permite associar a um ViewHolder dados de um item da lista
     *
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     *                 item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        // obter o contact que existe na lista na posição dada pelo parâmetro position
        MenuItem menuItem = this.menuList.get(position);
        holder.txtViewMenuItem.setText(menuItem.getMenuItemName());
        Glide.with(holder.rootView.getContext()).load(menuItem.getMenuItemAvatar()).into(holder.imageViewAvatar);

        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MenuDetailsActivity.startMenuDetailsActivity(holder.rootView.getContext(), menuTable, menuItem);
            }
        });

        holder.rootView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return true;
            }
        });
    }

    public void refresh(List<MenuItem> menuItems) {
        this.menuList.clear();
        this.menuList.addAll(menuItems);
        notifyDataSetChanged();
    }

    /**
     * Devolver o número de Items que a RecyclerView deve apresentar
     *
     * @return numero de items da recyclerView
     */
    @Override
    public int getItemCount() {
        return this.menuList.size();
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder {

        private View rootView;
        private TextView txtViewMenuItem;
        private ImageView imageViewAvatar;

        public MenuViewHolder(@NonNull View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.txtViewMenuItem = rootView.findViewById(R.id.txtViewMenuItem);
            this.imageViewAvatar = rootView.findViewById(R.id.imageViewAvatar);
        }
    }
}
