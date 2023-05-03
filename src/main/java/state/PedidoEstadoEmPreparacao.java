package state;

public class PedidoEstadoEmPreparacao extends PedidoEstado{

    private PedidoEstadoEmPreparacao() {}
    private static PedidoEstadoEmPreparacao instance = new PedidoEstadoEmPreparacao();
    public static PedidoEstadoEmPreparacao getInstance() { return instance; }

    public String getEstado() { return "Em preparação"; }

    public boolean enviar(Pedido pedido) {
        pedido.setEstado(PedidoEstadoEmTransito.getInstance());
        return true;
    }

    public boolean cancelar(Pedido pedido) {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        return true;
    }
}
