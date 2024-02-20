package com.example.asm_android1.HomeActivity;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.asm_android1.Adapter.LstNVAdapter;
import com.example.asm_android1.Model.NhanVienModel;
import com.example.asm_android1.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class DSNhanVienActivity extends AppCompatActivity {

    private ListView listView;
    private FloatingActionButton floatbtnAddNguoiDung ;
    private ArrayList<NhanVienModel> lstNv;
    private LstNVAdapter NVadapter;
    private Toolbar toolbar;
    private static final int REQUEST_CODE_CHITIET_NHANVIEN = 1001;

    private ActivityResultLauncher<Intent> getnewNv =  registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode() == 1){
                Intent data = result.getData();
                NhanVienModel NVnew = (NhanVienModel) data.getSerializableExtra("newNV");
                Log.i("lỗi", "" + NVnew.getHoTen());
                if (NVnew != null){

                    if (lstNv == null) {
                        lstNv = new ArrayList<>();
                    }
                    lstNv.add(NVnew);
                    NVadapter = new LstNVAdapter(DSNhanVienActivity.this, lstNv);
                    listView.setAdapter(NVadapter);
                    NVadapter.notifyDataSetChanged();
                }else {
                    Toast.makeText(getApplicationContext(),"Không có dữ liệu được thêm mới",Toast.LENGTH_LONG).show();}

            }
            else {
                Toast.makeText(getApplicationContext(),"Không lấy được",Toast.LENGTH_LONG).show();}
        }
    });

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_CHITIET_NHANVIEN) {
            if (resultCode == Activity.RESULT_OK && data != null) {
                // Nhận danh sách nhân viên đã cập nhật từ Intent
                List<NhanVienModel> updatedList = (List<NhanVienModel>) data.getSerializableExtra("lstNV");

                // Cập nhật danh sách nhân viên trong ListView
                if (updatedList != null) {
                    lstNv.clear();
                    lstNv.addAll(updatedList);
                    // Cập nhật ListView (adapter.notifyDataSetChanged();)
                    NVadapter.notifyDataSetChanged();
                }
            }
        }

        if (resultCode == Activity.RESULT_OK && data != null) {
            // Nhận danh sách nhân viên đã cập nhật từ Intent
            List<NhanVienModel> updatedList = (List<NhanVienModel>) data.getSerializableExtra("lstNV");

            // Cập nhật danh sách nhân viên trong ListView
            if (updatedList != null) {
                lstNv.clear();
                lstNv.addAll(updatedList);
                // Cập nhật ListView (adapter.notifyDataSetChanged();)
                NVadapter.notifyDataSetChanged();
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dsnhan_vien);

        listView = findViewById(R.id.lstView_NhanVien);
        toolbar = findViewById(R.id.toobarNV);
        floatbtnAddNguoiDung = findViewById(R.id.floatbtnAddNguoiDung);
        setSupportActionBar(toolbar);

        if (lstNv == null) {
            lstNv = new ArrayList<>();
        }
        NVadapter = new LstNVAdapter(this, lstNv);
        listView.setAdapter(NVadapter);


        floatbtnAddNguoiDung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DSNhanVienActivity.this , AddNhanVienActivity.class);
               getnewNv.launch(i);

            }
        });
    }
}