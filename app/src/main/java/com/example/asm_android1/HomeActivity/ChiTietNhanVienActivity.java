package com.example.asm_android1.HomeActivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.asm_android1.Model.NhanVienModel;
import com.example.asm_android1.R;

import java.io.Serializable;
import java.util.List;

public class ChiTietNhanVienActivity extends AppCompatActivity {

    private TextView ChiTiet_Name,chiTiet_PhongBan,chiTiet_ChucVu,chiTiet_NgaySinh,chiTiet_DiaChi,chiTiet_SDT,chiTiet_Email,chiTiet_HonNhan;
    private Button btnDelete,btnEditNv;
    private int position;
    private List<NhanVienModel> lstNV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_nhan_vien);
        ChiTiet_Name = findViewById(R.id.ChiTiet_Name);
        chiTiet_PhongBan = findViewById(R.id.chiTiet_PhongBan);
        chiTiet_ChucVu = findViewById(R.id.chiTiet_ChucVu);
        chiTiet_NgaySinh = findViewById(R.id.chiTiet_NgaySinh);
        chiTiet_DiaChi = findViewById(R.id.chiTiet_DiaChi);
        chiTiet_SDT = findViewById(R.id.chiTiet_SDT);
        chiTiet_Email = findViewById(R.id.chiTiet_Email);
        chiTiet_HonNhan = findViewById(R.id.chiTiet_HonNhan);
        btnDelete = findViewById(R.id.btnXoaNv);
        btnEditNv = findViewById(R.id.btnEditNv);

        Intent intent = getIntent();
        if (intent != null) {
            lstNV = (List<NhanVienModel>) intent.getSerializableExtra("lstNV");
            position = intent.getIntExtra("position", -1);
            if (lstNV != null && !lstNV.isEmpty()) {
                NhanVienModel nhanVien = lstNV.get(0); // Ví dụ lấy thông tin của phần tử đầu tiên
                ChiTiet_Name.setText(nhanVien.getHoTen());
                chiTiet_PhongBan.setText(nhanVien.getPhongBan());
                chiTiet_ChucVu.setText(nhanVien.getChucVu());
                chiTiet_NgaySinh.setText(nhanVien.getNgaySinh());
                chiTiet_DiaChi.setText(nhanVien.getDiaChi());
                chiTiet_SDT.setText(nhanVien.getSoDienThoai());
                chiTiet_Email.setText(nhanVien.getEmail());
                chiTiet_HonNhan.setText(nhanVien.getTinhTrangHonNhan());

                btnDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showDeleteConfirmationDialog();
                    }
                });
                btnEditNv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showEditDialog();
                    }
                });
            }

        }

    }

    private void showDeleteConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Bạn có chắc muốn xóa nhân viên này?")
                .setPositiveButton("Xóa", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Xác nhận xóa
                        deleteEmployee();
                    }
                })
                .setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Hủy bỏ xóa
                        dialog.dismiss();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    private void deleteEmployee() {
        // Kiểm tra vị trí của nhân viên
        if (position != -1 && position < lstNV.size()) {
            // Xóa nhân viên khỏi danh sách
            lstNV.remove(position);
            // Trả về kết quả cho Activity trước (nếu cần)
            Intent resultIntent = new Intent();
            resultIntent.putExtra("lstNV", (Serializable) lstNV);
            setResult(RESULT_OK, resultIntent);
            // Kết thúc Activity chi tiết
            finish();
        }
    }
    private void showEditDialog() {
        // Tạo dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Chỉnh sửa thông tin nhân viên");
        EditText edtNameNV, edtPhongBanNV, edtEmailNV, edtNgaySinhNV, edtSDTNV, edtTinhTrangHN, edtChucVuNV, edtDiaChiNV;

        // Bố cục của dialog (Thêm EditText để người dùng nhập liệu)
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_editnv, null);
        builder.setView(dialogView);
        edtNameNV = dialogView.findViewById(R.id.HoTenNVDG);
        edtPhongBanNV = dialogView.findViewById(R.id.PhongBanNVDG);
        edtEmailNV = dialogView.findViewById(R.id.EmailNVDG);
        edtNgaySinhNV = dialogView.findViewById(R.id.NgaySinhNVDG);
        edtSDTNV = dialogView.findViewById(R.id.SDTNVDG);
        edtTinhTrangHN = dialogView.findViewById(R.id.TinhTrangHonNhanNVDG);
        edtChucVuNV = dialogView.findViewById(R.id.ChucVuNVDG);
        edtDiaChiNV = dialogView.findViewById(R.id.DiaChiNVDG);



        edtNameNV.setText(lstNV.get(position).getHoTen());
        edtPhongBanNV.setText(lstNV.get(position).getPhongBan());
        edtEmailNV.setText(lstNV.get(position).getEmail());
        edtNgaySinhNV.setText(lstNV.get(position).getNgaySinh());
        edtSDTNV.setText(lstNV.get(position).getSoDienThoai());
        edtTinhTrangHN.setText(lstNV.get(position).getTinhTrangHonNhan());
        edtChucVuNV.setText(lstNV.get(position).getChucVu());
        edtDiaChiNV.setText(lstNV.get(position).getDiaChi());

        // Xử lý sự kiện khi người dùng nhấn nút Lưu trên dialog
        builder.setPositiveButton("Lưu", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Lấy dữ liệu từ các EditText
                String newName = edtNameNV.getText().toString();
                String newPhongBan = edtPhongBanNV.getText().toString();
                String newEmail = edtEmailNV.getText().toString();
                String newNgaySinh = edtNgaySinhNV.getText().toString();
                String newSDT = edtSDTNV.getText().toString();
                String newTinhTrangHN = edtTinhTrangHN.getText().toString();
                String newChucVu = edtChucVuNV.getText().toString();
                String newDiaChi = edtDiaChiNV.getText().toString();

                // Cập nhật thông tin của nhân viên trong danh sách
                lstNV.get(position).setHoTen(newName);
                lstNV.get(position).setPhongBan(newPhongBan);
                lstNV.get(position).setEmail(newEmail);
                lstNV.get(position).setNgaySinh(newNgaySinh);
                lstNV.get(position).setSoDienThoai(newSDT);
                lstNV.get(position).setTinhTrangHonNhan(newTinhTrangHN);
                lstNV.get(position).setChucVu(newChucVu);
                lstNV.get(position).setDiaChi(newDiaChi);

                // Tạo Intent để trả lại danh sách nhân viên đã cập nhật
                Intent intent = new Intent();
                intent.putExtra("lstNV", (Serializable) lstNV);

                // Đặt kết quả là RESULT_OK và chuyển Intent này về màn hình chính
                setResult(Activity.RESULT_OK, intent);

                // Kết thúc Activity hiện tại và quay trở lại màn hình chính
                finish();
            }
        });

        // Xử lý sự kiện khi người dùng nhấn nút Hủy trên dialog
        builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Đóng dialog khi người dùng nhấn Hủy
                dialog.dismiss();
            }
        });

        // Hiển thị dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

}