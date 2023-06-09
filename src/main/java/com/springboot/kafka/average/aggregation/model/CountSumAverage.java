package com.springboot.kafka.average.aggregation.model;

import lombok.*;

@Data
@ToString
@AllArgsConstructor
@Builder
public class CountSumAverage {
    private Long movieId;
    private Long count;
    private Double sum;
    private Double average;
    private String movieName;
    public CountSumAverage() {
        this.count=0L;
        this.sum=0.0;
        this.average=0.0;
        this.movieId=0L;
        this.movieName="";
    }
}
