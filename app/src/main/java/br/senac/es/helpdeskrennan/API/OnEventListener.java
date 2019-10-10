/*
* Não sei muito bem o que essa parte faz, mas ela faz parte das Api e tem a ver com a interface.
* */

package br.senac.es.helpdeskrennan.API;

public interface OnEventListener<T> {
    public void onSuccess(T object);
    public void onFailure(Exception e);
}
