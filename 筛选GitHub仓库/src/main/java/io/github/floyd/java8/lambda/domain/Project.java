package io.github.floyd.java8.lambda.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Project {

    private String name;
    private String language;
    private Integer stars;
    private String description;
    private String author;
}
