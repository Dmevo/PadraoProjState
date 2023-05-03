package state;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PedidoTest {

    Pedido pedido;

    @BeforeEach
    public void SetUp() { pedido = new Pedido(); }

    // Pedido pendente

    @Test
    public void devePrepararPedidoPendente() {
        pedido.setEstado(PedidoEstadoPendente.getInstance());
        assertTrue(pedido.preparar());
        assertEquals(PedidoEstadoEmPreparacao.getInstance(), pedido.getEstado());
    }

    @Test
    public void deveCancelarPedidoPendente() {
        pedido.setEstado(PedidoEstadoPendente.getInstance());
        assertTrue(pedido.cancelar());
        assertEquals(PedidoEstadoCancelado.getInstance(), pedido.getEstado());
    }

    @Test
    public void naoDeveEnviarPedidoPendente() {
        pedido.setEstado(PedidoEstadoPendente.getInstance());
        assertFalse(pedido.enviar());
    }

    @Test
    public void naoDeveEntregarPedidoPendente() {
        pedido.setEstado(PedidoEstadoPendente.getInstance());
        assertFalse(pedido.entregar());
    }

    // Pedido em preparacao

    @Test
    public void naoDevePrepararPedidoEmPreparacao() {
        pedido.setEstado(PedidoEstadoEmPreparacao.getInstance());
        assertFalse(pedido.preparar());
    }

    @Test
    public void deveCancelarPedidoEmPreparacao() {
        pedido.setEstado(PedidoEstadoEmPreparacao.getInstance());
        assertTrue(pedido.cancelar());
        assertEquals(PedidoEstadoCancelado.getInstance(), pedido.getEstado());
    }

    @Test
    public void deveEnviarPedidoEmPreparacao() {
        pedido.setEstado(PedidoEstadoEmPreparacao.getInstance());
        assertTrue(pedido.enviar());
        assertEquals(PedidoEstadoEmTransito.getInstance(), pedido.getEstado());
    }

    @Test
    public void naoDeveEntregarPedidoEmPreparacao() {
        pedido.setEstado(PedidoEstadoEmPreparacao.getInstance());
        assertFalse(pedido.entregar());
    }

    // Pedido em transito

    @Test
    public void deveEntregarPedidoEmTransito() {
        pedido.setEstado(PedidoEstadoEmTransito.getInstance());
        assertTrue(pedido.entregar());
        assertEquals(PedidoEstadoEntregue.getInstance(), pedido.getEstado());
    }

    @Test
    public void naoDeveEnviarPedidoEmTransito() {
        pedido.setEstado(PedidoEstadoEmTransito.getInstance());
        assertFalse(pedido.enviar());
    }

    @Test
    public void naoDevePrepararPedidoEmTransito() {
        pedido.setEstado(PedidoEstadoEmTransito.getInstance());
        assertFalse(pedido.preparar());
    }

    @Test
    public void naoDeveCancelarPedidoEmTransito() {
        pedido.setEstado(PedidoEstadoEmTransito.getInstance());
        assertFalse(pedido.cancelar());
    }

    // Pedido entregue

    @Test
    public void naoDeveEntregarPedidoEntregue() {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        assertFalse(pedido.entregar());
    }

    @Test
    public void naoDeveCancelarPedidoEntregue() {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        assertFalse(pedido.cancelar());
    }

    @Test
    public void naoDevePrepararPedidoEntregue() {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        assertFalse(pedido.preparar());
    }

    @Test
    public void naoDeveEnviarPedidoEntregue() {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        assertFalse(pedido.enviar());
    }

    // Pedido cancelado

    @Test
    public void naoDeveCancelarPedidoCancelado() {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        assertFalse(pedido.cancelar());
    }

    @Test
    public void naoDeveEntregarPedidoCancelado() {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        assertFalse(pedido.entregar());
    }

    @Test
    public void naoDevePrepararPedidoCancelado() {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        assertFalse(pedido.preparar());
    }

    @Test
    public void naoDeveEnviarPedidoCancelado() {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        assertFalse(pedido.enviar());
    }
}


