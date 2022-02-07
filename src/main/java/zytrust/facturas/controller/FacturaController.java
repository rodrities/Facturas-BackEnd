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
import zytrust.facturas.service.ProductoFacturaService;
import zytrust.facturas.service.ProductoService;
import zytrust.facturas.util.FacturaConverter;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.time.LocalDate;
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
    private ProductoFacturaService productoFacturaService;

    @Autowired
    private FacturaConverter converter;

    @GetMapping
    public ResponseEntity<List<FacturaResponse>> getAll() throws Exception{
        var facturas = facturaService.getAll();
        return new ResponseEntity<>(converter.convertFacturaToResponse(facturas), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacturaResponse> getById(@Valid @PathVariable(name = "id") String id) throws Exception{
        var videoGame = facturaService.getById(id).orElseThrow(() -> new ResourceNotFoundException("CLiente no encontrado"));
        return new ResponseEntity<>(converter.convertFacturaToResponse(videoGame), HttpStatus.OK);
    }

    @PostMapping("/cliente/{clienteId}")
    public ResponseEntity<FacturaResponse> createVideoGame(@Valid @RequestBody FacturaRequest request,
                                                             @Valid @PathVariable(name = "clienteId") String clienteId) throws Exception{
        var cliente = clienteService.getById(clienteId).orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado"));

        var tem = converter.convertFacturaToEntity(request);

        List<ProductoFactura> productos = new ArrayList<>();

        for (ProductoFactura producto: request.getProductos()) {
            var productoTem = (productoService.getById(producto.getId()).orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado")));
            var prodFacTem = new ProductoFactura();
            prodFacTem.setCantidad(producto.getCantidad());
            prodFacTem.setProducto(productoTem);
            productos.add(prodFacTem);
            productoFacturaService.create(prodFacTem);

            tem.setSubtotal(tem.getSubtotal().add(productoTem.getPrecio().multiply(new BigDecimal(prodFacTem.getCantidad()))));
        }

        tem.setFechaEmision(LocalDate.now());
        tem.setFechaVencimiento(tem.getFechaEmision().plusMonths(1));
        tem.setImpuesto(tem.getSubtotal().multiply(new BigDecimal("0.18")));
        tem.setTotal(tem.getSubtotal().add(tem.getImpuesto()));

        tem.setCliente(cliente);
        tem.setProductos(productos);
        var factura = facturaService.create(tem);

        return new ResponseEntity<>(converter.convertFacturaToResponse(factura), HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}/status/{status}")
    public ResponseEntity<FacturaResponse> cambiarStatus(
            @Valid @PathVariable(name = "id") String id,
            @Valid @PathVariable(name = "status") String status
            ) throws Exception{
        var factura = facturaService.getById(id).orElseThrow(() -> new ResourceNotFoundException("Factura no encontrada"));

        factura.setStatus(status);

        /*if(status.equals("Confirmada")) {
            for(ProductoFactura producto: factura.getProductos()) {

            }
        }*/

        facturaService.update(factura);
        return new ResponseEntity<>(converter.convertFacturaToResponse(factura), HttpStatus.OK);
    }

}
