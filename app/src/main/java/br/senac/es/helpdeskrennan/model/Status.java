package br.senac.es.helpdeskrennan.model;

public enum Status {


    ENVIADA {
        @Override
        public String toString() {
            return "ENVIADA";
        }

    },
    NAOENVIADA {
        @Override
        public String toString() {
            return "NÃO ENVIADA";

        }
    },
    SOLUCIONADOS {
        @Override
        public String toString() {
            return "SOLUCIONADO";

        }
    }
}
