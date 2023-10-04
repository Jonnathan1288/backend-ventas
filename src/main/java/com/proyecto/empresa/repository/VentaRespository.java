package com.proyecto.empresa.repository;

import com.proyecto.empresa.model.Venta;
import com.proyecto.empresa.reduce.AlmacenFilter;
import com.proyecto.empresa.reduce.DataChart;
import com.proyecto.empresa.reduce.DataFilterChart;
import com.proyecto.empresa.repository.generic.GenericRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface VentaRespository extends GenericRepository<Venta, Integer> {

    @Query("SELECT v FROM Venta v WHERE v.fecha BETWEEN :startDate and :endDate")
    public List<Venta> getDataByFecha(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);


    @Query("SELECT v.estadoVenta as estadoVenta, count(v.estadoVenta) as total FROM Venta v  GROUP BY v.estadoVenta")
    public List<DataChart> getChartALL();

    @Query("SELECT v.concecionario as concecionario, "+
            "count(v.estadoVenta) as total, "+
            "sum(case when v.estadoVenta = 'COMPLETA' then 1 else 0 end) as completo, " +
            "sum(case when v.estadoVenta = 'INCOMPLETA' then 1 else 0 end) as incompleto " +
            "FROM Venta v GROUP BY v.concecionario ")

    public List<DataFilterChart> getChartFiltered();

    @Query("SELECT v.concecionario as concecionario, "+
            "count(v.estadoVenta) as total, "+
            "sum(case when v.estadoVenta = 'COMPLETA' then 1 else 0 end) as completo, " +
            "sum(case when v.estadoVenta = 'INCOMPLETA' then 1 else 0 end) as incompleto " +
            "FROM Venta v WHERE v.fecha BETWEEN :startDate and :endDate GROUP BY v.concecionario ")
    public List<DataFilterChart> getChartFilteredDate(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

    @Query("SELECT v.idVenta as idVenta, "+
            "v.almacen as almacen "+
            "FROM Venta v GROUP BY v.almacen ")
    public List<AlmacenFilter> getAllAlmacen();

    @Query("SELECT v.idVenta as idVenta, "+
            "v.almacen as almacen "+
            "FROM Venta v WHERE v.concecionario = :key GROUP BY v.almacen ")
    public List<AlmacenFilter> getAllAlmacenByConcecionario(@Param("key") String key);

}

