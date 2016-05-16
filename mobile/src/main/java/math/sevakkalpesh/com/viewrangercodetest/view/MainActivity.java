package math.sevakkalpesh.com.viewrangercodetest.view;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import math.sevakkalpesh.com.viewrangercodetest.R;
import math.sevakkalpesh.com.viewrangercodetest.presenter.MathPresenter;
import math.sevakkalpesh.com.viewrangercodetest.interfaces.IMathView;

/**
 * Views
 *
 * The view, usually implemented by an Activity, will contain a reference to the presenter.
 *
 * @author Kalpesh
 * @version 2016.1605
 * @since 1.0
 */
public class MainActivity extends AppCompatActivity implements IMathView {
    @Bind(R.id.tvCalculation)
    TextView tvCalculation;

    @Bind(R.id.tvResult)
    TextView tvResult;

    @Bind(R.id.etInput)
    EditText etInput;

    @Bind(R.id.fab)
    FloatingActionButton fab;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    MathPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        presenter = new MathPresenter(this);

    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @Override
    public String getEntry() {
        return etInput.getText().toString();
    }

    @Override
    public void showEmptyErrorMessage(int resId) {
        etInput.setError(getString(resId));
    }

    @Override
    public void setResult(String result) {
        tvCalculation.setText(getEntry());
        tvResult.setText(result);
        etInput.setText("");
    }

    @Override
    public String getSolution() {
        return tvResult.getText().toString();
    }

    @Override
    public void showEntryFormatErrorMessage(int resId) {
        etInput.setError(getString(resId));
    }

    @Override
    public void onClickCalculate(View view) {
        presenter.onClickCalculateButton();
        etInput.setText("");

    }


}
