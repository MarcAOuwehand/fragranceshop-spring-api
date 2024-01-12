package com.example.webshopapi.seeder;

import com.example.webshopapi.dao.ProductDAO;
import com.example.webshopapi.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ProductSeeder {
    @Autowired
    private ProductDAO productDAO;

    public void seed() {
        Product product1 = new Product();
        product1.setProductID(UUID.randomUUID());
        product1.setName("Stronger With You");
        product1.setBrand("Armani");
        product1.setPrice(100.0);
        product1.setDescription("Een krachtige en verleidelijke geur voor de moderne man. De geur opent met frisse noten van kardemom en roze peper, evolueert naar een hart van salie en meloen, en rust op een warme basis van vanille en kastanje.");
        product1.setImg_path("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRdCfOyMugCew4LLGWitTftU6l49QoiA9TCJQ&usqp=CAU");
        productDAO.save(product1);

        Product product2 = new Product();
        product2.setProductID(UUID.randomUUID());
        product2.setName("Eros");
        product2.setBrand("Versace");
        product2.setPrice(50.0);
        product2.setDescription("Eros, genoemd naar de Griekse god van de liefde, belichaamt passie en verleiding. Deze geur opent met verfrissende noten van munt en groene appel.");
        product2.setImg_path("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSf3AqURLLUclGqr5pyUIKwmilPTOeJxxq0Uu431gfEEWWc7TMKjUqvhSbAheGkRtbU9ms&usqp=CAU");
        productDAO.save(product2);

        Product product3 = new Product();
        product3.setProductID(UUID.randomUUID());
        product3.setName("Code");
        product3.setBrand("Armani");
        product3.setPrice(120.0);
        product3.setDescription("Code is een geur die mysterie en sensualiteit uitstraalt. De topnoten bevatten bergamot en citroen, gevolgd door een hart van olijfboom bloesem en steranijs. De basisnoten zijn leder en tabak, wat zorgt voor een diepe en intrigerende geur.");
        product3.setImg_path("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS4y_MDm2XbehvbrPfEptRPtPKlzmpLEe86EQ&usqp=CAU");
        productDAO.save(product3);

        Product product4 = new Product();
        product4.setProductID(UUID.randomUUID());
        product4.setName("1 Million");
        product4.setBrand("Paco Robanne");
        product4.setPrice(70.0);
        product4.setDescription("Een iconische geur die luxe en zelfverzekerdheid uitstraalt. 1 Million opent met levendige topnoten van bloedmandarijn en munt, evolueert naar een hart van rozen en kaneel, en rust op een basis van leder en houtachtige noten.");
        product4.setImg_path("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQnyl6pIqu0o_93XREUbDJvHr1o-TSvnNnBkg&usqp=CAU");
        productDAO.save(product4);

        Product product5 = new Product();
        product5.setProductID(UUID.randomUUID());
        product5.setName("Le Beau");
        product5.setBrand("Jean Paul Gaultier");
        product5.setPrice(110.0);
        product5.setDescription("Le Beau is een levendige en charmante geur die de essentie van frisheid vastlegt. De geur opent met bergamot en kokosnoot, ontwikkelt zich tot een hart van tonkaboon en vanille, en eindigt met een warme basis van sandelhout.");
        product5.setImg_path("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTz_B4xi6NqqoILGs61MoY0CTLmiMFCFHDY7w&usqp=CAU");
        productDAO.save(product5);

        Product product6 = new Product();
        product6.setProductID(UUID.randomUUID());
        product6.setName("La Nuit de L'Homme");
        product6.setBrand("Yves Saint Laurent");
        product6.setPrice(95.0);
        product6.setDescription("Een mysterieuze en sensuele geur met topnoten van kardemom en bergamot, een hart van cederhout en lavendel, en basisnoten van vetiver en kumarin.");
        product6.setImg_path("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTnJVAWkE88syUnzxiXzAmURUfvYCtGHPluEg&usqp=CAU");
        productDAO.save(product6);

        Product product7 = new Product();
        product7.setProductID(UUID.randomUUID());
        product7.setName("Chanel No. 5");
        product7.setBrand("Chanel");
        product7.setPrice(120.0);
        product7.setDescription("Een tijdloze klassieker en symbool van elegantie. Opent met frisse aldehyden en citrusnoten, ontwikkelt zich tot een hart van jasmijn en roos, en rust op een basis van vanille en sandelhout.");
        product7.setImg_path("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQs-M9h9GSHStFF8VgfETRUn-q8g7HwhdXNVw&usqp=CAU");
        productDAO.save(product7);

        Product product8 = new Product();
        product8.setProductID(UUID.randomUUID());
        product8.setName("Acqua Di Gio");
        product8.setBrand("Giorgio Armani");
        product8.setPrice(85.0);
        product8.setDescription("Een verfrissende en mediterrane geur met topnoten van citrus en zeenoten, een hart van rozemarijn en jasmijn, en een basis van patchouli en cederhout.");
        product8.setImg_path("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSE_Ve2mr6ZXhIFJ1cCA97iIlECT3np1evXWQ&usqp=CAU");
        productDAO.save(product8);

        Product product9 = new Product();
        product9.setProductID(UUID.randomUUID());
        product9.setName("Black Opium");
        product9.setBrand("Yves Saint Laurent");
        product9.setPrice(110.0);
        product9.setDescription("Een moderne en energieke geur met noten van koffie, roze peper, vanille, oranjebloesem en jasmijn, en een basis van patchouli en cederhout.");
        product9.setImg_path("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQdH6v3Otl7O6RU3ybo4VFIdEX6xL8IKHg5CQ&usqp=CAU");
        productDAO.save(product9);

        Product product10 = new Product();
        product10.setProductID(UUID.randomUUID());
        product10.setName("Dior Sauvage");
        product10.setBrand("Dior");
        product10.setPrice(100.0);
        product10.setDescription("Een krachtige en kruidige geur met topnoten van bergamot en peper, een hart van lavendel en nootmuskaat, en basisnoten van ambroxan en cederhout.");
        product10.setImg_path("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQzdnMEJE2LADX6V0A7XKtjPHSyiNhBIynEiA&usqp=CAU");
        productDAO.save(product10);
    }
}
