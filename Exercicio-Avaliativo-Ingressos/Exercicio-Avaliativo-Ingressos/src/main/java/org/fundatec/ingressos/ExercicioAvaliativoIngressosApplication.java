package org.fundatec.ingressos;

import org.fundatec.ingressos.model.Ingresso;
import org.fundatec.ingressos.model.Usuario;
import org.fundatec.ingressos.model.VendaIngressos;
import org.fundatec.ingressos.model.enuns.TipoIngresso;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.time.LocalDate;

@SpringBootApplication
public class ExercicioAvaliativoIngressosApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExercicioAvaliativoIngressosApplication.class, args);

        Usuario usuario = new Usuario(
                "Maria",
                LocalDate.of(1990, 10, 20),
                false);
        Usuario usuario1 = new Usuario(
                "Paulo",
                LocalDate.of(1958, 2, 15),
                false);
        Usuario usuario2 = new Usuario(
                "Pedro",
                LocalDate.of(2005, 5, 12),
                true);
        Usuario usuario3 = new Usuario(
                "Marcelo",
                LocalDate.of(2000, 3, 4),
                true);
        Usuario usuario4 = new Usuario(
                "Marco",
                LocalDate.of(1960, 8, 10),
                false);

        usuario.verificarIdadeParaDesconto(usuario);
        usuario1.verificarIdadeParaDesconto(usuario1);
        usuario2.verificarIdadeParaDesconto(usuario2);
        usuario3.verificarIdadeParaDesconto(usuario3);
        usuario4.verificarIdadeParaDesconto(usuario4);

        Ingresso ingresso = new Ingresso(new BigDecimal(750), usuario, TipoIngresso.CAMAROTE);
        Ingresso ingresso1 = new Ingresso(new BigDecimal(400), usuario1, TipoIngresso.PISTA_PREMIUM);
        Ingresso ingresso2 = new Ingresso(new BigDecimal(250), usuario2, TipoIngresso.PISTA);
        Ingresso ingresso3 = new Ingresso(new BigDecimal(200), usuario3, TipoIngresso.CADEIRA_INFERIOR);
        Ingresso ingresso4 = new Ingresso(new BigDecimal(150), usuario4, TipoIngresso.CADEIRA_SUPERIOR);

        ingresso.getValor();
        ingresso1.getValor();
        ingresso2.getValor();
        ingresso3.getValor();
        ingresso4.getValor();

        System.out.println(ingresso.getValor());
        System.out.println(ingresso1.getValor());
        System.out.println(ingresso2.getValor());
        System.out.println(ingresso3.getValor());
        System.out.println(ingresso4.getValor());

        VendaIngressos vendaIngressos = new VendaIngressos();
        vendaIngressos.calcularValorIngresso(TipoIngresso.CAMAROTE, usuario);
        vendaIngressos.calcularValorIngresso(TipoIngresso.PISTA_PREMIUM,usuario1);
        vendaIngressos.calcularValorIngresso(TipoIngresso.PISTA, usuario2);
        vendaIngressos.calcularValorIngresso(TipoIngresso.CADEIRA_INFERIOR, usuario3);
        vendaIngressos.calcularValorIngresso(TipoIngresso.CADEIRA_SUPERIOR, usuario4);


        System.out.println("usuario = " + vendaIngressos.calcularValorIngresso(TipoIngresso.CAMAROTE, usuario));
        System.out.println("usuario1= " + vendaIngressos.calcularValorIngresso(TipoIngresso.PISTA_PREMIUM, usuario1));
        System.out.println("usuario2= " + vendaIngressos.calcularValorIngresso(TipoIngresso.PISTA, usuario2));
        System.out.println("usuario3= " + vendaIngressos.calcularValorIngresso(TipoIngresso.CADEIRA_INFERIOR, usuario3));
        System.out.println("usuario4= " + vendaIngressos.calcularValorIngresso(TipoIngresso.CADEIRA_SUPERIOR, usuario4));

    }

}


