package com.example.backendreactinicial;

import com.example.backendreactinicial.entities.Categoria;
import com.example.backendreactinicial.entities.Instrumento;
import com.example.backendreactinicial.repositories.CategoriaRepository;
import com.example.backendreactinicial.repositories.InstrumentoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class BackendReactInicialApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendReactInicialApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(InstrumentoRepository instrumentoRepository, CategoriaRepository categoriaRepository) {
        return (args) -> {
            // Inicializar categorias
            List<Categoria> categorias = Arrays.asList(
                    new Categoria("Cuerda"),
                    new Categoria("Viento"),
                    new Categoria("Percusión"),
                    new Categoria("Teclado"),
                    new Categoria("Electrónico")
            );
            categoriaRepository.saveAll(categorias);

            // Inicializar instrumentos
            List<Instrumento> instrumentos = Arrays.asList(
                    new Instrumento("Mandolina Instrumento Musical Stagg Sunburst", "Stagg", "M20", "https://http2.mlstatic.com/D_NQ_NP_764778-MLA40447145988_012020-O.webp", 2450.0, "G", 28, "Estas viendo una excelente mandolina de la marca Stagg, con un sonido muy dulce, tapa aros y fondo de tilo, y diapasón de palisandro. Es un instrumento acústico (no se enchufa) de cuerdas dobles (4 pares) con la caja ovalada y cóncava, y el mástil corto. Su utilización abarca variados ámbitos, desde rock, folk, country y ensambles experimentales.", categorias.get(0), null),
                    new Instrumento("Pandereta Pandero Instrumento Musical", "DyM ventas", "32 sonajas", "https://http2.mlstatic.com/D_NQ_NP_895881-MLA69104523759_042023-O.webp", 325.0, "150", 10, "1 Pandereta - 32 sonajas metálicas. Más de 8 años vendiendo con 100 % de calificaciones POSITIVAS y clientes satisfechos !! ", categorias.get(2), null),
                    new Instrumento("Triangulo Musical 24 Cm Percusion", "LBP", "24", "https://http2.mlstatic.com/D_NQ_NP_651934-MLA72060088225_102023-O.webp", 260.0, "250", 3, "Triangulo Musical de 24 Centímetros De Acero. ENVIOS POR CORREO O ENCOMIENDA: Se le deberán adicionar $40 en concepto de Despacho y el Costo del envío se abonará al recibir el producto en Terminal, Sucursal OCA o Domicilio", categorias.get(2), null),
                    new Instrumento("Bar Chimes Lp Cortina Musical 72 Barras", "FM", "LATIN", "https://http2.mlstatic.com/D_NQ_NP_838108-MLA31575605575_072019-O.webp", 2250.0, "G", 2, "BARCHIME CORTINA MUSICAL DE 25 BARRAS LATIN CUSTOM. Emitimos factura A y B", categorias.get(2), null),
                    new Instrumento("Shekeres. Instrumento. Música. Artesanía.", "Azalea Artesanías", "Cuentas de madera", "https://galeriaartesanalpr.com/cdn/shop/files/SHEKERE800LOGO2_2fcbe4be-eb88-4d7c-94f4-e3b619eb623b_600x.jpg?v=1693183399", 850.0, "300", 5, "Las calabazas utilizadas para nuestras artesanías son sembradas y cosechadas por nosotros, quienes seleccionamos el mejor fruto para garantizar la calidad del producto y ofrecerle algo creativo y original.", categorias.get(2), null),
                    new Instrumento("Antiguo Piano Aleman Con Candelabros.", "Neumeyer", "Stratus", "https://http2.mlstatic.com/D_NQ_NP_741625-MLA25468412771_032017-O.webp", 17000.0, "2000", 0, "Buen dia! Sale a la venta este Piano Alemán Neumeyer con candelabros incluidos. Tiene una talla muy bonita en la madera. Una pieza de calidad.", categorias.get(3), null),
                    new Instrumento("Guitarra Ukelele Infantil Grande 60cm", "GUITARRA", "UKELELE", "https://http2.mlstatic.com/D_NQ_NP_602949-MLA32297056646_092019-O.webp", 500.0, "G", 5, "Material: Plástico smil madera 4 Cuerdas longitud: 60cm, el mejor regalo para usted, su familia y amigos, adecuado para 3-18 años de edad", categorias.get(0), null),
                    new Instrumento("Teclado Organo Electronico Musical Instrumento 54 Teclas", "GADNIC", "T01", "https://acdn.mitiendanube.com/stores/078/394/products/hd-1013a1a7076ba2786a17104249369253-1024-1024.jpg", 2250.0, "G", 1375, "Organo Electrónico GADNIC T01. Display de Led. 54 Teclas. 100 Timbres / 100 Ritmos. 4 1/2 octavas. 8 Percusiones. 8 Canciones de muestra. Grabación y reproducción. Entrada para Micrófono. Salida de Audio (Auriculares / Amplificador). Vibrato. Sustain Incluye Atril Apoya partitura y Micrófono. Dimensiones: 84,5 x 32,5 x 11 cm", categorias.get(4), null),
                    new Instrumento("Instrumentos De Percusión Niños Set Musical Con Estuche", "KNIGHT", "LB17", "https://www.heavenimagenes.com/heavencommerce/36552d98-557c-43dd-ad26-2c9343813a85/images/v2/DENVER/1903261110399534_01_medium.jpg", 2700.0, "300", 15, "Estas viendo un excelente y completísimo set de percusion para niños con estuche rígido, equipado con los instrumentos mas divertidos! De gran calidad y sonoridad. Ideal para jardines, escuelas primarias, musicoterapeutas o chicos que se quieran iniciar en la música de la mejor manera. Es un muy buen producto que garantiza entretenimiento en cualquier casa o reunión, ya que esta equipado para que varias personas al mismo tiempo estén tocando un instrumento.", categorias.get(2), null),
                    new Instrumento("Batería Musical Infantil Juguete Niño 9 Piezas Palillos ", "Bateria", "Infantil", "https://http2.mlstatic.com/D_NQ_NP_643960-MLA27368744727_052018-O.webp", 850.0, "250", 380, "DESCRIPCIÓN: DE 1 A 3 AÑOS. EL SET INCLUYE 5 TAMBORES, PALILLOS Y EL PLATILLO TAL CUAL LAS FOTOS. SONIDOS REALISTAS Y FÁCIL DE MONTAR. MEDIDAS: 40X20X46 CM", categorias.get(2), null)
            );
            instrumentoRepository.saveAll(instrumentos);
        };
    }
}
