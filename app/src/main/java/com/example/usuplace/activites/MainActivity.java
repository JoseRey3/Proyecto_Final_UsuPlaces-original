package com.example.usuplace.activites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

import com.example.usuplace.Adapter.CategoryAdapter;
import com.example.usuplace.Adapter.ItemAdapter;
import com.example.usuplace.Domain.CategoryDomain;
import com.example.usuplace.Domain.ItemDomain;
import com.example.usuplace.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapterplace, adapterCategory;
    private RecyclerView recyclerViewPlace, recyclerViewCategory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerView();
    }

    private void initRecyclerView() {
        //Category
        ArrayList<CategoryDomain> CatArrayList = new ArrayList<>();
        CatArrayList.add(new CategoryDomain("Pueblitos Mágicos", "cat_1"));
        CatArrayList.add(new CategoryDomain("Acuaticos", "cat_2"));

        recyclerViewCategory= findViewById(R.id.category);
        recyclerViewCategory.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        RecyclerView.Adapter<CategoryAdapter.ViewHolder> adapterCategory = new CategoryAdapter(CatArrayList);
        recyclerViewCategory.setAdapter(adapterCategory);

        //Places
        ArrayList<ItemDomain> ItemArraylist = new ArrayList<>();
        ItemArraylist.add(new ItemDomain("Ahuachapán", "San José, San Salvador", "Es el mejor lugar para vacacionar", 12, "pic1"));
        ItemArraylist.add(new ItemDomain("Cabañas", "San José, San Salvador", "Es el mejor lugar para vacacionar", 12, "pic2"));
        ItemArraylist.add(new ItemDomain("Chalatenango", "San José, San Salvador", "Es el mejor lugar para vacacionar", 12, "pic1"));
        ItemArraylist.add(new ItemDomain("Cuscatlán", "San José, San Salvador", "Es el mejor lugar para vacacionar", 12, "pic2"));
        ItemArraylist.add(new ItemDomain("La Libertad", "San José, San Salvador", "Es el mejor lugar para vacacionar", 12, "pic2"));
        ItemArraylist.add(new ItemDomain("Morazán", "San José, San Salvador", "Es el mejor lugar para vacacionar", 12, "pic1"));
        ItemArraylist.add(new ItemDomain("La Paz", "San José, San Salvador", "Es el mejor lugar para vacacionar", 12, "pic2"));
        ItemArraylist.add(new ItemDomain("Santa Ana", "San José, San Salvador", "Es el mejor lugar para vacacionar", 12, "pic1"));
        ItemArraylist.add(new ItemDomain("San Miguel", "San José, San Salvador", "Es el mejor lugar para vacacionar", 12, "pic2"));
        ItemArraylist.add(new ItemDomain("San Salvador", "San José, San Salvador", "Es el mejor lugar para vacacionar", 12, "pic1"));
        ItemArraylist.add(new ItemDomain("San Vicente", "San José, San Salvador", "Es el mejor lugar para vacacionar", 12, "pic2"));
        ItemArraylist.add(new ItemDomain("Sonsonate", "San José, San Salvador", "Es el mejor lugar para vacacionar", 12, "pic2"));
        ItemArraylist.add(new ItemDomain("La Unión", "San José, San Salvador", "Es el mejor lugar para vacacionar", 12, "pic1"));
        ItemArraylist.add(new ItemDomain("Usulután", "San José, San Salvador", "Es el mejor lugar para vacacionar", 12, "pic2"));

        recyclerViewPlace= findViewById(R.id.itemRV);
        recyclerViewPlace.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        RecyclerView.Adapter<ItemAdapter.ViewHolder> adapterPlace = new ItemAdapter(ItemArraylist);
        recyclerViewPlace.setAdapter(adapterPlace);


    }

    public void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

        // Manejar los clics en los elementos del menú
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_profile:
                        // Acción para "Perfil"
                        return true;
                    case R.id.menu_logout:
                        // Acción para "Cerrar Sesión"
                        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish(); // Finalizar la actividad actual
                        return true;
                    default:
                        return false;
                }
            }
        });

        // Mostrar el menú desplegable
        popupMenu.show();
    }

}