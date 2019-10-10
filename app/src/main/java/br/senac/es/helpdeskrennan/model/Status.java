/*
* Aqui fica o nosso enum de Status onde contamos com status aberto, fechado e solucionados ambos convertidos para String*/

package br.senac.es.helpdeskrennan.model;

public enum Status {


    ABERTO {
        @Override
        public String toString() {
            return "ABERTO";
        }

    },
    FECHADO {
        @Override
        public String toString() {
            return "FECHADO";

        }
    },
    SOLUCIONADOS {
        @Override
        public String toString() {
            return "SOLUCIONADO";

        }
    }
}
