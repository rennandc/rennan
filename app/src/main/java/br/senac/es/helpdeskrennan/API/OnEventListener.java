package br.senac.es.helpdeskrennan.API;

public interface OnEventListener<T> {
    public void onSuccess(T object);
    public void onFailure(Exception e);
}
