package com.manuico.paginasamarillasapp.models;

public class Company {

    private Integer id;
    private String category;
    private String name;
    private String addres;
    private String phone;
    private String email;
    private String url;
    private String logo;
    private String info;

    public Company() {
    }

    public Company(Integer id, String category, String name, String addres,
                   String phone, String email, String url, String logo, String info) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.addres = addres;
        this.phone = phone;
        this.email = email;
        this.url = url;
        this.logo = logo;
        this.info = info;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", name='" + name + '\'' +
                ", addres='" + addres + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", url='" + url + '\'' +
                ", logo='" + logo + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
