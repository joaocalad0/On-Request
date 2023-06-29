package com.example.onrequest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onrequest.schema.MenuItem;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {

    // variável de instância que armazena a lista de Produtos que este Adapter vai utilizar
    private  List<MenuItem> menuItems;

    /**
     * Construtor que recebe uma Lista de contactos a ser utilizada por este MenuAdapter
     * @param menuEntracesList
     */
    private MenuAdapter(List<MenuItem> menuEntracesList) {
        // armazenar na variável de instância o valor do parâmetro do construtor
        this.menuItems = menuEntracesList;
    }

    /**
     * Criar um novo ViewHolder sempre que for necessário
     * @param parent The ViewGroup into which the new View will be added after it is bound to
     *               an adapter position.
     * @param viewType The view type of the new View.
     *
     * @return
     */
    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Criar um objeto do tipo View com base no layout criado (menu_.xml)
        View rootView;
        rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_entraces, parent, false);
        // criar e devolver um objeto do tipo ContactViewHolder
        return new MenuViewHolder(rootView);
    }

    /**
     * Permite associar a um ViewHolder dados de um item da lista
     * @param holder The ViewHolder which should be updated to represent the contents of the
     *        item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        // obter o contact que existe na lista na posição dada pelo parâmetro position
        MenuItem menu = this.menuItems.get(position);
        // definir que o valor da TextView no ViewHolder passa a conter o valor da propriedade name do Menu
        holder.textViewDrink.setText(menu.getName());
    }

    /**
     * Devolver o número de Items que a RecyclerView deve apresentar
     * @return numero de items da recyclerView
     */
    @Override
    public int getItemCount() {
        return this.menuItems.size();
    }

    public static class MenuViewHolder extends RecyclerView.ViewHolder {

        private final TextView textViewDrink;

        public MenuViewHolder(@NonNull View rootView) {
            super(rootView);
            this.textViewDrink = rootView.findViewById(R.id.textViewDrink);
        }
    }
}
