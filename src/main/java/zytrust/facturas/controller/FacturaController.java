package zytrust.facturas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zytrust.facturas.dto.FacturaResponse;
import zytrust.facturas.service.FacturaService;
import zytrust.facturas.util.FacturaConverter;

import java.util.List;

@RestController
@RequestMapping("/api/facturas")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    //@Autowired
    //private GenreService genreService;

    @Autowired
    private FacturaConverter converter;

    @GetMapping
    public ResponseEntity<List<FacturaResponse>> getAll() throws Exception{
        var facturas = facturaService.getAll();
        return new ResponseEntity<>(converter.convertFacturaToResponse(facturas), HttpStatus.OK);
    }
}
