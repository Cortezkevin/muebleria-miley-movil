package com.dswjp.muebleria_miley_movil.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.dswjp.muebleria_miley_movil.commons.SuccessResponseDTO;
import com.dswjp.muebleria_miley_movil.dto.catalog.DetailedProductDTO;
import com.dswjp.muebleria_miley_movil.dto.catalog.ProductDTO;
import com.dswjp.muebleria_miley_movil.dto.profile.address.AddressDTO;
import com.dswjp.muebleria_miley_movil.dto.profile.information.PersonalDataDTO;
import com.dswjp.muebleria_miley_movil.repository.AddressRepository;
import com.dswjp.muebleria_miley_movil.repository.ProductRepository;
import com.dswjp.muebleria_miley_movil.repository.ProfileRepository;

import java.util.List;

public class ProfileViewModel extends AndroidViewModel {
    private final ProfileRepository profileRepository;
    private final AddressRepository addressRepository;
    private MutableLiveData<PersonalDataDTO> personalData;
    private MutableLiveData<AddressDTO> address;

    public ProfileViewModel(@NonNull Application application) {
        super(application);
        profileRepository = ProfileRepository.getInstance();
        addressRepository = AddressRepository.getInstance();
    }

    public void loadPersonalData() {
        Log.d("ProfileViewModel","Calling method loadPersonalData");
        profileRepository.getFromSession().observeForever(res -> {
            Log.d("ProfileViewModel","Response from getSession " + res.toString());
            personalData.setValue(res.getContent());
        });
    }

    public void loadAddress(){
        addressRepository.getFromSession().observeForever(res -> {
            address.setValue(res.getContent());
        });
    }

    public LiveData<PersonalDataDTO> getPersonalData(){
        if(personalData == null){
            personalData = new MutableLiveData<>();
            this.loadPersonalData();
        }
        return personalData;
    }

    public LiveData<AddressDTO> getAddress(){
        if(address == null){
            address = new MutableLiveData<>();
            this.loadAddress();
        }
        return address;
    }
}
