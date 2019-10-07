package vu.co.yingcelestine.democustomcomponent;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import java.util.Arrays;
import java.util.List;

public class ImageSelectionView extends LinearLayout implements View.OnClickListener {
    private List<ImageView> imageViewList;
    private int filterColor;
    private Context context;
    private AttributeSet attributeSet;

    public ImageSelectionView(Context context) {
        super(context);
    }


    public ImageSelectionView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.attributeSet = attrs;
        this.context = context;
        setOrientation(LinearLayout.HORIZONTAL);
        setGravity(Gravity.CENTER_VERTICAL);
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        inflater.inflate(R.layout.image_selection_view, this, true);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        TypedArray a = context.obtainStyledAttributes(attributeSet,
                R.styleable.ImageSelectionView, 0, 0);
        filterColor = a.getColor(R.styleable.ImageSelectionView_filter_color,
                android.R.color.holo_blue_light);

        Drawable i0Src = a.getDrawable(R.styleable.ImageSelectionView_img_src0);
        Drawable i1Src = a.getDrawable(R.styleable.ImageSelectionView_img_src1);
        Drawable i2Src = a.getDrawable(R.styleable.ImageSelectionView_img_src2);
        Drawable i3Src = a.getDrawable(R.styleable.ImageSelectionView_img_src3);
        Drawable i4Src = a.getDrawable(R.styleable.ImageSelectionView_img_src4);
        a.recycle();
        ImageView i0 = (ImageView) getChildAt(0);
        ImageView i1 = (ImageView) getChildAt(1);
        ImageView i2 = (ImageView) getChildAt(2);
        ImageView i3 = (ImageView) getChildAt(3);
        ImageView i4 = (ImageView) getChildAt(4);
        i0.setImageDrawable(i0Src);
        i1.setImageDrawable(i1Src);
        i2.setImageDrawable(i2Src);
        i3.setImageDrawable(i3Src);
        i4.setImageDrawable(i4Src);
        imageViewList = Arrays.asList(
                i0,
                i1,
                i2,
                i3,
                i4
        );
        setImagesToGray();
        i0.setColorFilter(0xff000000);
        setImagesOnClickListener();
    }

    private void setImagesOnClickListener() {
        for(ImageView v: imageViewList) {
            v.setOnClickListener(this);
        }
    }

    private void setImagesToGray() {
        for(ImageView v: imageViewList) {
            v.setColorFilter(0xffaaaaaa);
        }
    }


    @Override
    public void onClick(View v) {
        if (v instanceof ImageView) {
            setImagesToGray();
            ImageView imageView = (ImageView) v;
            imageView.setColorFilter(filterColor);
        }
    }

}
