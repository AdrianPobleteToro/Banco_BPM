package Clases;

public class Prestamos {
    private String tipo;
    private float monto;
    private float montoDeuda;
    private int cuotas;

    public Prestamos(String credito){
        switch (credito){
            case "Crédito Hipotecario":
                tipo = credito;
                monto = 1000000;
                cuotas = 12;
                montoDeuda = monto/cuotas;
                break;
            case "Crédito Automotriz":
                tipo = credito;
                monto = 500000;
                cuotas = 8;
                montoDeuda = monto/cuotas;
                break;
            default:
                break;
        }
    }
    public String getTipo() {
        return tipo;
    }

    public float getMonto() {
        return monto;
    }

    public float getMontoDeuda() {
        return montoDeuda;
    }

    public int getCuotas() {
        return cuotas;
    }

    public void setCuotas(int cuotas) {
        this.cuotas = cuotas;
    }

}
