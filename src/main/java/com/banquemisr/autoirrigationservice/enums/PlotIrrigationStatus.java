package com.banquemisr.autoirrigationservice.enums;

public enum PlotIrrigationStatus {
    SUCCESS("SUCCESS"),
    SENSOR_NOT_RESPONDING("SENSOR_NOT_RESPONDING"),
    SENSOR_ALREAD_RUNNING("SENSOR_ALREAD_RUNNING"),
    SENSOR_ERROR("SENSOR_ERROR");

    private final String status;

    PlotIrrigationStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
