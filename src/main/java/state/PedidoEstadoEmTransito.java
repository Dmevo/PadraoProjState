package state;

public class PedidoEstadoEmTransito extends PedidoEstado{

    private PedidoEstadoEmTransito() {}
    private static PedidoEstadoEmTransito instance = new PedidoEstadoEmTransito();
    public static PedidoEstadoEmTransito getInstance() { return instance; }

    public String getEstado() { return "Em transito"; }

    public boolean entregar(Pedido pedido) {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        return true;
    }
}
