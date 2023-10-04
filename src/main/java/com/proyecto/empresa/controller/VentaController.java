package com.proyecto.empresa.controller;

import com.proyecto.empresa.RequestDto.DateDto;
import com.proyecto.empresa.controller.generic.GenericControllerImpl;
import com.proyecto.empresa.model.Venta;
import com.proyecto.empresa.reduce.AlmacenFilter;
import com.proyecto.empresa.reduce.DataChart;
import com.proyecto.empresa.reduce.DataFilterChart;
import com.proyecto.empresa.service.VentaService;
import com.proyecto.empresa.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class VentaController extends GenericControllerImpl<Venta, Integer> {

    private VentaService ventaService;

    @Autowired
    public VentaController(VentaService ventaService){
        this.ventaService = ventaService;
    }

    @Override
    protected GenericService<Venta, Integer> getService() {
        return ventaService;
    }

    @PostMapping("/reuest")
    public ResponseEntity<List<Venta>> requestByDate(@RequestBody DateDto d) {
       try {
            return new ResponseEntity<>(ventaService.getDataByFecha(d.getStartDate(), d.getEndDate()), HttpStatus.OK);
       }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }

    @GetMapping("/reuest/chart")
    public ResponseEntity<List<DataFilterChart>> getChartFiltered() {
        try {
            return new ResponseEntity<>(ventaService.getChartFiltered(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/reuest/chart/final")
    public ResponseEntity<List<DataFilterChart>> getChartFilteredDate(@RequestBody DateDto d) {
        try {
            return new ResponseEntity<>(ventaService.getChartFilteredDate(d.getStartDate(), d.getEndDate()), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/almacen")
    public ResponseEntity<List<AlmacenFilter>> getAllAlmacen() {
        try {
            return new ResponseEntity<>(ventaService.getAllAlmacen(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/almacen/{key}")
    public ResponseEntity<List<AlmacenFilter>> getAllAlmacenByConcecionario(@PathVariable("key") String key) {
        try {
            return new ResponseEntity<>(ventaService.getAllAlmacenByConcecionario(key), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}