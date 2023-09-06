package br.com.alura.alurator.conversor;

import br.com.alura.alurator.conversor.anotacao.NomeTagXml;

import java.lang.reflect.Field;
import java.util.Collection;

public class ConversorXML {

    public String converte(Object objeto){
        try {
            Class<?> classeObjeto = objeto.getClass();
            StringBuilder xmlBuilder = new StringBuilder();

            if (objeto instanceof Collection<?> colecao){
                xmlBuilder.append("<lista>");

                for(Object o : colecao){
                    String xml = converte(o);
                    xmlBuilder.append(xml);
                }

                xmlBuilder.append("</lista>");
            } else {
                NomeTagXml annotationClass = classeObjeto.getDeclaredAnnotation(NomeTagXml.class);

                String nomeClasse =
                        annotationClass == null
                        ? classeObjeto.getName()
                        : annotationClass.value();

                xmlBuilder.append("<").append(nomeClasse).append(">");

                for(Field atributo : classeObjeto.getDeclaredFields()) {
                    atributo.setAccessible(true);

                    NomeTagXml annotationAtribute = atributo.getDeclaredAnnotation(NomeTagXml.class);

                    String nomeAtributo =
                            annotationAtribute == null
                            ? atributo.getName()
                            : annotationAtribute.value();

                    Object valorAtributo = atributo.get(objeto);

                    xmlBuilder.append("<").append(nomeAtributo).append(">");
                    xmlBuilder.append(valorAtributo);
                    xmlBuilder.append("</").append(nomeAtributo).append(">");
                }

                xmlBuilder.append("</").append(nomeClasse).append(">");
            }

            return xmlBuilder.toString();
        } catch (IllegalAccessException e) {
            e.fillInStackTrace();
            throw new RuntimeException("Erro na geração do XML! ");
        }
    }
}
