package com.sbz.sweetdialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.google.android.material.button.MaterialButton;

public class SweetDialog {

    public static class Builder {

        private Context activity;
        private Drawable image;
        private String title, body, positiveBtnTxt, negativeBtnTxt;
        int positiveBtnColor = 0, negativeBtnColor = 0;
        private DialogListener positiveListener, negativeListener;
        private boolean cancel;


        public Builder(Context activity) {
            this.activity = activity;
        }

        public Builder setImage(Drawable image) {
            this.image = image;
            return this;

        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setBody(String body) {
            this.body = body;
            return this;
        }

        public Builder setPositiveBtnTxt(String positiveBtnTxt) {
            this.positiveBtnTxt = positiveBtnTxt;
            return this;
        }

        public Builder setNegativeBtnTxt(String negativeBtnTxt) {
            this.negativeBtnTxt = negativeBtnTxt;
            return this;
        }

        public Builder setPositiveBtnColor(int positiveBtnColor) {
            this.positiveBtnColor = positiveBtnColor;
            return this;
        }

        public Builder setNegativeBtnColor(int negativeBtnColor) {
            this.negativeBtnColor = negativeBtnColor;
            return this;
        }

        public Builder setPositiveListener(DialogListener positiveListener) {
            this.positiveListener = positiveListener;
            return this;
        }

        public Builder setNegativeListener(DialogListener negativeListener) {
            this.negativeListener = negativeListener;
            return this;
        }

        public Builder setCancel(boolean cancel) {
            this.cancel = cancel;
            return this;
        }

        public SweetDialog build() {
            TextView titleTv, bodyTv;
            ImageView imageV;
            MaterialButton pBtn, nBtn;

            final Dialog dialog = new Dialog(activity);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.setCancelable(false);
            dialog.setContentView(R.layout.custom_dialog);


            imageV = dialog.findViewById(R.id.iconImgId);
            titleTv = dialog.findViewById(R.id.titleTvId);
            bodyTv = dialog.findViewById(R.id.bodyTvId);
            pBtn = dialog.findViewById(R.id.pBtnId);
            nBtn = dialog.findViewById(R.id.nBtnId);

            imageV.setImageDrawable(image);
            titleTv.setText(title);


            if (body != null) {
                bodyTv.setText(body);
            } else {
                bodyTv.setVisibility(View.GONE);
            }


            if (positiveBtnTxt != null) {
                pBtn.setText(positiveBtnTxt);
                if (positiveBtnColor != 0) {
                /*    GradientDrawable gradientDrawable = (GradientDrawable) pBtn.getBackground();
                    gradientDrawable.setColor(Color.parseColor(positiveBtnColor));
*/
                    pBtn.setBackgroundColor(ContextCompat.getColor(activity, positiveBtnColor));

                    // pBtn.setBackgroundColor(Integer.parseInt(positiveBtnColor));
                }
                pBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (positiveListener != null) positiveListener.onClick();
                        dialog.dismiss();
                    }
                });
            } else {
                pBtn.setVisibility(View.GONE);
            }


            if (negativeBtnTxt != null) {
                nBtn.setText(negativeBtnTxt);
                if (negativeBtnColor != 0) {
                  /*  GradientDrawable gradientDrawable = (GradientDrawable) nBtn.getBackground();
                    gradientDrawable.setColor(Color.parseColor(negativeBtnColor));
*/
                    //  nBtn.setBackgroundColor(Integer.parseInt(negativeBtnColor)); // From android.graphics.Color

                    nBtn.setBackgroundColor(ContextCompat.getColor(activity, negativeBtnColor));
                }
                nBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (negativeListener != null) negativeListener.onClick();
                        dialog.dismiss();
                    }
                });
            } else {
                nBtn.setVisibility(View.GONE);
            }

            dialog.show();
            return new SweetDialog();
        }

    }

}