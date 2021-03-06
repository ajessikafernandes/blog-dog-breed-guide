package br.com.blogdogbreedguide.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private Integer minRead;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy.MM.dd")
    private LocalDate date;

    @NotNull
    @Lob
    private String text;

    @NotNull
    private String author;

}
