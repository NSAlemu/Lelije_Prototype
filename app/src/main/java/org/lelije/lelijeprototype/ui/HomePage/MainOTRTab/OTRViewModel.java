package org.lelije.lelijeprototype.ui.HomePage.MainOTRTab;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class OTRViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public OTRViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}