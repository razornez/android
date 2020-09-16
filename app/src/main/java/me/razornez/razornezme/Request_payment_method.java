package me.razornez.razornezme;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;


public class Request_payment_method extends AppCompatActivity {
    LinearLayout bt_bca, bt_bri, bt_mandiri, kk_mastercard, kk_visa, ib_bca, s_indomaret, s_alfamart;

    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_payment_method);

        ImageButton btnback = (ImageButton) findViewById(R.id.trans_btn_back_pay);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        final LinearLayout lay_expand_transfer = (LinearLayout) findViewById(R.id.lay_collapse_bank_transfer);
        final LinearLayout lay_expand_kk = (LinearLayout) findViewById(R.id.lay_collapse_kk);

        final ImageView btn_expand_transfer = (ImageView) findViewById(R.id.collapse_bank_transfer);
        final ImageView btn_expand_transfer_on = (ImageView) findViewById(R.id.collapse_bank_transfer_on);

        final ImageView btn_expand_kk = (ImageView) findViewById(R.id.collapse_kk);
        final ImageView btn_expand_kk_on = (ImageView) findViewById(R.id.collapse_kk_on);

        final LinearLayout expand_transfer = (LinearLayout) findViewById(R.id.expand_transfer);
        final LinearLayout expand_kk = (LinearLayout) findViewById(R.id.expand_kk);

        bt_bca = (LinearLayout) findViewById(R.id.payment_transfer_bca);
        bt_bri = (LinearLayout) findViewById(R.id.payment_transfer_bri);
        bt_mandiri = (LinearLayout) findViewById(R.id.payment_transfer_mandiri);
        kk_mastercard = (LinearLayout) findViewById(R.id.payment_kk_mastercard);
        kk_visa = (LinearLayout) findViewById(R.id.payment_kk_visa);


        lay_expand_transfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expand_transfer.setVisibility(View.VISIBLE);
                btn_expand_transfer.setVisibility(View.GONE);
                btn_expand_transfer_on.setVisibility(View.VISIBLE);
                bt_bri.setVisibility(View.VISIBLE);
                bt_bca.setVisibility(View.VISIBLE);
                bt_mandiri.setVisibility(View.VISIBLE);

                expand_kk.setVisibility(View.GONE);
                btn_expand_kk.setVisibility(View.VISIBLE);
                btn_expand_kk_on.setVisibility(View.GONE);
                kk_mastercard.setVisibility(View.INVISIBLE);
                kk_visa.setVisibility(View.INVISIBLE);

            }
        });

        btn_expand_transfer_on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expand_transfer.setVisibility(View.GONE);
                btn_expand_transfer.setVisibility(View.VISIBLE);
                btn_expand_transfer_on.setVisibility(View.GONE);
                bt_bri.setVisibility(View.INVISIBLE);
                bt_bca.setVisibility(View.INVISIBLE);
                bt_mandiri.setVisibility(View.INVISIBLE);
            }
        });

        lay_expand_kk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expand_kk.setVisibility(View.VISIBLE);
                btn_expand_kk.setVisibility(View.GONE);
                btn_expand_kk_on.setVisibility(View.VISIBLE);
                kk_mastercard.setVisibility(View.VISIBLE);
                kk_visa.setVisibility(View.VISIBLE);

                expand_transfer.setVisibility(View.GONE);
                btn_expand_transfer.setVisibility(View.VISIBLE);
                btn_expand_transfer_on.setVisibility(View.GONE);
                bt_bri.setVisibility(View.INVISIBLE);
                bt_bca.setVisibility(View.INVISIBLE);
                bt_mandiri.setVisibility(View.INVISIBLE);
            }
        });

        btn_expand_kk_on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expand_kk.setVisibility(View.GONE);
                btn_expand_kk.setVisibility(View.VISIBLE);
                btn_expand_kk_on.setVisibility(View.GONE);
                kk_mastercard.setVisibility(View.INVISIBLE);
                kk_visa.setVisibility(View.INVISIBLE);
            }
        });

        bt_bri.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                intent = new Intent(Request_payment_method.this, Request_payment_invoice.class);
//                finish();
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem)
    {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    @Override
    public void onBackPressed() {
        if(getFragmentManager().getBackStackEntryCount() > 0)
            getFragmentManager().popBackStack();
        else
            super.onBackPressed();
    }

    public static void setWindowFlag(Activity activity, final int bits, boolean on) {
        Window win = activity.getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

}
