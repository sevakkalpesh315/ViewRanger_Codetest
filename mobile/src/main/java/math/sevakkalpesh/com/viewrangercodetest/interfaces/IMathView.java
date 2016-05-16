package math.sevakkalpesh.com.viewrangercodetest.interfaces;

import android.view.View;
/**
 * Interface for views
 *
 * View interface: This decouples the presenter from the view implementation.The view is passed into the presenter when the presenter is constructed.
 * This approach is sometimes referred to as constructor injection. Because the view is passed to the presenter, you can also provide a mock view for unit tests.
 *
 * @author Kalpesh
 * @version 2016.1605
 * @since 1.0
 */
public interface IMathView {
    public String getEntry();

    void onClickCalculate(View view);

    void showEmptyErrorMessage(int resId);

    void setResult(String result);

    String getSolution();

    void showEntryFormatErrorMessage(int resId);
}
