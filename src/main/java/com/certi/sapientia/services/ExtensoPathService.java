package com.certi.sapientia.services;

import org.springframework.stereotype.Service;

@Service
public class ExtensoPathService {


    public String retornaValorExtenso(Integer valor){
        String operador = "";
        if(valor < 0){
            valor =valor * -1;
            operador = "menos ";
        }


        if(valor < 10){
            return operador +unidade(valor);
        }else if (valor <= 99){
            return operador + dezena(valor);
        }else if(valor > 99 && valor <= 999){
            return operador + centena(valor);
        }else if(valor >= 1000 && valor <= 99999){
            Integer verificaCentena = (valor%1000)/100;
            Integer verificaDezena = ((valor%100)/10);
            Integer verificaUnidade = (((valor%1000)%100)%10);
            if(verificaCentena != 0) {
                return operador + milhar(valor) + centena(valor);
            }else if(verificaDezena !=0){
                return operador + milhar(valor) + dezena(valor);
            }else if(verificaUnidade !=0){
                return operador + milhar(valor) + unidade(valor);
            }
            return operador + milhar(valor);
        }else
            throw new IllegalArgumentException("Digite um valor entre -99999 e 99999");
    }

    private String milhar(Integer valor){
        Integer verificaMilhar = (valor/1000);
        Integer verificaCentena = (valor%1000)/100;
        Integer verificaDezena = ((valor%100)/10);
        Integer verificaUnidade = (((valor%1000)%100)%10);
        if(verificaMilhar == 1 ){
            if(verificaCentena == 0 || verificaDezena == 0 || verificaUnidade == 0){
                return "mil e ";
            }
            return "mil ";
        }else{
            if(verificaMilhar < 10){
                if(verificaUnidade != 0 || verificaCentena != 0) {
                    return unidade(verificaMilhar) + " mil e ";
                }else{
                    return unidade(verificaMilhar) + " mil ";
                }
            }else{
                if(verificaDezena != 0){
                    return dezena(verificaMilhar) + " mil e ";
                }else{
                    if(verificaUnidade != 0){
                        return dezena(verificaMilhar) + " mil e ";
                    }else
                    return dezena(verificaMilhar) + " mil ";
                }
            }
        }
    }

    private String centena(Integer valor){

        Integer verificaCentena = (valor%1000)/100;
        Integer verificaDezena = ((valor%100)/10);
        Integer verificaUnidade = (((valor%1000)%100)%10);

        if(verificaDezena == 0 && verificaUnidade == 0) {
            String centenaZero[] = {"", "cem", "duzentos", "trezentos", "quatrocentos", "quinhentos", "seiscentos", "setecentos", "oitocentos", "novecentos"};
            return centenaZero[verificaCentena];
        }else{
            String centena[] = {"", "cento e ", "duzentos e ", "trezentos e ", "quatrocentos e ", "quinhentos e ","seiscentos", "setecentos", "oitocentos e ", "novecentos e "};
            if(verificaDezena != 0){
                return centena[verificaCentena] + dezena(valor);
            }
            return centena[verificaCentena] + unidade(valor);
        }

    }

    private String dezena(Integer valor){

        Integer verificaDezena = ((valor%100)/10);
        Integer verificaUnidade = (((valor%1000)%100)%10);

        if(verificaDezena == 1) {
            String dezena1[] = {"dez", "onze", "doze","treze","quatorze", "quinze", "dezesseis", "dezessete", "dezoito", "dezenove"};
            return dezena1[verificaUnidade];
        }else if (verificaDezena >=2){
            String dezena2[]= {"", "","vinte e", "trinta e", "quarenta e", "cinquenta e", "sessenta e", "setenta e", "oitenta e", "noventa e"};
            String dezenaZero[] = {"", "", "vinte", "trinta", "quarenta", "cinquenta", "sessenta", "setenta", "oitenta", "noventa"};
            if(verificaUnidade ==0){
                return dezenaZero[verificaDezena];
            }else{
                return dezena2[verificaDezena] + " " + unidade(valor);
            }
        }

        return "";
    }



    private String unidade(Integer valor){

       Integer x = (((valor%1000)%100)%10);
        String unidade[] = {"zero", "um", "dois", "três", "quatro", "cinco", "seis", "sete", "oito", "nove"};
        return unidade[x];
    }
}
