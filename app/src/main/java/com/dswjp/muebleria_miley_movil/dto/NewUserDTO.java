package com.dswjp.muebleria_miley_movil.dto;

import com.dswjp.muebleria_miley_movil.dto.address.MemoryAddressDTO;
import com.dswjp.muebleria_miley_movil.dto.cart.MemoryCartDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
public class NewUserDTO {
    String firstName;
    String lastName;
    String email;
    String password;
    MemoryCartDTO memoryCart;
    MemoryAddressDTO memoryAddress;
    Boolean isAdmin;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public MemoryAddressDTO getMemoryAddress() {
        return memoryAddress;
    }

    public void setMemoryAddress(MemoryAddressDTO memoryAddress) {
        this.memoryAddress = memoryAddress;
    }

    public MemoryCartDTO getMemoryCart() {
        return memoryCart;
    }

    public void setMemoryCart(MemoryCartDTO memoryCart) {
        this.memoryCart = memoryCart;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
