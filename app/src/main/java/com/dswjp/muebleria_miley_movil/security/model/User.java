package com.dswjp.muebleria_miley_movil.security.model;

import com.dswjp.muebleria_miley_movil.delivery.model.Carrier;
import com.dswjp.muebleria_miley_movil.entity.Cart;
import com.dswjp.muebleria_miley_movil.profile.model.PersonalInformation;
import com.dswjp.muebleria_miley_movil.enums.Status;
import com.dswjp.muebleria_miley_movil.sales.model.order.Order;
import com.dswjp.muebleria_miley_movil.warehouse.model.Grocer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {
    private String id;
    private String email;
    private String password;
    private String tokenPassword;
    private Status status;
    private Set<Role> roles = new HashSet<>();
    private Cart cart;
    private PersonalInformation personalInformation;
    private Carrier carrier;
    private Grocer grocer;
    private List<Order> orders = new ArrayList<>();

    public User() {
    }

    public User(Carrier carrier, Cart cart, String email, Grocer grocer, String id, List<Order> orders, String password, PersonalInformation personalInformation, Set<Role> roles, Status status, String tokenPassword) {
        this.carrier = carrier;
        this.cart = cart;
        this.email = email;
        this.grocer = grocer;
        this.id = id;
        this.orders = orders;
        this.password = password;
        this.personalInformation = personalInformation;
        this.roles = roles;
        this.status = status;
        this.tokenPassword = tokenPassword;
    }

    public Carrier getCarrier() {
        return carrier;
    }

    public void setCarrier(Carrier carrier) {
        this.carrier = carrier;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Grocer getGrocer() {
        return grocer;
    }

    public void setGrocer(Grocer grocer) {
        this.grocer = grocer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public PersonalInformation getPersonalInformation() {
        return personalInformation;
    }

    public void setPersonalInformation(PersonalInformation personalInformation) {
        this.personalInformation = personalInformation;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getTokenPassword() {
        return tokenPassword;
    }

    public void setTokenPassword(String tokenPassword) {
        this.tokenPassword = tokenPassword;
    }


}
