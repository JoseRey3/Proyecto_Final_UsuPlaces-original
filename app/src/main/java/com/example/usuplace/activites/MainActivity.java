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
import com.example.usuplace.Domain.CategoryDomain;
import com.example.usuplace.Domain.DepartmentDomain;
import com.example.usuplace.R;
import com.google.firebase.FirebaseApp;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapterPlace;
    private RecyclerView recyclerViewPlace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar Firebase
        FirebaseApp.initializeApp(this);

        initRecyclerView();
    }

    private void initRecyclerView() {
        // Places
        ArrayList<DepartmentDomain> itemArrayList = new ArrayList<>();
        itemArrayList.add(new DepartmentDomain("Ahuachapán", "pic1"));
        itemArrayList.add(new DepartmentDomain("Cabañas", "pic2"));
        itemArrayList.add(new DepartmentDomain("Chalatenango", "pic1"));
        itemArrayList.add(new DepartmentDomain("Cuscatlán", "pic2"));
        itemArrayList.add(new DepartmentDomain("La Libertad", "pic2"));
        itemArrayList.add(new DepartmentDomain("Morazán", "pic1"));
        itemArrayList.add(new DepartmentDomain("La Paz", "pic2"));
        itemArrayList.add(new DepartmentDomain("Santa Ana", "pic1"));
        itemArrayList.add(new DepartmentDomain("San Miguel", "pic2"));
        itemArrayList.add(new DepartmentDomain("San Salvador", "pic1"));
        itemArrayList.add(new DepartmentDomain("San Vicente", "pic2"));
        itemArrayList.add(new DepartmentDomain("Sonsonate", "pic2"));
        itemArrayList.add(new DepartmentDomain("La Unión", "pic1"));
        itemArrayList.add(new DepartmentDomain("Usulután", "pic2"));

        recyclerViewPlace = findViewById(R.id.itemRV);
        recyclerViewPlace.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapterPlace = new DepartmentAdapter(itemArrayList);
        recyclerViewPlace.setAdapter(adapterPlace);

        ((DepartmentAdapter) adapterPlace).setOnItemClickListener(new DepartmentAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                DepartmentDomain selectedDepartment = itemArrayList.get(position);

                Intent intent = new Intent(MainActivity.this, PlacesActivity.class);
                intent.putExtra("departmentName", selectedDepartment.getTitle());
                intent.putExtra("departmentImage", selectedDepartment.getPic());
                startActivity(intent);
            }
        });
    }

    public void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_profile:
                        return true;
                    case R.id.menu_logout:
                        Intent intent = new Intent(MainActivity.this, IntroActivity.class);
                        startActivity(intent);
                        finish();

                        Intent intent1 = new Intent(MainActivity.this, IntroActivity.class);
                        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent1);
                        finish();
                        return true;
                    default:
                        return false;
                }
            }
        });

        popupMenu.show();
    }
}
