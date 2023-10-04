package com.proyecto.empresa.service;


import com.proyecto.empresa.model.Venta;
import com.proyecto.empresa.reduce.AlmacenFilter;
import com.proyecto.empresa.reduce.DataChart;
import com.proyecto.empresa.reduce.DataFilterChart;
import com.proyecto.empresa.service.generic.GenericService;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface VentaService extends GenericService<Venta, Integer> {
    public List<Venta> findAll();

    public List<Venta> getDataByFecha(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

    public List<DataChart> getChartALL();

    public List<DataFilterChart> getChartFiltered();

    public List<DataFilterChart> getChartFilteredDate(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

    public List<AlmacenFilter> getAllAlmacen();

    public List<AlmacenFilter> getAllAlmacenByConcecionario(@Param("key") String key);

}
