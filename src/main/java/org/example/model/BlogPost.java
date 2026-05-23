package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BlogPost {
    private Long id;
    private String title;
    private String summary;
    private String content;
    private String author;
    private LocalDate publishedDate;
    private List<String> tags;
}
