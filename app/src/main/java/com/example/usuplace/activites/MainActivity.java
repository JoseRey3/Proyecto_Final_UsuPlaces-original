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
import com.example.usuplace.Adapter.DepartmentAdapter;
import com.example.usuplace.Adapter.ItemAdapter;
import com.example.usuplace.Domain.CategoryDomain;
import com.example.usuplace.Domain.DepartmentDomain;
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
        ArrayList<DepartmentDomain> ItemArraylist = new ArrayList<>();
        ItemArraylist.add(new DepartmentDomain("Ahuachapán", "pic1"));
        ItemArraylist.add(new DepartmentDomain("Cabañas", "pic2"));
        ItemArraylist.add(new DepartmentDomain("Chalatenango", "pic1"));
        ItemArraylist.add(new DepartmentDomain("Cuscatlán", "pic2"));
        ItemArraylist.add(new DepartmentDomain("La Libertad", "pic2"));
        ItemArraylist.add(new DepartmentDomain("Morazán", "pic1"));
        ItemArraylist.add(new DepartmentDomain("La Paz", "pic2"));
        ItemArraylist.add(new DepartmentDomain("Santa Ana", "pic1"));
        ItemArraylist.add(new DepartmentDomain("San Miguel", "pic2"));
        ItemArraylist.add(new DepartmentDomain("San Salvador", "pic1"));
        ItemArraylist.add(new DepartmentDomain("San Vicente", "pic2"));
        ItemArraylist.add(new DepartmentDomain("Sonsonate", "pic2"));
        ItemArraylist.add(new DepartmentDomain("La Unión", "pic1"));
        ItemArraylist.add(new DepartmentDomain("Usulután", "pic2"));

        recyclerViewPlace= findViewById(R.id.itemRV);
        recyclerViewPlace.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        RecyclerView.Adapter<DepartmentAdapter.ViewHolder> adapterPlace = new DepartmentAdapter(ItemArraylist);
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