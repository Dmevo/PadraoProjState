package state;

public class Pedido {

    private PedidoEstado estado;

    public Pedido() { this.estado = PedidoEstadoPendente.getInstance(); }

    public void setEstado(PedidoEstado estado) { this.estado = estado; }

    public boolean preparar() { return estado.preparar(this); }

    public boolean enviar() { return estado.enviar(this); }

    public boolean entregar() { return estado.entregar(this); }

    public boolean cancelar() { return estado.cancelar(this); }

    public String getNomeEstado() { return estado.getEstado(); }

    public PedidoEstado getEstado() { return estado; }
}
