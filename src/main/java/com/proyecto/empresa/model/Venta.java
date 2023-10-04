package com.proyecto.empresa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ventas")
public class Venta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idVenta")
    private Integer idVenta;

    @Column(name = "fecha")
    private LocalDateTime fecha;

    @Column(name = "concecionario")
    private String concecionario;

    @Column(name = "almacen")
    private String almacen;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "estadoVenta")
    private String estadoVenta;


}