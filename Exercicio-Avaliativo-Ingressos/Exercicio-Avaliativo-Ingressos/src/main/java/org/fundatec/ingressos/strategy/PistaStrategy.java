package org.fundatec.ingressos.strategy;


import org.fundatec.ingressos.model.Usuario;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PistaStrategy implements TipoIngressoStrategy {
    @Override
    public BigDecimal calcularValorIngresso(Usuario usuario) {
        BigDecimal valorTotalDoIngressoPista = new BigDecimal(250);
        BigDecimal valorTotalDoIngressoCom50DeDescontoParaEstudanteIdoso = new BigDecimal(0);
        BigDecimal valorTotalDoIngressoCom50DeDescontoParaEstudanteOuIdoso = new BigDecimal(0);
        BigDecimal cinquentaPorCentoDoTotal = valorTotalDoIngressoPista.multiply(new BigDecimal(0.5));


        if (usuario.isEstudante() == true && usuario.getDataNascimento().getYear() - LocalDate.now().getYear() > 60) {

            valorTotalDoIngressoCom50DeDescontoParaEstudanteIdoso = valorTotalDoIngressoPista
                    .subtract(cinquentaPorCentoDoTotal);

            System.out.println(valorTotalDoIngressoCom50DeDescontoParaEstudanteIdoso);
            System.out.println(usuario.getNome());
            System.out.println(usuario.getDataNascimento());

            return valorTotalDoIngressoCom50DeDescontoParaEstudanteIdoso;


        }
        if (usuario.isEstudante() == true | usuario.getDataNascimento().getYear() - LocalDate.now().getYear() > 60) {
            valorTotalDoIngressoCom50DeDescontoParaEstudanteOuIdoso = valorTotalDoIngressoPista
                    .subtract(cinquentaPorCentoDoTotal);

            System.out.println(usuario.getNome());
            System.out.println(usuario.getDataNascimento());
            System.out.println(valorTotalDoIngressoCom50DeDescontoParaEstudanteOuIdoso);

            return valorTotalDoIngressoCom50DeDescontoParaEstudanteOuIdoso;


        }
        return valorTotalDoIngressoPista;
    }
}
