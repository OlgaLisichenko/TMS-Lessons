package org.tms.decorator.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarEntity {

    private String id;
    private String model;
    private String number;
    private String owner;

    @Override
    public String toString() {
        return "[id '" + id + '\'' +
               ", model '" + model + '\'' +
               ", number '" + number + '\'' +
               ", owner '" + owner + "']";
    }
}