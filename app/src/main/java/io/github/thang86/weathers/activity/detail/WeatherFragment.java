package io.github.thang86.weathers.activity.detail;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.palette.graphics.Palette;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import io.github.thang86.weathers.R;
import io.github.thang86.weathers.data.model.Address;


/**
 * ThangTX2
 * A simple {@link Fragment} subclass.
 */
public class WeatherFragment extends Fragment {
    private Address mAddress;

    public static WeatherFragment newInstance(Address address) {


        Bundle args = new Bundle();
        args.putParcelable("address", address);
        WeatherFragment fragment = new WeatherFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public WeatherFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Bundle bundle = getArguments();
        if (bundle == null || !bundle.containsKey("address")) {
            return;
        } else {
            mAddress = bundle.getParcelable("address");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_weather, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        View view1 = view.findViewById(R.id.header_layout);
        TextView address = view1.findViewById(R.id.location_header_tv);
        TextView temperatureHeader = view1.findViewById(R.id.tv_temperature_header);

        address.setText(mAddress.getAddress());
        temperatureHeader.setText(mAddress.getTemperature());
//        setGradientForTextView(temperatureHeader, mAddress.getBackground());
    }

    /**
     * set gradient color for textview
     *
     * @param textView
     * @param drawable
     */
    private void setGradientForTextView(TextView textView, int drawable) {

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), drawable);

        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                //work with the palette here
                int defaultValue = 0x000000;
                int vibrant = palette.getVibrantColor(defaultValue);
                int vibrantLight = palette.getLightVibrantColor(defaultValue);
                int vibrantDark = palette.getDarkVibrantColor(defaultValue);
                int muted = palette.getMutedColor(defaultValue);
                int mutedLight = palette.getLightMutedColor(defaultValue);
                int mutedDark = palette.getDarkMutedColor(defaultValue);
                int[] colors = {vibrant, vibrantLight, vibrantDark, muted, mutedLight, mutedDark};

//                TextView secondTextView = new TextView(this);
                Shader textShader = new LinearGradient(0, 0, 0, 20,
                        colors, null, Shader.TileMode.CLAMP);

                textView.getPaint().setShader(textShader);
            }
        });


    }
}
