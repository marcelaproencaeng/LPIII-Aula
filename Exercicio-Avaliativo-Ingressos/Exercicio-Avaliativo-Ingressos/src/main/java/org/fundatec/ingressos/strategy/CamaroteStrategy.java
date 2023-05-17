package org.fundatec.ingressos.strategy;


import org.fundatec.ingressos.model.Usuario;
import org.fundatec.ingressos.model.enuns.TipoIngresso;

import java.math.BigDecimal;

public class CamaroteStrategy implements TipoIngressoStrategy {
    @Override
    public BigDecimal calcularValorIngresso(Usuario usuario) {

        BigDecimal valorTotalDoIngressoCamarote = new BigDecimal(750);




        System.out.println(valorTotalDoIngressoCamarote);
        System.out.println("Não há desconto para estudantes e idosos");
        System.out.println(usuario.getNome());
        System.out.println(usuario.getDataNascimento());

        return valorTotalDoIngressoCamarote;

    }

}
