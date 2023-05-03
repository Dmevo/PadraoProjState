package state;

public class PedidoEstadoPendente extends PedidoEstado{

    private PedidoEstadoPendente() {};
    private static PedidoEstadoPendente instance = new PedidoEstadoPendente();
    public static PedidoEstadoPendente getInstance() { return instance; }

    public String getEstado() { return "Pendente"; }

    public boolean preparar(Pedido pedido) {
        pedido.setEstado(PedidoEstadoEmPreparacao.getInstance());
        return true;
    }

    public boolean cancelar(Pedido pedido) {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        return true;
    }
}
