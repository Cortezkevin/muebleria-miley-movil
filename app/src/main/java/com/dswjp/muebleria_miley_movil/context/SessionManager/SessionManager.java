package com.dswjp.muebleria_miley_movil.context.SessionManager;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.dswjp.muebleria_miley_movil.dto.profile.address.AddressDTO;
import com.dswjp.muebleria_miley_movil.dto.profile.information.PersonalDataDTO;
import com.dswjp.muebleria_miley_movil.enums.AccessType;
import com.dswjp.muebleria_miley_movil.security.dto.SessionDTO;

import java.util.List;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class SessionManager {
    private static SessionManager instance;
    private String userId;
    private String email;
    private boolean isLogged = false;
    private boolean isAdmin = false;
    private AccessType accessType = AccessType.CLIENT;

    private final MutableLiveData<PersonalDataDTO> personalData = new MutableLiveData<>();
    private final MutableLiveData<AddressDTO> address = new MutableLiveData<>();

    public LiveData<PersonalDataDTO> getPersonalData() {
        return personalData;
    }

    private SessionManager() {}

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public void loadSession(SessionDTO sessionDTO){
        this.userId = sessionDTO.getId();
        this.isAdmin = sessionDTO.getRoles().contains("ROLE_ADMIN");
        this.isLogged = true;
        this.email = sessionDTO.getEmail();
        List<String> roles = sessionDTO.getRoles();
        this.accessType = roles.contains("ROLE_ADMIN")
                ? AccessType.ADMIN
                : roles.contains("ROLE_WAREHOUSE")
                ? AccessType.WAREHOUSE
                : roles.contains("ROLE_TRANSPORT")
                ? AccessType.TRANSPORT
                : AccessType.CLIENT;
    }

    public void loadPersonalData(PersonalDataDTO personalDataDTO) {
        personalData.setValue(personalDataDTO);
    }

    public void loadAddress(AddressDTO addressDTO) {
        address.setValue(addressDTO);
    }
    public void clearSession() {
        this.isLogged = false;
        this.isAdmin = false;
        this.accessType = AccessType.CLIENT;
        this.userId = null;
        this.personalData.setValue(null);
        this.address.setValue(null);
    }

}
