package com.example.mybookmarks;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
public class BookmarksFragment extends Fragment implements View.OnClickListener {
    private ImageView imgZingMp3,imgBlueZone,imgBaoMoi,imgVnexpress;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_bookmarks, container, false);

        imgZingMp3 = v.findViewById(R.id.imgZingMp3);
        imgBlueZone = v.findViewById(R.id.imgBlueZone);
        imgBaoMoi = v.findViewById(R.id.imgBaoMoi);
        imgVnexpress = v.findViewById(R.id.imgVnExpress);

        imgZingMp3.setOnClickListener(this);
        imgBlueZone.setOnClickListener(this);
        imgBaoMoi.setOnClickListener(this);
        imgVnexpress.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {
        FragmentManager manager = getFragmentManager();
        Fragment fragment = new WebViewFragment();
        Bundle bundle = new Bundle();
        switch(v.getId()){
            case R.id.imgZingMp3:
                bundle.putString("URL","https://zingmp3.vn/");
                fragment.setArguments(bundle);
                manager.beginTransaction()
                        .replace(R.id.fragmentContainer,fragment)
                        .addToBackStack("Zing MP3")
                        .commit();
                break;
            case R.id.imgBlueZone:
                bundle.putString("URL","https://bluezone.gov.vn/");
                fragment.setArguments(bundle);
                manager.beginTransaction()
                        .replace(R.id.fragmentContainer,fragment)
                        .addToBackStack("BlueZone")
                        .commit();
                break;
            case R.id.imgBaoMoi:
                bundle.putString("URL","https://baomoi.com/");
                fragment.setArguments(bundle);
                manager.beginTransaction()
                        .replace(R.id.fragmentContainer,fragment)
                        .addToBackStack("Bao Moi")
                        .commit();
                break;
            case R.id.imgVnExpress:
                bundle.putString("URL","https://vnexpress.net/");
                fragment.setArguments(bundle);
                manager.beginTransaction()
                        .replace(R.id.fragmentContainer,fragment)
                        .addToBackStack("VN Express")
                        .commit();
                break;
        }
    }
}