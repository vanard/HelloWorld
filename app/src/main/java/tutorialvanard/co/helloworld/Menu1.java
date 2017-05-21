package tutorialvanard.co.helloworld;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import _sliders.FragmentSlider;
import _sliders.SliderIndicator;
import _sliders.SliderPagerAdapter;
import _sliders.SliderView;

/**
 * Created by Vanard on 5/20/2017.
 */

public class Menu1 extends Fragment {

    private SliderPagerAdapter mAdapter;
    private SliderIndicator mIndicator;

    private SliderView sliderView;
    private LinearLayout mLinearLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_menu_1, container,false);
        sliderView = (SliderView) rootView.findViewById(R.id.sliderView);
        mLinearLayout = (LinearLayout) rootView.findViewById(R.id.pagesContainer);
        setupSlider();

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Menu Slider");
    }

    private void setupSlider() {
        sliderView.setDurationScroll(800);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(FragmentSlider.newInstance("http://www.planwallpaper.com/static/images/HD-Wallpapers1_FOSmVKg.jpeg"));
        fragments.add(FragmentSlider.newInstance("http://www.planwallpaper.com/static/images/Mario-mario-wallpaper-hd-games-1920x1080.jpg"));
        fragments.add(FragmentSlider.newInstance("http://www.planwallpaper.com/static/images/high-definition-wallpaper-3-798x350.jpg"));
        fragments.add(FragmentSlider.newInstance("http://www.planwallpaper.com/static/images/lamborghini_murcielago_superveloce_2-2880x1800.jpg"));

        mAdapter = new SliderPagerAdapter(getFragmentManager(), fragments);
        sliderView.setAdapter(mAdapter);
        mIndicator = new SliderIndicator(getActivity(), mLinearLayout, sliderView, R.drawable.indicator_circle);
        mIndicator.setPageCount(fragments.size());
        mIndicator.show();
    }
}
