package com.proyecto.empresa.RequestDto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class DateDto {
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
