package com.example.laba_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import Data.DatabaseHandler;
import Model.Classmates;

public class MainActivity extends AppCompatActivity {
    private Button btnViewData;
    private Button btnAddRecord;
    private Button btnUpdateLastRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnViewData = findViewById(R.id.btn_view_data);
        btnAddRecord = findViewById(R.id.btn_add_record);
        btnUpdateLastRecord = findViewById(R.id.btn_update_last_record);


        DatabaseHandler databaseHandler = new DatabaseHandler(this);



        btnViewData.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ViewDataActivity.class);
            startActivity(intent);
        });

        btnViewData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewDataActivity.class);
                startActivity(intent);
            }
        });
        btnAddRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentTime = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date());
                databaseHandler.addClas(new Classmates("Новое Имя", currentTime));
            }
        });

        btnUpdateLastRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Получаем последнюю запись
                List<Classmates> classmatesList = databaseHandler.getAllClas();
                if (!classmatesList.isEmpty()) {
                    Classmates lastClassmate = classmatesList.get(classmatesList.size() - 1);
                    // Обновляем ФИО на Иванов Иван Иванович
                    lastClassmate.setFIO("Иванов Иван Иванович");
                    databaseHandler.updateClas(lastClassmate);
                }
            }
        });
    }
}
