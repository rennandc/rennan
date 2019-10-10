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
