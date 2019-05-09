package com.manuico.paginasamarillasapp.repositories;

import com.manuico.paginasamarillasapp.models.Company;

import java.util.ArrayList;
import java.util.List;

public class CompanyRepository {

    private static List<Company> companies = new ArrayList<>();

    static {
        companies.add(new Company(1, "Restaurante","La Casa del Tacu Tacu", "Jr. Pelotillehue 53-48 Int 84",
                        "012242625", "informes@lacasadeltacutacu.com","www.lacasadeltacutacu.com",
                        "ic_company1", "Déjese cautivar por el mejor sabor criollo"));
        companies.add(new Company(2, "Academia","Aduni", "Av. La Marina 383",
                "017370122", "informes@aduni.com","aduni.edu.pe/",
                "ic_company3", "Academias Aduni, su mejor elección!"));
        companies.add(new Company(3, "Restaurante","La Rosa Nautica", "Espigón Miraflores, Lima 18, Circuito de Playas, Miraflores",
                "014352289", "larosa@nautica.com","www.larosanautica.com/",
                "ic_company5", "Los más finos platos a la carta"));
        companies.add(new Company(4, "Academia","Pamer", "Av. San Juan 748",
                "016243549", "pamerinfo@academiaspamer.com","pamer.edu.pe/academias/",
                "ic_company2", "Aprende con nosotros e ingresa entre los primeros puestos a la universidad"));
        companies.add(new Company(5, "Universidad","Universidad de Lima", "Av. Javier Prado Este 4600, Santiago de Surco 15023",
                "012242625", "ulima@gmail.com","www.ulima.edu.pe/",
                "ic_company6", "La mejor elección para sus futuro"));
        companies.add(new Company(6, "Universidad","Universidad Nacional de Ingeniería", "Av. Tupac Amaru 210, Rímac 15333",
                "016354720", "uni@gmail.com","www.uni.edu.pe/",
                "ic_company7", "Ciencia y Tecnología al servicio del país"));
        companies.add(new Company(7, "Instituto","TECSUP", "Santa Anita, Avenida Cascanueces 2221, Lima 15011",
                "016726734", "informestec@tecsup.edu.pe","www.tecsup.edu.pe/",
                "ic_company8", "Únete a la comunidad de innovadores"));
        companies.add(new Company(8, "Instituto","SENATI", "Av. 28 de Julio 715, Cercado de Lima 15046",
                "012674728", "senati@gmail.com","www.senati.edu.pe/",
                "ic_company9", "Estudia en el mejor instituto: SENATI"));
        companies.add(new Company(9, "Instituto","CIBERTEC", "Avenida Ernesto Diez Canseco 316, Miraflores 15074",
                "012748292", "cibertec@gmail.com","www.cibertec.edu.pe/",
                "ic_company10", "El instituto del Perú"));
        companies.add(new Company(10, "Academia","Academia Saco Oliveros", "Av. Arequipa 288",
                "012342788", "academiaSO@saco.oliveros.com","sacooliveros.edu.pe/index.php/academias",
                "ic_company4", "Saco Oliveros le brinda preparación de alta calidad"));
    }

    public static List<Company> getCompanies() {
        return companies;
    }

    public static List<Company> findCompanies(String category) {
        List<Company> companiesByCategory= new ArrayList<>();
        for (Company company: companies) {
            if(company.getCategory().toLowerCase().indexOf(category.toLowerCase()) > -1 && category != null) {
                companiesByCategory.add(company);
            }
        }
        return companiesByCategory;
    }

    public static Company getCompanyById(Integer id) {
        for (Company company: companies) {
            if(company.getId().equals(id)) {
                return company;
            }
        }
        return null;
    }

}
