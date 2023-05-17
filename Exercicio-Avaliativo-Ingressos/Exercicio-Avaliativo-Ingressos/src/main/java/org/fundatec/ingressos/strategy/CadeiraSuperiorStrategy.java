package org.fundatec.ingressos.strategy;


import org.fundatec.ingressos.model.Usuario;


import java.math.BigDecimal;
import java.time.LocalDate;

public class CadeiraSuperiorStrategy implements TipoIngressoStrategy {

    @Override
    public BigDecimal calcularValorIngresso(Usuario usuario) {
        BigDecimal valorTotalDoIngressoCadeiraSuperior = new BigDecimal(150);
        BigDecimal valorTotalDoIngressoCom50DeDesconto = new BigDecimal(0);
        BigDecimal valorTotalDoIngressoCom60DeDesconto = new BigDecimal(0);

        BigDecimal cinquentaPorCentoDoTotal = valorTotalDoIngressoCadeiraSuperior.multiply(new BigDecimal(0.5));
        BigDecimal sessentaPorCentoDoTotal = valorTotalDoIngressoCadeiraSuperior.multiply(new BigDecimal(0.6));

        if (usuario.isEstudante() == true && usuario.getDataNascimento().getYear() - LocalDate.now().getYear() < 60) {
            valorTotalDoIngressoCom50DeDesconto = valorTotalDoIngressoCadeiraSuperior
                    .subtract(cinquentaPorCentoDoTotal);
            return valorTotalDoIngressoCom50DeDesconto;

        }

        System.out.println(valorTotalDoIngressoCom50DeDesconto);
        System.out.println(usuario.getNome());
        System.out.println(usuario.getDataNascimento());
        System.out.println(usuario.isEstudante());


        if (!usuario.isEstudante() == true && usuario.getDataNascimento().getYear() - LocalDate.now().getYear() > 60) {
            valorTotalDoIngressoCom60DeDesconto = valorTotalDoIngressoCadeiraSuperior
                    .subtract(sessentaPorCentoDoTotal);

            return valorTotalDoIngressoCom60DeDesconto;
        }

        System.out.println(valorTotalDoIngressoCom60DeDesconto);
        System.out.println(usuario.getNome());
        System.out.println(usuario.getDataNascimento());
        System.out.println(usuario.isEstudante());


        return valorTotalDoIngressoCadeiraSuperior;
    }
}


