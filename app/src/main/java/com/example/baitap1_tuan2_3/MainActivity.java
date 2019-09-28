package com.example.baitap1_tuan2_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList<NhanVien> nhanVienArrayList=null;
    MyArrayAdapter adapter=null;
    ListView listViewNV;
    Button btnNhap;
    ImageButton btnRemoveAll;
    EditText txtMa,txtTen;
    RadioGroup genderGroup;
    RadioButton male,female;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNhap=(Button)findViewById(R.id.button_Nhap);
        btnRemoveAll=(ImageButton)findViewById(R.id.imageButton);
        txtMa=(EditText) findViewById(R.id.editText_Ma);
        txtTen=(EditText) findViewById(R.id.editText_Ten);
        genderGroup=(RadioGroup)findViewById(R.id.radioGroup_Gender);
        male=(RadioButton)findViewById(R.id.radioButton_Nam);
        female=(RadioButton)findViewById(R.id.radioButton_Nu);

        listViewNV=(ListView)findViewById(R.id.listView);
        nhanVienArrayList=new ArrayList<NhanVien>();
        adapter=new MyArrayAdapter(this,R.layout.my_item_layout,nhanVienArrayList);
        listViewNV.setAdapter(adapter);

        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XuLyNhap();
            }
        });

        btnRemoveAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XuLyXoa();
            }
        });
    }

    private void XuLyXoa() {

        for (int i=listViewNV.getChildCount()-1;i>=0;i--){

            View v=listViewNV.getChildAt(i);
            CheckBox cb=(CheckBox)findViewById(R.id.checkBox_Item);

            if (cb.isChecked()){
                nhanVienArrayList.remove(i);
            }

        }
        adapter.notifyDataSetChanged();
    }

    private void XuLyNhap() {
        String ma=txtMa.getText()+"";
        String ten=txtTen.getText()+"";
        boolean gioiTinh=false;

        if (male.isChecked()){
            gioiTinh=false;
        }
        if (female.isChecked()){
            gioiTinh=true;
        }

        NhanVien nv= new NhanVien();
        nv.setId(ma);
        nv.setName(ten);
        nv.setGender(gioiTinh);

        nhanVienArrayList.add(nv);

        adapter.notifyDataSetChanged();
        txtMa.setText("");
        txtTen.setText("");
        txtMa.requestFocus();

    }
}
