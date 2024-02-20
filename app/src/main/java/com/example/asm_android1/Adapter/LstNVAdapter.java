package com.example.asm_android1.Adapter;





import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.asm_android1.AuthActivity.SignInActivity;
import com.example.asm_android1.HomeActivity.ChiTietNhanVienActivity;
import com.example.asm_android1.HomeActivity.DSNhanVienActivity;
import com.example.asm_android1.Model.NhanVienModel;
import com.example.asm_android1.R;

import java.io.Serializable;
import java.util.List;

public class LstNVAdapter extends BaseAdapter implements Filterable {


    private Context context;
    private List<NhanVienModel> lstNV;
    private int REQUEST_CODE_CHITIET_NHANVIEN = 1001;


    public LstNVAdapter(Context context, List<NhanVienModel> lstNV) {
        this.context = context;
        this.lstNV = lstNV;

    }

    @Override
    public int getCount() {
        if (lstNV != null){
            return lstNV.size();
        }
        else {return 0;}
    }

    @Override
    public Object getItem(int position) {
        return lstNV.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView Avataimg;
        TextView txtName,txtPhongBan,txtChucVu;
        LayoutInflater inflater =((DSNhanVienActivity) context).getLayoutInflater();
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_nhanvien, parent, false);
        }

txtName =convertView.findViewById(R.id.NameNhanVien);
        txtPhongBan= convertView.findViewById(R.id.PhongBanNhanVien);
        txtChucVu = convertView.findViewById(R.id.chucVuNhanVien);
        Avataimg = convertView.findViewById(R.id.AvataNhanVien);

        txtName.setText(lstNV.get(position).getHoTen());
        txtPhongBan.setText(lstNV.get(position).getPhongBan());
        txtChucVu.setText(lstNV.get(position).getChucVu());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, ChiTietNhanVienActivity.class);
                intent.putExtra("lstNV", (Serializable) lstNV);
                intent.putExtra("position", position);
                ((Activity) context).startActivityForResult(intent, REQUEST_CODE_CHITIET_NHANVIEN);
            }
        });


        return convertView;
    }

    @Override
    public Filter getFilter() {
        return null;
    }
}
