package zytrust.facturas.util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import zytrust.facturas.dto.FacturaRequest;
import zytrust.facturas.dto.FacturaResponse;
import zytrust.facturas.model.Factura;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClienteConverter {
    @Autowired
    private ModelMapper modelMapper;

    public Factura convertClienteToEntity(ClienteRequest request){
        return modelMapper.map(request, Factura.class);
    }

    public FacturaResponse convertFacturaToResponse(Factura factura){
        return modelMapper.map(factura, FacturaResponse.class);
    }

    public List<FacturaResponse> convertFacturaToResponse(List<Factura> facturas) {
        return facturas.stream().map(factura -> modelMapper.map(factura, FacturaResponse.class)).collect(Collectors.toList());
    }
}
