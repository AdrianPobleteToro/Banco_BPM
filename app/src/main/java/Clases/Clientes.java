package Clases;

public class Clientes {

    private String nombre;
    private float saldo;

    public Clientes(String cliente){
        switch (cliente){
            case "AXEL":
                nombre=cliente;
                saldo=750000;
                break;
            case "ROXANE":
                nombre=cliente;
                saldo=900000;
                break;
            default:
                break;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float nuevoSaldo) {
        if(nuevoSaldo > 0)
            saldo = nuevoSaldo;
        else
            return;
    }
}
