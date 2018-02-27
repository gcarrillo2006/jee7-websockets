/**
 * Funciones Javascript de utilidad
 */
/**
 * Funcion para abrir un websocket
 */
if (window.WebSocket) {
    var ws = new WebSocket("ws://localhost:8080/inscription-web/stock");
    ws.onmessage = function(event) {
        var text = event.data;
        updateStock();
        console.log(text);
    };
}
else {
    // Bad luck. Browser doesn't support it. Consider falling back to long polling.
    // See http://caniuse.com/websockets for an overview of supported browsers.
    // There exist jQuery WebSocket plugins with transparent fallback.
}

/**
 * Funcion para confirmar eliminacion
 */
function confirmacion() {
	return confirm("Esta seguro de eliminar el registro?");
}

