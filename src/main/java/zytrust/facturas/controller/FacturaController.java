package zytrust.facturas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zytrust.facturas.dto.FacturaRequest;
import zytrust.facturas.dto.FacturaResponse;
import zytrust.facturas.exception.ResourceNotFoundException;
import zytrust.facturas.model.ProductoFactura;
import zytrust.facturas.service.ClienteService;
import zytrust.facturas.service.FacturaService;
import zytrust.facturas.service.ProductoService;
import zytrust.facturas.util.FacturaConverter;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/facturas")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProductoService productoService;

    @Autowired
    private FacturaConverter converter;

    @GetMapping
    public ResponseEntity<List<FacturaResponse>> getAll() throws Exception{
        var facturas = facturaService.getAll();
        return new ResponseEntity<>(converter.convertFacturaToResponse(facturas), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacturaResponse> getById(@Valid @PathVariable(name = "id") Long id) throws Exception{
        var videoGame = facturaService.getById(id).orElseThrow(() -> new ResourceNotFoundException("Genre not found"));
        return new ResponseEntity<>(converter.convertFacturaToResponse(videoGame), HttpStatus.OK);
    }

    @PostMapping("/cliente/{clienteId}")
    public ResponseEntity<FacturaResponse> createVideoGame(@Valid @RequestBody FacturaRequest request,
                                                             @Valid @PathVariable(name = "clienteId") Long clienteId) throws Exception{
        var cliente = clienteService.getById(clienteId).orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado"));

        var tem = converter.convertFacturaToEntity(request);

        //List<ProductoFactura> productos = new ArrayList<>();

        /*for (ProductoFactura producto: request.getProductos()) {
            var prodtem = (productoService.getById(producto.getId()).orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado")));
            var pTemp = new ProductoFactura();
            pTemp.setCantidad(producto.getCantidad());
            pTemp.setProducto(prodtem);
            productos.add(pTemp);
        }*/

        tem.setCliente(cliente);
        //tem.setProductos(productos);
        var factura = facturaService.create(tem);
        return new ResponseEntity<>(converter.convertFacturaToResponse(factura), HttpStatus.ACCEPTED);
    }
}
