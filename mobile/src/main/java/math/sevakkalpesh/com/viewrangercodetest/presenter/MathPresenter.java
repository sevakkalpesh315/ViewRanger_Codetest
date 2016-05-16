package math.sevakkalpesh.com.viewrangercodetest.presenter;

import math.sevakkalpesh.com.viewrangercodetest.R;
import math.sevakkalpesh.com.viewrangercodetest.interfaces.IMathView;
import math.sevakkalpesh.com.viewrangercodetest.utility.Controller;

/**
 * Presenter
 *
 * The presenter is responsible to act as the middle man between view and model.
 * It retrieves data from the model and returns it formatted to the view.
 *
 * @author Kalpesh
 * @version 2016.1605
 * @since 1.0
 */
public class MathPresenter {
    private final IMathView view;

    public MathPresenter(IMathView view) {
        this.view = view;
    }

    public void onClickCalculateButton() {
        String tvEntry = view.getEntry();
        if (tvEntry.isEmpty()) {
            view.showEmptyErrorMessage(R.string.error_empty_entry);
            return;
        }

        if (!tvEntry.matches("\\d+(\\.\\d+)?([\\/\\*\\+-]\\d+(.\\d+)?)+")) {
            view.showEntryFormatErrorMessage(R.string.error_format_text);
            return;
        }
        String result = Controller.calculateSimpleMaths(tvEntry);
        view.setResult(result);
    }
}
