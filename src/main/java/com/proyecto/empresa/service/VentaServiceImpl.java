package com.proyecto.empresa.service;

import com.proyecto.empresa.model.Venta;
import com.proyecto.empresa.reduce.AlmacenFilter;
import com.proyecto.empresa.reduce.DataChart;
import com.proyecto.empresa.reduce.DataFilterChart;
import com.proyecto.empresa.repository.VentaRespository;
import com.proyecto.empresa.repository.generic.GenericRepository;
import com.proyecto.empresa.service.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VentaServiceImpl extends GenericServiceImpl<Venta, Integer> implements VentaService{
    private VentaRespository ventaRespository;

    @Override
    public GenericRepository<Venta, Integer> getDao() {
        return ventaRespository;
    }

    @Autowired
    public VentaServiceImpl(VentaRespository ventaRespository){
        this.ventaRespository = ventaRespository;
    }

    @Override
    public List<Venta> findAll() {
        return ventaRespository.findAll();
    }

    @Override
    public List<Venta> getDataByFecha(LocalDateTime startDate, LocalDateTime endDate) {
        return ventaRespository.getDataByFecha(startDate, endDate);
    }


    @Override
    public List<DataChart> getChartALL() {
        return ventaRespository.getChartALL();
    }

    @Override
    public List<DataFilterChart> getChartFiltered() {
        return ventaRespository.getChartFiltered();
    }

    @Override
    public List<DataFilterChart> getChartFilteredDate(LocalDateTime startDate, LocalDateTime endDate) {
        return ventaRespository.getChartFilteredDate(startDate, endDate);
    }

    @Override
    public List<AlmacenFilter> getAllAlmacen() {
        return ventaRespository.getAllAlmacen();
    }

    @Override
    public List<AlmacenFilter> getAllAlmacenByConcecionario(String key) {
        return ventaRespository.getAllAlmacenByConcecionario(key);
    }


}
