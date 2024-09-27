package com.example.bai_layout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Tìm điểu khiện để tham chiếu đến và thao tác
        EditText dieukhienA = findViewById(R.id.edtA);

        EditText dieukhienB = findViewById(R.id.edtB);

        Button nutTinhToan = findViewById(R.id.btTinhTong);

        //2. Gắn bộ lắng nghe sự khiện cho điều khiển



    }

    public void XuLyTinhTong(View v){
        //1. Tìm điểu khiển cần thao tác nếu chưa tìm
        EditText dieukhienA = findViewById(R.id.edtA);

        EditText dieukhienB = findViewById(R.id.edtB);
        TextView tvKetQua = findViewById(R.id.tvKetQua);
        //2. Lấy dữ liệu
        String strSoThuNhat = dieukhienA.getText().toString();
                            // phải đưa về String, vì getText() cho ta 1 Objext
        String strSoThuHai = dieukhienB.getText().toString();
        //3. Đưa về kiểu dữ liệu phù hợp ( ở dây là dữ liệu số) để tính toán

        double soThuNhat = Double.parseDouble(strSoThuNhat);
        double soThuHai = Double.parseDouble(strSoThuHai);
        //4. Thực hiện tính toán
        double ketQua = soThuNhat + soThuHai;
        //5. Hiển thị kết quả
           // đưa sang dạng chuỗi
        String chuoiThongBao = String.valueOf(ketQua);
        tvKetQua.setText(chuoiThongBao);




    }
}